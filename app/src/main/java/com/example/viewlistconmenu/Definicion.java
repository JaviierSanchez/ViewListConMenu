package com.example.viewlistconmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Definicion extends AppCompatActivity {

    TextView info,titulo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definicion);

        titulo = findViewById(R.id.textViewTitulo);
        info = findViewById(R.id.textViewInfo);

        Bundle datos = getIntent().getExtras();

        String lenguaje = datos.getString("lenguaje");

        switch (lenguaje){

            case "Java":
                titulo.setText("Java");
                info.setText("Java es un lenguaje de programación de alto nivel y orientado a objetos que fue desarrollado por Sun Microsystems en la década de 1990.");
                break;
            case "C":
                titulo.setText("C");
                info.setText("Es un lenguaje de programación de bajo nivel que proporciona un alto nivel de control sobre el hardware de la computadora, lo que lo hace adecuado para programación de sistemas y desarrollo de software de bajo nivel.");
                break;
            case "Python":
                titulo.setText("Python");
                info.setText("Python es un lenguaje de programación de alto nivel, interpretado y de propósito general, conocido por su sintaxis clara y legible, así como por su versatilidad en aplicaciones que abarcan desde desarrollo web hasta inteligencia artificial.");
                break;
            case "Ruby":
                titulo.setText("Ruby");
                info.setText("Ruby es un lenguaje de programación interpretado, de alto nivel y orientado a objetos, diseñado para ser simple y productivo, con un énfasis en la elegancia y la diversión en la programación.");
                break;
        }



    }
}