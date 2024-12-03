package com.example.repasoconinazuma;

import com.example.repasoconinazuma.Personaje;

import java.util.ArrayList;

public class PersonajeManager {

    private ArrayList<Personaje> personajes;

    public PersonajeManager() {
        personajes = new ArrayList<>();
    }

    // ID berria sortzeko metodoa
    public int sortuHurrengoId() {
        int azkenId = 0; // Hasierako ID-a

        for (Personaje personaje : personajes) {
            if (personaje.getId() > azkenId) {
                azkenId = personaje.getId(); // ID handiena aurkitu
            }
        }

        return azkenId + 1; // Hurrengo ID-a
    }

    // Datuak gehitzeko metodoa
    public void gehituElementua(Personaje personaje) {
        personajes.add(personaje);
    }

    // ID baten arabera elementua bilatzeko metodoa
    public Personaje bilatuElementuaId(int id) {
        for (Personaje personaje : personajes) {
            if (personaje.getId() == id) {
                return personaje; // Aurkitutako elementua itzuli
            }
        }
        return null; // Ez da aurkitu
    }

    public boolean aldatuElementua(int id, String nuevoNombre, String nuevoApellido, String nuevaPosicion) {
        for (Personaje personaje : personajes) {
            if (personaje.getId() == id) {
                // Aurkitutako elementuaren datuak aldatu
                personaje.setNombre(nuevoNombre);
                personaje.setApellido(nuevoApellido);
                personaje.setPosicion(nuevaPosicion);
                return true; // Aldaketa arrakastatsua izan da
            }
        }
        return false; // Ez da aurkitu
    }

    // ID baten arabera elementua ezabatzeko metodoa
    public boolean ezabatuElementuaById(int id) {
        for (Personaje personaje : personajes) {
            if (personaje.getId() == id) {
                personajes.remove(personaje); // Aurkitutako elementua ezabatu
                return true; // Ezabatuta
            }
        }
        return false; // Ez da aurkitu
    }

    // Datuak iragazteko metodoa
    public ArrayList<Personaje> iragaziElementuak(String izena) {
        ArrayList<Personaje> iragazitakoZerrenda = new ArrayList<>();

        for (Personaje personaje : personajes) {
            if (personaje.getNombre().toLowerCase().contains(izena.toLowerCase()) ) {
                iragazitakoZerrenda.add(personaje);
            }
        }

        return iragazitakoZerrenda;
    }

    // Zerrendako elementuak itzultzeko metodoa
    public ArrayList<Personaje> getElementuak() {
        return personajes;
    }
}