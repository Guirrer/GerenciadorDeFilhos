package com.example.guilh.gerenciadordefilhos.tabelas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.example.guilh.gerenciadordefilhos.Util.Database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class tableUsuario implements Serializable {
    private static  final String TABLE = "usuario";

    private Integer id;
    private String nome;
    private String senha;
    private String email;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "id INTEGER NOT NULL , " +
                    "nome TEXT NOT NULL, " +
                    "senha TEXT NOT NULL, " +
                    "email TEXT NOT NULL, " +
                    "PRIMARY KEY (id) " +
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

    public List<tableUsuario> selectList(SQLiteDatabase db)
    {
        String query = "SELECT * FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        List<tableUsuario> list = new ArrayList<tableUsuario>();
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                do{
                tableUsuario table = new tableUsuario();
                table.id = c.getInt(c.getColumnIndex("id"));
                table.nome = c.getString(c.getColumnIndex("nome"));
                table.senha = c.getString(c.getColumnIndex("senha"));
                table.email = c.getString(c.getColumnIndex("email"));
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
                this.id = c.getInt(c.getColumnIndex("id"));
                this.nome = c.getString(c.getColumnIndex("nome"));
                this.senha = c.getString(c.getColumnIndex("senha"));
                this.email = c.getString(c.getColumnIndex("email"));
            }
        }
    }

    public boolean selectUser(String user, String senha, SQLiteDatabase db)
    {
        boolean valid = false;
        String query = "SELECT * FROM " + TABLE + " WHERE nome = '" + user + "' AND senha = '" + senha + "'";
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                valid = true;
                this.id = c.getInt(c.getColumnIndex("id"));
                this.nome = c.getString(c.getColumnIndex("nome"));
                this.senha = c.getString(c.getColumnIndex("senha"));
                this.email = c.getString(c.getColumnIndex("email"));
            }
        }
        return  valid;
    }

    private ContentValues retornaValues()
    {
        ContentValues values = new ContentValues();

        values.put("nome", this.nome);
        values.put("senha", this.senha);
        values.put("email", this.email);

        return  values;
    }
}
