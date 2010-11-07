//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 7, Ejercicio 6
// ASIGNATURA : Metodologia de la Programación
//

package com.mp.practica7.ejercicio6;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import com.mp.estructurasdatos.ArrayLista;
import com.mp.estructurasdatos.Iterador;

/**
 * Clase que representa una Residencia
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.1 09.03.2009
 */
public class Residencia {
	/**
	 * Representa el nombre de la residencia
	 */
	private String nombre;

	/**
	 * ArrayList privado que representa los cuidadores de la residencia
	 */
	private ArrayList cuidadores;

	/**
	 * ArrayList privado que representa las habitaciones de la residencia
	 */
	private ArrayList habitaciones;

	/**
	 * ArrayLista privado que representa los residentes de la residencia
	 */
	private ArrayLista residentes;

	/**
	 * LinkedList privado que representa las reservas de la residencia
	 */
	private LinkedList reservas;

	/**
	 * Genera una Residencia con parametros
	 * 
	 * @param nombre
	 *            de la residencia
	 * @param cuidadores
	 *            array de cuidadores de la residencia
	 * @param habitaciones
	 *            array de habitaciones de la residencia
	 */
	public Residencia(String nombre, Cuidador[] cuidadores,
			Habitacion[] habitaciones) {

		this(nombre);
		for (int i = 0; i < cuidadores.length; i++) {
			if (cuidadores[i] != null)
				this.cuidadores.add(cuidadores[i]);
		}
		for (int i = 0; i < habitaciones.length; i++) {
			if (habitaciones[i] != null)
				this.habitaciones.add(habitaciones[i]);
		}
	}

	/**
	 * Constructor base de Residencia
	 * 
	 * @param nombre
	 *            el nombre de la residencia
	 */
	public Residencia(String nombre) {
		this.setNombre(nombre);
		this.cuidadores = new ArrayList();
		this.habitaciones = new ArrayList();
		this.reservas = new LinkedList();
		this.residentes = new ArrayLista();
	}

	/**
	 * Metodo modificador para la propiedad nombre
	 * 
	 * @param nombre
	 *            representa el nombre de la residencia
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo de acceso para la propiedad nombre
	 * 
	 * @return devuelve el nombre de la residencia
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo modificador del ArrayList cuidadores
	 * 
	 * @param cuidadores
	 *            representa los cuidadores que tiene la residencia
	 */
	public void setCuidadores(ArrayList cuidadores) {
		this.cuidadores = cuidadores;
	}

	/**
	 * Metodo de acceso al ArrayList cuidadores
	 * 
	 * @return devuelve un array de cuidadores representado por la ArrayList
	 */
	public Cuidador[] getCuidadores() {
		Cuidador[] aux = new Cuidador[cuidadores.size()];
		int i = 0;
		Iterator it = cuidadores.iterator();
		while (it.hasNext())
			aux[i++] = (Cuidador) it.next();
		return aux;
	}

	/**
	 * Metodo modificador del ArrayList habitaciones
	 * 
	 * @param habitaciones
	 *            representa las habitaciones que tiene la residencia
	 */
	public void setHabitaciones(ArrayList habitaciones) {
		this.habitaciones = habitaciones;
	}

	/**
	 * Metodo de acceso al ArrayList habitaciones
	 * 
	 * @return devuelve un array de habitaciones representado por el ArrayList
	 */
	public Habitacion[] getHabitaciones() {
		Habitacion[] aux = new Habitacion[habitaciones.size()];
		int i = 0;
		Iterator it = habitaciones.iterator();
		while (it.hasNext())
			aux[i++] = (Habitacion) it.next();
		return aux;
	}

	/**
	 * Metodo modificador del ArrayLista residentes
	 * 
	 * @param residentes
	 *            representa los residentes que tiene la residencia
	 */
	public void setResidentes(ArrayLista residentes) {
		this.residentes = residentes;
	}

	/**
	 * Metodo de acceso al ArrayLista residentes
	 * 
	 * @return devuelve el ArrayLista residentes de la residencia
	 */
	public ArrayLista getResidentes() {
		return residentes;
	}

	/**
	 * Metodo modificador del LinkedList reservas
	 * 
	 * @param reservas
	 *            representa los residentes que tiene la residencia
	 */
	public void setReservas(LinkedList reservas) {
		this.reservas = reservas;
	}

	/**
	 * Metodo de acceso al LinkedList reservas
	 * 
	 * @return devuelve un array de reservas representado por la LinkedList
	 */
	public Reserva[] getReservas() {
		Reserva[] aux = new Reserva[reservas.size()];
		int i = 0;
		Iterator it = reservas.iterator();
		while (it.hasNext())
			aux[i++] = (Reserva) it.next();
		return aux;
	}

	/**
	 * Metodo de acceso al numero de cuidadores
	 * 
	 * @return devuelve el numero de cuidadores de la residencia
	 */
	public int getNCuidadores() {
		return cuidadores.size();
	}

	/**
	 * Metodo de acceso al numero de habitaciones
	 * 
	 * @return devuelve el numero de habitaciones de la residencia
	 */
	public int getNHabitaciones() {
		return habitaciones.size();
	}

	/**
	 * Metodo de acceso al numero de residentes
	 * 
	 * @return devuelve el numero de residentes de la residencia
	 */
	public int getNResidentes() {
		return residentes.tamaño();
	}

	/**
	 * Metodo de acceso al numero de Reservas
	 * 
	 * @return devuelve el numero de reservas de la residencia
	 */
	public int getNReservas() {
		return reservas.size();
	}

	/**
	 * Introduce un nuevo cuidador en el ArrayList cuidadores
	 * 
	 * @param cuidador
	 *            representa el nuevo cuidador a incluir
	 */
	public void insertarCuidador(Cuidador cuidador) {

		if (!cuidadores.contains(cuidador)) {
			cuidadores.add(cuidador);
		}
	}

	/**
	 * Busca un cuidador determinado en el ArrayList cuidadores por nombre
	 * 
	 * @param nombre
	 *            del cuidador a buscar
	 * @return devuelve el cuidador buscado, si no se encuentra, devuelve un
	 *         valor nulo
	 */
	public Cuidador buscarCuidador(String nombre) {

		Cuidador temp;
		Iterator it = cuidadores.iterator();
		while (it.hasNext()) {
			temp = (Cuidador) it.next();
			if (temp.getNombre().compareToIgnoreCase(nombre) == 0)
				return temp;
		}
		return null;
	}

	/**
	 * Elimina un cuidador de ArrayList cuidadores
	 * 
	 * @param cuidador
	 *            representa el cuidador a eliminar
	 */
	public void eliminarCuidador(Cuidador cuidador) {

		cuidadores.remove(cuidador);
	}

	/**
	 * Introduce una nueva habitacion en la residencia
	 * 
	 * @param habitacion
	 *            representa la nueva habitacion a incluir
	 */
	public void insertarHabitacion(Habitacion habitacion) {
		if (!habitaciones.contains(habitacion)) {
			habitaciones.add(habitacion);
		}
	}

	/**
	 * Busca una habitacion determinada
	 * 
	 * @param numero
	 *            de la habitacion a buscar
	 * @return devuelve la habitacion buscada, si no se encuentra, devuelve un
	 *         valor nulo
	 */
	public Habitacion buscarHabitacion(String numero) {
		Habitacion temp;
		Iterator it = habitaciones.iterator();
		while (it.hasNext()) {
			temp = (Habitacion) it.next();
			if (temp.getNumero().compareToIgnoreCase(numero) == 0)
				return temp;
		}
		return null;
	}

	/**
	 * Elimina una habitacion del ArrayList habitaciones
	 * 
	 * @param habitacion
	 *            representa la habitacion a eliminar
	 */
	public void eliminarHabitacion(Habitacion habitacion) {
		habitaciones.remove(habitacion);
	}

	/**
	 * Introduce un nuevo residente en el ArrayLista residentes
	 * 
	 * @param residente
	 *            representa el nuevo residente a incluir
	 */
	public void insertarResidente(Residente residente) {
		if (!residentes.contiene(residente)) {
			residentes.añadir(residente);
		}
	}

	/**
	 * Elimina un cliente del ArrayLista residentes
	 * 
	 * @param residente
	 *            a eliminar
	 */
	public void eliminarResidente(Residente residente) {
		residentes.eliminar(residente);
	}

	/**
	 * Introduce una nueva reserva en el LinkedList reservas
	 * 
	 * @param reserva
	 *            representa la nueva reserva a incluir
	 */
	public void insertarReserva(Reserva reserva) {

		boolean noAñadir = false;
		Reserva temp;
		Iterator it = reservas.iterator();
		while (it.hasNext() && noAñadir == false) {
			temp = (Reserva) it.next();
			// se comprueba si el residente tiene ya su reserva hecha
			if (temp.getResidente().equals(reserva.getResidente())) {
				// si la habitacion es la misma, actualiza las fechas en que el
				// cliente la usa
				if (temp.getHabitacion().equals(reserva.getHabitacion())) {
					temp.setFechaEntrada(reserva.getFechaEntrada());
					temp.setFechaSalida(reserva.getFechaSalida());
					noAñadir = true;
				}// si la habitacion es distina y las fechas son iguales no
				// introduce el residente
				else if ((reserva.getFechaEntrada().equals(temp
						.getFechaEntrada()))
						&& (reserva.getFechaSalida().equals(temp
								.getFechaSalida()))) {
					noAñadir = true;

				}
			}
		}
		if (noAñadir == false)
			reservas.add(reserva);
	}

	/**
	 * Ingreso de un cliente en la residencia
	 * 
	 * @param residente
	 *            que entra
	 * @param habitacion
	 *            asignada
	 * @param fechaEntrada
	 *            a la residencia
	 * @param fechaSalida
	 *            de la residencia
	 */
	public void ingreso(Residente residente, Habitacion habitacion,
			Date fechaEntrada, Date fechaSalida) {

		// se comprueba que las fechas sean validas y que la habitacion no este
		// ocupada
		if (!isHabitacionOcupada(habitacion, fechaEntrada)
				&& fechaEntrada.compareTo(fechaSalida) <= 0) {
			insertarResidente(residente);

			Reserva reserva = new Reserva(residente, habitacion, fechaEntrada,
					fechaSalida);
			insertarReserva(reserva);
		}
	}

	/**
	 * Salida de un cliente de la residencia
	 * 
	 * @param residente
	 *            a salir
	 * @param fechaSalida
	 *            de la residencia
	 */
	public void salida(Residente residente, Date fechaSalida) {

		Reserva temp;
		Iterator it = reservas.iterator();
		while (it.hasNext()) {
			temp = (Reserva) it.next();
			if (temp.getResidente().equals(residente)) {
				temp.setFechaSalida(fechaSalida);
			}
		}

		eliminarResidente(residente);
	}

	/**
	 * Cambio de habitacion de un cliente de la residencia
	 * 
	 * @param residente
	 *            que efectua el cambio de habitacion
	 * @param habitacion
	 *            a la que se cambia
	 * @param fechaEntrada
	 *            a la residencia
	 * @param fechaSalida
	 *            de la residencia
	 */

	public void cambiarHabitacion(Residente residente, Habitacion habitacion,
			Date fechaEntrada, Date fechaSalida) {

		Reserva temp;
		Iterator it = reservas.iterator();
		while (it.hasNext()) {
			temp = (Reserva) it.next();
			if (temp.getResidente().equals(residente)) {
				temp.setFechaSalida(fechaEntrada);
			}
		}

		Reserva reserva = new Reserva(residente, habitacion, fechaEntrada,
				fechaSalida);
		insertarReserva(reserva);
	}

	/**
	 * Realiza un listado por sexo de las edades medias de los residentes
	 * 
	 * @param fecha
	 *            que se tomara como referencia para el calculo de la edad
	 * @return devuelve el listado
	 */
	public String listadoEdadMediaPorSexo(Date fecha) {

		int sumaEdadV = 0;
		int sumaEdadM = 0;
		double mediaEdadV = 0;
		double mediaEdadM = 0;
		int nVarones = 0;
		int nMujeres = 0;
		Residente temp;
		Iterador it = residentes.iterador();
		for (it.primero(); it.estaDentro(); it.siguiente()) {
			temp = (Residente) it.actual();
			if (temp.getSexo() == 'V') {
				sumaEdadV += temp.getEdad(fecha);
				nVarones++;
			}
			if (temp.getSexo() == 'M') {
				sumaEdadM += temp.getEdad(fecha);
				nMujeres++;
			}
		}
		if (nVarones > 0) {
			mediaEdadV = (sumaEdadV / (double) nVarones);
		}
		if (nMujeres > 0) {
			mediaEdadM = (sumaEdadM / (double) nMujeres);
		}
		return mediaEdadV + " " + mediaEdadM;
	}

	/**
	 * Ordena los residentes de la LinkedList reservas por orden alfabetico
	 */
	public void ordenarReserva() {
		java.util.Collections.sort(reservas);
	}

	/**
	 * Realiza un listado de los residente que tienen una reserva en la fecha
	 * especificada
	 * 
	 * @param fecha
	 *            representa la fecha especificada
	 * @return devuelve el listado
	 */
	public String listadoResidentesHabitaciones(Date fecha) {
		String listado = "";
		ordenarReserva();
		Reserva temp;
		Iterator it = reservas.iterator();
		while (it.hasNext()) {
			temp = (Reserva) it.next();
			// comprueba que el cliente tenga una reserva en la fecha
			// especificada
			if (temp.getFechaEntrada().compareTo(fecha) <= 0
					&& temp.getFechaSalida().compareTo(fecha) >= 0) {
				listado += " " + temp.getResidente().getNombre();
			}
		}
		return listado;
	}

	/**
	 * Realiza un listado de las habitaciones libres en la fecha especificada
	 * 
	 * @param fecha
	 *            representa la fecha especificada
	 * @return devuelve el listado
	 */
	public String listadoHabitacionesLibres(Date fecha) {

		StringBuffer listado = new StringBuffer();
		listado.append("[");
		Reserva temp;
		Iterator it = reservas.iterator();
		while (it.hasNext()) {
			temp = (Reserva) it.next();
			if (fecha.before(temp.getFechaEntrada())
					|| fecha.after(temp.getFechaSalida())) {
				listado.append(temp.getHabitacion().getNumero()).append(", ");
			}
		}
		listado.setLength(listado.length() - 2);
		listado.append("]");
		return listado.toString();
	}

	/**
	 * Comprueba si una habitacion esta ocupada
	 * 
	 * @param fecha
	 *            representa la fecha especificada
	 * @param habitacion
	 *            a comprobar
	 * @return devuelve false si no esta ocupada y true si esta ocupada
	 */
	public boolean isHabitacionOcupada(Habitacion habitacion, Date fecha) {
		Reserva temp;
		Iterator it = reservas.iterator();
		while (it.hasNext()) {
			temp = (Reserva) it.next();
			if (temp.getHabitacion().equals(habitacion)) {
				if (!(fecha.before(temp.getFechaEntrada()) || fecha.after(temp
						.getFechaSalida()))) {
					return true;
				}
			}
		}
		return false;
	}
}
