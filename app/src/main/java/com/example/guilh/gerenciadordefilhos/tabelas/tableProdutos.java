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

public class tableProdutos extends Database {
    private static  final String TABLE = "produtos";

    private Integer produto_id;
    private String nome;
    private SQLiteDatabase db;
    private Context context;

    public tableProdutos(Context context) {
        super(context);
        this.context = context;
        db = this.getWritableDatabase();
    }

    public Integer getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Integer produto_id) {
        this.produto_id = produto_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "produto_id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, " +
                    "nome VARCHAR(255) NOT NULL, " +
                    "PRIMARY KEY (produto_id), " +
                    ")";

    private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

    public String create() { return CREATE; }

    public String upgrade() { return DROP; }

    public int update()
    {
        return db.update(TABLE, retornaValues(), "produto_id = ?", new String[]{ this.produto_id.toString() });
    }

    public void selectMaxId()
    {
        String query = "SELECT MAX(ID) FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                this.produto_id = c.getColumnIndex("produto_id");
            }
        }
    }

    public List<tableProdutos> selectList()
    {
        String query = "SELECT * FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        List<tableProdutos> list = new List<tableProdutos>() {
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
            public Iterator<tableProdutos> iterator() {
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
            public boolean add(tableProdutos tableProdutos) {
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
            public boolean addAll(@NonNull Collection<? extends tableProdutos> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, @NonNull Collection<? extends tableProdutos> c) {
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
            public tableProdutos get(int index) {
                return null;
            }

            @Override
            public tableProdutos set(int index, tableProdutos element) {
                return null;
            }

            @Override
            public void add(int index, tableProdutos element) {

            }

            @Override
            public tableProdutos remove(int index) {
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
            public ListIterator<tableProdutos> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<tableProdutos> listIterator(int index) {
                return null;
            }

            @NonNull
            @Override
            public List<tableProdutos> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                tableProdutos table = new tableProdutos(this.context);
                table.produto_id = c.getInt(c.getColumnIndex("produto_id"));
                table.nome = c.getString(c.getColumnIndex("nome"));
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
                this.produto_id = c.getInt(c.getColumnIndex("produto_id"));
                this.nome = c.getString(c.getColumnIndex("nome"));
            }
        }
    }

    private ContentValues retornaValues()
    {
        ContentValues values = new ContentValues();

        values.put("produto_id", this.produto_id);
        values.put("nome", this.nome);

        return  values;
    }

    @Override
    public String toString()
    {
        return nome;
    }
}
