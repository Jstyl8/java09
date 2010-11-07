package com.mio.meto.figura;

public class Rectangulo extends Figura {
	private double base;
	private double altura;

	public Rectangulo(double largo, double ancho) {
		super("Rectangulo");
		base = largo;
		altura = ancho;
	}

	public double area() {
		return base * altura;
	}
}