package com.example.repasoconinazuma;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Personaje> personajes;
    private PersonajeAdapter adapter;
    private PersonajeManager personajeManager;

    private final ActivityResultLauncher<Intent> añadirElementoLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {

                // Bigarren activity-ren emaitza dagoen konprobatu
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {

                    Intent data = result.getData();  // Itzulitako datuak lortu
                    String nombre = data.getStringExtra("nombre");
                    String apellido = data.getStringExtra("apellido");
                    String posicion = data.getStringExtra("posicion");

                    // Elementu berria arraylist-era gehitu
                    int id = personajeManager.sortuHurrengoId();
                    Personaje personaje = new Personaje(id, nombre, apellido, posicion);
                    personajeManager.gehituElementua(personaje);

                    Toast.makeText(this, "Se han guardado los datos", Toast.LENGTH_SHORT).show();
                    // RecyclerView eguneratu
                    adapter.notifyDataSetChanged();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inicializar PersonajeManager
        personajeManager = new PersonajeManager();

        // Datuak prestatu
        personajes = new ArrayList<>();
        personajes.add(new Personaje(1, "Caleb", "Stonewall", "Centro campista"));
        personajes.add(new Personaje(2, "Arion", "Sherwind", "Centro campista"));
        personajes.add(new Personaje(3, "Mark", "Evans", "Portero"));

        Log.d("MainActivity", "Tamaño de la lista: " + personajes.size());



        // RecyclerView layout-ean bilatu eta konfiguratu
        RecyclerView recyclerView = findViewById(R.id.reciclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Adapter-a ezarri
        adapter = new PersonajeAdapter(personajes);
        recyclerView.setAdapter(adapter);

        // Gehitu botoia
        Button btnAgregar = findViewById(R.id.bAñadir);
        btnAgregar.setOnClickListener(view -> {
            // ElementuaGehituActivity abiarazi
            Intent intent = new Intent(MainActivity.this, AgregarPersonaje.class);
            /*
            ADI! Zaharkituta dago Android-eko bertsio berrietan
            startActivityForResult(intent, 1); // Datuak itzultzeko erabiltzen da
             */
            // Modernoa eta gomendatua
            // elementuaGehituLauncher objektuak launch(intent) bat bidaltzen du bigarren activity bat abiarazteko
            añadirElementoLauncher.launch(intent);
        });

        // EJEMPLO DE INTENT EN BOTON
//        Button añadir = findViewById(R.id.bAñadir);
//        añadir.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent obj = new Intent(MainActivity.this, AgregarPersonaje.class);
//                startActivity(obj);
//                finish();
//            }
//        });
    }


}