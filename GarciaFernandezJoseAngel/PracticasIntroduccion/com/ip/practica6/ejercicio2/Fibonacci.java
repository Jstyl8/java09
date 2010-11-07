package com.ip.practica6.ejercicio2;
/**
*nombre: Fibonacci
*autor: José Ángel García Fernández
*fecha: 04/12/08
*Descripcion:clase que contiene un metodo para calcula los k
*primeros terminos de la serie Fibonacci
*/

public class Fibonacci
{
	static int K;
	static String serie;

/*********************************************************************
METODO Calcular_serie(): Calcula la serie de Fibonacci hasta K
********************************************************************/

	public static String Calcular_serie(int K)
	{
		int ultimo, penultimo, actual;
		if(K==1)
		{
			serie="0";
		}
			else if(K==2)
			{
				serie="0 1";
			}
				else
				{
					serie="0 1";
					ultimo=1;
					penultimo=0;
					for(int i=1;i<=K-2;i=i+1)
					{
						actual=ultimo+penultimo;
						penultimo=ultimo;
						ultimo=actual;

						serie=serie+" "+actual;
					}
				}
	return serie;		
	}//fin Calcular_serie
}//fin de Fibonacci