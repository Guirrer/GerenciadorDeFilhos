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

public class tableVacinacao {
    private static  final String TABLE = "vacinacao";

    private Integer vacinas_id;
    private Integer filho_id;
    private String data_vacina;

    public Integer getVacinas_id() {
        return vacinas_id;
    }

    public void setVacinas_id(Integer vacinas_id) {
        this.vacinas_id = vacinas_id;
    }

    public Integer getFilho_id() {
        return filho_id;
    }

    public void setFilho_id(Integer filho_id) {
        this.filho_id = filho_id;
    }

    public String getData_vacina() {
        return data_vacina;
    }

    public void setData_vacina(String data_vacina) {
        this.data_vacina = data_vacina;
    }

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "vacinas_id INTEGER NOT NULL , " +
                    "filho_id INTEGER NOT NULL , " +
                    "data_vacina DATE NOT NULL, " +
                    "PRIMARY KEY (vacinas_id, filho_id), " +
                    "FOREIGN KEY (vacinas_id) REFERENCES vacinas (id) ON DELETE NO ACTION ON UPDATE NO ACTION, " +
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
        return db.update(TABLE, retornaValues(), "vacinas_id = ?", new String[]{ this.vacinas_id.toString() });
    }

    public void selectMaxId(SQLiteDatabase db)
    {
        String query = "SELECT MAX(ID) FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                this.vacinas_id = c.getColumnIndex("vacinas_id");
            }
        }
    }

    public List<tableVacinacao> selectList(SQLiteDatabase db)
    {
        String query = "SELECT * FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        List<tableVacinacao> list = new ArrayList<tableVacinacao>();
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                do{
                tableVacinacao table = new tableVacinacao();
                table.vacinas_id = c.getInt(c.getColumnIndex("vacinas_id"));
                table.filho_id = c.getInt(c.getColumnIndex("filho_id"));
                table.data_vacina = c.getString(c.getColumnIndex("data_vacina"));
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
                this.vacinas_id = c.getInt(c.getColumnIndex("vacinas_id"));
                this.filho_id = c.getInt(c.getColumnIndex("filho_id"));
                this.data_vacina = c.getString(c.getColumnIndex("data_vacina"));
            }
        }
    }

    private ContentValues retornaValues()
    {
        ContentValues values = new ContentValues();

        values.put("filho_id", this.filho_id);
        values.put("data_vacina", this.data_vacina);;

        return  values;
    }

}
