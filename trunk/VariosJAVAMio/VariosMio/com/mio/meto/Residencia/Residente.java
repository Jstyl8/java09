//
// Universidad de Almer�a
// Ingenier�a T�cnica de Inform�tica de Sistemas
// Fuente Java seg�n Plantilla
//
// PRACTICA : Practica 2, Ejercicio 6
// ASIGNATURA : Metodologia de la Programaci�n
//

package com.mio.meto.Residencia;

import java.util.Date;

/**
 * Clase que representa un Residente
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 09.03.2008
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
