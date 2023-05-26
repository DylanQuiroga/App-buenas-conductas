package com.example.apppraxisii;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;

public class DataBase extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "mi_base_de_datos";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "tabla_puntajes";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOMBRE = "nombre";
    private static final String COLUMN_PUNTAJE = "puntaje";

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NOMBRE + " TEXT, " +
                COLUMN_PUNTAJE + " INTEGER)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Aquí puedes implementar la lógica para actualizar la base de datos si cambia la versión.
    }

    public void insertarPuntaje(String nombre, int puntaje) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, nombre);
        values.put(COLUMN_PUNTAJE, puntaje);

        db.insert(TABLE_NAME, null, values);

        //db.close();
    }

    public void imprimirTabla() {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE));
                int puntaje = cursor.getInt(cursor.getColumnIndex(COLUMN_PUNTAJE));

                Log.d("TAG", "ID: " + id + ", Nombre: " + nombre + ", Puntaje: " + puntaje);
            } while (cursor.moveToNext());
        }

        //cursor.close();
        //db.close();
    }

    public HashMap<String, Integer> obtenerDatosComoDiccionario() {
        HashMap<String, Integer> diccionario = new HashMap<>();

        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                String nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE));
                int puntaje = cursor.getInt(cursor.getColumnIndex(COLUMN_PUNTAJE));

                diccionario.put(nombre, puntaje);
            } while (cursor.moveToNext());
        }

        //cursor.close();
        //db.close();

        return diccionario;
    }



}
