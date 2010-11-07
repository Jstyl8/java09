package com.ip.practica6.ejercicio7;
/**
*nombre: Uso Operaciones con Pares e Impares
*autor: José Ángel García Fernández
*fecha: 13/12/08
*Descripcion: programa que dados 10 números positivos obtiene la suma de los impares y 
*la media de los pares, indicando el número de valores pares e impares leídos usando
*metodos de la clase OperacionesPares
*/
import java.io.*;			//Importamos la clase E/S de java
							// es imprescindible para leer de teclado
public class UsoOperacionesPares
{
	static int numero;
	static int suma_impares, numero_impares, suma_pares, numero_pares;
	static float media_pares;

/********************************************************************* 
METODO Lectura_numero_positivo(): Lee un valor positivo y los transforma en un dato entero
********************************************************************/

	public static int Lectura_numero_positivo() throws IOException
	{		
		System.out.println("Introduzca un numero positivo");	
		BufferedReader entrada = new BufferedReader
			(new InputStreamReader(System.in));
		String cadenaleida = entrada.readLine();
		numero = Integer.parseInt(cadenaleida);
		
		while(numero<0)
		{
			System.out.println("ERROR: Introduzca un numero positivo");	
			String cadenaleida2 = entrada.readLine();
			numero = Integer.parseInt(cadenaleida2);
		}
	return numero;
	}	//fin Lectura_numero_positivo()
/*********************************************************************
METODO Mostrar(): Muestra los datos pedidos
********************************************************************/

	public static void Mostrar(int suma_impares, float media_pares, int numero_impares, int numero_pares)
	{		
		System.out.println("La suma de los impares es "+suma_impares);
		System.out.println("El numero de impares es "+numero_impares);
		System.out.println("La media de los pares es "+media_pares);
		System.out.println("El numero de pares es "+numero_pares);
	}//fin Mostrar()
/*******************************************************
METODO MAIN()
******************************************************/

	public static void main(String argv[]) throws IOException
	{	
		suma_impares=0;
		numero_impares=0;
		suma_pares=0;
		numero_pares=0;		
		for(int i=1;i<=10;i=i+1)
		{
			numero = Lectura_numero_positivo();	
			suma_impares = OperacionesPares.Calcular_suma_impares(numero);
			suma_pares = OperacionesPares.Calcular_suma_pares(numero);
			numero_impares = OperacionesPares.Calcular_numero_impares(numero, numero_impares);
			numero_pares = OperacionesPares.Calcular_numero_pares(numero, numero_pares);		
		}
		media_pares= OperacionesPares.Calcular_media_pares(suma_pares, numero_pares);
		Mostrar(suma_impares, media_pares, numero_impares, numero_pares);
	}//fin de main()
}//fin de UsoOperacionesPares