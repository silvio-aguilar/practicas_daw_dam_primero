package org.example;

import java.util.ArrayList;

public class Socio {
    private String nombre;
    private String idSocio;
    protected ArrayList<Libro> librosPrestados;

    // Constructor principal
    public Socio(String nombre, String idSocio){
        this.nombre = nombre;
        this.idSocio = idSocio;
        librosPrestados = new ArrayList<>();
    }

    // Getters
    public String getNombre(){
        return nombre;
    }
    public String getIdSocio(){
        return idSocio;
    }
    public ArrayList<Libro> getLibrosPrestados() {
        return librosPrestados;
    }



    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setIdSocio(String idSocio) {
        this.idSocio = idSocio;
    }


    // Metodos
    public void pedirLibro(Libro libro){
        librosPrestados.add(libro);

    }
    public void devolucionLibro(Libro libro){
        librosPrestados.remove(libro);

    }
    public void mostrarLibrosPrestados(){
        if (librosPrestados.isEmpty()){
            System.out.println("Este socio no tiene libros prestados.");
            return;
        }
        for (Libro libro : librosPrestados){
            System.out.println(libro.mostrarInfo());
        }
    }
}
