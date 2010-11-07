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
 * Clase que representa una Residencia
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 09.03.2008
 */
public class Residencia {
	/**
	 * Representa el nombre de la residencia
	 */
	private String nombre;

	/**
	 * Vector privado que representa los cuidadores de la residencia
	 */
	private Cuidador[] cuidadores;

	/**
	 * Vector privado que representa las habitaciones de la residencia
	 */
	private Habitacion[] habitaciones;

	/**
	 * Vector privado que representa los residentes de la residencia
	 */
	private Residente[] residentes = new Residente[0];

	/**
	 * Vector privado que representa las reservas de la residencia
	 */
	private Reserva[] reservas = new Reserva[0];

	/**
	 * Genera una Residencia con parametros
	 * 
	 * @param nombre
	 * @param cuidadores
	 * @param habitaciones
	 */
	public Residencia(String nombre, Cuidador[] cuidadores,
			Habitacion[] habitaciones) {
		super();
		this.setNombre(nombre);
		this.setCuidadores(cuidadores);
		this.setHabitaciones(habitaciones);
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
	 * Metodo modificador del vector cuidadores
	 * 
	 * @param cuidadores
	 *            representa los cuidadores que tiene la residencia
	 */
	public void setCuidadores(Cuidador[] cuidadores) {
		this.cuidadores = cuidadores;
	}

	/**
	 * Metodo de acceso al vector cuidadores
	 * 
	 * @return devuelve el vector cuidadores de la residencia
	 */
	public Cuidador[] getCuidadores() {
		return (Cuidador[]) cuidadores.clone();
	}

	/**
	 * Metodo modificador del vector habitaciones
	 * 
	 * @param habitaciones
	 *            representa las habitaciones que tiene la residencia
	 */
	public void setHabitaciones(Habitacion[] habitaciones) {
		this.habitaciones = habitaciones;
	}

	/**
	 * Metodo de acceso al vector habitaciones
	 * 
	 * @return devuelve el vector habitaciones de la residencia
	 */
	public Habitacion[] getHabitaciones() {
		return (Habitacion[]) habitaciones.clone();
	}

	/**
	 * Metodo modificador del vector residentes
	 * 
	 * @param residentes
	 *            representa los residentes que tiene la residencia
	 */
	public void setResidentes(Residente[] residentes) {
		this.residentes = residentes;
	}

	/**
	 * Metodo de acceso al vector residentes
	 * 
	 * @return devuelve el vector residentes de la residencia
	 */
	public Residente[] getResidentes() {
		return residentes;
	}

	/**
	 * Metodo modificador del vector reservas
	 * 
	 * @param reservas
	 *            representa los residentes que tiene la residencia
	 */
	public void setReservas(Reserva[] reservas) {
		this.reservas = reservas;
	}

	/**
	 * Metodo de acceso al vector reservas
	 * 
	 * @return devuelve el vector reservas de la residencia
	 */
	public Reserva[] getReservas() {
		return reservas;
	}
	
	/**
	 * Metodo de acceso al numero de reservas
	 * 
	 * @return devuelve el numero de reservas
	 */
	public int getNReservas() {
		return reservas.length;
	}
	
	/**
	 * Metodo de acceso al numero de residentes
	 * 
	 * @return devuelve el numero de residentes
	 */
	public int getNResidentes() {
		return residentes.length;
	}

	/**
	 * Metodo de acceso al numero de cuidadores
	 * 
	 * @return devuelve el numero de cuidadores de la residencia
	 */
	public int getNCuidadores() {
		int nCuidadores = 0;
		for (int i = 0; (i < cuidadores.length); i++) {
			if (!(cuidadores[i] == null)) {
				nCuidadores++;
			}
		}
		return nCuidadores;

	}

	/**
	 * Metodo de acceso al numero de habitaciones
	 * 
	 * @return devuelve el numero de habitaciones de la residencia
	 */
	public int getNHabitaciones() {
		int nHabitaciones = 0;
		for (int i = 0; (i < habitaciones.length); i++) {
			if (!(habitaciones[i] == null)) {
				nHabitaciones++;
			}

		}
		return nHabitaciones;
	}

	/**
	 * Introduce un nuevo cuidador en el vector cuidadores
	 * 
	 * @param cuidador
	 *            representa el nuevo cuidador a incluir
	 */
	public void insertarCuidador(Cuidador cuidador) {

		// se comprueba si el cuidador ya esta en la residencia
		boolean Esta = false;
		for (int i = 0; (i < cuidadores.length) && (Esta == false); i++) {
			if (cuidadores[i].equals(cuidador)) {
				Esta = true;
			}
		}

		if (Esta == false) {
			int nuevoTamaño = cuidadores.length + 1;
			Cuidador[] cuidadores2 = cuidadores;
			cuidadores = new Cuidador[nuevoTamaño];
			for (int i = 0; i < cuidadores2.length; i++) {
				cuidadores[i] = cuidadores2[i];
			}
			cuidadores[nuevoTamaño - 1] = cuidador;
		}
	}

	/**
	 * Busca un cuidador determinado en el vector cuidadores
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
	 * Elimina un cuidador de vector cuidadores
	 * 
	 * @param cuidador
	 *            representa el cuidador a eliminar
	 */
	public void eliminarCuidador(Cuidador cuidador) {
		cuidador = buscarCuidador(cuidador.getNombre());
		if (cuidador == null) {

		} else {
			Cuidador[] cuidadores2 = cuidadores;
			cuidadores = new Cuidador[cuidadores.length - 1];
			for (int i = 0; i < cuidadores.length; i++) {
				cuidadores[i] = cuidadores2[i];
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
		// se comprueban las condiciones de insercion
		boolean noAñadir = false;
		for (int i = 0; (i < habitaciones.length) && (noAñadir == false); i++) {
			if (habitaciones[i].equals(habitacion)) {
				noAñadir = true;
			}
		}
		if (noAñadir == false) {
			int nuevoTamaño = habitaciones.length + 1;
			Habitacion[] habitaciones2 = habitaciones;
			habitaciones = new Habitacion[nuevoTamaño];
			for (int i = 0; i < habitaciones2.length; i++) {
				habitaciones[i] = habitaciones2[i];
			}
			habitaciones[nuevoTamaño - 1] = habitacion;
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
	 * Elimina una habitacion del vector habitaciones
	 * 
	 * @param habitacion
	 *            representa la habitacion a eliminar
	 */
	public void eliminarHabitacion(Habitacion habitacion) {
		habitacion = buscarHabitacion(habitacion.getNumero());
		if (habitacion == null) {

		} else {
			Habitacion[] habitaciones2 = habitaciones;
			habitaciones = new Habitacion[habitaciones.length - 1];
			for (int i = 0; i < habitaciones.length; i++) {
				habitaciones[i] = habitaciones2[i];
			}
		}
	}

	/**
	 * Introduce un nuevo residente en el vector residentes
	 * 
	 * @param residente
	 *            representa el nuevo residente a incluir
	 */
	public void insertarResidente(Residente residente) {
		// se comprueban las condiciones de insercion
		boolean noAñadir = false;
		if (residente == null) {
			noAñadir = true;
		} else {
			for (int i = 0; (i < residentes.length) && (noAñadir == false); i++) {
				if (residentes[i].equals(residente)) {
					noAñadir = true;
				}
			}
		}
		if (noAñadir == false) {
			int nuevoTamaño = residentes.length + 1;
			Residente[] residentes2 = residentes;
			residentes = new Residente[nuevoTamaño];
			for (int i = 0; i < residentes2.length; i++) {
				residentes[i] = residentes2[i];
			}
			residentes[nuevoTamaño - 1] = residente;
		}

	}

	/**
	 * Elimina un cliente del vector clientes
	 */
	public void eliminarCliente() {

		Residente[] residentes2 = residentes;
		residentes = new Residente[residentes.length - 1];
		for (int i = 0; i < residentes.length; i++) {
			residentes[i] = residentes2[i];
		}
	}

	/**
	 * Introduce una nueva reserva en el vector reservas
	 * 
	 * @param reserva
	 *            representa la nueva reserva a incluir
	 */
	public void insertarReserva(Reserva reserva) {
		// se comprueba si el residente tiene ya su reserva hecha
		boolean noAñadir = false;
		for (int i = 0; (i < reservas.length) && (noAñadir == false); i++) {
			if (reservas[i].getResidente().equals(reserva.getResidente())) {
				// si la habitacion es la misma, actualiza las fechas que el
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
			int nuevoTamaño = reservas.length + 1;
			Reserva[] reservas2 = reservas;
			reservas = new Reserva[nuevoTamaño];
			for (int i = 0; i < reservas2.length; i++) {
				reservas[i] = reservas2[i];
			}
			reservas[nuevoTamaño - 1] = reserva;
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
	 * @param fechaSalida
	 */
	public void ingreso(Residente residente, Habitacion habitacion,
			Date fechaEntrada, Date fechaSalida) {

		// se comprueba si la habitacion esta libre
		boolean ocupada = isHabitacionOcupada(habitacion, fechaEntrada);

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
	 */
	public void salida(Residente residente, Date fechaSalida) {

		// asignacion fechasalida a la reserva del cliente
		for (int i = 0; i < reservas.length; i++) {
			if (reservas[i].getResidente().equals(residente)) {
				reservas[i].setFechaSalida(fechaSalida);

			}
		}
		// eliminacion de cliente
		for (int i = 0; i < residentes.length; i++) {
			if (residentes[i].equals(residente)) {
				// si el residente se encuentra en la ultima posicion del vector
				// lo borra directamente
				if (i == residentes.length - 1) {
					eliminarCliente();

					// si no se encuentra en la ultima posicion lo coloca en
					// ella y luego lo borra
				} else {
					for (int j = i; j < residentes.length - 1; j++) {
						Residente aux = residentes[j + 1];
						residentes[j + 1] = residentes[j];
						residentes[j] = aux;
					}
					eliminarCliente();
				}
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
	 * @param fechaSalida
	 */

	public void cambiarHabitacion(Residente residente, Habitacion habitacion,
			Date fechaEntrada, Date fechaSalida) {

		// busca la reserva del cliente y actualiza la fecha de salida
		for (int i = 0; i < reservas.length; i++) {
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
	 *            para la edad
	 * @return devuelve el listado
	 */
	public String listadoEdadMediaPorSexo(Date fecha) {

		int sumaEdadV = 0;
		int sumaEdadM = 0;
		double mediaEdadV = 0;
		double mediaEdadM = 0;
		int nVarones = 0;
		int nMujeres = 0;
		for (int i = 0; i < residentes.length; i++) {
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
	 * Ordena los residentes del vector reservas por orden alfabetico
	 */
	public void ordenarReserva() {
		int pasada = 1;
		boolean intercambio = true;
		Reserva aux = new Reserva();

		while ((pasada < reservas.length) && (intercambio == true)) {
			intercambio = false;
			for (int j = 0; j < (reservas.length - 1) - (pasada - 1); j++) {
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
	 * Ordena los residentes del vector residentes por orden alfabetico
	 */
	public void ordenarResidentes() {
		int pasada = 1;
		boolean intercambio = true;
		Residente aux = new Residente();

		while ((pasada < residentes.length) && (intercambio == true)) {
			intercambio = false;
			for (int j = 0; j < (residentes.length - 1) - (pasada - 1); j++) {
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
		for (int j = 0; j < reservas.length; j++) {
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
		for (int j = 0; j < reservas.length; j++) {
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
		boolean ocupada = false;

		for (int j = 0; j < reservas.length; j++) {
			// busca la habitacion y comprueba si esta libre en la fecha dada
			if (reservas[j].getHabitacion().equals(habitacion)) {
				if (!(fecha.before(reservas[j].getFechaEntrada()) || fecha
						.after(reservas[j].getFechaSalida()))) {
					ocupada = true;
				}
			}
		}
		return ocupada;
	}
}
