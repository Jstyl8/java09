package com.ip.practica5.ejercicio4;
/**
*nombre: Adivinador
*autor: José Ángel García Fernández
*fecha: 04/12/08
*Descripcion: clase que adivina el numero en funcion del resto y la paridad
*/

public class Adivinador
{
	static int resto, numero, paridad;
	
/*********************************************************************
METODO Calcular_numero(): Calcula el numero pensado por el usuario
********************************************************************/

	public static int Calcular_numero(int resto, int paridad)
	{	
		if((resto%2)==paridad)
		{
			numero=resto;
		}	
			else
			{
				numero=resto+5;
			}	
		return numero;
	}//fin Calcular_numero()
}//fin de Adivinador