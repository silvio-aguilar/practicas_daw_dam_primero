package org.example;

public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;


    // Constructor principal
    protected Vehiculo(String marca, String modelo, int anio){
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    // Metodos
    public void arrancar(){
        System.out.println("El vehiculo arranca...");
    }

    // Metodo abstracto
    public abstract void acelerar();


    // Mostrar la informacion de los vehiculos
    public String mostrarInfo(){
        return "Marca: " + getMarca() +
                "\nModelo: " + getModelo() +
                "\nAño: " + getAnio();
    }
}
