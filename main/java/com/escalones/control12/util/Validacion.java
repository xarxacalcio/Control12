package com.escalones.control12.util;

import java.util.Date;

/**
 *
 * @author xarxa
 */
public class Validacion {

    // Verifica si una cadena está rellena (no es nula, vacía o solo espacios en blanco)
    public static boolean estaRelleno(String cadena) {
        if (cadena == null) {
            return false;
        }
        return !(cadena.isEmpty() || cadena.isBlank());
    }
    
    // Verifica si una fecha está rellena (no es nula)
    public static boolean estaRelleno(Date fecha) {
        if (fecha == null) {
            return false;
        }
        return true;
    }

    // Verifica si la longitud de una cadena está entre un mínimo y un máximo
    public static boolean tamanoEntre(String cadena, int min, int max) {
        if (cadena == null) {
            return false;
        }
        if (cadena.length() < min || cadena.length() > max) {
            return false;
        }
        return true;
    }

    // Verifica si un número entero está entre un mínimo y un máximo
    public static boolean numeroEnteroEntre(int n, int min, int max) {
        if (n < min || n > max) {
            return false;
        }
        return true;
    }

    // Verifica si un número flotante está entre un mínimo y un máximo
    public static boolean numeroFloatEntre(float n, float min, float max) {
        if (n < min || n > max) {
            return false;
        }
        return true;
    }

    // Verifica si una cadena puede ser convertida a un número entero válido
    public static boolean enteroValido(String n) {
        boolean resultado = true;
        try {
            int num = Integer.parseInt(n);

        } catch (Exception ex) {
            resultado = false;
        }
        return resultado;
    }

    // Verifica si una cadena puede ser convertida a un número flotante válido
    public static boolean floatValido(String n) {
        boolean resultado = true;
        try {
            float num = Float.parseFloat(n);

        } catch (Exception ex) {
            resultado = false;
        }
        return resultado;
    }
    
    // Verifica si un número flotante es mayor que un valor dado
    public static boolean floatMayorQue(float n, float valor){
        
        return n>valor;
      
    }

    // Verifica si un número flotante es mayor o igual que un valor dado
    public static boolean floatMayorIgualQue(float n, float valor){
        
        return n>=valor;
      
    }
    
    // Verifica si un número flotante está entre dos valores dados
    public static boolean floatEntre(float n, float valor1, float valor2){
        
        return n>=valor1 && n<=valor2;
      
    }
    
    // Verifica si un número entero es mayor que un valor dado
    public static boolean enteroMayorQue(int n, int valor){
        
        return n>valor;
      
    }

    // Verifica si un número entero es mayor o igual que un valor dado
    public static boolean enteroMayorIgualQue(int n, int valor){
        
        return n>=valor;
      
    }
    
    // Verifica si un número entero está entre dos valores dados
    public static boolean enteroEntre(int n, int valor1, int valor2){
        
        return n>=valor1 && n<=valor2;
      
    }
    
    // Verifica si una cadena cumple con una expresión regular dada
    public static boolean cumpleExpresionRegular(String cadena, String expresionRegular) {
        return cadena.matches(expresionRegular);
    }
}
