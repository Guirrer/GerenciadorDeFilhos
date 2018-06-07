package com.example.guilh.gerenciadordefilhos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guilh.gerenciadordefilhos.Util.Database;
import com.example.guilh.gerenciadordefilhos.tabelas.tableUsuario;

public class MainActivity extends AppCompatActivity {

    private Database db;
    private EditText etLogin;
    private EditText etSenha;
    private Button btnLogin;
    private tableUsuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new Database(getApplicationContext());

        etLogin = (EditText) findViewById(R.id.etLogin);
        etSenha = (EditText) findViewById(R.id.etSenha);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        user = new tableUsuario(this.getApplicationContext());

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {

            }
        });

        setContentView(R.layout.activity_main);
    }
}
