package com.ip.practica8.ejercicio4;
/**
*nombre: Primo
*autor: José Ángel García Fernández
*fecha: 05/12/08
*Descripcion: Clase que contiene 2 metodos relacionados con el calculo de primos
*/

public class Primo
{
	static float numero;
	static String mensaje;
	static boolean primo;

/*********************************************************************
METODO Esprimo(): Calcula si un numero es primo o no
********************************************************************/

	public boolean EsPrimo(float numero)
	{	
		primo=true;
		for(int i=2;i<=Math.sqrt(numero)&&primo==true;) //inicializacion; condicion
		{
			if(numero%i==0)
			{
				primo=false;
			}
				else
				{
					i=i+1;
				}
       		}		
	return primo;
	}//fin Esprimo()
/*********************************************************************
METODO Asignar_Primo(): Asigna a mensaje la cadena de caracteres a mostrar en funcion de primo
********************************************************************/

	public String Asignar_Primo(boolean primo)
	{	
		if(primo==true)
		{
			mensaje="El numero es PRIMO";
		}
			else
			{
				mensaje="El numero no es PRIMO";
			}
	return mensaje;
	}//fin Asignar_Primo()
}//fin de Primo