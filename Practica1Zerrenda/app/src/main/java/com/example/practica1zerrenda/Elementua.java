package com.example.practica1zerrenda;

import android.util.Log;

public class Elementua {

    private int id;
    private String izena;
    private String deskribapena;
    private String libreaDa;

    public Elementua(int id, String izena, String deskribapena, String libreaDa) {
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

    public String getLibreaDa() {
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

    public void setLibreaDa(String libreaDa) {
        this.libreaDa = libreaDa;
    }

    // Metodoa: elementuaren datuak pantailan erakusten ditu
    public void erakutsiDatuak() {
        Log.d("Elementua", "ID: " + id + ", Izena: " + izena + ", Deskribapena: " + deskribapena + " " + libreaDa);
        // Edo kontsola erabiliz:
        System.out.println("ID: " + id + ", Izena: " + izena + ", Deskribapena: " + deskribapena + " " + libreaDa);
    }

}
