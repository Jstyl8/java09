package com.ip.practica6.ejercicio9;
/**
*nombre: Factorizador
*autor: José Ángel García Fernández
*fecha: 13/12/08
*Descripcion: clase que contiene un metodo para calcular la descomposicion factorial de 
*un numero
*/

public class Factorizador
{
	static String descomposicion;
	
/*********************************************************************
METODO Calcular_descomposicion_factorial(): Calcula la descomposicion factorial
********************************************************************/

	public static String Calcular_descomposicion_factorial(int numero)
	{
		descomposicion=numero+" =";
		int factor_primo=2;
		while (numero>1)
		{
			int contador_de_factores=0;
			while((numero%factor_primo)==0)
			{
				contador_de_factores=contador_de_factores+1;
				numero=numero/factor_primo;
			}
			
			if (contador_de_factores > 0) 
			{
		       descomposicion=descomposicion+" "+ ( + factor_primo + "(" + (contador_de_factores) + ")*");
			}
		    factor_primo=factor_primo+1;
		}
	return descomposicion;
	}//fin Calcular_descomposicion_factorial()
}//fin de Factorizador