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
        List<tableVacinacao> list = new List<tableVacinacao>() {
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
            public Iterator<tableVacinacao> iterator() {
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
            public boolean add(tableVacinacao tableVacinacao) {
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
            public boolean addAll(@NonNull Collection<? extends tableVacinacao> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, @NonNull Collection<? extends tableVacinacao> c) {
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
            public tableVacinacao get(int index) {
                return null;
            }

            @Override
            public tableVacinacao set(int index, tableVacinacao element) {
                return null;
            }

            @Override
            public void add(int index, tableVacinacao element) {

            }

            @Override
            public tableVacinacao remove(int index) {
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
            public ListIterator<tableVacinacao> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<tableVacinacao> listIterator(int index) {
                return null;
            }

            @NonNull
            @Override
            public List<tableVacinacao> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                tableVacinacao table = new tableVacinacao();
                table.vacinas_id = c.getInt(c.getColumnIndex("vacinas_id"));
                table.filho_id = c.getInt(c.getColumnIndex("filho_id"));
                table.data_vacina = c.getString(c.getColumnIndex("data_vacina"));
                list.add(table);
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
