package com.example.repasoconinazuma;

public class Personaje {

    private int id;
    private String nombre;
    private String apellido;

    // Constructor
    public Personaje(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters y Setters

    // Obtener el ID
    public int getId() {
        return id;
    }

    // Establecer el ID
    public void setId(int id) {
        this.id = id;
    }

    // Obtener el nombre
    public String getNombre() {
        return nombre;
    }

    // Establecer el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Obtener el apellido
    public String getApellido() {
        return apellido;
    }

    // Establecer el apellido
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}