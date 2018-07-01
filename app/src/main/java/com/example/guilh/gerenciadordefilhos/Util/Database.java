package com.example.guilh.gerenciadordefilhos.Util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    private tableMedicamento medicamento;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        eventosFilhos = new tableEventoDosFilhos();
        eventos = new tableEventos();
        filho = new tableFilho();
        medicamento = new tableMedicamento();
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
        db.execSQL(usuario.create());
        db.execSQL(filho.create());
        db.execSQL(eventos.create());
        db.execSQL(produtos.create());
        db.execSQL(vacinas.create());
        db.execSQL(eventosFilhos.create());
        db.execSQL(medicamento.create());
        db.execSQL(filhoMedicamento.create());
        db.execSQL(medidas.create());
        db.execSQL(produtoFilho.create());
        db.execSQL(vacinacao.create());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(usuario.upgrade());
        db.execSQL(filho.upgrade());
        db.execSQL(eventos.upgrade());
        db.execSQL(produtos.upgrade());
        db.execSQL(vacinas.upgrade());
        db.execSQL(eventosFilhos.upgrade());
        db.execSQL(medicamento.upgrade());
        db.execSQL(filhoMedicamento.upgrade());
        db.execSQL(medidas.upgrade());
        db.execSQL(produtoFilho.upgrade());
        db.execSQL(vacinacao.upgrade());

        onCreate(db);
    }
}
