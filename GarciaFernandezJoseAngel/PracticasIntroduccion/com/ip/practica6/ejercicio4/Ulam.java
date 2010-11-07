package com.ip.practica6.ejercicio4;
/**
*nombre: Ulam
*autor: José Ángel García Fernández
*fecha: 04/12/08
*Descripcion: clase que contiene un metodo para calcular la sucesion de Ulam hasta
* un numero k.
*/
public class Ulam
{
	static int numero;
	static String serie;

/*********************************************************************
METODO Calcular_serie(): Calcula la serie de Ulam
********************************************************************/

	public static String Calcular_serie(int numero)
	{	
				if(numero==1)
				{
					serie="1";	
				}
					else
					{
						serie=""+numero;
						do
						{
							if((numero%2)==0)
							{
								numero=numero/2;
							}
								else
								{
									numero=numero*3+1;
								}
							serie=serie+" "+numero;	
						}while(numero!=1);
					}
	return serie;
	}///fin Calcular_serie()
}//fin de Ulam