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
import com.example.guilh.gerenciadordefilhos.tabelas.tableMedicamento;

public class CadastroMedicamento extends AppCompatActivity {
    private EditText etNomeMedicamento;
    private EditText etFinalidade;
    private EditText etLaboratorio;
    private EditText etValor;
    private EditText etLocalCompra;
    private EditText etQuantidade;
    private EditText etDosagem;

    private Button btnCadastrar;

    private tableMedicamento tableMedicamento;
    private Database db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_medicamento);

        etNomeMedicamento = (EditText) findViewById(R.id.etNomeMedicamento);
        etFinalidade = (EditText) findViewById(R.id.etFinalidade);
        etLaboratorio = (EditText) findViewById(R.id.etLaboratorio);
        etValor = (EditText) findViewById(R.id.etValor);
        etLocalCompra = (EditText) findViewById(R.id.etLocalCompra);
        etQuantidade = (EditText) findViewById(R.id.etQuantidade);
        etDosagem = (EditText) findViewById(R.id.etDosagem);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        db = new Database(getApplicationContext());

        tableMedicamento = new tableMedicamento();

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tableMedicamento.setNome(etNomeMedicamento.getText().toString());
                tableMedicamento.setFinalidade(etFinalidade.getText().toString());
                tableMedicamento.setLaboratorio(etLaboratorio.getText().toString());
                tableMedicamento.setValor(Float.parseFloat(etValor.getText().toString().replace(",",".")));
                tableMedicamento.setLocal_compra(etLocalCompra.getText().toString());
                tableMedicamento.setQtd(Integer.parseInt(etQuantidade.getText().toString()));
                tableMedicamento.setDosagem(Float.parseFloat(etDosagem.getText().toString().replace(",",".")));
                tableMedicamento.insert(db.getReadableDatabase());
                tableMedicamento.selectMaxId(db.getReadableDatabase());
                if(tableMedicamento.insert(db.getReadableDatabase()) != -1)
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(CadastroMedicamento.this).create();
                    alertDialog.setTitle("ALERTA");
                    alertDialog.setMessage("Medicamento cadastrado com sucesso.");

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
