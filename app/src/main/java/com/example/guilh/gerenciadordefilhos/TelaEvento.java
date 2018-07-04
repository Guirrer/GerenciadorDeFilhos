package com.example.guilh.gerenciadordefilhos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.guilh.gerenciadordefilhos.Util.Database;
import com.example.guilh.gerenciadordefilhos.tabelas.tableEventos;
import com.example.guilh.gerenciadordefilhos.tabelas.tableFilho;

import java.util.List;

public class TelaEvento extends AppCompatActivity {

    private ListView lvEvento;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_evento);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        lvEvento = (ListView)  findViewById(R.id.lvEvento);


        Database db = new Database(this.getApplicationContext());

        tableEventos eventos = new tableEventos();

        List<tableEventos> listaEvento = eventos.selectList(db.getReadableDatabase());

        ArrayAdapter<tableEventos> adapter = new ArrayAdapter<tableEventos>(this, android.R.layout.simple_list_item_1, listaEvento);

        lvEvento.setAdapter(adapter);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaEvento.this, CadastroEvento.class);
                startActivity(intent);
            }
        });

        lvEvento.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tableEventos eventos = (tableEventos) parent.getItemAtPosition(position);

                Intent intent = new Intent(TelaEvento.this, CadastroEvento.class);
                Bundle bundle = new Bundle();

                bundle.putSerializable("evento", eventos);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
    protected void onResume() {
        super.onResume();
        Database db = new Database(this.getApplicationContext());

        tableEventos eventos = new tableEventos();
        List<tableEventos> listaEvento = eventos.selectList(db.getReadableDatabase());

        ArrayAdapter<tableEventos> adapter = new ArrayAdapter<tableEventos>(this, android.R.layout.simple_list_item_1, listaEvento);

        lvEvento.setAdapter(adapter);
    }
}
