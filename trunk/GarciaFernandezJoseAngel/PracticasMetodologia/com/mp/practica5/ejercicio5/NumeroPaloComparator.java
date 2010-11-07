//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 5, Documentacion de ejercicio 5
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica5.ejercicio5;

import java.util.Comparator;



/**
 * Clase que añade un criterio de comparacion para la clase Carta implementado
 * el interfaz Comparator
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 21.04.2009
 */
public class NumeroPaloComparator implements Comparator {

	/**
	 * Metodo que comprueba el orden de 2 objetos tipo Carta
	 * 
	 * @param o1
	 *            primer objeto a comparar
	 * @param o2
	 *            segundo objeto a comparar
	 * @return devuelve -1 si o1 es mayor, 0 si son iguales y 1 si o2 es mayor
	 */
	public int compare(Object o1, Object o2) {

		Carta carta1 = (Carta) o1;
		Carta carta2 = (Carta) o2;
		String[] palos = { "O", "C", "E", "B" };

		if (carta1.equals(carta2)) {
			return 0;
		}
		if (carta1.getNumero() == carta2.getNumero()) {
			for (int i = 0; i < palos.length; i++) {
				if (carta1.getPalo() == palos[i])
					return -1;
				if (carta2.getPalo() == palos[i])
					return 1;
			}
		}
		if (carta1.getNumero() < carta2.getNumero()) {
			return -1;
		} else {
			return 1;
		}
	}
}
