package com.example.practicaandreudecabo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.practicaandreudecabo.controller.NotaController;
import com.example.practicaandreudecabo.model.Nota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Nota> notas;
    EditText et_message;
    EditText et_message2;
    EditText et_message3;
    EditText et_message4;
    EditText et_message5;
    ListView listView;
    NotaAdapter adapter;
    NotaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_message = findViewById(R.id.et_message);
        listView = findViewById(R.id.listview);

        controller = NotaController.get(this); //Init el controller

        notas = new ArrayList<>();
        adapter = new NotaAdapter(this, R.layout.row, notas);

        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Nota n= notas.get(position);
                controller.deleteNota(n);
                getNotas();
                return true;
            }
        });
        getNotas();
    }

    private void getNotas()
    {
        notas.clear();
        notas.addAll(controller.getNotas());
        adapter.notifyDataSetChanged();
    }

    public void createNota(View view) {

        String message = et_message.getText().toString();
        String message2 = et_message2.getText().toString();
        String message3 = et_message3.getText().toString();
        String message4 = et_message4.getText().toString();
        String message5 = et_message5.getText().toString();

        if (!"".equals(message))
        {
            Nota nota = new Nota(message);
            controller.addNota(nota);
            getNotas();
        }
        if (!"".equals(message2))
        {
            Nota nota = new Nota(message2);
            controller.addNota(nota);
            getNotas();
        }
        else
        {
            Toast.makeText(this, "Message cannot be empty", Toast.LENGTH_LONG).show();
        }
    }
}
