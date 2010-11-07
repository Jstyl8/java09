package com.ip.practica6.ejercicio2;
/**
*nombre: UsoFibonacci
*autor: José Ángel García Fernández
*fecha: 04/12/08
*Descripcion:programa que muestra los k primeros 
*términos de la serie de Fibonacci siendo k un valor introducido por teclado usando
*un metodo de la clase Fibonacci
*/

import java.io.*;			//Importamos la clase E/S de java
							// es imprescindible para leer de teclado
public class UsoFibonacci
{
	static int K;
	static String serie;

/********************************************************************* 
METODO Lectura_K(): Lee un valor positivo de K
********************************************************************/

	public static int Lectura_K() throws IOException
	{		
		System.out.println("Introduzca el numero de terminos de la secuencia de Fibonacci que quiere ver (numero positivo)");
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();
		K = Integer.parseInt(cadenaleida);
				
		while(K<=0)
		{
			System.out.println("Error:Introduzca el numero de terminos de la secuencia de Fibonacci que quiere ver (numero positivo)");
			String cadenaleida2 = entrada.readLine();
			K = Integer.parseInt(cadenaleida2);
		}	
	return K;
	}//fin Lectura_K()	
	
/*********************************************************************
METODO Mostrar_serie(): Muestra por pantalla el valor de la serie.
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
		K = Lectura_K();				// asigna a K el numero de terminos
										// de la serie a mostrar
		serie = Fibonacci.Calcular_serie(K);	//asigna a serie la cadena de caracteres que
												// contiene a la serie
		Mostrar(serie);
	}//fin de main()
	
}//fin de UsoFibonacci