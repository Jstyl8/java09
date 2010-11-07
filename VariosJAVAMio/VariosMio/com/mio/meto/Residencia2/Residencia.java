//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 2, Ejercicio 6
// ASIGNATURA : Metodologia de la Programación
//

package com.mio.meto.Residencia2;

import java.util.Date;

/**
 * Clase que representa una Residencia
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 09.03.2009
 */
public class Residencia {
	/**
	 * Representa el nombre de la residencia
	 */
	private String nombre;

	/**
	 * Array privado que representa los cuidadores de la residencia
	 */
	private Cuidador[] cuidadores;

	/**
	 * Array privado que representa las habitaciones de la residencia
	 */
	private Habitacion[] habitaciones;

	/**
	 * Array privado que representa los residentes de la residencia
	 */
	private Residente[] residentes;

	/**
	 * Array privado que representa las reservas de la residencia
	 */
	private Reserva[] reservas;

	/**
	 * Representa el numero de cuidadores de la residencia
	 */
	private int nCuidadores;

	/**
	 * Representa el numero de habitaciones de la residencia
	 */
	private int nHabitaciones;

	/**
	 * Representa el numero de residentes de la residencia
	 */
	private int nResidentes;

	/**
	 * Representa el numero de reservas de la residencia
	 */
	private int nReservas;

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
		this.setNombre(nombre);
		this.setCuidadores(cuidadores);
		this.setHabitaciones(habitaciones);
		this.reservas = new Reserva[5];
		this.residentes = new Residente[5];
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
	 * Metodo modificador del Array cuidadores
	 * 
	 * @param cuidadores
	 *            representa los cuidadores que tiene la residencia
	 */
	public void setCuidadores(Cuidador[] cuidadores) {
		this.cuidadores = cuidadores;
	}

	/**
	 * Metodo de acceso al Array cuidadores
	 * 
	 * @return devuelve el vector cuidadores de la residencia
	 */
	public Cuidador[] getCuidadores() {
		return (Cuidador[]) cuidadores.clone();
	}

	/**
	 * Metodo modificador del Array habitaciones
	 * 
	 * @param habitaciones
	 *            representa las habitaciones que tiene la residencia
	 */
	public void setHabitaciones(Habitacion[] habitaciones) {
		this.habitaciones = habitaciones;
	}

	/**
	 * Metodo de acceso al Array habitaciones
	 * 
	 * @return devuelve el Array habitaciones de la residencia
	 */
	public Habitacion[] getHabitaciones() {
		return (Habitacion[]) habitaciones.clone();
	}

	/**
	 * Metodo modificador del Array residentes
	 * 
	 * @param residentes
	 *            representa los residentes que tiene la residencia
	 */
	public void setResidentes(Residente[] residentes) {
		this.residentes = residentes;
	}

	/**
	 * Metodo de acceso al Array residentes
	 * 
	 * @return devuelve el Array residentes de la residencia
	 */
	public Residente[] getResidentes() {
		return residentes;
	}

	/**
	 * Metodo modificador del Array reservas
	 * 
	 * @param reservas
	 *            representa los residentes que tiene la residencia
	 */
	public void setReservas(Reserva[] reservas) {
		this.reservas = reservas;
	}

	/**
	 * Metodo de acceso al Array reservas
	 * 
	 * @return devuelve el Array reservas de la residencia
	 */
	public Reserva[] getReservas() {
		return reservas;
	}

	/**
	 * Metodo de acceso al numero de cuidadores
	 * 
	 * @return devuelve el numero de cuidadores de la residencia
	 */
	public int getNCuidadores() {
		int total = 0;
		for (int i = 0; i < cuidadores.length; i++) {
			if (cuidadores[i] != null) {
				total++;
			}
		}
		nCuidadores = total;
		return nCuidadores;
	}

	/**
	 * Metodo modificador de nCuidadores
	 * 
	 * @param nCuidadores
	 */
	public void setNCuidadores(int nCuidadores) {
		this.nCuidadores = nCuidadores;

	}

	/**
	 * Metodo de acceso al numero de habitaciones
	 * 
	 * @return devuelve el numero de habitaciones de la residencia
	 */
	public int getNHabitaciones() {
		int total = 0;
		for (int i = 0; (i < habitaciones.length); i++) {
			if (!(habitaciones[i] == null)) {
				total++;
			}

		}
		nHabitaciones = total;
		return nHabitaciones;
	}

	/**
	 * Metodo modificador de nHabitaciones
	 * 
	 * @param nHabitaciones
	 */
	public void setNHabitaciones(int nHabitaciones) {
		this.nHabitaciones = nHabitaciones;

	}

	/**
	 * Metodo de acceso al numero de residentes
	 * 
	 * @return devuelve el numero de residentes de la residencia
	 */
	public int getNResidentes() {
		int total = 0;
		for (int i = 0; (i < residentes.length); i++) {
			if (residentes[i] != null) {
				total++;
			}
		}
		nResidentes = total;
		return nResidentes;
	}

	/**
	 * Metodo modificador de nResidentes
	 * 
	 * @param nResidentes
	 */
	public void setNResidentes(int nResidentes) {
		this.nResidentes = nResidentes;

	}

	/**
	 * Metodo de acceso al numero de Reservas
	 * 
	 * @return devuelve el numero de reservas de la residencia
	 */
	public int getNReservas() {
		int total = 0;
		for (int i = 0; (i < reservas.length); i++) {
			if (reservas[i] != null) {
				total++;
			}
		}
		nReservas = total;
		return nReservas;
	}

	/**
	 * Metodo modificador de nReservas
	 * 
	 * @param nReservas
	 */
	public void setNReservas(int nReservas) {
		this.nReservas = nReservas;
	}

	/**
	 * Duplica el tamaño del array cuidadores
	 * 
	 * @param cuidadores
	 *            representa el array a aumentar
	 */
	private void duplicarArrayCuidadores() {

		int nuevoTamaño = cuidadores.length * 2;
		Cuidador[] aux = new Cuidador[nuevoTamaño];
		for (int i = 0; i < cuidadores.length; i++) {
			aux[i] = cuidadores[i];
		}
		cuidadores = aux;
	}

	/**
	 * Duplica el tamaño del array habitaciones
	 * 
	 * @param habitaciones
	 *            representa el array a aumentar
	 */
	private void duplicarArrayHabitaciones() {

		int nuevoTamaño = habitaciones.length * 2;
		Habitacion[] aux = new Habitacion[nuevoTamaño];
		for (int i = 0; i < habitaciones.length; i++) {
			aux[i] = habitaciones[i];
		}
		habitaciones = aux;
	}

	/**
	 * Duplica el tamaño del array residentes
	 * 
	 * @param residentes
	 *            representa el array a aumentar
	 */
	private void duplicarArrayResidentes() {

		int nuevoTamaño = residentes.length * 2;
		Residente[] aux = new Residente[nuevoTamaño];
		for (int i = 0; i < residentes.length; i++) {
			aux[i] = residentes[i];
		}
		residentes = aux;
	}

	/**
	 * Duplica el tamaño del array reservas
	 * 
	 * @param reservas
	 *            representa el array a aumentar
	 */
	private void duplicarArrayReservas() {

		int nuevoTamaño = reservas.length * 2;
		Reserva[] aux = new Reserva[nuevoTamaño];
		for (int i = 0; i < reservas.length; i++) {
			aux[i] = reservas[i];
		}
		reservas = aux;
	}

	/**
	 * Introduce un nuevo cuidador en el Array cuidadores
	 * 
	 * @param cuidador
	 *            representa el nuevo cuidador a incluir
	 */
	public void insertarCuidador(Cuidador cuidador) {

		// se comprueba si el cuidador ya esta en la residencia
		boolean Esta = false;
		for (int i = 0; (i < getNCuidadores()) && (Esta == false); i++) {
			if (cuidadores[i].equals(cuidador)) {
				Esta = true;
			}
		}

		if (Esta == false) {
			if (cuidadores.length <= getNCuidadores()) {
				duplicarArrayCuidadores();
			}
			setNCuidadores(getNCuidadores() + 1);
			cuidadores[getNCuidadores()] = cuidador;
		}
	}

	/**
	 * Busca un cuidador determinado en el Array cuidadores
	 * 
	 * @param nombre
	 *            del cuidador a buscar
	 * @return devuelve el cuidador buscado, si no se encuentra, devuelve un
	 *         valor nulo
	 */
	public Cuidador buscarCuidador(String nombre) {

		for (int i = 0; i < getNCuidadores(); i++) {
			if (cuidadores[i].getNombre().compareToIgnoreCase(nombre) == 0) {
				Cuidador cuidador = cuidadores[i];
				return cuidador;
			}
		}
		return null;
	}

	/**
	 * Elimina un cuidador de Array cuidadores
	 * 
	 * @param cuidador
	 *            representa el cuidador a eliminar
	 */
	public void eliminarCuidador(Cuidador cuidador) {

		for (int i = 0; i < getNCuidadores(); i++) {
			if (cuidadores[i].equals(cuidador)) {
				cuidadores[i] = null;
			}
		}
	}

	/**
	 * Introduce una nueva habitacion en la residencia
	 * 
	 * @param habitacion
	 *            representa la nueva habitacion a incluir
	 */
	public void insertarHabitacion(Habitacion habitacion) {
		// se comprueba si la habitacion ya existe
		boolean noAñadir = false;
		for (int i = 0; (i < getNHabitaciones()) && (noAñadir == false); i++) {
			if (habitaciones[i].equals(habitacion)) {
				noAñadir = true;
			}
		}
		if (noAñadir == false) {
			if (habitaciones.length <= getNHabitaciones()) {
				duplicarArrayHabitaciones();
			}
			setNHabitaciones(getNHabitaciones() + 1);
			habitaciones[getNHabitaciones()] = habitacion;
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

		for (int i = 0; i < habitaciones.length; i++) {
			if (habitaciones[i].getNumero().compareToIgnoreCase(numero) == 0) {
				Habitacion habitacion = habitaciones[i];
				return habitacion;
			}
		}
		return null;
	}

	/**
	 * Elimina una habitacion del Array habitaciones
	 * 
	 * @param habitacion
	 *            representa la habitacion a eliminar
	 */
	public void eliminarHabitacion(Habitacion habitacion) {
		for (int i = 0; i < getNHabitaciones(); i++) {
			if (habitaciones[i].equals(habitacion)) {
				habitaciones[i] = null;
			}
		}
	}

	/**
	 * Introduce un nuevo residente en el Array residentes
	 * 
	 * @param residente
	 *            representa el nuevo residente a incluir
	 */
	public void insertarResidente(Residente residente) {

		boolean noAñadir = false;
		// se comprueba si el residente ya existe
		for (int i = 0; (i < getNResidentes()) && (noAñadir == false); i++) {
			if (residentes[i].equals(residente)) {
				noAñadir = true;
			}
		}
		if (noAñadir == false) {
			if (residentes.length <= getNResidentes()) {
				duplicarArrayResidentes();
			}
			setNResidentes(getNResidentes() + 1);
			residentes[getNResidentes()] = residente;
		}

	}

	/**
	 * Elimina un cliente del Array residentes
	 * 
	 * @param residente
	 *            a eliminar
	 */
	public void eliminarResidente(Residente residente) {
		for (int i = 0; i < getNResidentes(); i++) {
			if (residentes[i].equals(residente)) {
				// si el residente se encuentra en la ultima posicion valida
				// lo borra directamente
				if (i == getNResidentes() - 1) {
					residentes[i] = null;
					// si no se encuentra en la ultima posicion lo coloca en
					// ella y luego lo borra
				} else {
					for (int j = i; j < getNResidentes() - 1; j++) {
						Residente aux = residentes[j + 1];
						residentes[j + 1] = residentes[j];
						residentes[j] = aux;
					}
					residentes[getNResidentes() - 1] = null;
				}
			}
		}
	}

	/**
	 * Introduce una nueva reserva en el Array reservas
	 * 
	 * @param reserva
	 *            representa la nueva reserva a incluir
	 */
	public void insertarReserva(Reserva reserva) {

		boolean noAñadir = false;
		// se comprueba si el residente tiene ya su reserva hecha
		for (int i = 0; (i < getNReservas()) && (noAñadir == false); i++) {
			if (reservas[i].getResidente().equals(reserva.getResidente())) {
				// si la habitacion es la misma, actualiza las fechas en que el
				// cliente la usa
				if (reservas[i].getHabitacion().equals(reserva.getHabitacion())) {
					reservas[i].setFechaEntrada(reserva.getFechaEntrada());
					reservas[i].setFechaSalida(reserva.getFechaSalida());
					noAñadir = true;
				}// si la habitacion es distina y las fechas son iguales no
				// introduce el residente
				else if ((reserva.getFechaEntrada().equals(reservas[i]
						.getFechaEntrada()))
						&& (reserva.getFechaSalida().equals(reservas[i]
								.getFechaSalida()))) {
					noAñadir = true;

				}
			}
		}
		if (noAñadir == false) {
			if (reservas.length <= getNReservas()) {
				duplicarArrayReservas();
			}
			setNReservas(getNReservas() + 1);
			reservas[getNReservas()] = reserva;
		}
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

		// se comprueba si la habitacion esta libre
		boolean ocupada = isHabitacionOcupada(habitacion, fechaEntrada);

		// se comprueba que las fechas sean validas
		if (ocupada == false && fechaEntrada.compareTo(fechaSalida) <= 0) {
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

		// asignacion fechasalida a la reserva del cliente
		for (int i = 0; i < getNReservas(); i++) {
			if (reservas[i].getResidente().equals(residente)) {
				reservas[i].setFechaSalida(fechaSalida);

			}
		}
		// eliminacion de cliente
		for (int i = 0; i < getNResidentes(); i++) {
			if (residentes[i].equals(residente)) {
				eliminarResidente(residente);
			}
		}
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

		// busca la reserva del cliente y actualiza la fecha de salida
		for (int i = 0; i < getNReservas(); i++) {
			if (reservas[i].getResidente().equals(residente)) {
				reservas[i].setFechaSalida(fechaEntrada);
			}
		}

		Reserva reserva = new Reserva(residente, habitacion, fechaEntrada,
				fechaSalida);// la fecha de salida y fecha de entrada no
		// entiendor
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
		for (int i = 0; i < getNResidentes(); i++) {
			if (residentes[i].getSexo() == 'V') {
				sumaEdadV += residentes[i].getEdad(fecha);
				nVarones++;
			}
			if (residentes[i].getSexo() == 'M') {
				sumaEdadM += residentes[i].getEdad(fecha);
				nMujeres++;
			}
		}
		if (nVarones != 0) {
			mediaEdadV = (sumaEdadV / (double) nVarones);
		}
		if (nMujeres != 0) {
			mediaEdadM = (sumaEdadM / (double) nMujeres);
		}
		return mediaEdadV + " " + mediaEdadM;
	}

	/**
	 * Ordena los residentes del Array reservas por orden alfabetico
	 */
	public void ordenarReserva() {
		int pasada = 1;
		boolean intercambio = true;
		Reserva aux = new Reserva();

		while ((pasada < getNReservas()) && (intercambio == true)) {
			intercambio = false;
			for (int j = 0; j < (getNReservas() - 1) - (pasada - 1); j++) {
				if (reservas[j].getResidente().getNombre().compareTo(
						reservas[j + 1].getResidente().getNombre()) > 0) {
					aux = reservas[j];
					reservas[j] = reservas[j + 1];
					reservas[j + 1] = aux;
					intercambio = true;
				}
			}
			pasada++;
		}

	}

	/**
	 * Ordena los residentes del Array residentes por orden alfabetico
	 */
	public void ordenarResidentes() {
		int pasada = 1;
		boolean intercambio = true;
		Residente aux = new Residente();

		while ((pasada < getNResidentes()) && (intercambio == true)) {
			intercambio = false;
			for (int j = 0; j < (getNResidentes() - 1) - (pasada - 1); j++) {
				if (residentes[j].getNombre().compareTo(
						residentes[j + 1].getNombre()) > 0) {
					aux = residentes[j];
					residentes[j] = residentes[j + 1];
					residentes[j + 1] = aux;
					intercambio = true;
				}
			}
			pasada++;
		}
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
		ordenarResidentes();
		ordenarReserva();
		for (int j = 0; j < getNReservas(); j++) {
			// compara que el cliente tenga una reserva en la fecha especificada
			if (reservas[j].getFechaEntrada().compareTo(fecha) <= 0
					&& reservas[j].getFechaSalida().compareTo(fecha) >= 0) {
				listado += " " + residentes[j].getNombre();
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
		String listado = "";
		for (int j = 0; j < getNReservas(); j++) {
			// comprueba si la habitacion esta desocupada
			if (fecha.before(reservas[j].getFechaEntrada())
					|| fecha.after(reservas[j].getFechaSalida())) {
				listado += " " + reservas[j].getHabitacion().getNumero();
			}

		}
		return listado;
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

		for (int j = 0; j < getNReservas(); j++) {
			// busca la habitacion y comprueba si esta libre en la fecha dada
			if (reservas[j].getHabitacion().equals(habitacion)) {
				if (!(fecha.before(reservas[j].getFechaEntrada()) || fecha
						.after(reservas[j].getFechaSalida()))) {
					return true;
				}
			}
		}
		return false;
	}
}
