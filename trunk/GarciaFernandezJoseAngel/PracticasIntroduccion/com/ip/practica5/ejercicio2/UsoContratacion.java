package com.ip.practica5.ejercicio2;
/**
*nombre: UsoContratacion
*autor: José Ángel García Fernández
*fecha: 04/12/08
*Descripcion: programa que muestra si se está contratado al introducir una edad y 2 calificaciones
*usando un metodo de la clase Contratacion.
*/

import java.io.*;			//Importamos la clase E/S de java
							// es imprescindible para leer de teclado
public class UsoContratacion
{
	static byte edad;
	static byte calificacion1, calificacion2;
	static String mensaje;

/********************************************************************* 
METODO Lectura_edad(): Lee una edad por teclado y los transforma en un dato entero.
********************************************************************/

	public static byte Lectura_edad() throws IOException
	{		
		System.out.println("Introduzca una edad mayor o igual que 0 y menor o igual que 120");
			
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();
		edad = Byte.parseByte(cadenaleida);
				
		while(edad<0||edad>120)
		{
			System.out.println("ERROR: Introduzca una edad mayor o igual que 0 y menor o igual que 120");
				
			BufferedReader entrada2 = new BufferedReader
				(new InputStreamReader(System.in));
			String cadenaleida2 = entrada2.readLine();
			edad = Byte.parseByte(cadenaleida2);
		}
		
	return edad;
	}	//fin lectura_edad()
	
/*********************************************************************
METODO Lectura_calificacion(): Lee una calificacion por teclado y lo transforma en un dato entero.
********************************************************************/

	public static byte Lectura_calificacion () throws IOException
	{
		byte calificacion;
		
			System.out.println("Introduzca una calificacion mayor o igual que 0 y menor o igual que 100");
			
			BufferedReader entrada = new BufferedReader
				(new InputStreamReader(System.in));
			String cadenaleida = entrada.readLine();
			calificacion = Byte.parseByte(cadenaleida);
				
		while(calificacion<0||calificacion>100)
			{
		
			System.out.println("ERROR: Introduzca una calificacion mayor o igual que 0 y menor o igual que 100");
				
			BufferedReader entrada2 = new BufferedReader
				(new InputStreamReader(System.in));
			String cadenaleida2 = entrada2.readLine();
			calificacion = Byte.parseByte(cadenaleida2);
			}
	return calificacion;
	}//fin Lectura_calificacion()

/*********************************************************************
METODO Mostrar_contratado(): Muestra por pantalla el valor de mensaje.
********************************************************************/

	public static void Mostrar_contratado(String mensaje)
	{
		System.out.println(mensaje);
	}//fin Mostrar_dia_semana()
	
	
/*******************************************************
METODO MAIN()
******************************************************/

	public static void main(String argv[]) throws IOException
	{
		edad = Lectura_edad();					//asigna la edad introducida a 
												//la variable edad
												
		calificacion1 = Lectura_calificacion(); //asigna a cada calificacion
		calificacion2 = Lectura_calificacion(); //las calificaciones introducidas
		
		mensaje = Contratacion.Calcular_contratado(edad, calificacion1, calificacion2);
												//asigna a mensaje la cadena de caracteres
												//correspondiente
												
		Mostrar_contratado(mensaje);			//muestra el mensaje
	}//fin de main()
}//fin de Contratacion