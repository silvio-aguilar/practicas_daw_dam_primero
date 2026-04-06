package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Inventario libros = new Inventario();


        Scanner entrada = new Scanner(System.in);
        int option = 0;

        do {
            // Menú visual
            System.out.println("\n=== Menú ===");
            System.out.println("1. Registrar nuevo libro");
            System.out.println("2. Vender libro");
            System.out.println("3. Listar libros");
            System.out.println("4. Buscar libro");
            System.out.println("5. Ver último libro añadido");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");

            // Control de entrada del menú
            try {
                option = entrada.nextInt();
                entrada.nextLine(); // limpiar buffer
            } catch (InputMismatchException e) {
                System.out.println("Error en la entrada... introduce un número (1 - 6)");
                entrada.nextLine();
                continue;
            }

            switch (option) {

                case 1:
                    System.out.print("Introduce el título: ");
                    String titulo = entrada.nextLine();

                    System.out.print("Introduce el autor: ");
                    String autor = entrada.nextLine();

                    System.out.print("Introduce el ISBN: ");
                    String isbn = entrada.nextLine();

                    libros.registrarLibro(titulo, autor, isbn, 1);
                    System.out.println("Libro registrado correctamente.");
                    break;

                case 2:
                    System.out.print("Introduce el ISBN: ");
                    String isbnVenta = entrada.nextLine();

                    boolean vendido = libros.venderLibro(isbnVenta);
                    if (vendido) {
                        System.out.println("Libro vendido correctamente.");
                    } else {
                        System.out.println("No se pudo vender el libro (no existe o sin stock).");
                    }
                    break;

                case 3:
                    System.out.println("\n=== Libros ===");
                    if (libros.listarLibros().isEmpty()) {
                        System.out.println("La lista está vacía, añade un libro primero.");
                    } else {
                        System.out.println(libros.listarLibros());
                    }
                    break;

                case 4:
                    System.out.print("Introduce el título o ISBN: ");
                    String busqueda = entrada.nextLine();

                    Libro resultado = libros.buscarLibros(busqueda);
                    if (resultado != null) {
                        System.out.println("Libro encontrado:");
                        System.out.println(resultado);
                    } else {
                        System.out.println("No hay ninguna coincidencia.");
                    }
                    break;

                case 5:
                    Libro ultimo = libros.mostrarUltimoLibro();
                    if (ultimo == null) {
                        System.out.println("No hay libros que mostrar.");
                    } else {
                        System.out.println("Último libro añadido:");
                        System.out.println(ultimo);
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    entrada.close();
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (option != 6);
    }
}
