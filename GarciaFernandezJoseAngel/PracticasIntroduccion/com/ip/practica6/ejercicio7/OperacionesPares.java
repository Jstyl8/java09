package com.ip.practica6.ejercicio7;
/**
*nombre: Operaciones con Pares e Impares
*autor: José Ángel García Fernández
*fecha: 13/12/08
*Descripcion: clase que contiene una serie de metodos para hacer operaciones
*/
public class OperacionesPares
{
	static int suma_impares, numero_impares, suma_pares, numero_pares;
	static float media_pares;

/*********************************************************************
METODO Calcular_suma_impares(): Calcula la suma de los numeros impares
********************************************************************/

	public static int Calcular_suma_impares(int numero)
	{		
		if(numero%2!=0)
		{
			suma_impares=suma_impares+numero;
		}
	return suma_impares;
	}///fin Calcular_suma_impares()
/*********************************************************************
METODO Calcular_suma_pares(): Calcula la suma de los numeros pares
********************************************************************/

	public static int Calcular_suma_pares(int numero)
	{		
		if(numero%2==0)
		{
			suma_pares=suma_pares+numero;
		}
	return suma_pares;
	}///fin Calcular_suma_pares()	
/*********************************************************************
METODO Calcular_numero_impares(): Calcula el numero de impares
********************************************************************/

	public static int Calcular_numero_impares(int numero, int numero_impares)
	{		
		if(numero%2!=0)
		{
			numero_impares=numero_impares+1;
		}
	return numero_impares;
	}///fin Calcular_numero_impares()
/*********************************************************************
METODO Calcular_numero_pares(): Calcula el numero de pares
********************************************************************/

	public static int Calcular_numero_pares(int numero, int numero_pares)
	{		
		if(numero%2==0)
		{
			numero_pares=numero_pares+1;
		}
	return numero_pares;
	}///fin Calcular_numero_pares()
/*********************************************************************
METODO Calcular_media_pares(): Calcula la media de los numeros pares
********************************************************************/

	public static float Calcular_media_pares(int suma_pares, int numero_pares)
	{		
		media_pares=suma_pares/numero_pares;
	return media_pares;
	}///fin Calcular_media_pares()
}//fin de OperacionesPares