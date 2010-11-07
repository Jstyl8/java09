package com.mio.meto.TorresHanoi;

/**
 * @author Angel Nieto
 * @category Clase que define las Torres de Hanoi
 */
public class TorresHanoi {
	/**
	 * Variable privada global de tipo entero que almacena los movimientos
	 * hechos
	 */
	private int movimientos;
	/**
	 * Variable privada global de tipo entero que almacena el numero de torres
	 */
	private int n;
	/**
	 * Variable privada global de tipo entero tope de la torre primera
	 */
	private int a;
	/**
	 * Vector privado de valores de tipo String que almacena los discos de la
	 * primera torre
	 */
	private String[] posteA;
	/**
	 * Variable privada global de tipo entero tope de la torre segunda
	 */
	private int b;
	/**
	 * Vector privado de valores de tipo String que almacena los discos de la
	 * segunda torre
	 */
	private String[] posteB;
	/**
	 * Variable privada global de tipo entero tope de la torre tercera
	 */
	private int c;
	/**
	 * Vector privado de valores de tipo String que almacena los discos de la
	 * tercera torre
	 */
	private String[] posteC;

	/**
	 * Metodo constructor que crea un objeto de tipo Torres de Hanoi en funcion
	 * del numero de torres
	 * 
	 * @param n
	 *            Parametro de tipo entero que almacena el numero de torres a
	 *            crear
	 */
	public TorresHanoi(int n) {
		this.n = n;
		movimientos = 1;

		posteA = new String[n];
		a = 0;
		for (int i = 0; i < n; i++) {
			String disco = "";
			for (int j = i + 1; j > 0; j--)
				disco += '*';
			posteA[i] = disco;
		}

		posteB = new String[n];
		posteC = new String[n];
		b = n;
		c = n;
		for (int i = 0; i < n; i++) {
			posteB[i] = "";
			posteC[i] = "";
		}
	}

	/**
	 * Metodo inicial o puente de la torres hanoi
	 * 
	 * @param n
	 *            Parametro de tipo entero que almacena el numero de discos
	 * @param a
	 *            Parametro de tipo entero que almacena el valor de la torre
	 *            inicial
	 * @param c
	 *            Parametro de tipo entero que almacena el valor de la torre de
	 *            apoyo
	 * @param b
	 *            Parametro de tipo entero que almacena el valor de la torre
	 *            final
	 */
	public void solucionRec(int n, int a, int c, int b) {
		hanoi(n, a, c, b);
	}

	public void solucionRecSimple(int n, int a, int c, int b) {
		hanoiSimple(n, a, c, b);
	}

	/**
	 * Metodo privado recursivo de la torres de hanoi
	 * 
	 * @param n
	 *            Parametro de tipo entero que almacena el numero de discos
	 * @param a
	 *            Parametro de tipo entero que almacena el valor de la torre
	 *            inicial
	 * @param c
	 *            Parametro de tipo entero que almacena el valor de la torre de
	 *            apoyo
	 * @param b
	 *            Parametro de tipo entero que almacena el valor de la torre
	 *            final
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

	private void hanoiSimple(int n, int a, int c, int b) {
		if (n == 1) {
			System.out.println("Mover disco " + n + " desde " + a + " hasta "
					+ c);
		} else {
			hanoiSimple(n - 1, a, b, c);
			// hanoiSimple(1, a, c, b);
			System.out.println("Mover disco " + n + " desde " + a + " hasta "
					+ c);
			hanoiSimple(n - 1, b, c, a);
		}
	}

	/**
	 * Metodo que muestra el estado de las torres de hanoi en un momento
	 * determinado
	 */
	private void estado() {
		for (int i = 0; i < n; i++) {
			System.out.printf("%10s||%-10s %d %10s||%-10s %d %10s||%-10s %d",
					posteA[i], posteA[i], posteA[i].length(), posteB[i],
					posteB[i], posteB[i].length(), posteC[i], posteC[i],
					posteC[i].length());
			System.out.println();
		}
	}

	/**
	 * Metodo que se encarga de mover un disco de una torre a otra
	 * 
	 * @param desde
	 *            Parametro de tipo entero que almacena el valor de la torre
	 *            inicial
	 * @param hasta
	 *            Parametro de tipo entero que almacena el valor de la torre
	 *            final
	 */
	private void moverDisco(int desde, int hasta) {

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
