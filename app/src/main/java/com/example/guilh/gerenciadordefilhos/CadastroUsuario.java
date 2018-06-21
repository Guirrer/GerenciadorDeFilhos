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
import com.example.guilh.gerenciadordefilhos.tabelas.tableUsuario;

public class CadastroUsuario extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etSenha;
    private EditText etRepetirSenha;
    private EditText etEmail;
    private EditText etRepetirEmail;

    private Button btnCadastrar;

    private tableUsuario tableUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etSenha = (EditText) findViewById(R.id.etSenha);
        etRepetirSenha = (EditText) findViewById(R.id.etRepetirSenha);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etRepetirEmail = (EditText) findViewById(R.id.etRepetirEmail);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        final Database db = new Database(getApplicationContext());

        tableUsuario = new tableUsuario();

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tableUsuario.setNome(etUsuario.getText().toString());
                tableUsuario.setSenha(etSenha.getText().toString());
                tableUsuario.setEmail(etEmail.getText().toString());
                if(tableUsuario.insert(db.getReadableDatabase()) != -1)
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(CadastroUsuario.this).create();
                    alertDialog.setTitle("ALERTA");
                    alertDialog.setMessage("Usuário cadastrado com sucesso.");

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
