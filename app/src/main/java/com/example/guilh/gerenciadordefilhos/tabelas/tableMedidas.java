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

public class tableMedidas {
    private static  final String TABLE = "medidas";

    private Integer filho_id;
    private String data_dado;
    private Float peso;
    private Integer tam_pe;
    private Float altura;

    public Integer getFilho_id() {
        return filho_id;
    }

    public void setFilho_id(Integer filho_id) {
        this.filho_id = filho_id;
    }

    public String getData_dado() {
        return data_dado;
    }

    public void setData_dado(String data_dado) {
        this.data_dado = data_dado;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Integer getTam_pe() {
        return tam_pe;
    }

    public void setTam_pe(Integer tam_pe) {
        this.tam_pe = tam_pe;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "id INTEGER NOT NULL , " +
                    "filho_id INTEGER NOT NULL, " +
                    "data_dado DATE NOT NULL, " +
                    "peso FLOAT NULL DEFAULT NULL, " +
                    "tam_pe INTEGER NULL DEFAULT NULL, " +
                    "altura FLOAT NULL DEFAULT NULL, " +
                    "PRIMARY KEY (id), " +
                    "FOREIGN KEY (filho_id) REFERENCES filho (id) ON DELETE NO ACTION ON UPDATE NO ACTION" +
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
        return db.update(TABLE, retornaValues(), "filho_id = ?", new String[]{ this.filho_id.toString() });
    }

    public void selectMaxId(SQLiteDatabase db)
    {
        String query = "SELECT MAX(ID) FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                this.filho_id = c.getColumnIndex("filho_id");
            }
        }
    }

    public List<tableMedidas> selectList(SQLiteDatabase db)
    {
        String query = "SELECT * FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        List<tableMedidas> list = new ArrayList<tableMedidas>();
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                do{
                tableMedidas table = new tableMedidas();
                table.filho_id = c.getInt(c.getColumnIndex("eventos_id"));
                table.data_dado = c.getString(c.getColumnIndex("data_dado"));
                table.peso = c.getFloat(c.getColumnIndex("peso"));
                table.tam_pe = c.getInt(c.getColumnIndex("tam_pe"));
                table.altura = c.getFloat(c.getColumnIndex("altura"));
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
                this.filho_id = c.getInt(c.getColumnIndex("filho_id"));
                this.data_dado = c.getString(c.getColumnIndex("data_dado"));
                this.peso = c.getFloat(c.getColumnIndex("peso"));
                this.tam_pe = c.getInt(c.getColumnIndex("tam_pe"));
                this.altura = c.getFloat(c.getColumnIndex("altura"));
            }
        }
    }

    private ContentValues retornaValues()
    {
        ContentValues values = new ContentValues();

        values.put("filho_id", filho_id);
        values.put("data_dado", data_dado);
        values.put("peso", peso);
        values.put("tam_pe", tam_pe);
        values.put("altura", altura);

        return  values;
    }
}
