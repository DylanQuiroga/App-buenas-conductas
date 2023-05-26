package com.example.apppraxisii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Ejercicio4 extends AppCompatActivity {
    private VG varGlob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4);

        varGlob = (VG) getApplicationContext();
        ImageView Bueno = findViewById(R.id.imagePulgarArriba4);
        ImageView Malo = findViewById(R.id.imagePulgarAbajo4);

        Bueno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Oh no \uD83D\uDE14", Toast.LENGTH_SHORT).show();
                finish();
                ejercicio5(view);
            }
        });

        Malo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                varGlob.iplusplusGlobalVariable();
                System.out.println(varGlob.getGlobalVariable());
                Toast.makeText(getApplicationContext(),"Bravo ! \uD83D\uDE00", Toast.LENGTH_SHORT).show();
                finish();
                ejercicio5(view);
            }
        });

    }

    public void ejercicio5(View view) {
        Intent intent = new Intent(this, Ejercicio5.class);
        startActivity(intent);
    }
}