package com.ip.practica8.ejercicio2;
/**
*nombre: Temperatura
*autor: José Ángel García Fernández
*fecha: 23/12/08
*Descripcion: clase para la conversion de Celsius a Fahrenheit y viceversa
*/

public class Temperatura
{
	float GradosF;
	float GradosC;
/*********************************************************************
METODO ConvertirCF: calcula la conversion de Celsius a Fahrenheit
********************************************************************/
	public float ConvertirCF(float valor)
	{
		return(9*valor/5)+32;
	}//fin ConvertirCF
/*********************************************************************
METODO ConvertirFC: calcula la conversion de Fahrenheit a Celsius 
********************************************************************/
	public float ConvertirFC(float valor)
	{
		return 5*(valor-32)/9;
	}//fin ConvertirFC
}//fin de Temperatura