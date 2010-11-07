package com.ip.practica6.ejercicio5;
/**
*nombre: UsoNotaMedia
*autor: José Ángel García Fernández
*fecha: 09/12/08
*Descripcion: programa que calcula la nota media de un grupo de N alumnos y C notas por cada alumno
*usando un metodo de la clase NotaMedia.
*/

import java.io.*;			//Importamos la clase E/S de java
							// es imprescindible para leer de teclado
public class UsoNotaMedia
{
	static int numero_alumnos;
	static int notas_por_alumno;
	static int total_notas;
	static float suma, media, nota;

/********************************************************************* 
METODO Lectura_numero_positivo(): Lee un valor positivo y los transforma en un dato entero
********************************************************************/

	public static int Lectura_numero_positivo() throws IOException
	{	
		int numero;
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();
		numero = Integer.parseInt(cadenaleida);
				
		while(numero<=0)
		{
			System.out.println("Error: Introduzca un numero positivo");
			String cadenaleida2 = entrada.readLine();
			numero = Integer.parseInt(cadenaleida2);
		}
	return numero;
	}	//fin Lectura_numero_positivo()	
		
/********************************************************************* 
METODO Lectura_nota(): Lee un valor entre 0 y 10 y los transforma en un dato entero
********************************************************************/

	public static float Lectura_nota() throws IOException
	{		
		System.out.println("Introduzca una nota mayor o igual que 0 y menor o igual que 10");
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();
		nota = Float.parseFloat(cadenaleida);
		
		while(nota<0&&nota>10)
		{
			System.out.println("ERROR: Introduzca una nota mayor o igual que 0 y menor o igual que 10");
			String cadenaleida2 = entrada.readLine();
			nota = Float.parseFloat(cadenaleida2);
		}
	return nota;
	}	//fin Lectura_nota()

/********************************************************************* 
METODO Sumar_notas(): Realiza la suma de las notas
********************************************************************/
	public static float Sumar_notas(int numero_alumnos, int notas_por_alumno) throws IOException
	{	
		suma=0;
		for(int i=1;i<=numero_alumnos;i=i+1)
		{
			for(int j=1;j<=notas_por_alumno;j=j+1)
			{
				nota = Lectura_nota();					
				suma = suma+nota;		//suma cada nota nueva		
			}					
		}
	return suma;
	}	//fin Sumar_notas()	
/*********************************************************************
METODO Mostrar(): Muestra por pantalla el valor de mensaje.
********************************************************************/

	public static void Mostrar(float media)
	{
		System.out.println("La media de las notas introducidas es " +media);
	}//fin Mostrar()
	
/*******************************************************
METODO MAIN()
******************************************************/

	public static void main(String argv[]) throws IOException
	{		
		System.out.println("Introduzca el numero de alumnos");	
		numero_alumnos = Lectura_numero_positivo();			
			
		System.out.println("Introduzca el numero de notas por alumno");	
		notas_por_alumno = Lectura_numero_positivo();		//se usa el mismo metodo	
															//para las 2 lecturas de datos
		total_notas = numero_alumnos*notas_por_alumno;	
		
		System.out.println("Debera introducir "+total_notas+" nota(s)");	
		
		suma = Sumar_notas(numero_alumnos, notas_por_alumno);
		
		media = NotaMedia.Calcular_media(suma,total_notas);	
		
		Mostrar(media);
																	
	}//fin de main()
	
}//fin de UsoNotaMedia