package com.example.guilh.gerenciadordefilhos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.guilh.gerenciadordefilhos.Util.Database;
import com.example.guilh.gerenciadordefilhos.tabelas.*;

import java.util.Date;

public class CadastroFilho extends AppCompatActivity {

    private EditText etNome;
    private EditText etDtaNasc;
    private EditText etAltura;
    private EditText etPeso;
    private EditText edtTamPe;


    private RadioButton rbMasc;
    private RadioButton rbFem;

    private Button btnCadastrar;

    private tableFilho tableFilho;
    private tableMedidas tableMedidas;
    private tableUsuario usuario;
    private  Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_filho);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        usuario = (tableUsuario) bundle.getSerializable("usuario");

        etNome = (EditText) findViewById(R.id.etNome);
        etDtaNasc = (EditText) findViewById(R.id.etDtaNasc);
        etAltura = (EditText) findViewById(R.id.etAltura);
        etPeso = (EditText) findViewById(R.id.etPeso);
        edtTamPe = (EditText) findViewById(R.id.edtTamPe);

        rbFem = (RadioButton) findViewById(R.id.rbFem);
        rbMasc = (RadioButton) findViewById(R.id.rbMasc);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        db = new Database(getApplicationContext());

        tableFilho = new tableFilho();
        tableMedidas = new tableMedidas();

        btnCadastrar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                tableFilho.setNome(etNome.getText().toString());
                tableFilho.setData_nasc(etDtaNasc.getText().toString());
                tableFilho.setSexo(rbFem.isChecked() ? "Feminino" : "Masculino");
                tableFilho.setUsuario_id(usuario.getId());
                tableMedidas.setAltura(Float.parseFloat(etAltura.getText().toString().replace(",",".")));
                tableMedidas.setPeso(Float.parseFloat(etPeso.getText().toString().replace(",",".")));
                tableMedidas.setTam_pe(Integer.parseInt(edtTamPe.getText().toString()));
                Date data = new Date();
                tableMedidas.setData_dado(data.toString());
                if(tableFilho.insert(db.getReadableDatabase()) != -1)
                {
                    tableFilho.selectMaxId(db.getReadableDatabase());
                    tableMedidas.setFilho_id(tableFilho.getId());
                    tableMedidas.insert(db.getReadableDatabase());
                    AlertDialog alertDialog = new AlertDialog.Builder(CadastroFilho.this).create();
                    alertDialog.setTitle("ALERTA");
                    alertDialog.setMessage("Filho(a) cadastrado com sucesso!");

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
