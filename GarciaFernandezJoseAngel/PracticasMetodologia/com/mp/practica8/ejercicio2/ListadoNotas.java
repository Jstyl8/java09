//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 8, Ejercicio 2
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica8.ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Clase para realizar un listado de notas trabajando con ficheros
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 22/05/2009
 */
public class ListadoNotas {

	/**
	 * Variable privada que representa el coeficiente de teoria
	 */
	private double coeficienteTeoria;
	/**
	 * Variable privada que representa el coeficiente de practicas
	 */
	private double coeficientePractica;
	/**
	 * Variable privada que representa el limite para aprobado
	 */
	private double aprobado;
	/**
	 * Variable privada que representa el limite para notable
	 */
	private double notable;
	/**
	 * Variable privada que representa el limite para sobresaliente
	 */
	private double sobresaliente;
	/**
	 * Variable privada que representa el numero de alumnos
	 */
	private int numeroAlumnos;
	/**
	 * Variable privada que representa el numero de suspensos
	 */
	private int suspensos;
	/**
	 * Variable privada que representa el numero de aprobados
	 */
	private int aprobados;
	/**
	 * Variable privada que representa el numero de notables
	 */
	private int notables;
	/**
	 * Variable privada que representa el numero de sobresalientes
	 */
	private int sobreSalientes;
	/**
	 * Variable privada que representa la nota media
	 */
	private double notaMedia;
	/**
	 * ArrayList que se usara para el almacenamiento temporal de los datos de
	 * cada alumno
	 */
	private ArrayList aux;

	/**
	 * Genera un objeto de tipo ListadoNotas inicializando todos las propiedades
	 * 
	 */
	public ListadoNotas() {
		aux = new ArrayList();
		aux.clear();
		this.coeficienteTeoria = 0;
		this.coeficientePractica = 0;
		this.aprobado = 0;
		this.notable = 0;
		this.sobresaliente = 0;
		this.numeroAlumnos = 0;
		this.suspensos = 0;
		this.aprobados = 0;
		this.notables = 0;
		this.sobreSalientes = 0;
		this.notaMedia = 0;
	}

	/**
	 * Metodo de acceso para la propiedad coeficienteTeoria
	 * 
	 * @return el coeficienteTeoria
	 */
	public double getCoeficienteTeoria() {
		return coeficienteTeoria;
	}

	/**
	 * Metodo modificador para la propiedad coeficienteTeoria
	 * 
	 * @param coeficienteTeoria
	 *            el coeficienteTeoria a poner
	 */
	public void setCoeficienteTeoria(double coeficienteTeoria) {
		this.coeficienteTeoria = coeficienteTeoria;
	}

	/**
	 * Metodo de acceso para la propiedad coeficientePractica
	 * 
	 * @return el coeficientePractica
	 */
	public double getCoeficientePractica() {
		return coeficientePractica;
	}

	/**
	 * Metodo modificador para la propiedad coeficientePractica
	 * 
	 * @param coeficientePractica
	 *            el coeficientePractica a poner
	 */
	public void setCoeficientePractica(double coeficientePractica) {
		this.coeficientePractica = coeficientePractica;
	}

	/**
	 * Metodo de acceso para la propiedad aprobado
	 * 
	 * @return el aprobado
	 */
	public double getAprobado() {
		return aprobado;
	}

	/**
	 * Metodo modificador para la propiedad aprobado
	 * 
	 * @param aprobado
	 *            el aprobado a poner
	 */
	public void setAprobado(double aprobado) {
		this.aprobado = aprobado;
	}

	/**
	 * Metodo de acceso para la propiedad notable
	 * 
	 * @return el notable
	 */
	public double getNotable() {
		return notable;
	}

	/**
	 * Metodo modificador para la propiedad notable
	 * 
	 * @param notable
	 *            el notable a poner
	 */
	public void setNotable(double notable) {
		this.notable = notable;
	}

	/**
	 * Metodo de acceso para la propiedad sobresaliente
	 * 
	 * @return el sobresaliente
	 */
	public double getSobresaliente() {
		return sobresaliente;
	}

	/**
	 * Metodo modificador para la propiedad sobresaliente
	 * 
	 * @param sobresaliente
	 *            el sobresaliente a poner
	 */
	public void setSobresaliente(double sobresaliente) {
		this.sobresaliente = sobresaliente;
	}

	/**
	 * Metodo de acceso para la propiedad numeroAlumnos
	 * 
	 * @return el numeroAlumnos
	 */
	public int getNumeroAlumnos() {
		return numeroAlumnos;
	}

	/**
	 * Metodo modificador para la propiedad numeroAlumnos
	 * 
	 * @param numeroAlumnos
	 *            el numeroAlumnos a poner
	 */
	public void setNumeroAlumnos(int numeroAlumnos) {
		this.numeroAlumnos = numeroAlumnos;
	}

	/**
	 * Metodo de acceso para la propiedad suspensos
	 * 
	 * @return el suspensos
	 */
	public int getSuspensos() {
		return suspensos;
	}

	/**
	 * Metodo modificador para la propiedad suspensos
	 * 
	 * @param suspensos
	 *            el suspensos a poner
	 */
	public void setSuspensos(int suspensos) {
		this.suspensos = suspensos;
	}

	/**
	 * Metodo de acceso para la propiedad aprobados
	 * 
	 * @return el aprobados
	 */
	public int getAprobados() {
		return aprobados;
	}

	/**
	 * Metodo modificador para la propiedad aprobados
	 * 
	 * @param aprobados
	 *            el aprobados a poner
	 */
	public void setAprobados(int aprobados) {
		this.aprobados = aprobados;
	}

	/**
	 * Metodo de acceso para la propiedad notables
	 * 
	 * @return el notables
	 */
	public int getNotables() {
		return notables;
	}

	/**
	 * Metodo modificador para la propiedad notables
	 * 
	 * @param notables
	 *            el notables a poner
	 */
	public void setNotables(int notables) {
		this.notables = notables;
	}

	/**
	 * Metodo de acceso para la propiedad sobreSalientes
	 * 
	 * @return el sobreSalientes
	 */
	public int getSobresalientes() {
		return sobreSalientes;
	}

	/**
	 * Metodo modificador para la propiedad sobreSalientes
	 * 
	 * @param sobreSalientes
	 *            el sobreSalientes a poner
	 */
	public void setSobreSalientes(int sobreSalientes) {
		this.sobreSalientes = sobreSalientes;
	}

	/**
	 * Metodo de acceso para la propiedad notaMedia
	 * 
	 * @return el notaMedia
	 */
	public double getNotaMedia() {
		return notaMedia;
	}

	/**
	 * Metodo modificador para la propiedad notaMedia
	 * 
	 * @param notaMedia
	 *            el notaMedia a poner
	 */
	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	/**
	 * Metodo que lee unos coeficentes de un archivo de texto y los asigna a las
	 * variables de la clase
	 * 
	 * @param coeficientes
	 *            el directorio del archivo donde estan los coeficientes para el
	 *            calculo de notas
	 */
	public void leerCoeficientes(String coeficientes) {
		try {

			BufferedReader in = new BufferedReader(new FileReader(coeficientes));

			// Leyendo linea a linea y asignando direcectamente
			coeficienteTeoria = Double.parseDouble(in.readLine());
			coeficientePractica = Double.parseDouble(in.readLine());
			aprobado = Double.parseDouble(in.readLine());
			notable = Double.parseDouble(in.readLine());
			sobresaliente = Double.parseDouble(in.readLine());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que procesa las notas
	 * 
	 * @param notas
	 *            el directorio del archivo donde se encuentra el archivo con
	 *            las notas
	 * @param notasFinales
	 *            el directorio del archivo donde se guardara el listado de
	 *            notas
	 */
	public void procesarNotas(String notas, String notasFinales) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(notas));
			PrintWriter out = new PrintWriter(new FileWriter(notasFinales));

			out.format("%-15s%-20s%10s%15s%10s%15s", "DNI", "Nombre", "Teoría",
					"Prácticas", "Final", "Nota Acta");
			out.println();
			StringBuffer linea = new StringBuffer(85);
			for (int i = 0; i < 85; i++) {
				linea.append("-");
			}
			out.println(linea.toString());
			// out.println("-----------------------------------
			// --------------------------------------------------");
			String str;
			while ((str = in.readLine()) != null) {
				numeroAlumnos++;
				StringTokenizer tok = new StringTokenizer(str, ";");
				while (tok.hasMoreElements()) {
					aux.add(tok.nextToken());
				}
				double notaNumero = notaFinal(Double.parseDouble((String) aux
						.get(2)), Double.parseDouble((String) aux.get(3)));
				notaMedia += notaNumero;
				String notaTexto = tipoNota(notaNumero);
				out.format("%-15s%-20s%10s%15s%10.2f%15s", aux.get(0), aux
						.get(1), aux.get(2), aux.get(3), notaNumero, notaTexto);
				out.println();
				aux.clear();
			}
			in.close();
			notaMedia /= numeroAlumnos;
			out.println();
			out.format(String.format(
					"%-18s%10d%n%-18s%10d%n%-18s%10d%n%-18s%10d", "Suspensos:",
					suspensos, "Aprobados:", aprobados, "Notables:", notables,
					"Sobresalientes:", sobreSalientes));
			out.println();
			out.println();
			out.format("%-18s%10d%n%-18s%10.2f", "Número Alumnos:",
					numeroAlumnos, "Nota Media:", notaMedia);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Convierte una nota numerica en una nota de texto actualizando el numero
	 * de calificaciones
	 * 
	 * @param nota
	 *            la notaFinal como numero
	 * @return la nota final como texto o No Valida si esta fuera de limites
	 */
	private String tipoNota(double nota) {
		String notaTexto = "No Valida";
		if (nota >= 0 && nota < 5) {
			notaTexto = "Suspenso";
			suspensos++;
		} else if (nota >= 5 && nota < 7) {
			notaTexto = "Aprobado";
			aprobados++;
		} else if (nota >= 7 && nota < 8) {
			notaTexto = "Notable";
			notables++;
		} else if (nota >= 8 && nota <= 10) {
			notaTexto = "Sobresaliente";
			sobreSalientes++;
		}
		return notaTexto;
	}

	/**
	 * Metodo que calcula la nota final en funcion de los coeficientes para cada
	 * tipo de nota
	 * 
	 * @param notaTeoria
	 *            la nota numerica de teoria
	 * @param notaPracticas
	 *            la nota numerica de practicas
	 * @return la nota final
	 */
	private double notaFinal(double notaTeoria, double notaPracticas) {
		return notaTeoria * coeficienteTeoria + notaPracticas
				* coeficientePractica;
	}
}
