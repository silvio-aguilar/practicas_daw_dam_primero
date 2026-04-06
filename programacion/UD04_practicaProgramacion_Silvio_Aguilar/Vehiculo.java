package org.example;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int anio = 0;
    private String matricula;


    // Contructor vacío
    public Vehiculo(){}


    // Constrcutor default
    public Vehiculo(String marca, String modelo, int anio, String matricula){
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.matricula = matricula;
    }


    // GETTERS AND SETTERS

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
        if(anio < 1800){
            System.out.println("El año no puede ser menor a 1800");
        }
        this.anio = anio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }




    // Metodo mostrar informacion
    public void mostrarInformacion(){
        System.out.println(
                "\nMarca: " + marca +
                "\nModelo: " + modelo +
                "\nAño: " + anio +
                "\nMatricula: "+matricula);
    }

    // Metodo acelerar
    public void acelerar(){
        System.out.println("\nEl vehiculo " + marca+ " " + modelo + " está acelerando");
    }

    // Metodo estatico de fabrica
    public static Vehiculo crearVehiculoGenerico(String marca,String modelo){
        return new Vehiculo(marca,modelo,2023, "Generico");

    }




}
