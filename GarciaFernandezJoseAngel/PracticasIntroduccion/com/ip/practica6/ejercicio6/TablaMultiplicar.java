package com.ip.practica6.ejercicio6;
/**
*nombre: TablaMultiplicar 
*autor: José Ángel García Fernández
*fecha: 09/12/08
*Descripcion: clase que contiene un metodo para comprobar si una respuesta es correcta
*/

public class TablaMultiplicar
{
	static int numero_repaso;
	static int respuesta;
	static boolean correcto;

/*********************************************************************
METODO Comprobar_respuesta(): Comprueba si la respuesta es correcta
********************************************************************/

	public static boolean Comprobar_respuesta(int numero_repaso, int i, int respuesta)
	{		
		if(respuesta==numero_repaso*i)
		{
			correcto=true;
		}
			else
			{
				correcto=false;
			}
	return correcto;
	}///fin Comprobar_respuesta()
	
}//fin de TablaMultiplicar