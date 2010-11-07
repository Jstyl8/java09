//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 6, Ejercicio 2
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica6.ejercicio2;

/**
 * Clase que representa un cambioVoraz
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 02.05.2009
 */
public class CambioVoraz extends EsquemaVZ {

	/**
	 * Variable privada de tipo Cambio que representa el cambio voraz
	 */
	private Cambio cambio;

	/**
	 * Variable privada que funcionara como indice del array de monedas y
	 * contador
	 */
	private int k;

	/**
	 * Variable privada que almacena el numero de monedas minimo
	 */
	private int NumMinimoMonedas;

	/**
	 * Genera un objeto CambioVoraz a partir de un objeto cambio
	 * 
	 * @param cambio
	 *            el cambio a usar en cambioVoraz
	 */
	public CambioVoraz(Cambio cambio) {
		this.setCambio(cambio);

	}

	/**
	 * Metodo modificador para la propiedad cambio
	 * 
	 * @param cambio
	 *            el cambio a poner
	 */
	public void setCambio(Cambio cambio) {
		this.cambio = cambio;
	}

	/**
	 * Metodo de acceso para la propiedad cambio
	 * 
	 * @return el cambio
	 */
	public Cambio getCambio() {
		return cambio;
	}

	/**
	 * Metodo modificador para la propiedad numMinimoMonedas
	 * 
	 * @param numMinimoMonedas
	 *            el numero minimo de monedas a poner
	 */
	public void setNumMinimoMonedas(int numMinimoMonedas) {
		NumMinimoMonedas = numMinimoMonedas;
	}

	/**
	 * Metodo de acceso para la propiedad numMinimoMonedas
	 * 
	 * @return el numMinimoMonedas
	 */
	public int getNumMinimoMonedas() {
		return NumMinimoMonedas;
	}

	/**
	 * Metodo de inicializacion
	 */
	protected void inicializa() {
		NumMinimoMonedas = 0;
		k = 0;
	}

	/**
	 * Metodo que comprueba si se debe terminar o no
	 * 
	 * @return devuelve false si no es el fin, y true si ya lo es
	 */
	protected boolean fin() {

		return cambio.getACambiar() > 0 ? false : true;
	}

	/**
	 * Metodo que actualiza el contador en funcion de si una moneda usada es
	 * valida o no
	 */
	protected void seleccionaYElimina() {
		k++;
		// comprueba si la moneda usada es valida para volver a usarla
		if (cambio.getMonedas()[k - 1] <= cambio.getACambiar())
			k--;
	}

	/**
	 * Metodo que comprueba si la posible moneda sirve para el cambio dado
	 * 
	 * @return devuelve true si sirve y false en caso contrario
	 */
	protected boolean prometedor() {
		if (cambio.getMonedas()[k] <= cambio.getACambiar()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo que actualiza el numero de monedas y el cambio
	 * 
	 */
	protected void anotaEnSolucion() {
		NumMinimoMonedas++;
		cambio.setACambiar(cambio.getACambiar() - cambio.getMonedas()[k]);
	}

	/**
	 * Metodo de resolucion del problema de cambio de monedas que llama al
	 * metodo de su superclase
	 * 
	 */
	public void resolver() {
		resuelve();
	}
}
