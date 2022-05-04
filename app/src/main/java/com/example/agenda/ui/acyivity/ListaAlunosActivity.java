package com.example.agenda.ui.acyivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.dao.AlunoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaAlunosActivity extends AppCompatActivity {

    private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        setTitle("Lista de alunos");

        FloatingActionButton fabButton = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);

        ConfiguraFabAluno(fabButton);
    }

    private void ConfiguraFabAluno(FloatingActionButton fabButton) {
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AbreForularioAluno();
            }
        });
    }

    private void AbreForularioAluno() {
        startActivity(new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        ConfiguraLista();
    }

    private void ConfiguraLista() {
        ListView listaDeAlnos = findViewById(R.id.activity_main_lista_alunos_listview);
        listaDeAlnos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.todos()));
    }
}
