package org.example;

import java.util.ArrayList;

public class Coche extends Vehiculo implements Manejable {
    Motor motor;
    ArrayList<Rueda> ruedas = new ArrayList<>(4);

    public Coche(String marca,String modelo,int anio){
        super(marca,modelo,anio);
    }

    @Override
    public void arrancar(){
        System.out.println("El coche " + getMarca() + " " + getModelo() + " está arrancando");
    }

    @Override
    public void acelerar(){
        System.out.println("El coche acelera suavemente...");
    }

    @Override
    public void girar(String direccion) {
        System.out.println("El coche gira hacia la " + direccion);
    }

    @Override
    public void frenar(){
        System.out.println("El coche frena");
    }
}
