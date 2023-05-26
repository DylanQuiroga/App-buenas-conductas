package com.example.apppraxisii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TablaPuntaje extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_puntaje);

        ImageView flecha = findViewById(R.id.flecha);

        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ArrayList<String> listDatos;
        listDatos = new ArrayList<String>();

        DataBase db = new DataBase(getApplicationContext());
        HashMap<String, Integer> datosDiccionario = db.obtenerDatosComoDiccionario();
        List<Map.Entry<String, Integer>> listaEntradas = new ArrayList<>(datosDiccionario.entrySet());
        quicksort(listaEntradas, 0, listaEntradas.size() - 1);
        HashMap<String, Integer> diccionarioOrdenado = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> entrada : listaEntradas) {
            diccionarioOrdenado.put(entrada.getKey(), entrada.getValue());
        }

        for(Map.Entry<String, Integer> entry : diccionarioOrdenado.entrySet()){
            String nombre = entry.getKey();
            int puntaje = entry.getValue();

            listDatos.add(nombre +"........................................................"+ puntaje);
        }

        Modelo adapter = new Modelo(listDatos);
        rv.setAdapter(adapter);

        flecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public static void quicksort(List<Map.Entry<String, Integer>> lista, int inicio, int fin) {
        if (inicio < fin) {
            int indiceParticion = particion(lista, inicio, fin);
            quicksort(lista, inicio, indiceParticion - 1);
            quicksort(lista, indiceParticion + 1, fin);
        }
    }

    public static int particion(List<Map.Entry<String, Integer>> lista, int inicio, int fin) {
        int pivot = lista.get(fin).getValue();
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (lista.get(j).getValue() >= pivot) {
                i++;
                Collections.swap(lista, i, j);
            }
        }

        Collections.swap(lista, i + 1, fin);
        return i + 1;
    }
}