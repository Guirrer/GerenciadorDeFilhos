package com.example.guilh.gerenciadordefilhos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.guilh.gerenciadordefilhos.Util.Database;
import com.example.guilh.gerenciadordefilhos.tabelas.tableVacinas;

public class RelatorioVacina extends AppCompatActivity {

    private ListView lvVacina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio_vacina);

        tableVacinas tableVacinas = new tableVacinas();

        this.lvVacina = (ListView) findViewById(R.id.lvProduto);

        Database db = new Database(this.getApplicationContext());

        //ArrayAdapter<tableVacinas> adapter;
        //adapter = new ArrayAdapter<tableVacinas>(this, android.R.layout.simple_list_item_1, com.example.guilh.gerenciadordefilhos.tabelas.tableVacinas.selectList(db.getReadableDatabase()));

       // lvVacina.setAdapter(adapter);

    }
}
