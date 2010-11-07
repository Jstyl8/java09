package com.ip.practica5.ejercicio5;
/**
*nombre: UsoIntercambiador
*autor: José Ángel García Fernández
*fecha: 10/11/08
*Descripcion: programa que intercambia los valores de 2 variables
*usando el metodo de la clase Intercambiador
*/

import java.io.*;			//Importamos la clase E/S de java
							// es imprescindible para leer de teclado
public class UsoIntercambiador
{
	static int variable1, variable2;
	static String intercambio;
	
/*********************************************************************
METODO Mostrar(): Muestra  las variables intercambiadas mediante la cadena intercambio
********************************************************************/

	public static void Mostrar(String intercambio)
	{
		System.out.println(intercambio);	
	}//fin Mostrar()
	
/*******************************************************
METODO MAIN()
******************************************************/

	public static void main(String argv[]) throws IOException
	{
		System.out.println("Introduzca la primera variable");
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();
		variable1 = Integer.parseInt(cadenaleida);
		
		System.out.println("Introduzca la segunda variable");
		String cadenaleida2 = entrada.readLine();
		variable2 = Integer.parseInt(cadenaleida2);
									
		intercambio = Intercambiador.Intercambiar_valores(variable1,variable2);						
												//realiza el intercambio de las variables
		Mostrar(intercambio);						//muestra los valores
		
	}//fin de main()
	
}//fin de UsoIntercambiador