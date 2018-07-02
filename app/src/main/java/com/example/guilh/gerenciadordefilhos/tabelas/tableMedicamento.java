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

public class tableMedicamento {
    private static  final String TABLE = "medicamento";

    private Integer medicamento_id;
    private String nome;
    private String laboratorio;
    private String finalidade;
    private Float valor;
    private String local_compra;
    private String qtd;
    private String dosagem;
    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public Integer getMedicamento_id() {
        return medicamento_id;
    }

    public void setMedicamento_id(Integer medicamento_id) {
        this.medicamento_id = medicamento_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getLocal_compra() {
        return local_compra;
    }

    public void setLocal_compra(String local_compra) {
        this.local_compra = local_compra;
    }

    public String getQtd() {
        return qtd;
    }

    public void setQtd(String qtd) {
        this.qtd = qtd;
    }

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "medicamento_id INTEGER NOT NULL , " +
                    "nome TEXT NOT NULL, " +
                    "laboratorio TEXT NOT NULL, " +
                    "finalidade TEXT NOT NULL, " +
                    "valor FLOAT NULL DEFAULT NULL, " +
                    "local_compra TEXT NULL DEFAULT NULL, " +
                    "dosagem TEXT NULL DEFAULT NULL, " +
                    "qtd INTEGER  NOT NULL, " +
                    "PRIMARY KEY (medicamento_id) " +
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
        return db.update(TABLE, retornaValues(), "medicamento_id = ?", new String[]{ this.medicamento_id.toString() });
    }

    public void selectMaxId(SQLiteDatabase db)
    {
        String query = "SELECT MAX(ID) FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                this.medicamento_id = c.getColumnIndex("medicamento_id");
            }
        }
    }

    public List<tableMedicamento> selectList(SQLiteDatabase db)
    {
        String query = "SELECT * FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        List<tableMedicamento> list = new ArrayList<tableMedicamento>();
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                do {
                tableMedicamento table = new tableMedicamento();
                table.medicamento_id = c.getInt(c.getColumnIndex("medicamento_id"));
                table.nome = c.getString(c.getColumnIndex("nome"));
                table.laboratorio = c.getString(c.getColumnIndex("laboratorio"));
                table.finalidade = c.getString(c.getColumnIndex("finalidade"));
                table.valor = c.getFloat(c.getColumnIndex("valor"));
                table.local_compra = c.getString(c.getColumnIndex("local_compra"));
                table.qtd = c.getString(c.getColumnIndex("qtd"));
                table.dosagem = c.getString(c.getColumnIndex("dosagem"));
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
                this.medicamento_id = c.getInt(c.getColumnIndex("eventos_id"));
                this.nome = c.getString(c.getColumnIndex("nome"));
                this.laboratorio = c.getString(c.getColumnIndex("laboratorio"));
                this.finalidade = c.getString(c.getColumnIndex("finalidade"));
                this.valor = c.getFloat(c.getColumnIndex("valor"));
                this.qtd = c.getString(c.getColumnIndex("qtd"));
                this.dosagem = c.getString(c.getColumnIndex("dosagem"));
            }
        }
    }

    private ContentValues retornaValues()
    {
        ContentValues values = new ContentValues();

        values.put("nome", this.nome);
        values.put("laboratorio", this.laboratorio);
        values.put("finalidade", this.finalidade);
        values.put("valor", this.valor);
        values.put("qtd", this.qtd);
        values.put("dosagem", this.dosagem);

        return  values;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
