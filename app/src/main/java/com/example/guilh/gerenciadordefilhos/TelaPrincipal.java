package com.example.guilh.gerenciadordefilhos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPrincipal extends AppCompatActivity {
    private Button btnCadastrarFilho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        btnCadastrarFilho = (Button) findViewById(R.id.btnCadastrarFilho);

        btnCadastrarFilho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipal.this, CadastroFilho.class);
                startActivity(intent);
            }
        });
    }
}
