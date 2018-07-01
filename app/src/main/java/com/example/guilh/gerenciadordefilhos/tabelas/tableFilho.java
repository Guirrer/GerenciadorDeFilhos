package com.example.guilh.gerenciadordefilhos.tabelas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

import com.example.guilh.gerenciadordefilhos.Util.Database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class tableFilho {
    private static  final String TABLE = "filho";

    private Integer id;
    private Integer usuario_id;
    private String nome;
    private String data_nasc;
    private String sexo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

        private static final String CREATE =
                "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                        "id INTEGER NOT NULL , " +
                        "usuario_id INTEGER NOT NULL, " +
                        "nome TEXT NOT NULL, " +
                        "data_nasc DATE NULL DEFAULT NULL, " +
                        "sexo TEXT NULL DEFAULT NULL, " +
                        " PRIMARY KEY (id), "  +
                        " FOREIGN KEY (usuario_id) REFERENCES usuario (id) ON UPDATE NO ACTION ON DELETE NO ACTION" +
                        ")";

        private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

        public String create() {
            return CREATE;
        }

        public String upgrade() {
            return DROP;
        }


        public long insert(SQLiteDatabase db)
        {
            return db.insert(TABLE, null, retornaValues());
        }



    public int update(SQLiteDatabase db)
    {
        return db.update(TABLE, retornaValues(), "id = ?", new String[]{ this.id.toString() });
    }

    public void selectMaxId(SQLiteDatabase db)
    {
        String query = "SELECT MAX(ID) FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                this.id = c.getColumnIndex("id");
            }
        }
    }

    public List<tableFilho> selectList(SQLiteDatabase db, String user_id)
    {
        String query = "SELECT * FROM " + TABLE + " WHERE usuario_id = " + user_id;
        Cursor c = db.rawQuery(query, null);
        List<tableFilho> list = new ArrayList<tableFilho>();
        if (c != null) {
            if (c.getCount() > 0 && c.moveToFirst()) {
                //for(int i = 0;i < c.getCount(); i++ ) {
                do{
                    tableFilho table = new tableFilho();
                    table.id = c.getInt(c.getColumnIndex("id"));
                    table.usuario_id = c.getInt(c.getColumnIndex("usuario_id"));
                    table.nome = c.getString(c.getColumnIndex("nome"));
                    table.data_nasc = c.getString(c.getColumnIndex("data_nasc"));
                    table.sexo = c.getString(c.getColumnIndex("sexo"));
                    list.add(table);

                } while(c.moveToNext());
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
                this.id = c.getInt(c.getColumnIndex("id"));
                this.usuario_id = c.getInt(c.getColumnIndex("usuario_id"));
                this.nome = c.getString(c.getColumnIndex("nome"));
                this.data_nasc = c.getString(c.getColumnIndex("data_nasc"));
                this.sexo = c.getString(c.getColumnIndex("sexo"));
            }
        }
    }

    private ContentValues retornaValues()
    {
        ContentValues values = new ContentValues();

        values.put("usuario_id", this.usuario_id);
        values.put("nome", this.nome);
        values.put("data_nasc", this.data_nasc);
        values.put("sexo", this.sexo);

        return  values;
    }

    @Override
    public String toString()
    {
        return nome;
    }
}