package org.example;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblio =  new Biblioteca("El Madroño");

        Socio juan = new Socio("Juan", "123GHB");
        Socio vero = new Socio("Vero", "123UVF");
        biblio.registrarSocio(juan);
        biblio.registrarSocio(vero);

        biblio.agregarLibro(new Libro("Carmencita", "Garcia", "123qwe"));
        biblio.agregarLibro(new Libro("400 golpes", "Truffaut", "123123ewq"));
        biblio.agregarLibro(new Libro("El Quijote", "Cervantes", "ISBN999"));


        System.out.println("Bienvenido a la biblioteca " + biblio.getNombre());

        Scanner entrada = new Scanner(System.in);
        int opcion = 0;


            do {
                System.out.println(" === Menú === ");
                System.out.println("1. Agregar libro");
                System.out.println("2. Añadir socio");
                System.out.println("3. Realizar un prestamo");
                System.out.println("4. Realizar una devolucion");
                System.out.println("5. Mostrar libros registrados");
                System.out.println("6. Mostrar libros prestados");
                System.out.println("7. Salir");
                System.out.print("Opcion: ");

                try{
                    opcion = entrada.nextInt();
                    entrada.nextLine(); // Limpiar buffer
                }catch (InputMismatchException e){
                    System.out.println("Debes introducir un numero del 1 - 6");
                    entrada.nextLine(); // Limpiar la entrada
                    opcion = 0;
                    continue;
                }

                switch (opcion){
                    case 1:
                        System.out.print("Nombre del libro: ");
                        String nombre = entrada.nextLine();
                        System.out.print("Nombre del autor: ");
                        String autor = entrada.nextLine();
                        System.out.print("ISBN: ");
                        String isbn = entrada.nextLine();
                        biblio.agregarLibro(new Libro(nombre,autor,isbn));
                        System.out.println("Libro agregado correctamente!");
                        break;
                    case 2:
                        System.out.print("Nombre del socio: ");
                        String nombreSocio = entrada.nextLine();
                        System.out.print("ID de socio: ");
                        String idSocio = entrada.nextLine();
                        biblio.registrarSocio(new Socio(nombreSocio,idSocio));
                        System.out.println("Socio agregado correctamente!");
                        break;
                    case 3:
                        System.out.print("ID Socio: ");
                        idSocio = entrada.nextLine();
                        System.out.print("ISBN Libro: ");
                        isbn = entrada.nextLine();
                        biblio.realizarPrestamo(idSocio,isbn);
                        break;
                    case 4:
                        System.out.print("ID Socio: ");
                        idSocio = entrada.nextLine();
                        System.out.print("ISBN Libro: ");
                        isbn = entrada.nextLine();
                        biblio.realizarDevolucion(idSocio,isbn);
                        break;
                    case 5:
                        System.out.println(" === Libros === ");
                        biblio.mostrarCatalogo();
                        break;
                    case 6:
                        System.out.print("Introduce el id del socio: ");
                        idSocio = entrada.nextLine();
                        Socio socio = biblio.buscarSocio(idSocio);
                        if (socio == null) {
                            System.out.println("Socio no encontrado");
                            break;
                        }
                        socio.mostrarLibrosPrestados();
                        break;
                    case 7:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opcion invalida\n");
                        break;
                }
            }while (opcion != 7);





    }
}