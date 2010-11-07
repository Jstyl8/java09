package com.mp.practica8.ejercicio5.encuesta;

import java.util.ArrayList;

public class Encuesta {

	ArrayList encuesta;

	public Encuesta() {
		super();
		encuesta = new ArrayList();
	}

	public void addPregunta(PreguntaContestacion preguntaContestacion) {
		// TODO Auto-generated method stub
		encuesta.add(preguntaContestacion);
	}

	public ArrayList getEncuesta() {
		return encuesta;
	}

}
