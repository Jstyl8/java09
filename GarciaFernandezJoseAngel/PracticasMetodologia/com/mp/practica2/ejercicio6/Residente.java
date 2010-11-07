//
// Universidad de Almer�a
// Ingenier�a T�cnica de Inform�tica de Sistemas
// Fuente Java seg�n Plantilla
//
// PRACTICA : Practica 2, Ejercicio 6
// ASIGNATURA : Metodologia de la Programaci�n
//

package com.mp.practica2.ejercicio6;

import java.util.Date;

import com.mp.practica7.ejercicio6.Reserva;

/**
 * Clase que representa un Residente
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 09.03.2009
 */
public class Residente {
	/**
	 * Variable privada que representa el nombre del residente
	 */
	private String nombre;

	/**
	 * Variable privada que representa el DNI del residente
	 */
	private String DNI;

	/**
	 * Variable privada que representa el sexo del residente V varon M mujer
	 */
	private char sexo;

	/**
	 * Variable privada que representa la fecha de nacimiento del deudor
	 */
	private Date fechaNacimiento;

	/**
	 * Genera un residente con parametros
	 * 
	 * @param nombre
	 * @param dni
	 * @param sexo
	 * @param fechaNacimiento
	 */
	public Residente(String nombre, String dni, char sexo, Date fechaNacimiento) {
		this.setNombre(nombre);
		setDni(dni);
		this.setSexo(sexo);
		this.setFechaNacimiento(fechaNacimiento);
	}

	/**
	 * Genera un residente por defecto
	 */
	public Residente() {
	}

	/**
	 * Metodo modificador para la propiedad nombre
	 * 
	 * @param nombre
	 *            representa el nombre del Residente
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo de acceso para la propiedad nombre
	 * 
	 * @return devuelve el nombre del Residente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo modificador para la propiedad DNI
	 * 
	 * @param dNI
	 *            representa el DNI del Residente
	 */
	public void setDni(String dNI) {
		DNI = dNI;
	}

	/**
	 * Metodo de acceso para la propiedad DNI
	 * 
	 * @return devuelve el DNI del Residente
	 */
	public String getDni() {
		return DNI;
	}

	/**
	 * Metodo modificador para la propiedad sexo
	 * 
	 * @param sexo
	 *            representa el sexo del Residente
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	/**
	 * Metodo de acceso para la propiedad sexo
	 * 
	 * @return devuelve el sexo del Residente
	 */
	public char getSexo() {
		return sexo;
	}

	/**
	 * Metodo modificador para la propiedad fechaNacimiento
	 * 
	 * @param fechaNacimiento2
	 *            representa la fecha de nacimiento del residente
	 */
	public void setFechaNacimiento(Date fechaNacimiento2) {
		this.fechaNacimiento = fechaNacimiento2;
	}

	/**
	 * Metodo de acceso para la propiedad fechaNacimiento
	 * 
	 * @return devuelve la fecha de nacimiento del residente
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Metodo que comprueba si 2 residentes son iguales
	 * 
	 * @param residente
	 *            a comparar
	 * @return devuelve false si no son iguales y true si son iguales
	 */
	public boolean equals(Residente residente) {
		if (this == residente)
			return true;
		if (this == null)
			return false;
		if (residente == null)
			return false;
		if ((this.getNombre().equals(residente.getNombre()))) {
			return true;
		}
		return false;
	}

	/**
	 * Implementa el metodo compareTo para las comparaciones
	 * 
	 * @param o
	 *            residente a comparar
	 * @return -1 si this es menor, 0 si son iguales y 1 si es this mayor
	 */
	public int compareTo(Object o) {
		Residente aux = (Residente) o;
		if (nombre.compareToIgnoreCase(aux.nombre) < 0)
			return -1;
		else if (nombre.compareToIgnoreCase(aux.nombre) > 0)
			return 1;
		else
			return 0;
	}

	/**
	 * Calcula la edad del residente
	 * 
	 * @param fecha
	 *            fecha actual escogida
	 * @return devuelve la edad del residente
	 */
	public int getEdad(Date fecha) {

		int difA�os = fecha.getYear() - fechaNacimiento.getYear();
		int difMeses = fecha.getMonth() - fechaNacimiento.getMonth();
		int difDias = fecha.getDate() - fechaNacimiento.getDate();
		// si esta en ese a�o pero todavia no los ha cumplido
		if (difMeses < 0 || (difMeses == 0 && difDias < 0)) {
			difA�os--;
		}
		return difA�os;
	}
}
