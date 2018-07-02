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

public class tableProdutoFilho{
    private static  final String TABLE = "produto_filho";

    private Integer produtoFilho_id;
    private Integer produto_id;
    private Integer filho_id;
    private String loja_compra;
    private Integer qtd_pacote;
    private String data_compra;
    private Float preco;
    private String detalhe;
    private Integer qtd_compra;

    public Integer getProdutoFilho_id() {
        return produtoFilho_id;
    }

    public void setProdutoFilho_id(Integer produtoFilho_id) {
        this.produtoFilho_id = produtoFilho_id;
    }

    public Integer getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Integer produto_id) {
        this.produto_id = produto_id;
    }

    public Integer getFilho_id() {
        return filho_id;
    }

    public void setFilho_id(Integer filho_id) {
        this.filho_id = filho_id;
    }

    public String getLoja_compra() {
        return loja_compra;
    }

    public void setLoja_compra(String loja_compra) {
        this.loja_compra = loja_compra;
    }

    public Integer getQtd_pacote() {
        return qtd_pacote;
    }

    public void setQtd_pacote(Integer qtd_pacote) {
        this.qtd_pacote = qtd_pacote;
    }

    public String getData_compra() {
        return data_compra;
    }

    public void setData_compra(String data_compra) {
        this.data_compra = data_compra;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public Integer getQtd_compra() {
        return qtd_compra;
    }

    public void setQtd_compra(Integer qtd_compra) {
        this.qtd_compra = qtd_compra;
    }

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "produtoFilho_id INTEGER NOT NULL , " +
                    "produto_id INTEGER NOT NULL, " +
                    "filho_id INTEGER NOT NULL , " +
                    "loja_compra TEXT NULL DEFAULT NULL, " +
                    "qtd_pacote INTEGER NULL DEFAULT NULL, " +
                    "data_compra DATE NULL DEFAULT NULL, " +
                    "preco FLOAT NULL DEFAULT NULL, " +
                    "detalhe TEXT NULL DEFAULT NULL, " +
                    "qtd_compra INTEGER NULL DEFAULT NULL, " +
                    "PRIMARY KEY (produtoFilho_id), " +
                    "FOREIGN KEY (filho_id) REFERENCES filho (id) ON DELETE NO ACTION ON UPDATE NO ACTION, " +
                    "FOREIGN KEY (produto_id) REFERENCES produto (produto_id) ON DELETE NO ACTION ON UPDATE NO ACTION" +
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
        return db.update(TABLE, retornaValues(), "produtoFilho_id = ?", new String[]{ this.produtoFilho_id.toString() });
    }

    public void selectMaxId(SQLiteDatabase db)
    {
        String query = "SELECT MAX(ID) FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                this.produtoFilho_id = c.getColumnIndex("produtoFilho_id");
            }
        }
    }

    public List<tableProdutoFilho> selectList(SQLiteDatabase db)
    {
        String query = "SELECT * FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        List<tableProdutoFilho> list = new ArrayList<tableProdutoFilho>();
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                do{
                tableProdutoFilho table = new tableProdutoFilho();
                table.produtoFilho_id = c.getInt(c.getColumnIndex("produtoFilho_id"));
                table.produto_id = c.getInt(c.getColumnIndex("produto_id"));
                table.filho_id = c.getInt(c.getColumnIndex("filho_id"));
                table.loja_compra = c.getString(c.getColumnIndex("loja_compra"));
                table.qtd_pacote = c.getInt(c.getColumnIndex("qtd_pacote"));
                table.data_compra = c.getString(c.getColumnIndex("data_compra"));
                table.preco = c.getFloat(c.getColumnIndex("preco"));
                table.detalhe = c.getString(c.getColumnIndex("detalhe"));
                table.qtd_compra = c.getInt(c.getColumnIndex("qtd_compra"));
                list.add(table);
                }while(c.moveToNext());
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
                this.produtoFilho_id = c.getInt(c.getColumnIndex("produtoFilho_id"));
                this.produto_id = c.getInt(c.getColumnIndex("produto_id"));
                this.filho_id = c.getInt(c.getColumnIndex("filho_id"));
                this.loja_compra = c.getString(c.getColumnIndex("loja_compra"));
                this.qtd_pacote = c.getInt(c.getColumnIndex("qtd_pacote"));
                this.data_compra = c.getString(c.getColumnIndex("data_compra"));
                this.preco = c.getFloat(c.getColumnIndex("preco"));
                this.detalhe = c.getString(c.getColumnIndex("detalhe"));
                this.qtd_compra = c.getInt(c.getColumnIndex("qtd_compra"));
            }
        }
    }

    public String selectProd(int id, SQLiteDatabase db)
    {
        String qtd = "";
        String query = "SELECT SUM(qtd_pacote) as qtd FROM " + TABLE + " WHERE produto_id = " + id ;
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                qtd = c.getString(c.getColumnIndex("qtd"));
            }
        }
        return qtd;
    }

    private ContentValues retornaValues()
    {
        ContentValues values = new ContentValues();

        values.put("produto_id", this.produto_id);
        values.put("filho_id", this.filho_id);
        values.put("loja_compra", this.loja_compra);
        values.put("qtd_pacote", this.qtd_pacote);
        values.put("data_compra", this.data_compra);
        values.put("preco", this.preco);
        values.put("detalhe", this.detalhe);
        values.put("qtd_compra", this.qtd_compra);

        return  values;
    }

}
