package com.mp.practica5.ejercicio5;

public class Carta implements Comparable {

	private String palo;
	private int numero;
	private int valor;

	public Carta(String palo, int numero, int valor) {
		super();
		this.palo = palo;
		this.numero = numero;
		this.valor = valor;
	}

	public Carta(String palo, int numero) {
		super();
		this.palo = palo;
		this.numero = numero;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public boolean equals(Object obj) {
		
		//TODO
		
	}

	public int compareTo(Object o) {

		//TODO	}
	
	public String toString() {
		//TODO
	}

}
