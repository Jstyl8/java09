package com.mio.ip.clases.baraja;

import java.util.Random;

public class pruebaBaraja {

	private static Baraja baraja;

	public static void mostrarListado(String listado) {
		System.out.println(listado);
	}

	public static void main(String[] args) {

		// String[] palos = { "O", "C", "E", "B" };
		String[] palos = { "B", "C", "E", "O" };
		Carta carta;
		Carta[] cartas = new Carta[40];
		int j = 0;
		for (int k = 0; k < palos.length; k++) {
			for (int i = 1; i < 8; i++) {
				carta = new Carta(palos[k], i);
				cartas[j] = carta;
				j++;
			}
			for (int i = 10; i < 13; i++) {
				carta = new Carta(palos[k], i);
				cartas[j] = carta;
				j++;
			}
		}
		baraja = new Baraja(cartas);

		//prueba color
		Carta[] jugada1 = new Carta[5];
		for (int i = 0; i < jugada1.length; i++) {
			jugada1[i] = new Carta(palos[0], i + 1);
		}

		baraja.setJugada(jugada1);
		String listado = baraja.comprobarJugada();
		mostrarListado(listado);

		//prueba poker1
		Carta[] jugada2 = new Carta[5];
		for (int k = 0; k < palos.length; k++) {
			jugada2[k] = new Carta(palos[k], 10);
			jugada2[3] = new Carta(palos[3], 2);
		}
		jugada2[4] = new Carta(palos[2], 10);
		baraja.setJugada(jugada2);
		String listado2 = baraja.comprobarJugada();
		mostrarListado(listado2);
		
		//prueba poker2
		
		Carta[] jugada3 = new Carta[5];
		jugada3[0] = new Carta(palos[2], 10);
		for (int k = 1; k < palos.length; k++) {
			jugada3[k] = new Carta(palos[k], 2);
			jugada3[4] = new Carta(palos[3], 2);
		}
		
		baraja.setJugada(jugada3);
		String listado3 = baraja.comprobarJugada();
		mostrarListado(listado3);
		
		
		//prueba nada
		Carta[] jugada4 = new Carta[5];
		for (int i = 0; i < jugada4.length - 1; i++) {
			jugada4[i] = new Carta(palos[i], i);
		}
		jugada4[4] = new Carta(palos[2], 10);
		baraja.setJugada(jugada4);
		String listado4 = baraja.comprobarJugada();
		mostrarListado(listado4);

		for (int i = 0; i < 100; i++) {
			baraja.seleccionar5Cartas();
			String listado5 = baraja.comprobarJugada();
			mostrarListado(listado5);
			if (listado5.lastIndexOf("poker") != -1
					|| listado5.lastIndexOf("color") != -1) {
				System.out
						.println("AVISOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
			}
		}

		baraja.barajar();
		System.out.println(baraja);
		baraja.ordenar();
		System.out.println(baraja);
		for (int i = 0; i < cartas.length - 1; i++) {
			System.out.println(cartas[i] + " <-> " + cartas[i + 1]);

		}
	}
}
