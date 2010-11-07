package com.ip.practica5.ejercicio1;

/**
*nombre: UsoDiaSemana
*autor: José Ángel García Fernández
*fecha: 04/12/08
*Descripcion: programa que muestra el día de la semana en función del número introducido
* usando un metodo de la clase DiaSemana.
*/

import java.io.*;			//Importamos la clase E/S de java
							// es imprescindible para leer de teclado
public class UsoDiaSemana
{
	static byte dia;
	static String dia_literal;

/********************************************************************* 
METODO Lectura_dia(): Lee un valor del teclado y los transforma en un dato entero
********************************************************************/

	public static byte lectura_dia() throws IOException
	{		
		System.out.println("Introduzca un numero mayor o igual que 1 y menor o igual que 7");
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();
		dia = Byte.parseByte(cadenaleida);
				
		while(dia<1||dia>7)
		{
			System.out.println("ERROR: Introduzca un numero mayor o igual que 1 y menor o igual que 7");
			BufferedReader entrada2 = new BufferedReader
			(new InputStreamReader(System.in));
			String cadenaleida2 = entrada2.readLine();
			dia = Byte.parseByte(cadenaleida2);
		}
	return dia;
	}	//fin leer()

/*********************************************************************
METODO MOSTRAR(): Muestra por pantalla el valor de dia_literal.
********************************************************************/

	public static void Mostrar(String dia_literal)
	{
		System.out.println(dia_literal);
	}//fin Mostrar()
	
/*******************************************************
METODO MAIN()
******************************************************/

	public static void main(String argv[]) throws IOException
	{
		dia = lectura_dia();						//asigna el numero introducido a 
													//la variable dia
		
		dia_literal = DiaSemana.Calcular_dia(dia);	//asigna a dia_literal la cadena de caracteres
												//correspondiente al numero introducido
												
		Mostrar(dia_literal);			//muestra el dia_literal
		
	}//fin de main()
	
}//fin de UsoDiaSemana