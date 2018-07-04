package com.example.guilh.gerenciadordefilhos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guilh.gerenciadordefilhos.Util.Database;
import com.example.guilh.gerenciadordefilhos.tabelas.tableEventos;
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

    private Boolean update;

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

        update = false;

        db = new Database(getApplicationContext());

        tableMedicamento = new tableMedicamento();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        try
        {
            tableMedicamento = (tableMedicamento) bundle.getSerializable("medicamento");
            preencheCampos();

        }
        catch (Exception e)
        {

        }

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tableMedicamento.setNome(etNomeMedicamento.getText().toString());
                tableMedicamento.setFinalidade(etFinalidade.getText().toString());
                tableMedicamento.setLaboratorio(etLaboratorio.getText().toString());
                tableMedicamento.setValor(Float.parseFloat(etValor.getText().toString().replace(",",".")));
                tableMedicamento.setLocal_compra(etLocalCompra.getText().toString());
                tableMedicamento.setQtd(etQuantidade.getText().toString());
                tableMedicamento.setDosagem(etDosagem.getText().toString());
                if(update){
                    if (tableMedicamento.update(db.getReadableDatabase()) != -1) {
                        tableMedicamento.setMedicamento_id(tableMedicamento.getMedicamento_id());
                        limpaCampo();
                        AlertDialog alertDialog = new AlertDialog.Builder(CadastroMedicamento.this).create();
                        alertDialog.setTitle("ALERTA");
                        alertDialog.setMessage("Informações alteradas com sucesso!");

                        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                            }
                        });

                        alertDialog.show();


                    }
                }
                else {
                    if (tableMedicamento.insert(db.getReadableDatabase()) != -1) {
                        tableMedicamento.setMedicamento_id(tableMedicamento.getMedicamento_id());
                        limpaCampo();
                        AlertDialog alertDialog = new AlertDialog.Builder(CadastroMedicamento.this).create();
                        alertDialog.setTitle("ALERTA");
                        alertDialog.setMessage("Medicamento cadastrado com sucesso!");

                        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                            }
                        });

                        alertDialog.show();
                    }
                }
            }
        });

    }

    private void limpaCampo()
    {
        etNomeMedicamento.setText("");
        etFinalidade.setText("");
        etLaboratorio.setText("");
        etValor.setText("");
        etLocalCompra.setText("");
        etQuantidade.setText("");
        etDosagem.setText("");
    }

    private void preencheCampos()
    {
        etNomeMedicamento.setText(tableMedicamento.getNome());
        etFinalidade.setText(tableMedicamento.getFinalidade());
        etLaboratorio.setText(tableMedicamento.getLaboratorio().toString());
        etValor.setText(tableMedicamento.getValor().toString());
        etLocalCompra.setText(tableMedicamento.getLocal_compra().toString());
        etQuantidade.setText(tableMedicamento.getQtd().toString());
        etDosagem.setText(tableMedicamento.getDosagem().toString());
        update = true;

    }
}
