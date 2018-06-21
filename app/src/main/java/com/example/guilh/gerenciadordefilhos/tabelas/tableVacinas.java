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

public class tableVacinas {
    private static  final String TABLE = "vacinas";

    private Integer id;
    private String nome_vacina;
    private Integer idade_minima;
    private Integer dose;
    private Float validade;
    private Float periodicidade;



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

    public Integer getIdade_minima() {
        return idade_minima;
    }

    public void setIdade_minima(Integer idade_minima) {
        this.idade_minima = idade_minima;
    }

    public Integer getDose() {
        return dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
    }

    public Float getValidade() {
        return validade;
    }

    public void setValidade(Float validade) {
        this.validade = validade;
    }

    public Float getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(Float periodicidade) {
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
                this.idade_minima = c.getInt(c.getColumnIndex("idade_minima"));
                this.dose = c.getInt(c.getColumnIndex("dose"));
                this.validade = c.getFloat(c.getColumnIndex("validade"));
                this.periodicidade = c.getFloat(c.getColumnIndex("periodicidade"));
            }
        }
    }

    public void selectList(SQLiteDatabase db)
    {
        String query = "SELECT * FROM " + TABLE + " WHERE ID = " + id ;
        Cursor c = db.rawQuery(query, null);
        List<tableVacinas> list = new List<tableVacinas>() {
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
            public Iterator<tableVacinas> iterator() {
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
            public boolean add(tableVacinas tableVacinas) {
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
            public boolean addAll(@NonNull Collection<? extends tableVacinas> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, @NonNull Collection<? extends tableVacinas> c) {
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
            public tableVacinas get(int index) {
                return null;
            }

            @Override
            public tableVacinas set(int index, tableVacinas element) {
                return null;
            }

            @Override
            public void add(int index, tableVacinas element) {

            }

            @Override
            public tableVacinas remove(int index) {
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
            public ListIterator<tableVacinas> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<tableVacinas> listIterator(int index) {
                return null;
            }

            @NonNull
            @Override
            public List<tableVacinas> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                tableVacinas table = new tableVacinas();
                table.id = c.getInt(c.getColumnIndex("id"));
                table.nome_vacina = c.getString(c.getColumnIndex("nome_vacina"));
                table.idade_minima = c.getInt(c.getColumnIndex("idade_minima"));
                table.dose = c.getInt(c.getColumnIndex("dose"));
                table.validade = c.getFloat(c.getColumnIndex("validade"));
                table.periodicidade = c.getFloat(c.getColumnIndex("periodicidade"));
                list.add(table);
            }
        }
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
}
