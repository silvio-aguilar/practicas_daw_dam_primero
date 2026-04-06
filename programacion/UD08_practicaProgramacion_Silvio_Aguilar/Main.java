package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Lista de vehiculos
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        // Añadimos un coche y una moto
        vehiculos.add(new Coche("BYD","YXZ",2025));
        vehiculos.add(new Motocicleta("Suzuki","XR",2024));

        // Recorremos la lista "vehiculos" con un for-each
        for (Vehiculo vehiculo : vehiculos){
            // Info de vehiculo
            System.out.println(vehiculo.mostrarInfo());

            // Usar metodos
            vehiculo.arrancar();
            vehiculo.acelerar();

            // Upcasting
            Manejable manejable = (Manejable) vehiculo;
            manejable.girar("Izquierda");
            manejable.frenar();



            // Downcasting
            if (vehiculo instanceof Motocicleta){
                Motocicleta moto = (Motocicleta) vehiculo;
                System.out.println("Downcasting seguro para Motocicleta");
                moto.girar("Derecha");
                moto.frenar();
            }



        }


    }
}