package com.mio.ip.clases.baraja;



public class Carta implements Comparable{

	private int numero;

	private String palo;

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param palo
	 * @param numero
	 */
	public Carta(String palo, int numero) {
		this.numero = numero;
		this.palo = palo;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the palo
	 */
	public String getPalo() {
		return palo;
	}

	/**
	 * @param palo
	 *            the palo to set
	 */
	public void setPalo(String palo) {
		this.palo = palo;
	}

	/**
	 * Metodo que comprueba si 2 cartas son iguales
	 * 
	 * @param o
	 *            a comparar
	 * @return devuelve false si no son iguales y true si son iguales
	 */
	public boolean equals(Object o) {

		if (!(o instanceof Carta)) {
			return false;
		}

		Carta carta = (Carta) o;
		if ((this.numero == carta.numero) && (this.palo == carta.palo)) {
			return true;
		}
		return false;
	}

	/**
	 * Metodo que comprueba el orden de 2 cartas
	 * 
	 * @param o
	 *            a comparar
	 * @return devuelve -1 si this es mayor, 0 si son iguales y 1 si o es mayor
	 */
	public int compareTo(Object o) {

		Carta carta = (Carta) o;
		//String[] palos = { "O", "C", "E", "B" };
		String[] palos = { "B", "C", "E", "O" };
		if (this.equals(carta)) {
			return 0;
		}
		int posThis = 0;
		for (int i = 0; i < palos.length; i++) {
			if (this.palo.equals(palos[i]))
				posThis = i;
		}
		int posCarta = 0;
		for (int i = 0; i < palos.length; i++) {
			if (carta.palo.equals(palos[i]))
				posCarta = i;
		}
		if (posThis < posCarta) {
			return -1;
		} else if (posThis > posCarta) {
			return 1;
		} else {
			if (this.numero < carta.numero) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	/**
	 * Metodo toString para mostrar por pantalla
	 * 
	 * @return devuelve la carta por pantalla mostrando el palo y el numero
	 */
	public String toString() {
		return palo + numero;
	}

}
