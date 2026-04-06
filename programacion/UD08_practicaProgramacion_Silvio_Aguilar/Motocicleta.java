package org.example;

public class Motocicleta extends Vehiculo implements Manejable{


    public Motocicleta(String marca, String modelo, int anio){
        super(marca,modelo,anio);
    }

    @Override
    public void arrancar(){
        System.out.println("La moto " + getMarca() +  " " + getModelo() + " está arrancando");
    }

    @Override
    public void acelerar(){
        System.out.println("La motocicleta acelera rápidamente");
    }

    @Override
    public void girar(String direccion) {
        System.out.println("La motocicleta gira hacia la " + direccion);
    }

    @Override
    public void frenar(){
        System.out.println("La motocicleta frena");
    }
}
