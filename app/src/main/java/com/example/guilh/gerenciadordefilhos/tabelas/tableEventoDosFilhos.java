package com.example.guilh.gerenciadordefilhos.tabelas;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class tableEventoDosFilhos  {
    private static  final String TABLE = "eventos_dos_filhos";

    private Integer id;
    private Integer filho_id;
    private Integer eventos_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFilho_id() {
        return filho_id;
    }

    public void setFilho_id(Integer filho_id) {
        this.filho_id = filho_id;
    }

    public Integer getEventos_id() {
        return eventos_id;
    }

    public void setEventos_id(Integer eventos_id) {
        this.eventos_id = eventos_id;
    }


    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "id INTEGER NOT NULL , " +
                    "filho_id INTEGER NOT NULL, " +
                    "eventos_id INTEGER NOT NULL, " +
                    "FOREIGN KEY (filho_id) REFERENCES filho (filho_id) ON DELETE NO ACTION ON UPDATE NO ACTION, " +
                    "FOREIGN KEY (eventos_id) REFERENCES eventos (eventos_id) ON DELETE NO ACTION ON UPDATE NO ACTION " +
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

    public List<tableEventoDosFilhos> selectList(SQLiteDatabase db)
    {
        String query = "SELECT * FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        List<tableEventoDosFilhos> list = new List<tableEventoDosFilhos>() {
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
            public Iterator<tableEventoDosFilhos> iterator() {
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
            public boolean add(tableEventoDosFilhos tableEventoDosFilhos) {
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
            public boolean addAll(@NonNull Collection<? extends tableEventoDosFilhos> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, @NonNull Collection<? extends tableEventoDosFilhos> c) {
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
            public tableEventoDosFilhos get(int index) {
                return null;
            }

            @Override
            public tableEventoDosFilhos set(int index, tableEventoDosFilhos element) {
                return null;
            }

            @Override
            public void add(int index, tableEventoDosFilhos element) {

            }

            @Override
            public tableEventoDosFilhos remove(int index) {
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
            public ListIterator<tableEventoDosFilhos> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<tableEventoDosFilhos> listIterator(int index) {
                return null;
            }

            @NonNull
            @Override
            public List<tableEventoDosFilhos> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                tableEventoDosFilhos table = new tableEventoDosFilhos();
                table.id = c.getInt(c.getColumnIndex("id"));
                table.eventos_id = c.getInt(c.getColumnIndex("eventos_id"));
                table.filho_id = c.getInt(c.getColumnIndex("filho_id"));
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
                this.id = c.getInt(c.getColumnIndex("id"));
                this.eventos_id = c.getInt(c.getColumnIndex("eventos_id"));
                this.filho_id = c.getInt(c.getColumnIndex("filho_id"));
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
                this.eventos_id = c.getInt(c.getColumnIndex("eventos_id"));
                this.filho_id = c.getInt(c.getColumnIndex("filho_id"));
            }
        }
        return  valid;
    }

    private ContentValues retornaValues()
    {
        ContentValues values = new ContentValues();

        values.put("filho_id", this.filho_id);
        values.put("eventos_id", this.eventos_id);

        return  values;
    }


}
