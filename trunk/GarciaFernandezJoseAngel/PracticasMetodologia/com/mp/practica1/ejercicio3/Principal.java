//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 1, Ejercicio 3
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica1.ejercicio3;

import java.io.IOException;

import com.mp.utilidades.LeerDatos;

/**
 * Clase principal que hace uso de las clase Empresa, Cliente y Deudor
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 07.03.2009
 */
public class Principal {
	/**
	 * Arrays para su uso en el programa principal
	 */
	private static Empresa emp;
	private static Cliente[] clientes;
	private static Deudor[] deudores1;
	private static Deudor[] deudores2;
	private static Deudor[] deudores3;

	/**
	 * Variable privada para seleccionar la operacion a realizar
	 */
	private static int opcion;
	/**
	 * Propiedades para su uso en el programa principal
	 */
	private static double cantidadNoCobradaTotal;
	private static double cantidadLimite;
	private static String maximos;
	private static String listado;

	/**
	 * Objeto privado de la case LeerDatos que se usara para las lecturas de
	 * teclado
	 */
	private static LeerDatos lec = new LeerDatos();

	/**
	 * Lee una cantidad introducida por el usuario
	 * 
	 * @return devuelve la cantidad limite dentro del rango especificado
	 * @exception IOException
	 *                cuando se produzca una lectura de teclado erronea
	 */
	public static double LeerCantidadLimite() throws IOException {
		double cantidadLimite;
		System.out.println("Introduzca la cantidad limite");
		cantidadLimite = lec.leerDouble();
		while (cantidadLimite <= 0) {
			System.out.println("Introduzca un numero mayor que cero");
			cantidadLimite = lec.leerDouble();
		}
		return cantidadLimite;
	}

	/**
	 * Muestra la cantidad Total no cobrada por la empresa.
	 * 
	 * @param cantidadNoCobradaTotal
	 *            representa la cantidad total que la empresa aun no ha cobrado
	 */
	public static void MostrarTotalNoCobrado(double cantidadNoCobradaTotal) {

		System.out.println(cantidadNoCobradaTotal);

	}

	/**
	 * Muestra la cantidad máxima prestada por un cliente junto a los DNI.
	 * 
	 * @param maximos
	 *            representa tanto la maxima cantidad prestada como los DNI
	 *            maximos
	 */
	public static void MostrarMaximoPrestado(String maximos) {

		System.out.println(maximos);

	}

	/**
	 * Muestra un listado ordenado alfabéticamente por nombre de cliente, de
	 * aquellos que superan la cantidad limite.
	 * 
	 * @param listado
	 *            representa los nombres de los clientes
	 */
	public static void MostrarListado(String listado) {

		System.out.println(listado);

	}

	/**
	 * Metodo principal para la prueba de tiempos
	 * 
	 * @param args
	 *            parametros del main
	 * @exception IOException
	 *                cuando se produzca una lectura de teclado erronea
	 */
	public static void main(String[] args) throws IOException {

		/* Valores de pruebas */
		emp = new Empresa("El Buitre Negro", 3, clientes);

		emp.getClientes()[0] = new Cliente("Pepe", "666555444", 2, deudores1);
		emp.getClientes()[1] = new Cliente("Alberto", "672333123", 2, deudores2);
		emp.getClientes()[2] = new Cliente("Juan", "67153123", 2, deudores3);

		emp.getClientes()[0].getDeudores()[0] = new Deudor("54138111", 100, 50);
		emp.getClientes()[0].getDeudores()[1] = new Deudor("32342123", 77, 33);

		emp.getClientes()[1].getDeudores()[0] = new Deudor("23212321", 50, 25);
		emp.getClientes()[1].getDeudores()[1] = new Deudor("67544238", 23, 5);

		emp.getClientes()[2].getDeudores()[0] = new Deudor("95903022", 5123,
				678);
		emp.getClientes()[2].getDeudores()[1] = new Deudor("45433321", 532, 65);
		/* Valores de pruebas */

		System.out.println("1-Calcular el total no cobrado por la empresa");
		System.out.println("2-Calcular la maxima cantidad prestada");
		System.out.println("3-Calcular listado de clientes");
		System.out.println("Elija una opcion o introduzca 0 para terminar");

		// Lectura de accion a realizar
		opcion = lec.leerEntero();

		while (opcion != 0) {
			switch (opcion) {
			case 1:
				cantidadNoCobradaTotal = emp.CalcularTotalNoCobrado();
				MostrarTotalNoCobrado(cantidadNoCobradaTotal);
				break;
			case 2:
				maximos = emp.CalcularMaximoPrestado();
				MostrarMaximoPrestado(maximos);
				break;
			case 3:
				cantidadLimite = LeerCantidadLimite();
				emp.Ordenar();
				listado = emp.RealizarListado(cantidadLimite);
				MostrarListado(listado);
				break;
			default:
				System.out
						.println("ERROR: Introduzca un 1 para opcion 1, 2 para opcion 2 "
								+ "y 3 para opcion 3");
				break;
			}
			System.out.println("Elija una opcion o introduzca 0 para terminar");
			opcion = lec.leerEntero();
		}
		System.out.println("Gracias por usar el programa");
	}
}
