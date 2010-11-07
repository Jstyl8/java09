package com.mp.practica8.ejercicio5.encuesta;

public class PreguntaContestacion {

	private String pregunta;
	private String contestacion;
	private String tipo;
	private int numero;

	public PreguntaContestacion(int numero, String tipo, String pregunta,
			String contestacion) {
		super();
		this.numero = numero;
		this.tipo = tipo;
		this.pregunta = pregunta;
		this.contestacion = contestacion;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getContestacion() {
		return contestacion;
	}

	public void setContestacion(String contestacion) {
		this.contestacion = contestacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
