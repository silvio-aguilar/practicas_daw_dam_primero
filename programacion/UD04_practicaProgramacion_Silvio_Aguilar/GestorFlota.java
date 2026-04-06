package org.example;

public class GestorFlota {


    public static boolean validarMatricula(String matricula){

        /*
        *Validacion para la matricula
        * Primero calculamos que la matricula sea mayor o igual a 6 caracteres
        * Si es verdadero entramos en un bucle for recorriendo cada caracter
        * comprobando si cada caracter es letra o digito
         */


        if (matricula.length() >= 6 ){
            for (int i = 0; i< matricula.length();i++){
                char c = matricula.charAt(i);
                if (!Character.isLetterOrDigit(c)){
                    return false;
                }
            }
            return true;
        }
        return false;


    }



}
