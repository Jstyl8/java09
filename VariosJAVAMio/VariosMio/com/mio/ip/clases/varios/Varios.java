package com.mio.ip.clases.varios;

import java.util.Random;

public class Varios {

	private static int[] b = { 19, 8, 20, 3, 11 };

	// probar array aux insercion ordenada de una copia en 2 metodos
	public static int[] ins(int nuevo, int[] a, int numA) {
		boolean colocado = false;
		int j;
		for (j = numA; j > 0 && colocado == false;) {
			if (nuevo < a[j - 1]) {
				a[j] = a[j - 1];
				j--;
			} else {
				colocado = true;
			}
		}
		a[j] = nuevo;
		return a;
	}

	public static int[] pepe() {
		int[] a = new int[5];
		int numA = 0;
		Random r = new Random();
		for (int i = 0; i < b.length; i++) {
			a = ins(b[i], a, numA);
			numA++;
		}
		return a;
	}

	// probar array aux insercion ordenada de una copia en 1 metodo
	public static int[] pepePowa() {
		int[] a = new int[5];
		int numA = 0;
		Random r = new Random();
		for (int i = 0; i < b.length; i++) {
			int j;
			boolean colocado = false;
			for (j = numA; j > 0 && colocado == false;) {
				if (b[i] < a[j - 1]) {
					a[j] = a[j - 1];
					j--;
				} else {
					colocado = true;
				}
			}
			a[j] = b[i];
			numA++;
		}
		return a;
	}

	public static void main(String[] args) {

		int[] p = pepe();
		int[] p2 = pepePowa();
		for (int i : b) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i : p) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i : p2) {
			System.out.print(i + " ");
		}
	}
}
