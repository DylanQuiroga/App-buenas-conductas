package com.example.apppraxisii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private VG varGlob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        varGlob = (VG) getApplicationContext();
        ImageView imageComenzar = findViewById(R.id.imageComenzar);
        ImageView imageSalir = findViewById(R.id.imageSalir);
        ImageView imagePuntos = findViewById(R.id.puntos);

        imageComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                varGlob.ceroGlobalVariable();
                ejercicio1(view);
            }
        });

        imageSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                varGlob.ceroGlobalVariable();
                finish();
            }
        });

        imagePuntos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tabla(view);
            }
        });

    }

    public void ejercicio1(View view) {
        Intent intent = new Intent(this, Ejercicio1.class);
        startActivity(intent);
    }

    public void tabla(View view) {
        Intent intent = new Intent(this, TablaPuntaje.class);
        startActivity(intent);
    }

}