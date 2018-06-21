package com.example.guilh.gerenciadordefilhos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guilh.gerenciadordefilhos.Util.Database;
import com.example.guilh.gerenciadordefilhos.tabelas.tableUsuario;

public class MainActivity extends AppCompatActivity {

    private Database db;
    private EditText etLogin;
    private EditText etSenha;
    private Button btnLogin;
    private Button btnCadastrar;
    private tableUsuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etLogin = (EditText) findViewById(R.id.etLogin);
        etSenha = (EditText) findViewById(R.id.etSenha);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        db = new Database(getApplicationContext());
        user = new tableUsuario();

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {

                if(user.selectUser(etLogin.getText().toString(), etSenha.getText().toString(), db.getReadableDatabase()))
                {
                    Intent intent = new Intent(MainActivity.this, TelaPrincipal.class);
                    startActivity(intent);
                }
                else
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("ALERTA");
                    alertDialog.setMessage("Usuário ou senha incorreto.");

                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                        }
                    });

                    alertDialog.show();
                }
            }
        });
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroUsuario.class);
                startActivity(intent);
            }
        });

    }
}
