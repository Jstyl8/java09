package com.ip.practica6.ejercicio5;
/**
*nombre: NotaMedia
*autor: José Ángel García Fernández
*fecha: 09/12/08
*Descripcion: clase que contiene un metodo para calcular la nota media.
*/

public class NotaMedia
{
	static float media, suma;
	static int total_notas;
	
/*********************************************************************
METODO Calcular_media(): Calcula la media de notas
********************************************************************/

	public static float Calcular_media(float suma, int total_notas)
	{		
		media = suma/total_notas;	
	return media;
	}///fin Calcular_media
}//fin de NotaMedia