package com.mio.meto.figura;

public abstract class Figura {
	private String nombre;

	public Figura(String nombreFigura) {
		nombre = nombreFigura;
	}

	public abstract double area();

	public final boolean menorQue(Figura lder) {
		return area() < lder.area();
	}

	public final String toString() {
		return nombre + " con area " + area();
	}

}
