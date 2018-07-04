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
import com.example.guilh.gerenciadordefilhos.tabelas.tableVacinas;

import java.util.List;

public class TelaVacinacao extends AppCompatActivity {

    private Button btnCadastrar;
    private ListView lvVacina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_vacinacao);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        lvVacina = (ListView) findViewById(R.id.lvVacina);

        Database db = new Database(this.getApplicationContext());

        tableVacinas vacinas = new tableVacinas();

        List<tableVacinas> listaVacina = vacinas.selectList(db.getReadableDatabase());

        ArrayAdapter<tableVacinas> adapter = new ArrayAdapter<tableVacinas>(this, android.R.layout.simple_list_item_1, listaVacina);

        lvVacina.setAdapter(adapter);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaVacinacao.this, CadastroVacinas.class);
                startActivity(intent);
            }
        });

        lvVacina.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tableVacinas vacinas = (tableVacinas) parent.getItemAtPosition(position);

                Intent intent = new Intent(TelaVacinacao.this, CadastroVacinas.class);
                Bundle bundle = new Bundle();

                bundle.putSerializable("vacina", vacinas);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    protected void onResume() {
        super.onResume();
        Database db = new Database(this.getApplicationContext());

        tableVacinas vacinas = new tableVacinas();
        List<tableVacinas> listaVacina = vacinas.selectList(db.getReadableDatabase());

        ArrayAdapter<tableVacinas> adapter = new ArrayAdapter<tableVacinas>(this, android.R.layout.simple_list_item_1, listaVacina);

        lvVacina.setAdapter(adapter);
    }
}
