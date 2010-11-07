//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 2, Ejercicio 6
// ASIGNATURA : Metodologia de la Programación
//

package com.mio.meto.Residencia;

import java.util.Date;

/**
 * Clase que representa una reserva
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 09.03.2008
 */
public class Reserva {

	/**
	 * Genera una reserva con parametros
	 * @param residente
	 * @param habitacion
	 * @param fechaEntrada
	 * @param fechaSalida
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
	private static int ultimoNumero; // para k usa esto ResidenciaTestB

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
}
