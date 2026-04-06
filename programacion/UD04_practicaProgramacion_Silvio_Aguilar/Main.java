package org.example;

public class Main {
    public static void main(String[] args) {


        Vehiculo vehiculos =  new Vehiculo();

        vehiculos.setMarca("BMW");
        vehiculos.setModelo("800");
        vehiculos.setAnio(1800);
        vehiculos.setMatricula("534HE6");


        Coche coches =  new Coche("gasolina");

        coches.setMarca("Mercedes");
        coches.setModelo("2000");
        coches.setAnio(2025);
        coches.setMatricula("54GTF");

        Vehiculo v =  Vehiculo.crearVehiculoGenerico("HONDA","X7");


        vehiculos.mostrarInformacion();
        if (GestorFlota.validarMatricula(vehiculos.getMatricula())){
            System.out.println("Matricula de " + vehiculos.getMarca() + " " + vehiculos.getModelo() + " Correcta");
        }else{
            System.out.println("Matricula de " + vehiculos.getMarca() + " " + vehiculos.getModelo() + " INVÁLIDA");

        }


        coches.mostrarInformacion();
        if (GestorFlota.validarMatricula(coches.getMatricula())){
            System.out.println("Matricula de " + coches.getMarca() + " " + coches.getModelo() + " Correcta");
        }else{
            System.out.println("Matricula de " + coches.getMarca() + " " + coches.getModelo() + " INVÁLIDA");

        }

        v.mostrarInformacion();
        if (GestorFlota.validarMatricula(v.getMatricula())){
            System.out.println("Matricula de " + v.getMarca() + " " + v.getModelo() + " Correcta");
        }else{
            System.out.println("Matricula de " + v.getMarca() + " " + v.getModelo() + " INVÁLIDA");

        }


        vehiculos.acelerar();
        coches.acelerar();
        coches.abrirMaletero();


        vehiculos = null;



    }
}