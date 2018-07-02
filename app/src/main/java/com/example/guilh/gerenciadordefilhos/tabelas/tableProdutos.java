package com.example.guilh.gerenciadordefilhos.tabelas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.example.guilh.gerenciadordefilhos.Util.Database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class tableProdutos{
    private static  final String TABLE = "produtos";

    private Integer produto_id;
    private String nome;
    private String qtd;

    public Integer getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Integer produto_id) {
        this.produto_id = produto_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "produto_id INTEGER NOT NULL , " +
                    "nome TEXT NOT NULL, " +
                    "PRIMARY KEY (produto_id) " +
                    ")";

    private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

    public String create() { return CREATE; }

    public String upgrade() { return DROP; }

    public long insert(SQLiteDatabase db)
    {
        return db.insert(TABLE, null, retornaValues());
    }

    public int update(SQLiteDatabase db)
    {
        return db.update(TABLE, retornaValues(), "produto_id = ?", new String[]{ this.produto_id.toString() });
    }

    public void selectMaxId(SQLiteDatabase db)
    {
        String query = "SELECT MAX(ID) FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                this.produto_id = c.getColumnIndex("produto_id");
            }
        }
    }

    public List<tableProdutos> selectList(SQLiteDatabase db)
    {
        String query = "SELECT * FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        tableProdutoFilho produto = new tableProdutoFilho();
        List<tableProdutos> list = new ArrayList<tableProdutos>();
        if (c != null) {
            if (c.getCount() > 0) {
                for(int i = 0; i < c.getCount(); i++) {
                    tableProdutos table = new tableProdutos();
                    table.produto_id = c.getInt(c.getColumnIndex("produto_id"));
                    table.nome = c.getString(c.getColumnIndex("nome"));
                    table.qtd = produto.selectProd(produto_id,db);
                    list.add(table);
                    c.moveToNext();
                }
            }
        }
        return list;
    }

    public void select(int id, SQLiteDatabase db)
    {
        String query = "SELECT * FROM " + TABLE + " WHERE ID = " + id ;
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                this.produto_id = c.getInt(c.getColumnIndex("produto_id"));
                this.nome = c.getString(c.getColumnIndex("nome"));
            }
        }
    }

    private ContentValues retornaValues()
    {
        ContentValues values = new ContentValues();

        values.put("nome", this.nome);

        return  values;
    }

    @Override
    public String toString()
    {

        return nome + qtd;
    }
}
