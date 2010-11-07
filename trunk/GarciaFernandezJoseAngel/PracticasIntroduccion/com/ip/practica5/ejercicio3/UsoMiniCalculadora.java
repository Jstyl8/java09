package com.ip.practica5.ejercicio3;
/**
*nombre: MiniCalculadora
*autor: José Ángel García Fernández
*fecha: 09/11/08
*Descripcion: programa que dados 2 números y un operador, realiza la operación entre los 2
*números siempre que sea posible.
*/

import java.io.*;			//Importamos la clase E/S de java
							// es imprescindible para leer de teclado
public class UsoMiniCalculadora
{
	static float operando1, operando2;
	static char operador;
	static float resultado;
	
/********************************************************************* 
METODO leer_caracter(): Lee un caracter de teclado
********************************************************************/

	public static char leer_caracter() throws IOException
	{		
		System.out.println("Introduzca un operador: “*” para multiplicar, “/” para dividir, “+” para sumar, “-“ para restar, y “%” para el módulo (resto).");
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();
		operador = cadenaleida.charAt( 0 );
		
		while (operador!='+'&&operador!='-'&&operador!='*'&&operador!='/'&&operador!='%')
		{
			System.out.println(" ERROR : Introduzca un operador: “*” para multiplicar, “/” para dividir, “+” para sumar, “-“ para restar, y “%” para el módulo (resto).");
			cadenaleida = entrada.readLine();
			operador = cadenaleida.charAt( 0 ); 
		}	 
			 
	return operador;
	}	//fin leer_caracter()
	
/*********************************************************************
METODO Mostrar(): Muestra por pantalla el valor de resultado.
********************************************************************/

	public static void Mostrar(float resultado)
	{
		System.out.println("El resultado es "+resultado);
	}//fin Mostrar()
	
/*******************************************************
METODO MAIN()
******************************************************/

	public static void main(String argv[]) throws IOException
	{
		System.out.println("Introduzca el primer operando");
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();		// asigna a cada numero un valor														
		operando1 = Float.parseFloat(cadenaleida);		// introducido por teclado
														// a las variables correspondientes
			
		System.out.println("Introduzca el segundo operando");
		String cadenaleida2 = entrada.readLine();
		operando2 = Float.parseFloat(cadenaleida2);
											
		operador = leer_caracter();
		
		resultado = MiniCalculadora.RealizarOperacion(operando1,operando2,operador);
														//asigna el resultado
														//correspondiente										
		Mostrar(resultado);			//muestra el resultado
		
	}//fin de main()
	
}//fin de UsoMiniCalculadora