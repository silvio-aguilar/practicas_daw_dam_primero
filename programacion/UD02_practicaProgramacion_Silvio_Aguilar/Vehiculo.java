package org.example;

public class Vehiculo {
    public String marca;
    public String modelo;
    public int anio;
    protected double velocidadActual = 0.0;
    private double kilometrajeAcumulado = 0.0;

    //Constructos vacío
    public Vehiculo(){

    }

    //Constructor default
    public Vehiculo(String marca,String modelo, int anio){
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;

    }


    //MÉTODOS

    public void encender(){
        System.out.printf("!%s %s encendido!\n",marca,modelo);
    }

    public void apagar(){
        System.out.println("Vehículo apagado!\n");
    }

    public void registrarKilometraje(double distancia){
        kilometrajeAcumulado += distancia;


    }

    public double obtenerKilometraje(){
        return kilometrajeAcumulado;
    }

    public void obtenerInformacion() {
        System.out.printf(
                "\nMarca: %s\nModelo: %s\nAño: %d\nVelocidad Actual: %.2f km/h\nKilometraje: %.2f km\n",
                marca, modelo, anio, velocidadActual, kilometrajeAcumulado
        );
    }


    //GETTERS Y SETTERS DE LOS ATRIBUTOS PROTEGIDAS Y PRIVADAS

    public double getKilometrajeAcumulado() {
        return kilometrajeAcumulado;
    }

    public void setKilometrajeAcumulado(double kilometrajeAcumulado) {
        this.kilometrajeAcumulado = kilometrajeAcumulado;
    }

    public double getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(double velocidadActual) {
        this.velocidadActual = velocidadActual;
    }
}
