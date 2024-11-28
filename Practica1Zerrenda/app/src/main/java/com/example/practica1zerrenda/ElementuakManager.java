package com.example.practica1zerrenda;

import java.util.ArrayList;

public class ElementuakManager {
    private ArrayList<Elementua> elementuakList;

    // Constructor
    public ElementuakManager() {
        elementuakList = new ArrayList<>();
    }

    // Obtener la lista completa de elementos
    public ArrayList<Elementua> getElementuakList() {
        return elementuakList;
    }

    public void siguienteId(int id) {

    }

    // Añadir un nuevo elemento
    public void addElement(Elementua newElementua) {
        elementuakList.add(newElementua);
    }

    // Editar un elemento en una posición específica
    public void updateElement(int position, Elementua updatedElementua) {
        if (position >= 0 && position < elementuakList.size()) {
            elementuakList.set(position, updatedElementua);
        }
    }

    // Eliminar un elemento en una posición específica
    public void removeElement(int position) {
        if (position >= 0 && position < elementuakList.size()) {
            elementuakList.remove(position);
        }
    }

    // Obtener el tamaño de la lista
    public int getItemCount() {
        return elementuakList.size();
    }

    // Obtener un elemento por su posición
    public Elementua getElement(int position) {
        if (position >= 0 && position < elementuakList.size()) {
            return elementuakList.get(position);
        }
        return null;
    }
}
