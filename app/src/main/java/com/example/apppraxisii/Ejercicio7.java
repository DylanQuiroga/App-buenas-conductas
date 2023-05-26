package com.example.apppraxisii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Ejercicio7 extends AppCompatActivity {
    private VG varGlob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio7);

        varGlob = (VG) getApplicationContext();
        ImageView Bueno = findViewById(R.id.imagePulgarArriba7);
        ImageView Malo = findViewById(R.id.imagePulgarAbajo7);

        Bueno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Oh no \uD83D\uDE14", Toast.LENGTH_SHORT).show();
                finish();
                ejercicio8(view);
            }
        });

        Malo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                varGlob.iplusplusGlobalVariable();
                System.out.println(varGlob.getGlobalVariable());
                Toast.makeText(getApplicationContext(),"Muy bien! \uD83D\uDE00", Toast.LENGTH_SHORT).show();
                finish();
                ejercicio8(view);
            }
        });

    }

    public void ejercicio8(View view) {
        Intent intent = new Intent(this, Ejercicio8.class);
        startActivity(intent);
    }
}