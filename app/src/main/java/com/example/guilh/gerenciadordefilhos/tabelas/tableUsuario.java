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

public class    tableUsuario extends Database {
    private static  final String TABLE = "usuario";

    private Integer id;
    private String nome;
    private String senha;
    private Integer telefone;
    private SQLiteDatabase db;
    private Context context;

    public tableUsuario(Context context) {
        super(context);
        this.context = context;
        db = this.getWritableDatabase();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, " +
                    "nome VARCHAR(255) NOT NULL, " +
                    "senha VARCHAR(60) NOT NULL, " +
                    "telefone INT(11) NOT NULL, " +
                    "PRIMARY KEY (id), " +
                    ")";

    private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

    public String create() { return CREATE; }

    public String upgrade() { return DROP; }

    public long insert()
    {
        return db.insert(TABLE, null, retornaValues());
    }

    public int update()
    {
        return db.update(TABLE, retornaValues(), "id = ?", new String[]{ this.id.toString() });
    }

    public void selectMaxId()
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

    public List<tableUsuario> selectList()
    {
        String query = "SELECT * FROM " + TABLE;
        Cursor c = db.rawQuery(query, null);
        List<tableUsuario> list = new List<tableUsuario>() {
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
            public Iterator<tableUsuario> iterator() {
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
            public boolean add(tableUsuario tableUsuario) {
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
            public boolean addAll(@NonNull Collection<? extends tableUsuario> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, @NonNull Collection<? extends tableUsuario> c) {
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
            public tableUsuario get(int index) {
                return null;
            }

            @Override
            public tableUsuario set(int index, tableUsuario element) {
                return null;
            }

            @Override
            public void add(int index, tableUsuario element) {

            }

            @Override
            public tableUsuario remove(int index) {
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
            public ListIterator<tableUsuario> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<tableUsuario> listIterator(int index) {
                return null;
            }

            @NonNull
            @Override
            public List<tableUsuario> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                tableUsuario table = new tableUsuario(this.context);
                table.id = c.getInt(c.getColumnIndex("id"));
                table.nome = c.getString(c.getColumnIndex("nome"));
                table.senha = c.getString(c.getColumnIndex("senha"));
                table.telefone = c.getInt(c.getColumnIndex("telefone"));
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
                this.id = c.getInt(c.getColumnIndex("id"));
                this.nome = c.getString(c.getColumnIndex("nome"));
                this.senha = c.getString(c.getColumnIndex("senha"));
                this.telefone = c.getInt(c.getColumnIndex("telefone"));
            }
        }
    }

    public boolean selectUser(String user, String senha)
    {
        boolean valid = false;
        String query = "SELECT * FROM " + TABLE + " WHERE nome = " + id + " AND senha = " + senha;
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
            if (c.getCount() > 0) {
                valid = true;
            }
        }
        return  valid;
    }

    private ContentValues retornaValues()
    {
        ContentValues values = new ContentValues();

        values.put("id", this.id);
        values.put("nome", this.nome);
        values.put("senha", this.senha);
        values.put("telefone", this.telefone);

        return  values;
    }
}
