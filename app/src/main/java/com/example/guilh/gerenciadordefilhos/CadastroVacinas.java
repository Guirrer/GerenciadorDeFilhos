package com.example.guilh.gerenciadordefilhos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guilh.gerenciadordefilhos.Util.Database;
import com.example.guilh.gerenciadordefilhos.tabelas.tableVacinas;

public class CadastroVacinas extends AppCompatActivity {
    private EditText etNomeVacina;
    private EditText etDoseVacina;
    private EditText etPeriodiciadade;
    private EditText etIdadeMinima;
    private EditText etValidade;

    private Button btnCadastrarVacina;

    private tableVacinas tableVacinas;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_vacinas);

        etNomeVacina = (EditText) findViewById(R.id.etNomeVacina);
        etDoseVacina = (EditText) findViewById(R.id.etDoseVacina);
        etPeriodiciadade = (EditText) findViewById(R.id.etPeriodiciadade);
        etIdadeMinima = (EditText) findViewById(R.id.etIdadeMinima);
        etValidade = (EditText) findViewById(R.id.etValidade);

        btnCadastrarVacina = (Button) findViewById(R.id.btnCadastrarVacina);

        db = new Database(getApplicationContext());

        tableVacinas = new tableVacinas();

        btnCadastrarVacina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tableVacinas.setNome_vacina(etNomeVacina.getText().toString());
                tableVacinas.setValidade(Float.parseFloat(etValidade.getText().toString()));
                tableVacinas.setPeriodicidade(Float.parseFloat(etPeriodiciadade.getText().toString()));
                tableVacinas.setIdade_minima(Integer.parseInt(etIdadeMinima.getText().toString()));
                tableVacinas.setDose(Integer.parseInt(etDoseVacina.getText().toString()));
                tableVacinas.insert(db.getReadableDatabase());
                if(tableVacinas.insert(db.getReadableDatabase()) != -1)
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(CadastroVacinas.this).create();
                    alertDialog.setTitle("ALERTA");
                    alertDialog.setMessage("Vacina cadastrado com sucesso.");

                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                        }
                    });

                    alertDialog.show();

                }
            }
        });

    }
}
