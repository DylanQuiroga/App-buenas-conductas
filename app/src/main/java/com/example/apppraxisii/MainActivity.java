package com.example.apppraxisii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VG variableGlobal = (VG) getApplicationContext();
        ImageView imageComenzar = findViewById(R.id.imageComenzar);
        ImageView imageSalir = findViewById(R.id.imageSalir);

        imageComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Imagen 1");
            }
        });

        imageSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}