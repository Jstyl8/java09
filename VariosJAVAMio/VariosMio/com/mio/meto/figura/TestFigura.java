package com.mio.meto.figura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestFigura {

	private static BufferedReader in;

	private static void ordenacionPorInsercion(Figura[] a) {
		for (int p = 1; p < a.length; p++) {
			Figura tmp = a[p];
			int j = p;

			for (; j > 0 && tmp.menorQue(a[j - 1]); j--) {
				a[j] = a[j - 1];
			}
			a[j] = tmp;
		}
	}

	private static Figura leerFigura() {
		double radio;
		double largo;
		double ancho;
		String unaLinea;

		try {
			System.out.println("Introduzca el tipo de figura: ( c para circulo, "
							+ "s para cuadrado y r para rectangulo)");
			do {
				unaLinea = in.readLine();
			} while (unaLinea.length() == 0);

			switch (unaLinea.charAt(0)) {

			case 'c':
				System.out.println("Introduzca el radio:");
				radio = Double.parseDouble(in.readLine());
				return new Circulo(radio);

			case 's':
				System.out.println(" Introduzca el lado: ");
				largo = Double.parseDouble(in.readLine());
				return new Cuadrado(largo);

			case 'r':
				System.out
						.println("Introduzca el largo y el ancho en lineas separadas:");
				largo = Double.parseDouble(in.readLine());
				ancho = Double.parseDouble(in.readLine());
				return new Rectangulo(largo, ancho);
			
			default:
				System.out.println("Me faltan c, r o s");
				return new Circulo(0);
			}
		} catch (IOException e) {
			System.err.println(e);
			return new Circulo(0);
		}
	}

	public static void main(String[] args) {

		try {
			// Lectura del numero de figuras
			System.out.println(" Introduzca el numero de figuras: ");
			in = new BufferedReader(new InputStreamReader(System.in));
			int numFiguras = Integer.parseInt(in.readLine());

			// Lectura de las figuras
			Figura[] vector = new Figura[numFiguras];
			for (int i = 0; i < numFiguras; i++) {
				vector[i] = leerFigura();
			}

			// Ordenacion y Salida
			ordenacionPorInsercion(vector);
			System.out.println("Ordenados por area");
			for (int i = 0; i < numFiguras; i++) {
				System.out.println(vector[i]);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
