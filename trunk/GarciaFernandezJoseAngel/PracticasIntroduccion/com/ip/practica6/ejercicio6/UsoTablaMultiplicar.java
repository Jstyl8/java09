package com.ip.practica6.ejercicio6;
/**
*nombre: UsoTablaMultiplicar 
*autor: José Ángel García Fernández
*fecha: 09/12/08
*Descripcion: programa que sirve para aprender a multiplicar usando un metodo de la clase
*TablaMultiplicar.
*/
import java.io.*;			//Importamos la clase E/S de java
							// es imprescindible para leer de teclado
public class UsoTablaMultiplicar
{
	static int numero_repaso;
	static int respuesta;
	static int errores;
	static boolean correcto;

/********************************************************************* 
METODO Lectura_numero_repaso(): Lee un valor positivo y los transforma en un dato entero
********************************************************************/
	
	public static int Lectura_numero_repaso() throws IOException
	{		
		System.out.println("Introduzca el numero a repasar (mayor que 0 y menor o igual a 10)");	
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();
		numero_repaso = Integer.parseInt(cadenaleida);
		
		while(numero_repaso<0||numero_repaso>10)
		{	
			System.out.println("ERROR: Introduzca el numero a repasar (mayor que 0 y menor o igual a 10)");	
			String cadenaleida2 = entrada.readLine();
			numero_repaso = Integer.parseInt(cadenaleida2);
		}
	return numero_repaso;
	}	//fin Lectura_numero_repaso()
/*********************************************************************
METODO Mostrar_multiplicacion(): Muestra la cadena de caracteres de la multiplicacion
********************************************************************/

	public static void Mostrar_multiplicacion(int numero_repaso, int i)
	{		
		System.out.println(numero_repaso+"*"+i+"=?");
	}///fin Mostrar_multiplicacion()
			
/********************************************************************* 
METODO Lectura_respuesta(): Lee un valor y lo transforma en un dato entero
********************************************************************

	public static int Lectura_respuesta() throws IOException
	{		
				
		System.out.println("Introduzca el resultado de la multiplicacion ");
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();
		respuesta = Integer.parseInt(cadenaleida);
		
	return respuesta;
	}	//fin Lectura_respuesta()	
	
/*********************************************************************
METODO Mostrar_mensaje(): Muestra por pantalla el valor de mensaje y contea los errores
********************************************************************/

	public static int Mostrar_mensaje(boolean correcto,int numero_repaso, int i)
	{
		if(correcto==true)
		{
			System.out.println("Respuesta correcta");
		}
			else
			{
			System.out.println("Te has equivocado la respuesta es "+numero_repaso+"*"+i+"="+numero_repaso*i);
			errores = errores+1;
			}
	return errores;
	}//fin Mostrar_mensaje()

/*********************************************************************
METODO Mostrar_mensaje2(): Muestra por pantalla el valor de mensaje2 y contea los errores
********************************************************************/

	public static void Mostrar_mensaje2(int errores)
	{
		if(errores<=2)
		{
			System.out.println("APROBADO");
		}
			else
			{
				System.out.println("SUSPENSO");
			}
	}//fin Mostrar_mensaje2()
	
/*******************************************************
METODO MAIN()
******************************************************/

	public static void main(String argv[]) throws IOException
	{	
		do
		{	
			errores=0;
			numero_repaso = Lectura_numero_repaso();	
			for(int i=1;i<=10;i=i+1)
			{
				Mostrar_multiplicacion(numero_repaso,i);
		
				System.out.println("Introduzca el resultado de la multiplicacion ");
				BufferedReader entrada = new BufferedReader
					(new InputStreamReader(System.in));
				String cadenaleida = entrada.readLine();
				respuesta = Integer.parseInt(cadenaleida);
		
				correcto = TablaMultiplicar.Comprobar_respuesta(numero_repaso, i, respuesta);			
		
				errores = Mostrar_mensaje(correcto, numero_repaso, i);
			}
		Mostrar_mensaje2(errores);	
		}while(numero_repaso!=0);																
	}//fin de main()
}//fin de UsoMultiplicador