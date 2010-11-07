package com.mio.ip.clases.baraja;

import java.util.Random;

public class Baraja {

	private Carta[] cartas;

	private int numCartas;

	private Carta[] jugada;

	/**
	 * @return the jugada
	 */
	public Carta[] getJugada() {
		return jugada;
	}

	/**
	 * @param jugada
	 *            the jugada to set
	 */
	public void setJugada(Carta[] jugada) {
		this.jugada = jugada;
	}

	public Baraja(Carta[] cartas) {
		this.cartas = cartas;
		numCartas = cartas.length;
		jugada = new Carta[5];
	}

	public String comprobarJugada() {
		String listado = "";
		listado += comprobarColor();
		listado += comprobarPoker();
		if (listado.equals("")) {
			listado = "Ninguna jugada valida\n";
		}
		for (Carta a : jugada) {
			listado += a + " ";
		}
		return listado;
	}

	private String comprobarColor() {
		String color = "";
		int cont = 0;
		boolean salir = false;
		for (int i = 0; i < jugada.length && salir == false; i++) {
			if (jugada[1].getPalo().equals(jugada[i].getPalo())) {
				cont++;
			} else {
				salir = true;
			}
		}
		if (cont == 5) {
			color = "Es color\n";
		}
		return color;
	}

	private String comprobarPoker() {
		String poker = "";
		int cont = 0;
		for (int i = 0; i < 2 && cont != 4; i++) {
			cont = 0;
			for (int j = 0; j < jugada.length; j++) {
				if (jugada[i].getNumero() == jugada[j].getNumero()) {
					cont++;
				}
			}
		}
		if (cont == 4) {
			poker = "Es poker\n";
		}
		return poker;
	}

	public void seleccionar5Cartas() {
		int[] aux = new int[5];
		int numAux = 0;
		Random r = new Random();
		for (int i = 0; i < jugada.length;) {
			int n = r.nextInt(40);
			boolean yaUsado = false;
			for (int j = 0; j < numAux && yaUsado == false; j++) {
				if (aux[j] == n) {
					yaUsado = true;
				}
			}
			if (!yaUsado) {
				jugada[i] = cartas[n];
				aux[i] = n;
				i++;
				numAux++;
			}
		}
	}

	/*
	 * Ordenar k no ordena public void ordenar() { boolean salir = false; if
	 * (!salir) { salir = true; for (int i = 0; i < cartas.length-1;i++) { if
	 * (cartas[i].compareTo(cartas[i + 1]) > 0) { Carta x = cartas[i]; cartas[i]
	 * = cartas[i + 1]; cartas[i + 1] = x; salir = false; } } } // }
	 */
	public void ordenar() {
		boolean intercambio = true;
		for (int i = 0; i < numCartas - 1 && intercambio == true; i++) {
			intercambio = false;
			for (int j = 0; j < numCartas - 1 - i; j++) {
				if (cartas[j].getPalo().compareTo(cartas[j + 1].getPalo()) > 0) {
					swap(cartas, j, j + 1);
					intercambio = true;
				} else if (cartas[j].getPalo().compareTo(
						cartas[j + 1].getPalo()) == 0
						&& cartas[j].getNumero() > cartas[j + 1].getNumero()) {
					swap(cartas, j, j + 1);
					intercambio = true;
				}
			}
		}
	}

	private void swap(Carta[] cartas, int a, int b) {
		Carta aux = cartas[a];
		cartas[a] = cartas[b];
		cartas[b] = aux;
	}

	public void barajar() {

		Random rand = new Random();
		for (int i = 0; i < 160; i++) {
			int x = rand.nextInt(40);
			int y = rand.nextInt(40);

			Carta swap = cartas[x];
			cartas[x] = cartas[y];
			cartas[y] = swap;
		}
	}

	/**
	 * Metodo toString para mostrar por pantalla
	 * 
	 * @return devuelve la baraja por pantalla
	 */
	public String toString() {
		String baraja = "";
		for (int i = 0; i < cartas.length; i++) {
			baraja += cartas[i] + " ";
		}
		return baraja;
	}
}
