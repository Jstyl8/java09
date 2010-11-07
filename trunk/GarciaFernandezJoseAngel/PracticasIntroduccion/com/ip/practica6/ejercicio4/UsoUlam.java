package com.ip.practica6.ejercicio4;
/**
*nombre: UsoUlam
*autor: José Ángel García Fernández
*fecha: 04/12/08
*Descripcion: programa que muestra por pantalla la sucesión de Ulam usando el metodo
*de la clase Ulam.
*/

import java.io.*;			//Importamos la clase E/S de java
							// es imprescindible para leer de teclado
public class UsoUlam
{
	static int numero;
	static String serie;

/********************************************************************* 
METODO LecturaNumero(): Lee un valor positivo y los transforma en un dato entero
********************************************************************/

	public static int LecturaNumero() throws IOException
	{	
		System.out.println("Introduzca el numero de termimos de la serie que quiera ver");
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();
		numero = Integer.parseInt(cadenaleida);	
				
			while(numero<=0)
			{
				System.out.println("ERROR: Introduzca un numero positivo");
				String cadenaleida2 = entrada.readLine();
				numero = Integer.parseInt(cadenaleida2);
			}
	return numero;
	}	//fin LecturaNumero()	
	
/*********************************************************************
METODO Mostrar(): Muestra por pantalla el valor serie
********************************************************************/

	public static void Mostrar(String serie)
	{
		System.out.println(serie);
	}//fin Mostrar()
	
/*******************************************************
METODO MAIN()
******************************************************/

	public static void main(String argv[]) throws IOException
	{			
		numero = LecturaNumero();			//asigna a numero el numero introducido		
																			
		serie= Ulam.Calcular_serie(numero);	//calcula y  muestra la serie de ulam
											//correspondiente
		Mostrar(serie);									
	}//fin de main()
}//fin de Ulam