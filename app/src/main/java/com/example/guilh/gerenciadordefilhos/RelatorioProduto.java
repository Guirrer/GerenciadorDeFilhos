package com.example.guilh.gerenciadordefilhos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.guilh.gerenciadordefilhos.Util.Database;
import com.example.guilh.gerenciadordefilhos.tabelas.tableProdutoFilho;

public class RelatorioProduto extends AppCompatActivity {

    private ListView lvProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio_produto);

        tableProdutoFilho tableProdutoFilho = new tableProdutoFilho();

        this.lvProduto = (ListView) findViewById(R.id.lvProduto);

        Database db = new Database(this.getApplicationContext());

        ArrayAdapter<tableProdutoFilho> adapter = new ArrayAdapter<tableProdutoFilho>(this, android.R.layout.simple_list_item_1, tableProdutoFilho.selectList(db.getReadableDatabase()));

        lvProduto.setAdapter(adapter);
    }
}
