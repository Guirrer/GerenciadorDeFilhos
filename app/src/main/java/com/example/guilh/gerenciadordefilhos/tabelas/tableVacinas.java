package com.example.guilh.gerenciadordefilhos.tabelas;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class tableVacinas implements Serializable {
    private static  final String TABLE = "vacinas";

    private Integer id;
    private String nome_vacina;
    private String idade_minima;
    private Integer dose;
    private String validade;
    private String periodicidade;



    public Integer getVacina_id() {
        return id;
    }

    public void setVacina_id(Integer vacina_id) {
        this.id = vacina_id;
    }

    public String getNome_vacina() {
        return nome_vacina;
    }

    public void setNome_vacina(String nome_vacina) {
        this.nome_vacina = nome_vacina;
    }

    public String getIdade_minima() {
        return idade_minima;
    }

    public void setIdade_minima(String idade_minima) {
        this.idade_minima = idade_minima;
    }

    public Integer getDose() {
        return dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "id INTEGER NOT NULL , " +
                    "nome_vacina TEXT NOT NULL, " +
                    "idade_minima INTEGER NULL DEFAULT NULL, " +
                    "dose INTEGER NULL DEFAULT NULL, " +
                    "validade FLOAT NULL DEFAULT NULL, " +
                    "periodicidade FLOAT NULL DEFAULT NULL, " +
                    "PRIMARY KEY (id) " +
                    ")";

    private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

    public String create() { return CREATE; }

    public String upgrade() { return DROP; }

    public void select(int id, SQLiteDatabase db)
    {
        String query = "SELECT * FROM " + TABLE + " WHERE ID = " + id ;
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                this.id = c.getInt(c.getColumnIndex("id"));
                this.nome_vacina = c.getString(c.getColumnIndex("nome_vacina"));
                this.idade_minima = c.getString(c.getColumnIndex("idade_minima"));
                this.dose = c.getInt(c.getColumnIndex("dose"));
                this.validade = c.getString(c.getColumnIndex("validade"));
                this.periodicidade = c.getString(c.getColumnIndex("periodicidade"));
            }
        }
    }

    public List<tableVacinas> selectList(SQLiteDatabase db)
    {
        String query = "SELECT * FROM " + TABLE + " WHERE ID = " + id ;
        Cursor c = db.rawQuery(query, null);
        List<tableVacinas> list = new ArrayList<tableVacinas>();
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                do{
                tableVacinas table = new tableVacinas();
                table.id = c.getInt(c.getColumnIndex("id"));
                table.nome_vacina = c.getString(c.getColumnIndex("nome_vacina"));
                table.idade_minima = c.getString(c.getColumnIndex("idade_minima"));
                table.dose = c.getInt(c.getColumnIndex("dose"));
                table.validade = c.getString(c.getColumnIndex("validade"));
                table.periodicidade = c.getString(c.getColumnIndex("periodicidade"));
                list.add(table);
                }while(c.moveToNext());
            }
        }
        return list;
    }

    public long insert(SQLiteDatabase db)
    {
        return db.insert(TABLE, null, retornaValues());
    }

    public int update(SQLiteDatabase db)
    {
        return db.update(TABLE, retornaValues(), "id = ?", new String[]{ this.id.toString() });
    }
    private ContentValues retornaValues()
    {
        ContentValues values = new ContentValues();

        values.put("nome_vacina", this.nome_vacina);
        values.put("idade_minima", this.idade_minima);
        values.put("dose", this.dose);
        values.put("validade", this.validade);
        values.put("periodicidade", this.periodicidade);

        return  values;
    }

    @Override
    public String toString() {
        return nome_vacina;
    }
}
