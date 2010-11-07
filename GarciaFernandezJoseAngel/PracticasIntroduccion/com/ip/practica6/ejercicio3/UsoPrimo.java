package com.ip.practica6.ejercicio3;
/**
*nombre: UsoPrimo
*autor: José Ángel García Fernández
*fecha: 05/12/08
*Descripcion: programa que calcula si un numero es primo o no usando metodos
*de la clase Primo.
*/

import java.io.*;			//Importamos la clase E/S de java
							// es imprescindible para leer de teclado
public class UsoPrimo
{
	static float numero;
	static boolean primo;
	static String mensaje;

/*********************************************************************
METODO Mostrar(): Muestra por pantalla el valor de mensaje.
********************************************************************/

	public static void Mostrar(String mensaje)
	{
		System.out.println(mensaje);
	}//fin Mostrar()
	
/*******************************************************
METODO MAIN()
******************************************************/

	public static void main(String argv[]) throws IOException
	{			
		System.out.println("Introduzca un numero");
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();
		numero = Float.parseFloat(cadenaleida);
		
		primo = Primo.EsPrimo(numero);			//asigna mensaje una cadena de 
		mensaje = Primo.Asignar_Primo(primo);	//caracteres en funcion de
												//primo
												
		Mostrar(mensaje);							//muestra el mensaje	
	}//fin de main()
}//fin de UsoPrimo