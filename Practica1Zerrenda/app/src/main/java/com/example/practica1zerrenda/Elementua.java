package com.example.practica1zerrenda;

import android.util.Log;

public class Elementua {

    private int id;
    private String izena;
    private String deskribapena;

    public Elementua(int id, String izena, String deskribapena) {
        this.id = id;
        this.izena = izena;
        this.deskribapena = deskribapena;
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

    // Metodoa: elementuaren datuak pantailan erakusten ditu
    public void erakutsiDatuak() {
        Log.d("Elementua", "ID: " + id + ", Izena: " + izena + ", Deskribapena: " + deskribapena);
        // Edo kontsola erabiliz:
        System.out.println("ID: " + id + ", Izena: " + izena + ", Deskribapena: " + deskribapena);
    }

}
