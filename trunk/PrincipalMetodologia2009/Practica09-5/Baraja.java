package com.mp.practica5.ejercicio5;

public class Baraja {

	private String nombreBaraja;
	private Carta[] cartas;

	public Baraja(String nombreBaraja, Carta[] cartas) {
		super();
		this.nombreBaraja = nombreBaraja;
		this.cartas = cartas;
	}

	public String getNombreBaraja() {
		return nombreBaraja;
	}

	public void setNombreBaraja(String nombreBaraja) {
		this.nombreBaraja = nombreBaraja;
	}

	public Carta[] getCartas() {
		return cartas;
	}

	public void setCartas(Carta[] cartas) {
		this.cartas = cartas;
	}


	public String toString() {
		///TODO
	}

	
}
