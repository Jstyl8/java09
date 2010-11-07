package com.ip.practica5.ejercicio3;
/**
*nombre: UsoMiniCalculadora
*autor: José Ángel García Fernández
*fecha: 04/12/08
*Descripcion: clase para realizar operaciones entre 2 numeros
*/

public class MiniCalculadora
{
	static float operando1, operando2;
	static char operador;
	static float resultado;
	

/*********************************************************************
METODO RealizarOperacion(): Calcula el resultado de operar el primer operando con el segundo.
********************************************************************/

	public static float RealizarOperacion(float operando1, float operando2, char operador)
	{
		switch(operador)
		{
			case '+':	resultado=operando1+operando2;
       		break;
       			
   			case '-':	resultado=operando1-operando2;
       		break;
       			
    		case '*':	resultado=operando1*operando2;
       		break;
       			
    		case '/': if(operando2==0)
    					{
    						 resultado = 0;
    					}	
    						else
    						{
    							resultado=operando1/operando2;
    						}
       		break;
   	
    		case '%': if(operando2==0)
    					{
    						resultado = 0;
    					}	
    						else
    						{
    							resultado=operando1%operando2;
    						}
       		break;
       			
		}
	return resultado;
	}//fin RealizarOperacion()
}//fin de MiniCalculadora