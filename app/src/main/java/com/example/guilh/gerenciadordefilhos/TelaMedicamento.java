package com.example.guilh.gerenciadordefilhos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.guilh.gerenciadordefilhos.Util.Database;
import com.example.guilh.gerenciadordefilhos.tabelas.tableFilho;
import com.example.guilh.gerenciadordefilhos.tabelas.tableMedicamento;

import java.util.List;

public class TelaMedicamento extends AppCompatActivity {

    private Button btnCadastrar;
    private ListView lvMedicamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_medicamento);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        lvMedicamento = (ListView)  findViewById(R.id.lvMedicamento);

        tableMedicamento medicamento = new tableMedicamento();

        this.lvMedicamento = (ListView) findViewById(R.id.lvMedicamento);

        Database db = new Database(this.getApplicationContext());


        List<tableMedicamento> listaMedicamento = medicamento.selectList(db.getReadableDatabase());

        ArrayAdapter<tableMedicamento> adapter = new ArrayAdapter<tableMedicamento>(this, android.R.layout.simple_list_item_1, listaMedicamento);


        lvMedicamento.setAdapter(adapter);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaMedicamento.this, CadastroMedicamento.class);
                startActivity(intent);
            }
        });

    }
}
