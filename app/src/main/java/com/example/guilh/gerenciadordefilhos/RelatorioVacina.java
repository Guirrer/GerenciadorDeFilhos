package com.example.guilh.gerenciadordefilhos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.guilh.gerenciadordefilhos.Util.Database;
import com.example.guilh.gerenciadordefilhos.tabelas.tableFilho;
import com.example.guilh.gerenciadordefilhos.tabelas.tableVacinas;

import java.util.List;

public class RelatorioVacina extends AppCompatActivity {

    private ListView lvVacina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio_vacina);

        tableVacinas tableVacinas = new tableVacinas();

        this.lvVacina = (ListView) findViewById(R.id.lvVacina);

        Database db = new Database(this.getApplicationContext());

        List<tableVacinas> listaVacinas = tableVacinas.selectList(db.getReadableDatabase());

        ArrayAdapter<tableVacinas> adapter;
        adapter = new ArrayAdapter<tableVacinas>(this, android.R.layout.simple_list_item_1, listaVacinas);

        lvVacina.setAdapter(adapter);

    }
}
