package org.example;

public class Coche extends Vehiculo{


    private String combustible;


    // Contructor default
    public Coche(String combustible){
        this.combustible = combustible;
    }


    // Sobrescritura al metodo mostrar info de vehiculo

    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("Combustible: "+ combustible);
    }

    public void abrirMaletero(){
        System.out.println("Abriendo maletero...");
    }



}
