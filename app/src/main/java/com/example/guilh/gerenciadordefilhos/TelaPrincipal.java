package com.example.guilh.gerenciadordefilhos;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;

import com.example.guilh.gerenciadordefilhos.Util.Database;
import com.example.guilh.gerenciadordefilhos.tabelas.tableFilho;
import com.example.guilh.gerenciadordefilhos.tabelas.tableUsuario;

import java.util.List;

public class TelaPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {

    private Button btnCadastrarFilho;
    private tableUsuario usuario;
    private ListView lvFilho;

    public TelaPrincipal()
    {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        this.usuario = new tableUsuario();
        usuario = (tableUsuario) bundle.getSerializable("usuario");

        tableFilho filho = new tableFilho();

        this.lvFilho = (ListView) findViewById(R.id.lvFilho);



        Database db = new Database(this.getApplicationContext());

        List<tableFilho> listaFilho = filho.selectList(db.getReadableDatabase(), usuario.getId().toString());

        ArrayAdapter<tableFilho> adapter = new ArrayAdapter<tableFilho>(this, android.R.layout.simple_list_item_1, listaFilho);


        lvFilho.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        btnCadastrarFilho = (Button) findViewById(R.id.btnCadastrarFilho);

        btnCadastrarFilho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipal.this, CadastroFilho.class);
                Bundle bundle = new Bundle();

                bundle.putSerializable("usuario", usuario);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_evento) {
            Intent intent = new Intent(TelaPrincipal.this, TelaEvento.class);
            startActivity(intent);
        } else if (id == R.id.nav_medicamento) {
            Intent intent = new Intent(TelaPrincipal.this, TelaMedicamento.class);
            startActivity(intent);
        } else if (id == R.id.nav_produto) {
            Intent intent = new Intent(TelaPrincipal.this, TelaProduto.class);
            Bundle bundle = new Bundle();

            bundle.putSerializable("usuario", usuario);
            intent.putExtras(bundle);
            startActivity(intent);
        } else if (id == R.id.nav_vacinacao) {
            Intent intent = new Intent(TelaPrincipal.this, TelaVacinacao.class);
            startActivity(intent);
        } else if (id == R.id.nav_vacinas) {
            Intent intent = new Intent(TelaPrincipal.this, TelaVacina.class);
            startActivity(intent);
        } else if (id == R.id.nav_relatorio) {
            Intent intent = new Intent(TelaPrincipal.this, TelaRelatorio.class);
            startActivity(intent);
        }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
