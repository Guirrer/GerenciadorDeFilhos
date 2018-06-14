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

public class tableFilhoMedicamento {
    private static  final String TABLE = "filhomedicamento";

    private Integer idfilho_medicamento;
    private Integer filho_id;
    private Integer medicamento_id;
    public Integer getIdfilho_medicamento() {
        return idfilho_medicamento;
    }

    public void setIdfilho_medicamento(Integer idfilho_medicamento) {
        this.idfilho_medicamento = idfilho_medicamento;
    }

    public Integer getFilho_id() {
        return filho_id;
    }

    public void setFilho_id(Integer filho_id) {
        this.filho_id = filho_id;
    }

    public Integer getMedicamento_id() {
        return medicamento_id;
    }

    public void setMedicamento_id(Integer medicamento_id) {
        this.medicamento_id = medicamento_id;
    }

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "idfilho_medicamento INTEGER  NOT NULL , " +
                    "filho_id INTEGER NOT NULL, " +
                    "medicamento_id INTEGER NOT NULL, " +
                    "dosagem FLOAT  NULL DEFAULT NULL, " +
                    "periodo FLOAT  NULL DEFAULT NULL, " +
                    "observacao TEXT NULL DEFAULT NULL, " +
                    "PRIMARY KEY (idfilho_medicamento), "  +
                    "FOREIGN KEY (filho_id) REFERENCES filho (id) ON DELETE NO ACTION ON UPDATE NO ACTION" +
                    "FOREIGN KEY (medicamento_id) REFERENCES medicamento (medicamento_id) ON DELETE NO ACTION ON UPDATE NO ACTION" +
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
        return db.update(TABLE, retornaValues(), "idfilho_medicamento = ?", new String[]{ this.idfilho_medicamento.toString() });
    }

    public void selectMaxId(SQLiteDatabase db)
    {
        String query = "SELECT MAX(ID) FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                this.idfilho_medicamento = c.getColumnIndex("idfilho_medicamento");
            }
        }
    }

    public List<tableFilhoMedicamento> selectList(SQLiteDatabase db)
    {
        String query = "SELECT * FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        List<tableFilhoMedicamento> list = new List<tableFilhoMedicamento>() {
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
            public Iterator<tableFilhoMedicamento> iterator() {
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
            public boolean add(tableFilhoMedicamento tableFilhoMedicamento) {
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
            public boolean addAll(@NonNull Collection<? extends tableFilhoMedicamento> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, @NonNull Collection<? extends tableFilhoMedicamento> c) {
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
            public tableFilhoMedicamento get(int index) {
                return null;
            }

            @Override
            public tableFilhoMedicamento set(int index, tableFilhoMedicamento element) {
                return null;
            }

            @Override
            public void add(int index, tableFilhoMedicamento element) {

            }

            @Override
            public tableFilhoMedicamento remove(int index) {
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
            public ListIterator<tableFilhoMedicamento> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<tableFilhoMedicamento> listIterator(int index) {
                return null;
            }

            @NonNull
            @Override
            public List<tableFilhoMedicamento> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                tableFilhoMedicamento table = new tableFilhoMedicamento();
                table.idfilho_medicamento = c.getInt(c.getColumnIndex("idfilho_medicamento"));
                table.filho_id = c.getInt(c.getColumnIndex("filho_id"));
                table.medicamento_id = c.getInt(c.getColumnIndex("medicamento_id"));
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
                this.idfilho_medicamento = c.getInt(c.getColumnIndex("idfilho_medicamento"));
                this.filho_id = c.getInt(c.getColumnIndex("filho_id"));
                this.medicamento_id = c.getInt(c.getColumnIndex("medicamento_id"));
            }
        }
    }

    private ContentValues retornaValues()
    {
        ContentValues values = new ContentValues();

        values.put("idfilho_medicamento", this.idfilho_medicamento);
        values.put("filho_id", this.filho_id);
        values.put("medicamento_id", this.medicamento_id);

        return  values;
    }
}
