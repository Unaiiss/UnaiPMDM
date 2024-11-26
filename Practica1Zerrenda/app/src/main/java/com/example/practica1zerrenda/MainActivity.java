package com.example.practica1zerrenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Elementua> elementuak; // Klase mailan deklaratuta
    private ElementuaAdapter adapter; // Klase mailan deklaratuta

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Datuak prestatu
        elementuak = new ArrayList<>();
        elementuak.add(new Elementua(1, "Java", "Klaseetan oinarritutako hizkuntza oso erabilia web eta enpresa-aplikazioetan.", true));
        elementuak.add(new Elementua(2, "Python", "Sintaxi errazarekin eta moldakortasun handiarekin ezaguna.", true));
        elementuak.add(new Elementua(3, "C++", "Errendimendu handia eta kontrol maila altua eskatzen duten aplikazioetarako.", false));
        elementuak.add(new Elementua(4, ".NET", "Microsoft-en garapenerako plataforma anitza, bere API sendoarekin.", false));
        elementuak.add(new Elementua(5, "Kotlin", "Modernoa eta segurua, Android aplikazioetarako pentsatuta.", true));
        elementuak.add(new Elementua(6, "PHP", "Webgune dinamikoak sortzeko oso erabilia, backend garapenerako bereziki egokia.", true));

        // RecyclerView layout-ean bilatu eta konfiguratu
        RecyclerView recyclerView = findViewById(R.id.reciclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Adapter-a ezarri
        adapter = new ElementuaAdapter(elementuak);
        recyclerView.setAdapter(adapter);


        Button itzuliMenura = findViewById(R.id.bGehitu);
        itzuliMenura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(MainActivity.this, ElementuBerria.class);
                startActivity(obj);
                finish();
            }
        });
    }
}