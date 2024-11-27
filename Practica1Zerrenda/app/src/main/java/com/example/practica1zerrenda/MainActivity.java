package com.example.practica1zerrenda;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Elementua> elementuak; // Klase mailan deklaratuta
    private ElementuaAdapter adapter; // Klase mailan deklaratuta

    // Activity Result kudeatzailea
    // ElementuaActivity-tik datuak jasotzeko erabilten da (modernoa)
    private final ActivityResultLauncher<Intent> elementuaGehituLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                // Bigarren activity-tik itzultzen den emaitza dagoen egiaztatu
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();  // Itzulitako datuak lortu

                    // Datu berriak jaso Intent-etik
                    //Intent: Activity bat beste batetik abiarazterakoan (explicit kasu honetan)
                    int id = data.getIntExtra("id", -1);
                    String izena = data.getStringExtra("izena");
                    String deskribapena = data.getStringExtra("deskribapena");

                    // Datu berria zerrendara gehitu eta RecyclerView eguneratu
                    elementuak.add(new Elementua(id, izena, deskribapena));
                    adapter.notifyDataSetChanged();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Datuak prestatu
        elementuak = new ArrayList<>();
        elementuak.add(new Elementua(1, "Java", "Klaseetan oinarritutako hizkuntza oso erabilia web eta enpresa-aplikazioetan.", "Bai"));
        elementuak.add(new Elementua(2, "Python", "Sintaxi errazarekin eta moldakortasun handiarekin ezaguna.", "Bai"));
        elementuak.add(new Elementua(3, "C++", "Errendimendu handia eta kontrol maila altua eskatzen duten aplikazioetarako.", "Ez"));
        elementuak.add(new Elementua(4, ".NET", "Microsoft-en garapenerako plataforma anitza, bere API sendoarekin.", "Ez"));
        elementuak.add(new Elementua(5, "Kotlin", "Modernoa eta segurua, Android aplikazioetarako pentsatuta.", "Bai"));
        elementuak.add(new Elementua(6, "PHP", "Webgune dinamikoak sortzeko oso erabilia, backend garapenerako bereziki egokia.", "Bai"));

        // RecyclerView layout-ean bilatu eta konfiguratu
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Adapter-a ezarri
        adapter = new ElementuaAdapter(elementuak);
        recyclerView.setAdapter(adapter);

        // Gehitu botoia
        Button btnGehitu = findViewById(R.id.btnGehitu);
        btnGehitu.setOnClickListener(view -> {
            // ElementuaGehituActivity abiarazi
            Intent intent = new Intent(MainActivity.this, ElementuBerria.class);
            /*
            ADI! Zaharkituta dago Android-eko bertsio berrietan
            startActivityForResult(intent, 1); // Datuak itzultzeko erabiltzen da
             */
            // Modernoa eta gomendatua
            // elementuaGehituLauncher objektuak launch(intent) bat bidaltzen du bigarren activity bat abiarazteko
            elementuaGehituLauncher.launch(intent);

        });

    }
}