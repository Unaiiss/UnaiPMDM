package com.example.practica1zerrenda;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ElementuBerria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elementu_berria);

        // EditText-ak aurkitu
        EditText etId = findViewById(R.id.etId);
        EditText etIzena = findViewById(R.id.etIzena);
        EditText etDeskribapena = findViewById(R.id.etDeskribapena);

        // Karaktere mugak ezarri
        etId.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)}); // Gehienez 5 karaktere
        etIzena.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)}); // Gehienez 20 karaktere
        etDeskribapena.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)}); // Gehienez 50 karaktere

        // Botoiak aurkitu
        Button btnGorde = findViewById(R.id.btnGorde);
        Button btnItzuli = findViewById(R.id.btnItzuli);

        // "Gorde" botoiaren ekintza
        btnGorde.setOnClickListener(view -> {
            // EditText-en balioak lortu
            String idStr = etId.getText().toString();
            String izena = etIzena.getText().toString();
            String deskribapena = etDeskribapena.getText().toString();

            // Datuak egiaztatu
            if (idStr.isEmpty() || izena.isEmpty() || deskribapena.isEmpty()) {
                Toast.makeText(ElementuBerria.this, "Eremu guztiak bete behar dira!", Toast.LENGTH_SHORT).show();
            } else {
                try {
                    // Intent baten bidez datuak itzuli MainActivity-ra
                    int id = Integer.parseInt(idStr);
                    Intent intent = new Intent();
                    intent.putExtra("id", id);
                    intent.putExtra("izena", izena);
                    intent.putExtra("deskribapena", deskribapena);
                    setResult(RESULT_OK, intent);

                    // Mezu bat erakutsi
                    Toast.makeText(ElementuBerria.this, "Datuak ondo gorde dira", Toast.LENGTH_SHORT).show();
                    finish(); // Activity-a itxi eta MainActivity-ra itzuli
                } catch (NumberFormatException e) {
                    Toast.makeText(ElementuBerria.this, "ID balio egokia sartu!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // "Itzuli" botoiaren ekintza
        btnItzuli.setOnClickListener(view -> {
            // Activity-a itxi MainActivity-ra itzultzeko
            finish();
        });
    }
}
