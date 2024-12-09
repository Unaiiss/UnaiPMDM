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

public class EditarPersonaje extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_editar_personaje);

        EditText nuevoNombre = findViewById(R.id.etNombreNuevo);
        EditText nuevoApellido = findViewById(R.id.etApellidoNuevo);

        String idRecibida = getIntent().getStringExtra("id");
        nuevoNombre.setText(getIntent().getStringExtra("nombre"));
        nuevoApellido.setText(getIntent().getStringExtra("apellido"));

        EditText infoId = findViewById(R.id.etIdEditable);
        infoId.setText(idRecibida);
        infoId.setEnabled(false);

        Spinner spinnerEdicion = findViewById(R.id.spinnerEdicion);

        // Configurar el Spinner con un adaptador
        ArrayAdapter<CharSequence> adaptadorSpinner = ArrayAdapter.createFromResource(
                this,
                R.array.valores_spinner, // El array definido en strings.xml
                android.R.layout.simple_spinner_item // Estilo de los elementos del Spinner
        );
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Estilo desplegable
        spinnerEdicion.setAdapter(adaptadorSpinner);

        // Buscar la posición en el Spinner y establecerla
        String posicionDefault = getIntent().getStringExtra("posicion");
        int posicionIndex = ((ArrayAdapter<String>) spinnerEdicion.getAdapter()).getPosition(posicionDefault);
        if (posicionIndex >= 0) {
            spinnerEdicion.setSelection(posicionIndex);
        }

        // Karaktere mugak ezarri
        nuevoNombre.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)}); // Gehienez 5 karaktere
        nuevoApellido.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)}); // Gehienez 20 karaktere

        // Botoiak aurkitu
        Button btnGuardar = findViewById(R.id.bGuardarEdicion);
        Button btnVolver = findViewById(R.id.bVolverEdicion);

        // "Gorde" botoiaren ekintza
        btnGuardar.setOnClickListener(view -> {
            // EditText-en balioak lortu
            String nombre = nuevoNombre.getText().toString();
            String apellido = nuevoApellido.getText().toString();
            String posicion = spinnerEdicion.getSelectedItem().toString();

            // Datuak egiaztatu
            if (nombre.isEmpty() || apellido.isEmpty() || posicion.isEmpty()) {
                Toast.makeText(EditarPersonaje.this, "Debes rellenar todas las opciones", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent();
                int id = Integer.parseInt(idRecibida);
                intent.putExtra("id", id);
                intent.putExtra("nombre", nombre);
                intent.putExtra("apellido", apellido);
                intent.putExtra("posicion", posicion);
                setResult(RESULT_OK, intent);
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