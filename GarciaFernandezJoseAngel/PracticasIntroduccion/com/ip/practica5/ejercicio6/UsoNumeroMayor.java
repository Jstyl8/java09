package com.ip.practica5.ejercicio6;
/**
*nombre: UsoNumeroMayor
*autor: José Ángel García Fernández
*fecha: 10/11/08
*Descripcion: programa que dados 3 números muestra el mayor usando un metodo 
*de la clase NumeroMayor.
*/

import java.io.*;			//Importamos la clase E/S de java
							// es imprescindible para leer de teclado
public class UsoNumeroMayor
{
	static int numero1, numero2, numero3, numero_mayor;
		
/*********************************************************************
METODO Mostrar(): Muestra  el numero mayor
********************************************************************/

	public static void Mostrar(int numero_mayor)
	{
		System.out.println("El numero mayor es "+numero_mayor);
	}//fin Mostrar()
	
/*******************************************************
METODO MAIN()
******************************************************/

	public static void main(String argv[]) throws IOException
	{
		System.out.println("Introduzca el primer numero");
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();
		numero1 = Integer.parseInt(cadenaleida);
		
		System.out.println("Introduzca el segundo numero");	//asigna a cada numero 
		String cadenaleida2 = entrada.readLine();		//el valor introducido por teclado
		numero2 = Integer.parseInt(cadenaleida2);
		
		System.out.println("Introduzca el tercer numero");
		String cadenaleida3 = entrada.readLine();
		numero3 = Integer.parseInt(cadenaleida3);				
									
		numero_mayor = NumeroMayor.Calcular_numero_mayor(numero1, numero2, numero3);
														//calcula el numero	mayor					
		Mostrar(numero_mayor);						//muestra el numero mayor
		
	}//fin de main()
}//fin de UsoNumeroMayor