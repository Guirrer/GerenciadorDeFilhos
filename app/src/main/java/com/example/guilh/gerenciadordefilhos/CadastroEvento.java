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
import com.example.guilh.gerenciadordefilhos.tabelas.tableEventos;

public class CadastroEvento extends AppCompatActivity {
    private EditText etNomeEvento;
    private EditText etDtaEvento;
    private EditText etLocalEvento;
    private EditText etObservacoes;

    private Button btnCadastrar;
    private tableEventos tableEventos;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_evento);

        etNomeEvento = (EditText) findViewById(R.id.etNomeEvento);
        etDtaEvento = (EditText) findViewById(R.id.etDtaEvento);
        etLocalEvento = (EditText) findViewById(R.id.etLocalEvento);
        etObservacoes = (EditText) findViewById(R.id.etObservacoes);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        db = new Database(getApplicationContext());

        tableEventos = new tableEventos();

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tableEventos.setNome_evento(etNomeEvento.getText().toString());
                tableEventos.setDatahora_evento(etDtaEvento.getText().toString());
                tableEventos.setLocal_evento(etLocalEvento.getText().toString());
                tableEventos.setDescricao(etObservacoes.getText().toString());
                if(tableEventos.insert(db.getReadableDatabase()) != -1)
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(CadastroEvento.this).create();
                    alertDialog.setTitle("ALERTA");
                    alertDialog.setMessage("Evento cadastrado com sucesso.");
                    limparCampos();
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

    private void limparCampos()
    {
        etNomeEvento.setText("");
        etDtaEvento.setText("");
        etLocalEvento.setText("");
        etObservacoes.setText("");
    }
}
