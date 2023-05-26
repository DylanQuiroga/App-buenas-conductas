package com.example.apppraxisii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class PuntajeFinal extends AppCompatActivity {
    private VG varGlob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntaje_final);

        varGlob = (VG) getApplicationContext();
        ImageView check = findViewById(R.id.check);
        EditText nombre = findViewById(R.id.nombre);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBase db = new DataBase(getApplicationContext());

                String name = nombre.getText().toString();
                int puntaje = varGlob.getGlobalVariable();

                db.insertarPuntaje(name,puntaje);
                db.imprimirTabla();

                Menu(view);
            }
        });
    }

    public void Menu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}