package org.example;

public class Main {
    public static void main(String[] args) {

        // COCHES
        Coche cocheUno = new Coche();
        cocheUno.marca = "BMW";
        cocheUno.modelo = "Q7";
        cocheUno.anio = 2015;
        cocheUno.puertas = 5;
        cocheUno.setVelocidadActual(160);
        cocheUno.setKilometrajeAcumulado(200);

        Coche cocheDos = new Coche();
        cocheDos.marca = "Honda";
        cocheDos.modelo = "RX8";
        cocheDos.anio = 1998;
        cocheDos.puertas = 3;
        cocheDos.setVelocidadActual(190);
        cocheDos.setKilometrajeAcumulado(300);

        // MOTOS
        Motocicleta motoUno = new Motocicleta();
        motoUno.marca = "Yamaha";
        motoUno.modelo = "MT-07";
        motoUno.anio = 2019;
        motoUno.cilindrada = 689;

        Motocicleta motoDos = new Motocicleta();
        motoDos.marca = "Honda";
        motoDos.modelo = "CB500F";
        motoDos.anio = 2021;
        motoDos.cilindrada = 471;

        //INVENTARIO
        Vehiculo[] inventario = {cocheUno,cocheDos,motoUno,motoDos};

        for(int i = 0; i < inventario.length;i++){
            inventario[i].obtenerInformacion();
        }




    }
}