package com.example.repasoconinazuma;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AgregarPersonaje extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_personaje);

        // EditText-ak aurkitu
        EditText etNombre = findViewById(R.id.etNombre);
        EditText etApellido = findViewById(R.id.etApellido);
        Spinner spinnerPosicion = findViewById(R.id.spinnerPosicion);


        // Configurar el Spinner con un adaptador
        ArrayAdapter<CharSequence> adaptadorSpinner = ArrayAdapter.createFromResource(
                this,
                R.array.valores_spinner, // El array definido en strings.xml
                android.R.layout.simple_spinner_item // Estilo de los elementos del Spinner
        );
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Estilo desplegable
        spinnerPosicion.setAdapter(adaptadorSpinner);

        // Karaktere mugak ezarri
        etNombre.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)}); // Gehienez 5 karaktere
        etApellido.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)}); // Gehienez 20 karaktere

        // Botoiak aurkitu
        Button btnGuardar = findViewById(R.id.bGuardar);
        Button btnVolver = findViewById(R.id.bVolver);

        // "Gorde" botoiaren ekintza
        btnGuardar.setOnClickListener(view -> {
            // EditText-en balioak lortu
            String nombre = etNombre.getText().toString();
            String apellido = etApellido.getText().toString();
            String posicion = spinnerPosicion.getSelectedItem().toString();

            // Datuak egiaztatu
            if (nombre.isEmpty() || apellido.isEmpty() || posicion.isEmpty()) {
                Toast.makeText(AgregarPersonaje.this, "Debes rellenar todas las opciones", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent();
                intent.putExtra("nombre", nombre);
                intent.putExtra("apellido", apellido);
                intent.putExtra("posicion", posicion);
                setResult(RESULT_OK, intent);

                // Mezu bat erakutsi
                Toast.makeText(AgregarPersonaje.this, "Se han guardado correctamente los datos", Toast.LENGTH_SHORT).show();
                finish(); // Activity-a itxi eta MainActivity-ra itzuli
            }
        });

        // "Itzuli" botoiaren ekintza
        btnVolver.setOnClickListener(view -> {
            // Activity-a itxi MainActivity-ra itzultzeko
            finish();
        });
    }
}