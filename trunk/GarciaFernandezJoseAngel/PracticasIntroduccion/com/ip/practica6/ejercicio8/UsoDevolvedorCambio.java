package com.ip.practica6.ejercicio8;
/**
*nombre: UsoDevolvedorCambio
*autor: José Ángel García Fernández
*fecha: 09/12/08
*Descripcion: programa que devuelve el cambio de 100 
*pesetas (monedas 1 5 y 25) de una compra inferior a 100 ptas usando un metodo de la clase 
*DevolvedorCambio
*/
import java.io.*;			//Importamos la clase E/S de java
							// es imprescindible para leer de teclado
public class UsoDevolvedorCambio
{
	static int precio_compra, cambio;
	static String monedas;

/********************************************************************* 
METODO Lectura_precio_compra(): Lee un valor positivo y los transforma en un dato entero
********************************************************************/

	public static int Lectura_precio_compra() throws IOException
	{		
		System.out.println("Introduzca el precio de su compra (mayor que 0 y menor o igual a 100");	
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();
		precio_compra = Integer.parseInt(cadenaleida);
		
		while(precio_compra<0||precio_compra>100)
		{
			System.out.println("ERROR: Introduzca el precio de su compra (mayor que 0 y menor o igual a 100");	
			String cadenaleida2 = entrada.readLine();
			precio_compra = Integer.parseInt(cadenaleida2);
		}
	return precio_compra;
	}	//fin Lectura_precio_compra()
/*********************************************************************
METODO Mostrar(): Muestra el cambio expresado en funcion de las monedas de 1,5 y 25
********************************************************************/

	public static void Mostrar(String monedas)
	{		
		System.out.println(monedas);
	}///fin Mostrar()
/*******************************************************
METODO MAIN()
******************************************************/

	public static void main(String argv[]) throws IOException
	{	
		precio_compra = Lectura_precio_compra();
		cambio = 100-precio_compra; 				//calcula el cambio
		monedas = DevolvedorCambio.Calcular_monedas(cambio);
		Mostrar(monedas);
	}//fin de main()
}//fin de UsoDevolvedorCambio