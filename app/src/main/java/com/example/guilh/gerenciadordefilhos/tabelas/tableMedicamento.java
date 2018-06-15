package com.example.guilh.gerenciadordefilhos.tabelas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.example.guilh.gerenciadordefilhos.Util.Database;

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
    private Integer qtd;
    private Float dosagem;
    private SQLiteDatabase db;

    public tableMedicamento(SQLiteDatabase db)
    {
        this.db = db;
    }

    public Float getDosagem() {
        return dosagem;
    }

    public void setDosagem(Float dosagem) {
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

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
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
                    "qtd INTEGER  NOT NULL, " +
                    "PRIMARY KEY (medicamento_id), " +
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

    public List<tableMedicamento> selectList()
    {
        String query = "SELECT * FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        List<tableMedicamento> list = new List<tableMedicamento>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<tableMedicamento> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] a) {
                return null;
            }

            @Override
            public boolean add(tableMedicamento tableMedicamento) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends tableMedicamento> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, @NonNull Collection<? extends tableMedicamento> c) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public tableMedicamento get(int index) {
                return null;
            }

            @Override
            public tableMedicamento set(int index, tableMedicamento tableMedicamento) {
                return null;
            }

            @Override
            public void add(int index, tableMedicamento tableMedicamento) {

            }

            @Override
            public tableMedicamento remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<tableMedicamento> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<tableMedicamento> listIterator(int index) {
                return null;
            }

            @NonNull
            @Override
            public List<tableMedicamento> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                tableMedicamento table = new tableMedicamento(db);
                table.medicamento_id = c.getInt(c.getColumnIndex("medicamento_id"));
                table.nome = c.getString(c.getColumnIndex("nome"));
                table.laboratorio = c.getString(c.getColumnIndex("laboratorio"));
                table.finalidade = c.getString(c.getColumnIndex("finalidade"));
                table.valor = c.getFloat(c.getColumnIndex("valor"));
                table.local_compra = c.getString(c.getColumnIndex("local_compra"));
                table.qtd = c.getInt(c.getColumnIndex("qtd"));
                table.dosagem = c.getFloat(c.getColumnIndex("dosagem"));
                list.add(table);
            }
        }
        return list;
    }

    public void select(int id)
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
                this.qtd = c.getInt(c.getColumnIndex("qtd"));
                this.dosagem = c.getFloat(c.getColumnIndex("dosagem"));
            }
        }
    }

    private ContentValues retornaValues()
    {
        ContentValues values = new ContentValues();

        values.put("medicamento_id", this.medicamento_id);
        values.put("nome", this.nome);
        values.put("laboratorio", this.laboratorio);
        values.put("finalidade", this.finalidade);
        values.put("valor", this.valor);
        values.put("qtd", this.qtd);
        values.put("dosagem", this.dosagem);

        return  values;
    }
}
