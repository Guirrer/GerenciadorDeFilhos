package com.example.guilh.gerenciadordefilhos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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

        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etSenha = (EditText) findViewById(R.id.etSenha);
        etRepetirSenha = (EditText) findViewById(R.id.etRepetirSenha);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etRepetirEmail = (EditText) findViewById(R.id.etRepetirEmail);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        Database db = new Database(getApplicationContext());

        tableUsuario = new tableUsuario();



        setContentView(R.layout.activity_cadastro_usuario);
    }
}
