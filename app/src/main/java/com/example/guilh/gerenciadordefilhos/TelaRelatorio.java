package com.example.guilh.gerenciadordefilhos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaRelatorio extends AppCompatActivity {

    private Button btnRelatorioProduto;
    private Button btnRelatorioVacina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_relatorio);

        btnRelatorioProduto = (Button) findViewById(R.id.btnRelatorioProduto);
        btnRelatorioVacina = (Button) findViewById(R.id.btnRelatorioVacina);

        btnRelatorioProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaRelatorio.this, RelatorioProduto.class);
                startActivity(intent);
            }
        });

        btnRelatorioVacina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaRelatorio.this, RelatorioVacina.class);
                startActivity(intent);
            }
        });
    }
}
