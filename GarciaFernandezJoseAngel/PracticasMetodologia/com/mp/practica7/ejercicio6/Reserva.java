//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 7, Ejercicio 6
// ASIGNATURA : Metodologia de la Programación
//

package com.mp.practica7.ejercicio6;

import java.util.Date;

/**
 * Clase que representa una reserva e implementa la interfaz Comparable
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.1 09.03.2009
 */
public class Reserva implements Comparable {

	/**
	 * Genera una reserva con parametros
	 * 
	 * @param residente
	 *            de la reserva
	 * @param habitacion
	 *            de la reserva
	 * @param fechaEntrada
	 *            de la reserva
	 * @param fechaSalida
	 *            de la reserva
	 */
	public Reserva(Residente residente, Habitacion habitacion,
			Date fechaEntrada, Date fechaSalida) {
		this.setResidente(residente);
		this.setHabitacion(habitacion);
		this.setFechaEntrada(fechaEntrada);
		this.setFechaSalida(fechaSalida);
		ultimoNumero++;
		this.numeroReserva = ultimoNumero;

	}

	/**
	 * Genera una reserva por defecto
	 * 
	 */
	public Reserva() {
	}

	/**
	 * Variable privada que representa la fecha de entrada a la residencia
	 */
	private Date fechaEntrada;

	/**
	 * Variable privada que representa la fecha de salida de la residencia
	 */
	private Date fechaSalida;

	/**
	 * Variable privada que representa el numero de reserva
	 */
	private int numeroReserva;

	/**
	 * Variable privada estatica que se incrementa cada vez que se crea una
	 * reserva
	 */
	private static int ultimoNumero;

	/**
	 * Residente asociado a esta reserva
	 */
	private Residente residente;

	/**
	 * Habitacion asociada a esta reserva
	 */
	private Habitacion habitacion;

	/**
	 * Metodo de modificador para la fecha de entrada
	 * 
	 * @param fechaEntrada
	 *            representa la fecha de entrada a la residencia
	 */

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	/**
	 * Metodo de acceso para la fecha de entrada
	 * 
	 * @return devuelve la fecha de entrada
	 */
	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	/**
	 * Metodo de modificador para la fecha de salida
	 * 
	 * @param fechaSalida
	 *            repreesnta la fecha de Salida de la residencia
	 */
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	/**
	 * Metodo de acceso para la fecha de salida
	 * 
	 * @return devuelve la fecha de Salida
	 */
	public Date getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * Metodo de acceso para el numero de reserva
	 * 
	 * @return numeroReserva
	 */
	public int getNumeroReserva() {
		return numeroReserva;
	}

	/**
	 * Metodo modificador para el numero de reserva
	 * 
	 * @param numeroReserva
	 *            representa el numero de reserva para poner
	 */
	public void setNumeroReserva(int numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	/**
	 * Metodo modificador para el residente de la reserva
	 * 
	 * @param residente
	 *            residente a poner
	 */
	public void setResidente(Residente residente) {
		this.residente = residente;
	}

	/**
	 * Metodo de acceso para el residente de la reserva
	 * 
	 * @return residente
	 */
	public Residente getResidente() {
		return residente;
	}

	/**
	 * Metodo modificador para la habitacion de la reserva
	 * 
	 * @param habitacion
	 *            habitacion a poner
	 */
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	/**
	 * Metodo de acceso para la habitacion de la reserva
	 * 
	 * @return habitacion
	 */
	public Habitacion getHabitacion() {
		return habitacion;
	}

	/**
	 * Metodo de acceso para el ultimo numero de reserva
	 * 
	 * @return devuelve ultimoNumero que representa el ultimo numero de reserva
	 */
	public static int getUltimoNumero() {
		return ultimoNumero;
	}

	/**
	 * Implementa el metodo compareTo para las comparaciones
	 * 
	 * @param o
	 *            reserva a comparar
	 * @return -1 si this es menor, 0 si son iguales y 1 si es this mayor
	 */
	public int compareTo(Object o) {
		Reserva aux = (Reserva) o;
		if (residente.getNombre().compareToIgnoreCase(
				aux.getResidente().getNombre()) < 0)
			return -1;
		else if (residente.getNombre().compareToIgnoreCase(
				aux.getResidente().getNombre()) > 0)
			return 1;
		else
			return 0;
	}
}
