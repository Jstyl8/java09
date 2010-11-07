package com.ip.practica9.ejercicio1;
/**
*nombre: OperacionesCadenas
*autor: José Ángel García Fernández
*fecha: 13/12/08
*Descripcion: calse que contendra operaciones con cadenas
*/

public class OperacionesCadenas
{ 
	
/*********************************************************************
METODO Comparar: comparar 2 cadenas de caracteres
********************************************************************/

	public String Comparar(String a, String b)
	{
		String resultado;
		if((a.length()==b.length())&&(a.equals(b)==true))
		{
			resultado="Son iguales";
		}else
			{
				resultado="Son diferentes";
			}
		return resultado;
	}//fin Comparar()
/*********************************************************************
METODO Comprobar_contenido: comprueba si un caracter esta en una cadena
********************************************************************/

	public String Comprobar_contenido(String cadena, char caracter)
	{
		String contenido = null;
		boolean bandera=false;
		char[] letras = cadena.toCharArray();
		for (int i = 0; i < letras.length&&bandera==false; i=i+1)
		{
			if(caracter == letras[i])
			{
				contenido="Esta contenido";
				bandera=true;
			}else
				{
					contenido="NO Esta contenido";
				}
		}
	return contenido;
	}//fin Comprobar_contenido()
/*********************************************************************
METODO Contar_caracter: contea el numero de veces que un caracter aparece en una cadena
********************************************************************/
	public int Contar_caracter(String cadena, char caracter)
	{
		int cuenta=0;
		char[] letras = cadena.toCharArray();
		for (int i = 0; i < letras.length; i=i+1)
		{
			if (caracter == letras[i])
			{
				cuenta = cuenta+1;
			}
		}
	return cuenta;
	}//fin Contar_caracter()
}//fin de OperacionesCadenas