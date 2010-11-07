package com.mio.general.examen.ejer3.test;

import com.mio.general.examen.ejer3.Ordenacion;
import com.mio.utilidades.NumerosAleatorios;

import junit.framework.TestCase;

public class OrdenacionTestB extends TestCase {

	private String mensaje;
	private Entero[] array;
	private Entero[] temp;

	public OrdenacionTestB() {
		super();
		mensaje = "";
		array = new Entero[100];
		NumerosAleatorios aleatorio = new NumerosAleatorios();
		for (int i = 0; i < array.length; i++) {
			array[i] = new Entero(new Integer(aleatorio.randomInt(1, 10)), i);
		}
	}

	protected void setUp() throws Exception {
		super.setUp();
		temp = (Entero[]) array.clone();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testOrdenacionEstable() {

		Ordenacion.ordenacionPorInsercion(temp);

		// comprueba que es estable
		mensaje = "Falla: No es estable";
		for (int i = 0, j = 1; j < temp.length; i++, j++) {
			if (temp[i].entero.intValue() == temp[j].entero.intValue()) {
				assertTrue(mensaje, temp[i].posicion < temp[j].posicion);
			}
		}
		temp = (Entero[]) array.clone();
		Ordenacion.sort(temp);

		for (int i = 0, j = 1; j < temp.length; i++, j++) {
			if (temp[i].entero.intValue() == temp[j].entero.intValue()) {
				assertTrue(mensaje, temp[i].posicion < temp[j].posicion);
			}
		}
		temp = (Entero[]) array.clone();
		Ordenacion.mergeSort(temp);

		for (int i = 0, j = 1; j < temp.length; i++, j++) {
			if (temp[i].entero.intValue() == temp[j].entero.intValue()) {
				assertTrue(mensaje, temp[i].posicion < temp[j].posicion);
			}
		}
		temp = (Entero[]) array.clone();
		Ordenacion.quickSort(temp);

		boolean b = true;
		for (int i = 0, j = 1; j < temp.length; i++, j++) {
			if (temp[i].entero.intValue() == temp[j].entero.intValue()) {

				if (temp[i].posicion > temp[j].posicion) {
					b = false;
					System.out.println(temp[i] + " " + temp[j] + " falso");
					assertTrue(temp[i].posicion > temp[j].posicion);
				} else {

					System.out.println(temp[i] + " " + temp[j] + " verdadero");
					assertFalse(temp[i].posicion > temp[j].posicion);
				}
			}
		}
		mensaje = "Si falla: Sería estable";
		assertFalse(mensaje, b);
	}
}

class Entero implements Comparable {

	Integer entero;
	int posicion;

	public Entero(Integer entero, int posicion) {
		super();
		this.entero = entero;
		this.posicion = posicion;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub

		return entero.compareTo(((Entero) o).entero);
	}

	public String toString() {

		return "[" + entero + "," + posicion + "]";
	}

}
