package com.mp.utilidades;
import java.util.Calendar;
import java.util.Date;

public class PruebaPrintf {
    public static void main(String[] args) {
        String cadena = "Metodologia";
        int integer = 2400000;
        double real = 12*Math.PI;
        
        System.out.printf("Pruebas con String:\n");
        System.out.printf("Una cadena---------------------------------------------|%s|\n", cadena);
        System.out.printf("Una cadena en 15 espacios------------------------------|%15s|\n", cadena);
        System.out.printf("Una cadena en 15 espacios justificada a la izquierda---|%-15s|\n", cadena);
        System.out.printf("Una cadena con 5 caracteres----------------------------|%.5s|\n", cadena);
        System.out.printf("Una cadena en un espacio de 5 con 7 caracteres---------|%7.5s|\n", "holaaa");
        System.out.printf("\n");
               
        System.out.printf("Pruebas con integer:\n");
        System.out.printf("Un entero-----------------------------|%,d|\n", integer);
        System.out.printf("Un entero como octal------------------|%o|\n", integer);
        System.out.printf("Un entero como hex--------------------|%x|\n", integer);
        System.out.printf("\n");
        
        System.out.printf("Pruebas con double:\n");
        System.out.printf("Un double-------------------------------|%f|\n", real);
        System.out.printf("Un double en notación cientifica--------|%e|\n", real);
        System.out.printf("Un double con percisión 2---------------|%.2f|\n", real);
        System.out.printf("Un double con percisión 10--------------|%.10f|\n", real);
        System.out.printf("Un double en hexadecimal----------------|%a|\n", real);
        System.out.printf("\n");
        
        Date hoy = Calendar.getInstance().getTime();        
        System.out.printf("Pruebas con Date:\n"); 
        System.out.printf("Un objeto Date como un string--------------|%s|\n", hoy);
        System.out.printf("Objeto Date formateado---------------------|%tc|\n", hoy);
        System.out.printf("Objeto Date formateado como ISO8602--------|%tF|\n", hoy);
        System.out.printf("Hora en formato 12-------------------------|%tr|\n", hoy);
        System.out.printf("Hora en formato 24-------------------------|%tR|\n", hoy);
        System.out.printf("Hora en formato 24 y segundos--------------|%tT|\n", hoy);
        System.out.printf("Fecha--------------------------------------|%tD|\n", hoy);
        System.out.printf("\n");
               
        System.out.printf("Pruebas con multiples argumentos:\n");
        System.out.printf("%1$s %2$d, %1$s %3$d, %1$s %4$d\n", "etiqueta:", 1, 2, 3);
        System.out.printf("Fecha dd-mm-yyyy--------------------------|%1$td-%1$tm-%1$tY|\n", hoy);        
    }
}
