package org.example;

public class Coche extends Vehiculo{

    public int puertas;


    @Override
    public void obtenerInformacion(){
        super.obtenerInformacion();
        System.out.printf("Número de puertas: %d\n",puertas);

    }
}
