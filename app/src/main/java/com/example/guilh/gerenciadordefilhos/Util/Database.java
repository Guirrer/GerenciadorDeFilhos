package com.example.guilh.gerenciadordefilhos.Util;

/**
 * Created by guilh on 28/03/2018.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;

import com.example.guilh.gerenciadordefilhos.tabelas.tableEventoDosFilhos;
import com.example.guilh.gerenciadordefilhos.tabelas.*;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME  = "gerenciador_filho.db";
    private static final int DATABASE_VERSION   = 1;

    private tableEventoDosFilhos eventosFilhos;
    private tableEventos eventos;
    private tableFilho filho;
    private tableFilhoMedicamento filhoMedicamento;
    private tableMedidas medidas;
    private tableProdutoFilho produtoFilho;
    private tableProdutos produtos;
    private tableUsuario usuario;
    private tableVacinacao vacinacao;
    private tableVacinas vacinas;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        eventosFilhos = new tableEventoDosFilhos();
        eventos = new tableEventos();
        filho = new tableFilho();
        filhoMedicamento = new tableFilhoMedicamento();
        medidas = new tableMedidas();
        produtoFilho = new tableProdutoFilho();
        produtos = new tableProdutos();
        usuario = new tableUsuario();
        vacinacao = new tableVacinacao();
        vacinas = new tableVacinas();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(eventosFilhos.create());
        db.execSQL(eventos.create());
        db.execSQL(filho.create());
        db.execSQL(filhoMedicamento.create());
        db.execSQL(medidas.create());
        db.execSQL(produtoFilho.create());
        db.execSQL(produtos.create());
        db.execSQL(usuario.create());
        db.execSQL(vacinacao.create());
        db.execSQL(vacinas.create());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(eventosFilhos.upgrade());
        db.execSQL(eventos.upgrade());
        db.execSQL(filho.upgrade());
        db.execSQL(filhoMedicamento.upgrade());
        db.execSQL(medidas.upgrade());
        db.execSQL(produtoFilho.upgrade());
        db.execSQL(produtos.upgrade());
        db.execSQL(usuario.upgrade());
        db.execSQL(vacinacao.upgrade());
        db.execSQL(vacinas.upgrade());

        onCreate(db);
    }



}
