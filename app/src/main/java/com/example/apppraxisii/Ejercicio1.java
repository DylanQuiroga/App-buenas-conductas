package com.example.apppraxisii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Ejercicio1 extends AppCompatActivity {
    private VG varGlob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        varGlob = (VG) getApplicationContext();
        ImageView Bueno = findViewById(R.id.imagePulgarArriba);
        ImageView Malo = findViewById(R.id.imagePulgarAbajo);

        Bueno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Oh no \uD83D\uDE14", Toast.LENGTH_SHORT).show();
                finish();
                ejercicio2(view);
            }
        });

        Malo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                varGlob.iplusplusGlobalVariable();
                System.out.println(varGlob.getGlobalVariable());
                Toast.makeText(getApplicationContext(),"Muy bien! \uD83D\uDE00", Toast.LENGTH_SHORT).show();
                finish();
                ejercicio2(view);
            }
        });

    }

    public void ejercicio2(View view) {
        Intent intent = new Intent(this, Ejercicio2.class);
        startActivity(intent);
    }

}