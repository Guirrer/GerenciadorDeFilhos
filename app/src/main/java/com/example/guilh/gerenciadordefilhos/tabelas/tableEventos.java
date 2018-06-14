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

public class tableEventos {
    private static  final String TABLE = "eventos";

    private Integer eventos_id;
    private String datahora_evento;
    private String local_evento;
    private String nome_evento;
    private String descricao;

    public Integer getEventos_id() {
        return eventos_id;
    }

    public void setEventos_id(Integer eventos_id) {
        this.eventos_id = eventos_id;
    }

    public String getDatahora_evento() {
        return datahora_evento;
    }

    public void setDatahora_evento(String datahora_evento) {
        this.datahora_evento = datahora_evento;
    }

    public String getLocal_evento() {
        return local_evento;
    }

    public void setLocal_evento(String local_evento) {
        this.local_evento = local_evento;
    }

    public String getNome_evento() {
        return nome_evento;
    }

    public void setNome_evento(String nome_evento) {
        this.nome_evento = nome_evento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "eventos_id INTEGER NOT NULL , " +
                    "datahora_evento DATE NOT NULL, " +
                    "local_evento TEXT NULL DEFAULT NULL, " +
                    "nome_evento TEXT NULL DEFAULT NULL, " +
                    "descricao TEXT NULL DEFAULT NULL, " +
                    "PRIMARY KEY (eventos_id)" + " " +
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
        return db.update(TABLE, retornaValues(), "eventos_id = ?", new String[]{ this.eventos_id.toString() });
    }

    public void selectMaxId(SQLiteDatabase db)
    {
        String query = "SELECT MAX(ID) FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                this.eventos_id = c.getColumnIndex("eventos_id");
            }
        }
    }

    public List<tableEventos> selectList(SQLiteDatabase db)
    {
        String query = "SELECT * FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        List<tableEventos> list = new List<tableEventos>() {
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
            public Iterator<tableEventos> iterator() {
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
            public boolean add(tableEventos tableEventos) {
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
            public boolean addAll(@NonNull Collection<? extends tableEventos> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, @NonNull Collection<? extends tableEventos> c) {
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
            public tableEventos get(int index) {
                return null;
            }

            @Override
            public tableEventos set(int index, tableEventos element) {
                return null;
            }

            @Override
            public void add(int index, tableEventos element) {

            }

            @Override
            public tableEventos remove(int index) {
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
            public ListIterator<tableEventos> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<tableEventos> listIterator(int index) {
                return null;
            }

            @NonNull
            @Override
            public List<tableEventos> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                tableEventos table = new tableEventos();
                table.eventos_id = c.getInt(c.getColumnIndex("eventos_id"));
                table.datahora_evento = c.getString(c.getColumnIndex("datahora_evento"));
                table.local_evento = c.getString(c.getColumnIndex("local_evento"));
                table.nome_evento = c.getString(c.getColumnIndex("nome_evento"));
                table.descricao = c.getString(c.getColumnIndex("descricao"));
                list.add(table);
            }
        }
        return list;
    }

    public void select(int id,SQLiteDatabase db)
    {
        String query = "SELECT * FROM " + TABLE + " WHERE ID = " + id ;
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                this.eventos_id = c.getInt(c.getColumnIndex("eventos_id"));
                this.datahora_evento = c.getString(c.getColumnIndex("datahora_evento"));
                this.local_evento = c.getString(c.getColumnIndex("local_evento"));
                this.nome_evento = c.getString(c.getColumnIndex("nome_evento"));
                this.descricao = c.getString(c.getColumnIndex("descricao"));
            }
        }
    }

    private ContentValues retornaValues()
    {
        ContentValues values = new ContentValues();

        values.put("eventos_id", this.eventos_id);
        values.put("datahora_evento", this.datahora_evento);
        values.put("local_evento", this.local_evento);
        values.put("nome_evento", this.nome_evento);
        values.put("descricao", this.descricao);

        return  values;
    }
}
