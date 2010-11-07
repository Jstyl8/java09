package com.ip.practica5.ejercicio5;
/**
*nombre: Intercambiador
*autor: José Ángel García Fernández
*fecha: 04/12/08
*Descripcion: clase que intecambia los valores de 2 variables.
*/

public class Intercambiador
{
	static int variable1, variable2;
	static String intercambio;
/*********************************************************************
METODO Intercambiar valores: Calcula el numero pensado por el usuario
********************************************************************/

	public static  String Intercambiar_valores(int variable1, int variable2)
	{	
		int auxiliar = variable1;
		variable1 = variable2;
		variable2 = auxiliar;
		String intercambio = "La primera variable es ahora "+variable1+" y la segunda "+variable2;
		return intercambio;
	}//fin Intercambiar_valores()
}//fin de Intercambiador