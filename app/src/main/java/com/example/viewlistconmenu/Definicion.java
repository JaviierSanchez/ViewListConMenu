package com.example.viewlistconmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;
import java.util.ArrayList;

public class Definicion extends AppCompatActivity {

    TextView info, titulo;
    static ArrayList<Palabra> lista = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definicion);

        //inicialiarLenguaje();

        //escribirFicheroObjetos();

        leerFicheroObjetos();


        titulo = findViewById(R.id.textViewTitulo);
        info = findViewById(R.id.textViewInfo);

        Bundle datos = getIntent().getExtras();

        String lenguaje = datos.getString("lenguaje");


        switch (lenguaje) {

            case "Java":
                if (!lista.isEmpty()) {
                    titulo.setText(lista.get(0).getTitulo());
                    info.setText(lista.get(0).getDescripcion());
                } else {
                    Toast.makeText(this, "No hay nada", Toast.LENGTH_SHORT).show();
                }

                break;
            case "C":
                if (!lista.isEmpty()) {
                    titulo.setText(lista.get(1).getTitulo());
                    info.setText(lista.get(1).getDescripcion());
                } else {
                    Toast.makeText(this, "No hay nada", Toast.LENGTH_SHORT).show();
                }

                break;
            case "Python":
                if (!lista.isEmpty()) {
                    titulo.setText(lista.get(2).getTitulo());
                    info.setText(lista.get(2).getDescripcion());
                } else {
                    Toast.makeText(this, "No hay nada", Toast.LENGTH_SHORT).show();
                }
                break;
            case "Ruby":
                if (!lista.isEmpty()) {
                    titulo.setText(lista.get(3).getTitulo());
                    info.setText(lista.get(3).getDescripcion());
                } else {
                    Toast.makeText(this, "No hay nada", Toast.LENGTH_SHORT).show();
                }
                break;
        }


    }

    private void inicialiarLenguaje() {

        Palabra java = new Palabra("Java", "Java es un lenguaje de programación de alto nivel y orientado a objetos que fue desarrollado por Sun Microsystems en la década de 1990.");
        Palabra C = new Palabra("C", "Es un lenguaje de programación de bajo nivel que proporciona un alto nivel de control sobre el hardware de la computadora, lo que lo hace adecuado para programación de sistemas y desarrollo de software de bajo nivel.");
        Palabra Python = new Palabra("Python", "Python es un lenguaje de programación de alto nivel, interpretado y de propósito general, conocido por su sintaxis clara y legible, así como por su versatilidad en aplicaciones que abarcan desde desarrollo web hasta inteligencia artificial.");
        Palabra Ruby = new Palabra("Ruby", "Ruby es un lenguaje de programación interpretado, de alto nivel y orientado a objetos, diseñado para ser simple y productivo, con un énfasis en la elegancia y la diversión en la programación.");
        lista.add(java);
        lista.add(C);
        lista.add(Python);
        lista.add(Ruby);
    }

    public void escribirFicheroObjetos() {

        FileOutputStream fos = null;

        ObjectOutputStream os = null;

        try {

            fos = getApplicationContext().openFileOutput("palabras.ser", Context.MODE_PRIVATE);

            try {

                os = new ObjectOutputStream(fos);

                for (Palabra objeto : lista) {

                    os.writeObject(objeto);

                }

                os.close();

            } catch (Exception e) {
                e.printStackTrace();

            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }

    }


    public void leerFicheroObjetos() {

        FileInputStream fis = null;

        try {

            fis = getApplicationContext().openFileInput("palabras.ser");

            try {

                ObjectInputStream ois;

                ois = new ObjectInputStream(fis);

                while (true) {

                    try {

                        Palabra p = (Palabra) ois.readObject();

                        lista.add(p);

                    } catch (EOFException e) {

                        break;

                    } catch (ClassNotFoundException e) {

                        e.printStackTrace();

                    }

                }

                ois.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}