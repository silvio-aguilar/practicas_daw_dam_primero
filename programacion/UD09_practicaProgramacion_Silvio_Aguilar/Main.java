package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main programa = new Main();
        programa.simularOperaciones();
    }

    public void simularOperaciones() {

        CuentaBancaria cuenta = new CuentaBancaria(100);
        Scanner entrada = new Scanner(System.in);
        int option = 0;

        // Menú interactivo para probar los metodos

        do {
            System.out.println("\n=== Banco ===");
            System.out.println("1. Retirar");
            System.out.println("2. Depositar");
            System.out.println("3. Comprobar saldo");
            System.out.println("4. Salir");
            System.out.print("¿Qué desea hacer?: ");


            // Una excepción en la entrda para controlar que se introduczan números enteros
            try{
                option = entrada.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Entrada inválida, usa un número del 1 al 4.");
                entrada.nextLine();
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    try {
                        cuenta.retirar(entrada.nextDouble());
                        System.out.println("Operación realizada.");
                    } catch (CantidadInvalidaException | FondosInsuficientesException e) {
                        System.out.println("Error: " + e.getMessage());

                    }catch (Exception e){
                        System.out.println("Error inesperado: " + e.getMessage());
                    } finally {
                        System.out.println("Saldo actual: " + cuenta.getSaldo() + " €");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    try {
                        cuenta.depositar(entrada.nextDouble());
                        System.out.println("Ingreso realizado.");
                    } catch (CantidadInvalidaException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (Exception e){
                        System.out.println("Error inesperado: " + e.getMessage());
                    }finally {
                        System.out.println("Saldo actual: " + cuenta.getSaldo() + " €");
                    }
                    break;

                case 3:
                    System.out.println("Saldo actual: " + cuenta.getSaldo() + " €");
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    entrada.close();
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (option != 4);
    }
}
