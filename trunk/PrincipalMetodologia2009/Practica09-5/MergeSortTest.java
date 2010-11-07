package com.mp.practica5.ejercicio4.test;

import com.mp.practica5.ejercicio4.VectorComparables;
import com.mp.practica5.ejercicio4.MergeSortDYV;
import com.mp.practica5.ejercicio4.SolucionMergeSort;
import com.mp.utilidades.NumerosAleatorios;

import junit.framework.TestCase;

public class MergeSortTest extends TestCase {

	public static void main(String[] args) {
	}

	public MergeSortTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testVectorNormal() {

        Integer[] array = {
        		new Integer(3),new Integer(1),new Integer(2),new Integer(8),
                new Integer(3),new Integer(5),new Integer(2),new Integer(8),
                new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                new Integer(3),new Integer(6),new Integer(2),new Integer(8)};


		VectorComparables mergesort = new VectorComparables(array.length);
		mergesort.setVector(array);

		MergeSortDYV mergesortDyV = new MergeSortDYV(mergesort);

		mergesortDyV.resuelve();

        SolucionMergeSort solucion = (SolucionMergeSort) mergesortDyV
				.getSolucion();

		Comparable[] aux = new Comparable[solucion.getVector().length];
		aux = solucion.getVector();

		for (int i = 0, j = 1; j < aux.length; i++, j++) {
			assertTrue(aux[i].compareTo(aux[j])<=0);
		}
		for (int i = 0, j = 1; j < array.length; i++, j++) {
			assertTrue(array[i].compareTo(array[j])<=0);
		}
	
	}

	public void testVectorAleatorio() {

		Integer[] array = new Integer[1000];

		NumerosAleatorios aleatorio = new NumerosAleatorios();

		for (int i = 0; i < array.length; i++) {
			array[i] = new Integer(aleatorio.randomInt(-1000, 1000));
		}
		
		VectorComparables mergesort = new VectorComparables(array.length);
		mergesort.setVector(array);

		MergeSortDYV mergesortDyV = new MergeSortDYV(mergesort);

		mergesortDyV.resuelve();

        SolucionMergeSort solucion = (SolucionMergeSort) mergesortDyV
				.getSolucion();

		Comparable[] aux = new Comparable[solucion.getVector().length];
		
		aux = solucion.getVector();

		for (int i = 0, j = 1; j < aux.length; i++, j++) {
			assertTrue(aux[i].compareTo(aux[j])<=0);
		}
		for (int i = 0, j = 1; j < array.length; i++, j++) {
			assertTrue(array[i].compareTo(array[j])<=0);
		}

	}
}
