package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // DECLARACIÓN DE VARIABLES

        String nombre;
        double precioOriginal = 0;
        double descuento = 0;
        double tasaDeImpuesto = 0;

        // ENTRADA DE DATOS (INPUT)

        Scanner entrada = new Scanner(System.in);

        // Nombre
        System.out.print("Introduce el nombre del producto: ");
        nombre = entrada.nextLine();

        // Precio original
        System.out.print("Introduce el precio original: ");
        precioOriginal = entrada.nextDouble();
        entrada.nextLine();

        // Porcentaje de descuento
        System.out.print("Introduce el descuento: ");
        descuento =  entrada.nextDouble();
        entrada.nextLine();

        // Tasa de impuesto
        System.out.print("Introduce la tasa de impuesto: ");
        tasaDeImpuesto = entrada.nextDouble();
        entrada.nextLine();

        // Cerrar Scanner
        entrada.close();

        // PROCESAMIENTO (PROCESO)

        double montoDescuento = precioOriginal * (descuento/100);
        double precioConDescuento = precioOriginal - montoDescuento;
        double montoImpuesto = precioConDescuento *(tasaDeImpuesto/100);
        double precioFinal = precioConDescuento + montoImpuesto;

        // SALIDA DE DATOS (OUTPUT)

        System.out.println("\n----- RESULTADO FINAL -----");

        System.out.printf("Nombre del producto: %s\n", nombre);
        System.out.printf("Precio original: %.2f €\n", precioOriginal);
        System.out.printf("Descuento aplicado (%.2f%%): %.2f €\n", descuento, montoDescuento);
        System.out.printf("Precio tras descuento: %.2f €\n", precioConDescuento);
        System.out.printf("Impuesto aplicado (%.2f%%): %.2f €\n", tasaDeImpuesto, montoImpuesto);
        System.out.printf("Precio final: %.2f €\n", precioFinal);

    }








}