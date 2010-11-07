//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 8, Ejercicio 4
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica8.ejercicio4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

import com.mp.estructurasdatos.ArrayLista;

/**
 * Clase que permite serializar los datos de Residencia implementanto la
 * interfaz Serializable
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 23/05/2009
 */
public class ResidenciaDAO implements Serializable {

	/**
	 * Variable privada que representa la ruta donde se guardara los datos de la
	 * serializacion
	 */
	private String salida;

	/**
	 * Variable privada que representa el ObjectOutputStream usado para la
	 * serializacion
	 */
	private ObjectOutputStream oos;
	/**
	 * Variable privada que representa el ObjectInputStream usado para la
	 * serializacion
	 */
	private ObjectInputStream ois;

	/**
	 * Genera un objeto de tipo ResidenciaDAO
	 * 
	 * @param salida
	 *            la ruta donde se guardara el fichero
	 */
	public ResidenciaDAO(String salida) {
		this.salida = salida;
	}

	/**
	 * Metodo que realiza la serializacion de un objeto de tipo Residencia
	 * 
	 * @param residencia
	 *            el objeto Residencia que se serializara
	 */
	public void escribir(Residencia residencia) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(salida));
			oos.writeObject(residencia.getNombre());
			oos.writeObject(residencia.getCuidadores());
			oos.writeObject(residencia.getHabitaciones());
			oos.writeObject(residencia.getResidentes());
			oos.writeObject(residencia.getReservas());
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que desserializa el objeto Residencia
	 * 
	 * @return la residencia desserializada o null en otro caso
	 */
	public Residencia leer() {
		try {
			ois = new ObjectInputStream(new FileInputStream(salida));
			Residencia residencia = new Residencia((String) ois.readObject(),
					(Cuidador[]) ois.readObject(), (Habitacion[]) ois
							.readObject());
			residencia.setResidentes((ArrayLista) ois.readObject());
			LinkedList aux = new LinkedList();
			Reserva[] aux2 = (Reserva[]) ois.readObject();
			for (int i = 0; i < aux2.length; i++) {
				aux.add(aux2);
			}
			residencia.setReservas(aux);
			ois.close();
			return residencia;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}
