package com.mio.icaro;

import com.mio.excepciones.DesbordamientoInferiorException;

public class MainColaPri {

	public static void main(String argv[]) throws DesbordamientoInferiorException{
		Alumno a1 = new Alumno(13,"Pepito",5);
		Alumno a2 = new Alumno(13,"Juanito",6);
		Alumno a3 = new Alumno(13,"Antonio",7);
		Alumno a4 = new Alumno(13,"David",8);
		Alumno a5 = new Alumno(13,"Lucre",9);
		Alumno a6 = new Alumno(13,"Fran",10);
		Alumno a7 = new Alumno(13,"Cosco",3);
		Alumno a8 = new Alumno(13,"Andrés",7);
		
		ColaVecPri cola = new ColaVecPri();
		
		cola.insertarPrioridad(a1);
		cola.insertarPrioridad(a2);
		cola.insertarPrioridad(a3);
		cola.insertarPrioridad(a4);
		cola.insertarPrioridad(a5);
		cola.insertarPrioridad(a6);
		cola.insertarPrioridad(a7);
		cola.insertarPrioridad(a8);
		
		Alumno fuera = (Alumno)cola.salirPrioridad();
		System.out.println(fuera.getNombre());
	}
}
