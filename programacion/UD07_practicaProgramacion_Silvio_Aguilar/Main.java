package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Declarar array unidimensional
        String[] estudiantes = new String[10];

        // Declarar array bidimensional
        int[][] calificaciones = new int[10][3];

        // Declarar cadena con el nombre de la institucion
        String nombreInstitucion = "Universidad XYZ";


        //Inicialización de 5 estudiantes
        estudiantes[0] = "Ana";
        estudiantes[1] = "Luis";
        estudiantes[2] = "Marta";
        estudiantes[3] = "Carlos";
        estudiantes[4] = "Sofía";

        // Inicializar calificaciones de los 5 estudiantes
        //Estudiante 0 = Ana;
        calificaciones[0][0] = 6; // Mates
        calificaciones[0][1] = 8; // Historia
        calificaciones[0][2] = 9; // Programacion

        // Estudiante 1 = Luis

        // Mostrar por pantalla nombre de tercer estudiante mediante índice
        System.out.println("Nombre: " + estudiantes[2]);

        // Mostrar por pantalla la calificaion del primer estudiante en la segunda asignatura
        System.out.println("Calificaion en Historia: " + calificaciones[0][1]);

        // Recorrer el array de nombres y mostrar todos los estudiantes registrados
        for (int i = 0 ; i < estudiantes.length; i++){
            if (estudiantes[i] != null){
                System.out.println("Nombre: " + estudiantes[i]);

            }
        }

        // Recorrer el array bidimensional y mostrar todas las calificaiones organizadas por estudiante y asignatura
        for (int i = 0; i < estudiantes.length;i++){
            if (estudiantes[i] != null){
                System.out.print("Estudiante: " + (i+1) + " - " + estudiantes[i]);
                System.out.println("\nNota en Mates: " + calificaciones[i][0]);
                System.out.println("Nota en Historia: " + calificaciones[i][1]);
                System.out.println("Nota en Programación: " + calificaciones[i][2]);
                System.out.println("\n");
            }

        }

        // Busqueda de datos
        // Busqueda lineal
        boolean isInArray = false;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce el nombre del estudiante: ");
        String nombre = entrada.nextLine();
        for (int i = 0; i<estudiantes.length;i++){
            if (estudiantes[i] != null){
                if (nombre.equals(estudiantes[i])){
                    System.out.println("Nombre: " + estudiantes[i] + " - Posición: " + i);
                    isInArray = true;

                }
            }

        }
        if (!isInArray){
            System.out.println("El estudiante no se encuentra en el array");
        }

        // Ordenación de datos (burbuja)
        for (int i = 0; i < estudiantes.length - 1; i++) {
            for (int j = 0; j < estudiantes.length - 1; j++) {

                if (estudiantes[j] != null && estudiantes[j + 1] != null) {

                    if (estudiantes[j].compareTo(estudiantes[j + 1]) > 0) {

                        String aux = estudiantes[j];
                        estudiantes[j] = estudiantes[j + 1];
                        estudiantes[j + 1] = aux;
                    }
                }
            }
        }

        // Imprimir estudiantes ordenados
        System.out.println("Estudiantes ordenados:");
        for (String estudiante : estudiantes) {
            if (estudiante != null) {
                System.out.println(estudiante);
            }
        }


        // Operaciones con cadenas de caracteres

        // Primer y Último carácter
        System.out.println("Primer carácter de la institución: " + nombreInstitucion.charAt(0));
        System.out.println("Último carácter de la institución: " + nombreInstitucion.charAt(nombreInstitucion.length()-1));

        // Concatenar el nombre de la institución con - Sistema de calificaiones
        System.out.println(nombreInstitucion.concat(" - Sistema de Calificaiones"));

        // Convertir nombre de un estudiante a mayusculas
        if (estudiantes[0] != null){
            System.out.println("Nombre en mayusculas: " + estudiantes[0].toUpperCase());

        }

        // Buscar la subcadena Uni dentro del nombre de la institucion
        if (nombreInstitucion.contains("Uni")) {
            System.out.println("La institución contiene la subcadena 'Uni'");
        } else {
            System.out.println("La institución NO contiene la subcadena 'Uni'");
        }

        entrada.close();

    }
}