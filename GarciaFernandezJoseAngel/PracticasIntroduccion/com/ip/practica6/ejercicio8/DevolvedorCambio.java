package com.ip.practica6.ejercicio8;
/**
*nombre: Devolvedor de cambio
*autor: José Ángel García Fernández
*fecha: 09/12/08
*Descripcion: clase que contiene un metodo para calcular el cambio en
*pesetas (monedas 1 5 y 25) de una compra inferior a 100 ptas. 
*/

public class DevolvedorCambio
{
	static int cambio;
	static int mon_25, mon_5, mon_1;
	static String monedas;

/*********************************************************************
METODO Calcular_monedas(): Calcula las monedas a entregar
********************************************************************/

	public static String Calcular_monedas(int cambio)
	{
		while(cambio>=25)
		{	
			cambio=cambio-25;
			mon_25 = mon_25+1;
		}
		while(cambio>=5)
		{	
			cambio=cambio-5;
			mon_5 = mon_5+1;
		}
		while(cambio>=1)
		{
			cambio=cambio-1;
			mon_1 = mon_1+1;
		}
		
		monedas="El cambio es "+mon_25+" moneda(s) de 25, "+mon_5+" moneda(s) de 5 y "
															+mon_1+" moneda(s) de 1 peseta(s)";
	return monedas;
	}///fin Calcular_monedas()
}//fin de DevolvedorCambio