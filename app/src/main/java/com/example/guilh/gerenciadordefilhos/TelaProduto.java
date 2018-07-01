package com.example.guilh.gerenciadordefilhos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

import com.example.guilh.gerenciadordefilhos.Util.Database;
import com.example.guilh.gerenciadordefilhos.tabelas.tableFilho;
import com.example.guilh.gerenciadordefilhos.tabelas.tableProdutoFilho;
import com.example.guilh.gerenciadordefilhos.tabelas.tableProdutos;
import com.example.guilh.gerenciadordefilhos.tabelas.tableUsuario;

import java.util.ArrayList;

public class TelaProduto extends AppCompatActivity {

    private tableProdutos produto;
    private tableFilho filho;

    private Spinner spNomeProduto;
    private Spinner spNomeFilho;
    private EditText etDetalhe;
    private EditText etQuantidade;
    private EditText etQuantidadePacotes;
    private EditText etPreco;
    private EditText etData;
    private EditText etLocalCompra;
    private Button btnCadastrarProduto;
    private tableUsuario usuario;
    private Database db;

    private List<tableProdutos> nomeProduto;
    private List<tableFilho> nomeFilho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_produto);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        this.usuario = new tableUsuario();
        usuario = (tableUsuario) bundle.getSerializable("usuario");


        db = new Database(this.getApplicationContext());
        produto = new tableProdutos();
        nomeProduto = produto.selectList(db.getReadableDatabase());
        filho = new tableFilho();
        nomeFilho = filho.selectList(db.getReadableDatabase(), usuario.getId().toString());
        spNomeFilho =  (Spinner) findViewById(R.id.spNomeFilho);
        spNomeProduto =  (Spinner) findViewById(R.id.spNomeProduto);
        etDetalhe =  (EditText) findViewById(R.id.etDetalhe);
        etQuantidade =  (EditText) findViewById(R.id.etQuantidade);
        etQuantidadePacotes =  (EditText) findViewById(R.id.etQuantidadePacotes);
        etPreco =  (EditText) findViewById(R.id.etPreco);
        etData =  (EditText) findViewById(R.id.etData);
        etLocalCompra =  (EditText) findViewById(R.id.etLocalCompra);
        btnCadastrarProduto =  (Button) findViewById(R.id.btnCadastrarProduto);

        ArrayAdapter<tableProdutos> arrayAdapterProduto = new ArrayAdapter<tableProdutos>(this, android.R.layout.simple_spinner_item, nomeProduto);
        ArrayAdapter<tableFilho> arrayAdapterFilho = new ArrayAdapter<tableFilho>(this, android.R.layout.simple_spinner_item, nomeFilho);
        arrayAdapterFilho.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapterProduto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spNomeProduto.setAdapter(arrayAdapterProduto);
        spNomeFilho.setAdapter(arrayAdapterFilho);


        spNomeProduto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
                produto = (tableProdutos) parent.getItemAtPosition(posicao);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spNomeFilho.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
                filho = (tableFilho) parent.getItemAtPosition(posicao);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnCadastrarProduto.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                tableProdutoFilho TableProdutoFilho = new tableProdutoFilho();
                TableProdutoFilho.setFilho_id(filho.getId());
                TableProdutoFilho.setProduto_id(produto.getProduto_id());
                TableProdutoFilho.setDetalhe(etDetalhe.getText().toString());
                TableProdutoFilho.setQtd_compra(Integer.parseInt(etQuantidade.getText().toString()));
                TableProdutoFilho.setQtd_pacote(Integer.parseInt(etQuantidadePacotes.getText().toString()));
                TableProdutoFilho.setPreco(Float.parseFloat(etPreco.getText().toString().replace(",",".")));
                TableProdutoFilho.setData_compra(etData.getText().toString());
                TableProdutoFilho.setLoja_compra(etLocalCompra.getText().toString());
                TableProdutoFilho.insert(db.getReadableDatabase());

            }
        });


    }
}
