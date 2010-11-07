package com.mio.meto.figura;

public class Circulo extends Figura {
	private static final double PI = 3.1415926358979323;
	private double radio;

	public Circulo(double r) {
		super("Circulo");
		radio = r;
	}

	public double area() {
		return PI * radio * radio;
	}

}
