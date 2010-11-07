package com.ip.practica5.ejercicio6;
/**
*nombre: NumeroMayor
*autor: José Ángel García Fernández
*fecha: 04/12/08
*Descripcion: clase que contiene un metodo para calcular el mayor de 3 numeros.
*/

public class NumeroMayor
{
	static int numero1, numero2, numero3, numero_mayor;
		
/*********************************************************************
METODO Calcular_numero_mayor(): Calcula el mayor numero
********************************************************************/

	public static int Calcular_numero_mayor(int numero1, int numero2, int numero3)
	{	
		if(numero1>=numero2)
		{
			if(numero1>=numero3)
			{
				numero_mayor = numero1;
			}	
				else
				{
					numero_mayor = numero3;
				}	
		}
			else if(numero2>=numero3)
			{
				numero_mayor = numero2;
			}	
				else
				{
					numero_mayor = numero3;
				}	
		
	return numero_mayor;
	}//fin Calcular_numero_mayor()
}//fin de NumeroMayor