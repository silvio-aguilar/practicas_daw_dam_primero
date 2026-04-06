package org.example;

public class Motor {
    private String tipo;
    private int potencia;


    // Constructor principal
    public Motor(String tipo, int potencia){
        this.tipo = tipo;
        this.potencia = potencia;
    }

    // Getters
    public String getTipo(){
        return tipo;
    }
    public int getPotencia(){
        return potencia;
    }

    // Setters
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setPotencia(int potencia){
        this.potencia = potencia;
    }

    // Metodos
    public void encender(){
        System.out.println("El motor se ha endendido");
    }


}
