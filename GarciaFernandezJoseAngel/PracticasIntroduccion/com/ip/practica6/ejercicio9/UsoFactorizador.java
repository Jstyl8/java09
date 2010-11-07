package com.ip.practica6.ejercicio9;
/**
*nombre: UsoFactorizador
*autor: José Ángel García Fernández
*fecha: 13/12/08
*Descripcion: programa que escribe la descomposición de un numero 
*en potencias de factores primos usando un metodo de la clase Factorizador
*/
import java.io.*;			//Importamos la clase E/S de java
							// es imprescindible para leer de teclado
public class UsoFactorizador
{
	static int numero;
	static String descomposicion;

/********************************************************************* 
METODO Lectura_numero_positivo(): Lee un valor positivo y los transforma en un dato entero
********************************************************************/

	public static int Lectura_numero_positivo() throws IOException
	{		
		System.out.println("Introduzca el numero a descomponer");	
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();
		numero = Integer.parseInt(cadenaleida);
		while(numero<0)
		{
			System.out.println("ERROR: Introduzca el numero a descomponer (numero positivo)");	
			String cadenaleida2 = entrada.readLine();
			numero = Integer.parseInt(cadenaleida2);
		}
	return numero;
	}	//fin Lectura_numero_positivo()
/*********************************************************************
METODO Mostrar(): Muestra la descomposicion factorial
********************************************************************/

	public static void Mostrar(String descomposicion)
	{
			System.out.println(descomposicion);
	}///fin Mostrar()
/*******************************************************
METODO MAIN()
******************************************************/

	public static void main(String argv[]) throws IOException
	{	
		numero = Lectura_numero_positivo();
		descomposicion = Factorizador.Calcular_descomposicion_factorial(numero);
		Mostrar(descomposicion);
	}//fin de main()
}//fin de UsoFactorizador
