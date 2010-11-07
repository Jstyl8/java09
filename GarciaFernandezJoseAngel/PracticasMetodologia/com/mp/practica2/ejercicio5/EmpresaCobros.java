//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 1, Ejercicio 3
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica2.ejercicio5;

/**
 * Clase que contiene metodos y propiedades relacionados con una empresa
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 07.03.2009
 */
public class EmpresaCobros {

	/**
	 * Variable privada que representa el nombre de la empresa
	 */
	private String nombreEmpresa;

	/**
	 * Vector privado que representa los clientes de la empresa
	 */
	private Cliente[] clientes;

	/**
	 * Variable privada que representa el numero de clientes de la empresa
	 */
	private int nClientes;

	/**
	 * Genera una empresa con parametros
	 * 
	 * @param nombreEmpresa
	 *            representa el nombre de la empresa
	 */
	public EmpresaCobros(String nombreEmpresa) {
		super();
		this.setNombre(nombreEmpresa);
		clientes = new Cliente[1000];
	}

	/**
	 * Metodo modificador de la propiedad nombreEmpresa
	 * 
	 * @param nombreEmpresa
	 *            representa el nombre de la empresa
	 */
	public void setNombre(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	/**
	 * Metodo de acceso a la propiedad NombreEmpresa
	 * 
	 * @return devuelve el nombre de la empresa
	 */
	public String getNombre() {
		return nombreEmpresa;
	}

	/**
	 * Metodo modificador del vector clientes
	 * 
	 * @param clientes
	 *            representa los clientes que tiene la empresa
	 */
	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}

	/**
	 * Metodo de acceso al vector clientes
	 * 
	 * @return devuelve el vector clientes de la empresa
	 */
	public Cliente[] getClientes() {
		return clientes;
	}

	/**
	 * Metodo de acceso al numero de clientes
	 * 
	 * @return devuelve el numero de clientes de la empresa
	 */
	public int getNClientes() {
		int total = 0;
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] != null) {
				total++;
			}
		}
		nClientes = total;
		return nClientes;
	}

	/**
	 * Calcula la cantidad total que la empresa aun no ha cobrado.
	 * 
	 * @return devuelve el total que la empresa no ha cobrado aun
	 */
	public double cantidadTotalNoCobrada() {

		double cantidadNoCobradaTotal = 0;
		for (int i = 0; i < getNClientes(); i++) {
			cantidadNoCobradaTotal += clientes[i].cantidadTotalNoCobrada();
		}
		return cantidadNoCobradaTotal;
	}

	/**
	 * Calcula la cantidad máxima prestada por un cliente.
	 * 
	 * @return devuelve la cantidad prestada maxima y los DNI de los deudores
	 */
	public String maximoPrestado() {
		String DNIMax = "";
		double cantidadPrestadaMax = 0;

		for (int i = 0; i < getNClientes(); i++) {
			for (int j = 0; j < clientes[i].getNDeudores(); j++) {
				if (cantidadPrestadaMax >= clientes[i].getDeudores()[j]
						.getCantidadPrestada()) {

				} else if (cantidadPrestadaMax == clientes[i].getDeudores()[j]
						.getCantidadPrestada()) {
					DNIMax += " " + clientes[i].getDeudores()[j].getDNI();
				} else {
					DNIMax = clientes[i].getDeudores()[j].getDNI();
					cantidadPrestadaMax = clientes[i].getDeudores()[j]
							.getCantidadPrestada();
				}
			}
		}

		return DNIMax + " " + cantidadPrestadaMax;
	}

	/**
	 * Ordena el vector clientes por orden alfabetico
	 */
	public void Ordenar() {
		int pasada = 1;
		boolean intercambio = true;
		Cliente aux = new Cliente();

		while ((pasada < getNClientes()) && (intercambio == true)) {
			intercambio = false;
			for (int j = 0; j < (getNClientes() - 1) - (pasada - 1); j++) {
				if (clientes[j].getNombre().compareTo(
						clientes[j + 1].getNombre()) > 0) {
					aux = clientes[j];
					clientes[j] = clientes[j + 1];
					clientes[j + 1] = aux;
					intercambio = true;
				}
			}
			pasada++;
		}
	}

	/**
	 * Comprueba si el total prestado del cliente es superior a la cantidad
	 * limite, si lo es lo añade al listado, si no lo es, no lo añade.
	 * 
	 * @param cantidadLimite
	 *            representa el limite de cantidad prestada para realizar el
	 *            listado
	 * @return devuelve el listado ordenado con los nombres de los clientes
	 */
	public String listadoAlfabetico(double cantidadLimite) {

		double totalPrestado;
		String listado = "";
		Ordenar();

		for (int i = 0; i < getNClientes(); i++) {
			totalPrestado = clientes[i].CantidadTotalPrestada();
			if (totalPrestado > cantidadLimite) {
				listado += " " + clientes[i].getNombre();
			}
		}
		return listado;
	}

}