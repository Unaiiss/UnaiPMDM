package com.example.practica1zerrenda;

import android.util.Log;

public class Elementua {

    private int id;
    private String izena;
    private String deskribapena;
    private boolean libreaDa;

    public Elementua(int id, String izena, String deskribapena, boolean libreaDa) {
        this.id = id;
        this.izena = izena;
        this.deskribapena = deskribapena;
        this.libreaDa = libreaDa;
    }

    // Getter metodoak
    public int getId() {
        return id;
    }

    public String getIzena() {
        return izena;
    }

    public String getDeskribapena() {
        return deskribapena;
    }

    public boolean getLibreaDa() {
        return libreaDa;
    }

    // Setter metodoak
    public void setId(int id) {
        this.id = id;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public void setDeskribapena(String deskribapena) {
        this.deskribapena = deskribapena;
    }

    public void setLibreaDa(boolean libreaDa) {
        this.libreaDa = libreaDa;
    }

    // Metodoa: elementuaren datuak pantailan erakusten ditu
    public void erakutsiDatuak() {
        String librea = "";
        if (libreaDa){
            librea = "Librea";
        } else {
            librea = "Ez librea";
        }

        Log.d("Elementua", "ID: " + id + ", Izena: " + izena + ", Deskribapena: " + deskribapena + " " + librea);
        // Edo kontsola erabiliz:
        System.out.println("ID: " + id + ", Izena: " + izena + ", Deskribapena: " + deskribapena + " " + librea);
    }

}
