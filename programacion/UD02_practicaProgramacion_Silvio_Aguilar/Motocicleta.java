package org.example;

public class Motocicleta extends Vehiculo {
    public int cilindrada;


    @Override
    public void obtenerInformacion() {
        super.obtenerInformacion();
        System.out.printf("Cilindrada: %d cc\n", cilindrada);
    }
}
