package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("=== Bienvenido a la Tiendita ===");
        System.out.println("Este programa permite ingresar productos,");
        System.out.println("validar cantidades y precios, y aplicar descuentos.\n");

        // Array dinámico manual (crece copiando)
        Productos[] productos = new Productos[0];

        boolean continuar = true;

        while (continuar) {

            Productos producto = new Productos();

            // NOMBRE
            System.out.print("\nNombre del producto: ");
            producto.setNombre(entrada.nextLine());

            // VALIDAR PRECIO
            double precioIngresado;
            while (true) {
                System.out.print("Precio del producto: ");
                if (entrada.hasNextDouble()) {
                    precioIngresado = entrada.nextDouble();
                    entrada.nextLine();
                    if (precioIngresado > 0) {
                        producto.setPrecio(precioIngresado);
                        break;
                    } else {
                        System.out.println("El precio debe ser mayor a 0.");
                    }
                } else {
                    System.out.println("Debe ingresar un número válido.");
                    entrada.nextLine();
                }
            }

            // VALIDACIÓN DE CANTIDAD
            int cantidadIngresada;
            while (true) {
                System.out.print("Cantidad del producto: ");
                if (entrada.hasNextInt()) {
                    cantidadIngresada = entrada.nextInt();
                    entrada.nextLine();
                    if (cantidadIngresada > 0) {
                        producto.setCantidad(cantidadIngresada);
                        break;
                    } else {
                        System.out.println("La cantidad debe ser mayor a 0.");
                    }
                } else {
                    System.out.println("Debe ingresar un número entero válido.");
                    entrada.nextLine();
                }
            }

            // AÑADIR PRODUCTO AL ARRAY
            Productos[] nuevoArray = new Productos[productos.length + 1];
            for (int i = 0; i < productos.length; i++) {
                nuevoArray[i] = productos[i];
            }
            nuevoArray[productos.length] = producto;
            productos = nuevoArray;

            // PREGUNTAR SI DESEA AÑADIR OTRO
            System.out.print("\n¿Desea añadir otro producto? (s/n): ");
            String opcion = entrada.nextLine().trim().toLowerCase();
            if (!opcion.equals("s")) continuar = false;
        }

        // CALCULAR TOTAL
        double totalProvisional = 0;

        System.out.println("\n=== RESUMEN DEL PEDIDO ===");

        for (Productos p : productos) {
            double subtotal = p.calcularSubtotal();
            totalProvisional += subtotal;

            System.out.println("\nProducto: " + p.getNombre());
            System.out.printf("Precio unitario: %.2f €\n", p.getPrecio());
            System.out.println("Cantidad: " + p.getCantidad());
            System.out.printf("Subtotal con descuento: %.2f €\n", subtotal);
        }

        // DESCUENTO GLOBAL
        double totalFinal = totalProvisional;

        if (totalProvisional >= 500) {
            totalFinal *= 0.85;
        } else if (totalProvisional >= 200) {
            totalFinal *= 0.95;
        }

        System.out.println("\n=== TOTAL DEL PEDIDO ===");
        System.out.printf("Total provisional: %.2f €\n", totalProvisional);

        if (totalFinal != totalProvisional) {
            System.out.printf("Total tras descuentos globales: %.2f €\n", totalFinal);
        } else {
            System.out.printf("Total final: %.2f €\n", totalFinal);
        }

        System.out.println("\n¡Gracias por usar la Tiendita!");
        System.out.println("=== Hasta pronto ===");
    }
}
