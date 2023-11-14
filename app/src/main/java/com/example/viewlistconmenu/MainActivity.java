package com.example.viewlistconmenu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ListView lista;
    String [] listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listaLenguaje);

        listItem = new String[]{"Java","C","Python","Ruby"};

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listItem);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = adapter.getItem(i);
                info(value);
            }
        });
    }

    public void info(String value){
        Intent i = new Intent(this, Definicion.class);
        i.putExtra("lenguaje",value);
        startActivity(i);
    }

public void Salir(){
    AlertDialog.Builder builder = new AlertDialog.Builder(this);

    builder.setTitle("Salir")
            .setMessage("¿Estás seguro de que quieres salir?")
            .setPositiveButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            })
            .setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }


            });
    AlertDialog dialog = builder.create();
    dialog.show();
}

    public void AcercaDe() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Programador")
                .setMessage("Javier Sánchez Cerrato")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

@Override
    public boolean onCreateOptionsMenu(Menu mimenu){

    getMenuInflater().inflate(R.menu.menu, mimenu);

    return  true;
}

    @Override
    public boolean onOptionsItemSelected(MenuItem opcion_menu) {
        int id = opcion_menu.getItemId();

        if (id == R.id.AcercaDe) {
            AcercaDe(); // Llama al método AcercaDe cuando se selecciona la opción "AcercaDe" en el menú.
            return true;
        }

        if (id == R.id.Salir) {
            Salir();
            return true;
        }

        return super.onOptionsItemSelected(opcion_menu);
    }

    public void AcercaDeClick(MenuItem item) {

        AcercaDe();
    }

    public void SalirDeClick(MenuItem item) {
        Salir();
    }




}