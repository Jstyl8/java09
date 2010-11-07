//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 6, Ejercicio 3
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica6.ejercicio3;

/**
 * Clase que representa un laberinto
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 02.05.2009
 */
public class Laberinto {

	/**
	 * Array privado bidimensional que representa el laberinto
	 */
	private char[][] laberinto;

	/**
	 * Variable privada que representa la entrada x del laberinto
	 */
	private int entradaX;

	/**
	 * Variable privada que representa la entrada y del laberinto
	 */
	private int entradaY;

	/**
	 * Genera un objeto de tipo Laberinto
	 * 
	 * @param laberinto
	 *            el laberinto a usar
	 * @param entradaX
	 *            posicion de entrada x
	 * @param entradaY
	 *            posicion de entrada y
	 */
	public Laberinto(char[][] laberinto, int entradaX, int entradaY) {
		super();
		// TODO Auto-generated constructor stub
		this.laberinto = (char[][]) laberinto.clone();
		this.entradaX = entradaX;
		this.entradaY = entradaY;
	}

	/**
	 * Sobreescribe el metodo toString, usado para comprobar la evolucion del
	 * laberinto en las pruebas de unidad
	 * 
	 * @return el laberinto en un String
	 */
	public String toString() {
		String labe = "";
		for (int i = 0; i < laberinto.length; i++) {
			for (int j = 0; j < laberinto[i].length; j++) {
				labe += (laberinto[i][j]);
			}
			labe += "\n";
		}
		return labe;
	}

	/**
	 * Muestra por pantalla el laberinto
	 */
	public void imprimir() {

		for (int i = 0; i < laberinto.length; i++) {
			for (int j = 0; j < laberinto[i].length; j++) {
				System.out.print(laberinto[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Comprueba si una posicion del laberinto es valida
	 * 
	 * @param x
	 *            fila x
	 * @param y
	 *            columna y
	 * @return devuelve false si no es una posicion valida y true si si la es
	 */
	public boolean valido(int x, int y) {

		int N = laberinto.length;
		int M = laberinto[0].length;
		boolean ok = false;
		if (x < N && x >= 0 && y < M && y >= 0
				&& (laberinto[x][y] == ' ' || laberinto[x][y] == 's')) {
			ok = true;
		}
		return ok;
	}

	/**
	 * Metodo que llama al metodo de resolucion del laberinto
	 * 
	 * @return la solucion del laberinto
	 */
	public boolean resolver() {
		boolean solucion = resolver(entradaX, entradaY);
		imprimir();
		return solucion;
	}

	/**
	 * Metodo recursivo que resuelve el laberinto
	 * 
	 * @param x
	 *            fila x
	 * @param y
	 *            columna y
	 * @return devuelve true si existe solucion y false si no
	 */
	public boolean resolver(int x, int y) {

		boolean fin = false;
		if (valido(x, y) == true) {
			if (laberinto[x][y] == 's') {
				fin = true;
			} else {
				laberinto[x][y] = 'x';
				fin = true;
				// anidando las condiciones se consigue el mejor camino
				if (!resolver(x + 1, y))
					if (!resolver(x, y + 1))
						if (!resolver(x - 1, y))
							if (!resolver(x, y - 1)) {
								laberinto[x][y] = ' ';
								fin = false;
							}
			}
		}
		return fin;
	}
}
