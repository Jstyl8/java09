package com.ip.practica5.ejercicio4;
/**
*nombre: UsoAdivinador
*autor: José Ángel García Fernández
*fecha: 10/11/08
*Descripcion: programa que adivina un número de un solo digito usando el metodo
*Calcular_numero de la clase Adivinador.
*/

import java.io.*;			//Importamos la clase E/S de java
							// es imprescindible para leer de teclado
public class UsoAdivinador
{
	static int resto, numero, paridad;
	
/*********************************************************************
METODO Lectura_resto(): Lee el resto introducido por el usuario, resultado de dividir el numero entre 5
********************************************************************/

	public static int Lectura_resto() throws IOException
	{
		System.out.println("Introduzca el resto de dividir su numero entre 5");
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();
		resto = Integer.parseInt(cadenaleida);
		
		while(resto<0||resto>4)
		{	
			System.out.println("ERROR: Introduzca el resto de dividir su numero entre 5");
			String cadenaleida2 = entrada.readLine();
			resto = Integer.parseInt(cadenaleida2);
		}					
	return resto;
	}//fin Lectura_resto()

/*********************************************************************
METODO Lectura_paridad(): Lee la paridad del numero (1 para impar y 0 para par)
********************************************************************/

	public static int Lectura_paridad() throws IOException
	{
		System.out.println("Introduzca un 0 para par y un 1 para impar");
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();
		int par_impar = Integer.parseInt(cadenaleida);
		
		while(par_impar!=0&&par_impar!=1)
		{	
			System.out.println("ERROR: Introduzca un 0 para par y un 1 para impar");
			String cadenaleida2 = entrada.readLine();
			par_impar = Integer.parseInt(cadenaleida2);
		}
		if(par_impar==1)
		{
			paridad=1;
		}
			else
			{
				paridad=0;
			}
	return paridad;
	}//fin Lectura_paridad()
/*********************************************************************
METODO Mostrar(): Muestra  el numero pensado por el usuario.
********************************************************************/

	public static void Mostrar(int numero)
	{
		System.out.println("Su numero es el "+numero);
	}//fin Mostrar()
	
/*******************************************************
METODO MAIN()
******************************************************/

	public static void main(String argv[]) throws IOException
	{
		resto = Lectura_resto();					//asigna a resto el valor introducido
		paridad = Lectura_paridad();				//asigna a paridad un 1 si impar
													// o un 0 si par
		
		numero = Adivinador.Calcular_numero(resto, paridad);		//calcula el numero						
												
		Mostrar(numero);						//muestra el numero
		
	}//fin de main()
	
}//fin de UsoAdivinador