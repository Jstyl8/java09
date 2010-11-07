package com.ip.practica6.ejercicio1;
/**
*nombre: UsoSumador
*autor: José Ángel García Fernández
*fecha: 09/12/08
*Descripcion: programa que permite obtener la suma de una serie de números positivos usando
*un metodo de la clase Sumador
*/

import java.io.*;			//Importamos la clase E/S de java
							// es imprescindible para leer de teclado
public class UsoSumador
{
	static int sumandos;
	static float numero;
	static float suma;

/********************************************************************* 
METODO Lectura_numero_positivo(): Lee un valor positivo y los transforma en un dato entero
********************************************************************/

	public static float Lectura_numero_positivo() throws IOException
	{		
		System.out.println("Introduzca un numero positivo");
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();
		numero = Float.parseFloat(cadenaleida);
		
		while(numero<0)
		{
			System.out.println("Error: Introduzca un numero positivo");
			String cadenaleida2 = entrada.readLine();
			numero = Float.parseFloat(cadenaleida2);
		}
	return numero;
	}	//fin lectura_numero_positivo()	
	
/********************************************************************* 
METODO Lectura_sumandos(): Lee el numero de sumandos a sumar
********************************************************************/

	public static int Lectura_sumandos() throws IOException
	{		
		System.out.println("Introduzca el numero de numeros a sumar");
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();
			sumandos = Integer.parseInt(cadenaleida);
					
		while(sumandos<=0)
		{
			System.out.println("Error: Introduzca un numero positivo");
			String cadenaleida2 = entrada.readLine();
			sumandos =	Integer.parseInt(cadenaleida2);
		}
	return sumandos;
	}	//fin lectura_sumandos()	
/*********************************************************************
METODO Mostrar(): Muestra por pantalla el valor de la suma.
********************************************************************/

	public static void Mostrar(float suma)
	{
		System.out.println("La suma es "+suma);
	}//fin Mostrar()
	
/*******************************************************
METODO MAIN()
******************************************************/

	public static void main(String argv[]) throws IOException
	{	
		sumandos = Lectura_sumandos();	
		System.out.println("Debera introducir "+sumandos+" numeros");	
		
       	for(int i=1;i<=sumandos;i=i+1) 		 		//inicializacion, condicion
       	{
       		numero = Lectura_numero_positivo(); 	//cuerpo 
       		suma = Sumador.Calcular_suma(numero);	//del bucle
		}			
												
		Mostrar(suma);							//muestra la suma
		
	}//fin de main()
	
}//fin de UsoSumador