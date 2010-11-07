package com.mio.icaro;

public class Alumno implements Comparable{

	private int edad;
	private String nombre;
	private double nota;
	
	Alumno(int edad, String nombre, double nota){
		this.edad=edad;
		this.nombre=nombre;
		this.nota=nota;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public int compareTo(Object o) {
		Alumno otro = (Alumno)o;
		if(this.nota>otro.getNota())
			return -1;
		else if(this.nota==otro.getNota())
			return 0;
		else
			return 1;
	}
	
	
}
