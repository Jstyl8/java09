//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 4, Ejercicio 2
// ASIGNATURA : Metodologia de la Programación
//

package com.mp.practica4.ejercicio2;

/**
 * Clase que representa el juego de las Torres de Hanoi
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 01.04.2009
 */
public class TorresHanoi {

	/**
	 * Variable privada que representa el numero de movimientos realizados
	 */
	private int movimientos;

	/**
	 * Variable privada que representa el numero de discos
	 */
	private int n;

	/**
	 * Variable privada que indica el espacio libre de la torre origen
	 */
	private int a;

	/**
	 * Array de string que almacena los discos de la varilla origen
	 */
	private String[] posteA;

	/**
	 * Variable privada que indica el espacio libre de la torre auxiliar
	 */
	private int b;

	/**
	 * Array de string que almacena los discos de la varilla auxiliar
	 */
	private String[] posteB;

	/**
	 * Variable privada que indica el espacio libre de la torre destino
	 */
	private int c;

	/**
	 * Array de string que almacena los discos de la varilla destino
	 */
	private String[] posteC;

	/**
	 * Constructor de la clase TorresHanoi
	 * 
	 * @param n
	 *            el numero de discos
	 */
	public TorresHanoi(int n) {

		this.n = n;
		movimientos = 1;
		posteA = new String[n];
		posteB = new String[n];
		posteC = new String[n];
		// inicializo los topes de cada torre, a estara lleno, b y c vacios
		a = 0;
		b = n;
		c = n;
		// Inicializo los postes con los discos correspondientes
		for (int i = 0; i < n; i++) {
			String disco = "*";
			for (int j = i + 1; j > 1; j--) {
				disco += '*';
			}
			posteA[i] = disco;
			posteB[i] = "";
			posteC[i] = "";
		}

	}

	/**
	 * Metodo publico para realizar el juego
	 * 
	 * @param n
	 *            el numero de discos
	 * @param a
	 *            valor de la torre origen
	 * @param c
	 *            valor de la torre auxiliar
	 * @param b
	 *            valor de la torre destino
	 */
	public void solucionRec(int n, int a, int c, int b) {
		hanoi(n, a, c, b);
	}

	/**
	 * Metodo privado de resolucion del juego
	 * 
	 * @param n
	 *            el numero de discos
	 * @param a
	 *            valor de la torre origen
	 * @param c
	 *            valor de la torre auxiliar
	 * @param b
	 *            valor de la torre destino
	 */
	private void hanoi(int n, int a, int c, int b) {

		if (n == 1) {
			System.out.println("Movimiento: " + movimientos + " Mover disco "
					+ n + " desde " + a + " hasta " + c);
			moverDisco(a, c);
			estado();

		} else {
			hanoi(n - 1, a, b, c);
			System.out.println("Movimiento: " + movimientos + " Mover disco "
					+ n + " desde " + a + " hasta " + c);
			moverDisco(a, c);
			estado();

			hanoi(n - 1, b, c, a);
		}

	}

	/**
	 * Metodo que actualiza el estado de las torres
	 * 
	 */
	public void estado() {

		for (int i = 0; i < n; i++) {
			System.out.printf("%9s||%-9s %d %9s||%-9s %d %9s||%-9s %d",
					posteA[i], posteA[i], posteA[i].length(), posteB[i],
					posteB[i], posteB[i].length(), posteC[i], posteC[i],
					posteC[i].length());
			System.out.println();
		}
	}

	/**
	 * Metodo para mover un disco de un poste a otro
	 * 
	 * @param desde
	 *            torre de origen del disco
	 * @param hasta
	 *            torre de destino del disco
	 */
	public void moverDisco(int desde, int hasta) {

		movimientos++;

		if (desde == 1) {
			if (hasta == 2) {
				posteB[b - 1] = posteA[a];
				posteA[a] = "";
				a++;
				b--;
			}
			if (hasta == 3) {
				posteC[c - 1] = posteA[a];
				posteA[a] = "";
				a++;
				c--;
			}
		} else if (desde == 2) {
			if (hasta == 1) {
				posteA[a - 1] = posteB[b];
				posteB[b] = "";
				b++;
				a--;
			}
			if (hasta == 3) {
				posteC[c - 1] = posteB[b];
				posteB[b] = "";
				b++;
				c--;
			}
		} else if (desde == 3) {
			if (hasta == 1) {
				posteA[a - 1] = posteC[c];
				posteC[c] = "";
				c++;
				a--;
			}
			if (hasta == 2) {
				posteB[b - 1] = posteC[c];
				posteC[c] = "";
				c++;
				b--;
			}
		}
	}
}
