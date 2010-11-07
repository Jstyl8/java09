package com.ip.practica5.ejercicio2;
/**
*nombre: Contratacion
*autor: José Ángel García Fernández
*fecha: 04/12/08
*Descripcion: clase que calcula si se esta contratado.
*/

public class Contratacion
{
	static byte edad;
	static byte calificacion1, calificacion2;
	static String mensaje;

/*********************************************************************
METODO Calcular_contratado(): calcula si el usuario esta contratado en funcion de los requisitos establecidos
********************************************************************/

	public static String Calcular_contratado(byte edad, byte calificacion1, byte calificacion2)
	{
		if(calificacion1>85||calificacion2>85)
		{
			if(edad>=18)
			{
				mensaje="Contratado";
			}
				else
				{
					mensaje="No contratado";
				}
		}
			else
			{
				mensaje="No contratado";
			}
	return mensaje;
	}//fin Calcular_contratado()
}//fin de Contratacion