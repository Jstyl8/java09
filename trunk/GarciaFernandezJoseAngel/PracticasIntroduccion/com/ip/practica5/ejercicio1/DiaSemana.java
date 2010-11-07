package com.ip.practica5.ejercicio1;

/**
*nombre: DiaSemana
*autor: José Ángel García Fernández
*fecha: 04/12/08
*Descripcion: clase que calcula el dia de la semana.
*/		

public class DiaSemana
{

	static byte dia;
	static String dia_literal;

/*********************************************************************
METODO calcular_dia(): Asigna un dia al numero introducido.
********************************************************************/

	public static String Calcular_dia(byte dia)
	{
		switch(dia)
		{
			case 1:	dia_literal="LUNES";
       		break;
       			
   			case 2:	dia_literal="MARTES";
       		break;
       			
    		case 3:	dia_literal="MIERCOLES";
       		break;
       			
    		case 4: dia_literal="JUEVES";
       		break;
       			
    		case 5: dia_literal="VIERNES";
       		break;
       			
   			case 6: dia_literal="SABADO";
   			break;
   			
    		case 7: dia_literal="DOMINGO";
		}
	return dia_literal;
	}//fin calcular_dia()
	
}//fin de DiaSemana