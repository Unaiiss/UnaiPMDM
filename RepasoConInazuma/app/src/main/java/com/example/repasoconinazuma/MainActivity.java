package com.example.repasoconinazuma;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
                    Personaje personajeNuevo = new Personaje(id, nombre, apellido, posicion);
                    personajeManager.gehituElementua(personajeNuevo);

                    // añade el elemento en la ultima posicion del reciclerView
                    adapter.notifyItemInserted(personajes.size() - 1);

                    Toast.makeText(this, "Se han guardado los datos", Toast.LENGTH_SHORT).show();

                }
            });

    private final ActivityResultLauncher<Intent> editarPersonajeLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();  // Itzulitako datuak lortu
                    int id = data.getIntExtra("id", -1);
                    String nombre = data.getStringExtra("nombre");
                    String apellido = data.getStringExtra("apellido");
                    String posicion = data.getStringExtra("posicion");

                    if(personajeManager.editarPersonaje(id, nombre, apellido, posicion)){
                        Toast.makeText(this, "Se han guardado los datos", Toast.LENGTH_SHORT).show();
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(this, "Ha ocurrido un error en la edicion", Toast.LENGTH_SHORT).show();
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inicializar PersonajeManager
        personajeManager = new PersonajeManager();

        // Inicializar personajes base en el PersonajeManager
        personajeManager.gehituElementua(new Personaje(1, "Caleb", "Stonewall", "Centro campista"));
        personajeManager.gehituElementua(new Personaje(2, "Arion", "Sherwind", "Centro campista"));
        personajeManager.gehituElementua(new Personaje(3, "Mark", "Evans", "Portero"));

        // Obtener la lista completa desde PersonajeManager
        personajes = personajeManager.getElementuak();

        // RecyclerView configuración
        RecyclerView recyclerView = findViewById(R.id.reciclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Configurar el adapter con la lista de personajes
        adapter = new PersonajeAdapter(personajes);
        recyclerView.setAdapter(adapter);

        // Botón para añadir un nuevo personaje
        Button btnAgregar = findViewById(R.id.bAñadir);
        btnAgregar.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AgregarPersonaje.class);
            añadirElementoLauncher.launch(intent);
        });

        // Botón para editar un personaje
        Button btnEditar = findViewById(R.id.bEditar);
        btnEditar.setOnClickListener(view -> {
            // Variable del editTextEdicion
            EditText idEditable = findViewById(R.id.etIdParaEditar);
            String idParaEditar = idEditable.getText().toString();

            // si el editText de edicion tiene una id, se la pasa a la otra clase, si no, no hace nada
            if (!idParaEditar.isEmpty()) {
                if (personajeManager.existePersonaje(idParaEditar)) {
                    // recuperar el personaje
                    Personaje personajeAEditar = personajeManager.recogerPersonaje(idParaEditar);
                    Intent intent = new Intent(MainActivity.this, EditarPersonaje.class);
                    intent.putExtra("id", idParaEditar);
                    intent.putExtra("nombre", personajeAEditar.getNombre());
                    intent.putExtra("apellido", personajeAEditar.getApellido());
                    intent.putExtra("posicion", personajeAEditar.getPosicion());
                    editarPersonajeLauncher.launch(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Id inexistente", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(MainActivity.this, "El espacio debe contener una id", Toast.LENGTH_SHORT).show();
            }

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