//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 5, Ejercicio 3
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica5.ejercicio3;

/**
 * Clase que extiende de EsquemaDYV y se usa para resolver el problema de la
 * Subsecuencia maxima
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 22.03.2009
 */
public class SubsecuenciaRecDV extends EsquemaDYV {

	/**
	 * Variable privada que representa la subsecuencia problema
	 */
	private Problema problema;

	/**
	 * Variable privada que representa la subsecuencia solucion
	 */
	private Solucion solucion;

	/**
	 * Array privado que representa los enteros de la subsecuencia
	 */
	private int[] datosModelo;

	/**
	 * Varianble privada que representa la subsecuencia
	 */
	private Subsecuencia subsecuencia;

	/**
	 * Variable privada que representa el fin de la subsecuencia maxima
	 */
	private int secFin;

	/**
	 * Variable privada que representa el inicio de la subsecuencia maxima
	 */
	private int secIni;

	/**
	 * Variable privada que representa la suma maxima de la subsecuencia maxima
	 */
	private int sumaMax;

	/**
	 * Genera una SubsecuenciaRecDV en funcion de una objeto de tipo
	 * subsecuenciaProblema
	 * 
	 * @param subsecuenciaProblema
	 *            la subsecuencia a tratar
	 */
	public SubsecuenciaRecDV(Subsecuencia subsecuenciaProblema) {
		subsecuencia = subsecuenciaProblema;
		datosModelo = subsecuenciaProblema.datosModelo;
		problema = new ProblemaSubsecuencia(subsecuenciaProblema
				.getDatoModelo(), 0, subsecuenciaProblema.getNumElem() - 1);
	}

	/**
	 * Metodo de acceso para la propiedad secFin
	 * 
	 * @return secFin que representa el fin de la subsecuencia maxima
	 */
	public int getSecFin() {
		return secFin;
	}

	/**
	 * Metodo de acceso para la propiedad secini
	 * 
	 * @return secIni que representa el inicio de la subsecuencia maxima
	 */
	public int getSecIni() {
		return secIni;
	}

	/**
	 * Metodo de acceso para la propiedad sumaMax
	 * 
	 * @return sumaMax que representa la suma maxima de la subsecuencia maxima
	 */
	public int getSumaMax() {
		return sumaMax;
	}

	/**
	 * Metodo que comprueba si el transcurso del problema esta en un caso base o
	 * no
	 * 
	 * @param problema
	 *            el problema a tratar
	 *@return true si es caso base y false si no lo es
	 */
	protected boolean esCasoBase(Problema problema) {
		ProblemaSubsecuencia pro = (ProblemaSubsecuencia) problema;

		if (pro.getIzq() == pro.getDer()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo que devuelve la solucion del caso base
	 * 
	 * @param problema
	 *            el problema a tratar
	 * @return la solucion al problema tratado
	 */
	protected Solucion resuelveCasoBase(Problema problema) {
		ProblemaSubsecuencia pro = (ProblemaSubsecuencia) problema;
		SolucionSubsecuencia sol = new SolucionSubsecuencia(pro.getArray(), pro
				.getIzq(), pro.getDer());
		if (pro.getArray()[pro.getIzq()] > 0) {
			sol.setIzq(pro.getIzq());
			sol.setDer(pro.getDer());
			sol.setSumaMax(pro.getArray()[pro.getIzq()]);
			return sol;
		} else {
			sol.setIzq(0);
			sol.setDer(0);
			sol.setSumaMax(0);
			return sol;
		}
	}

	/**
	 * Metodo que divide el problema actual en 2 problemas de igual tamaño
	 * 
	 * @param problema
	 *            el problema a tratar
	 * @return array con los 2 problemas
	 */
	protected Problema[] divide(Problema problema) {
		ProblemaSubsecuencia pro = (ProblemaSubsecuencia) problema;
		ProblemaSubsecuencia[] pDiv = new ProblemaSubsecuencia[2];

		int centro = (pro.getIzq() + pro.getDer()) / 2;

		pDiv[0] = new ProblemaSubsecuencia(pro.getArray(), pro.getIzq(), centro);
		pDiv[1] = new ProblemaSubsecuencia(pro.getArray(), centro + 1, pro
				.getDer());
		return pDiv;
	}

	/**
	 * Metodo que que realiza la combinacion de las soluciones halladas en una
	 * sola
	 * 
	 * @param solucion
	 *            Array con las soluciones halladas
	 * @return devuelve la solucion al problema
	 */
	protected Solucion combina(Solucion[] solucion) {
		SolucionSubsecuencia solIzqDer = new SolucionSubsecuencia(datosModelo,
				0, datosModelo.length - 1);

		// Se obtienen los valores de las 2 subsoluciones
		int sumaMaxIzq = ((SolucionSubsecuencia) solucion[0]).getSumaMax();
		int sumaMaxDer = ((SolucionSubsecuencia) solucion[1]).getSumaMax();
		int izq = ((SolucionSubsecuencia) solucion[0]).getIzq();
		int der = ((SolucionSubsecuencia) solucion[1]).getDer();
		int centro = (izq + der) / 2;

		// Se comprueba la subsecuencia maxima que esta entre las 2 mitades
		int sumaMaxParteIzq = 0;
		int sumaParteIzq = 0;
		for (int i = centro; i >= izq; i--) {
			sumaParteIzq += subsecuencia.datosModelo[i];
			if (sumaParteIzq > sumaMaxParteIzq) {
				sumaMaxParteIzq = sumaParteIzq;
				solIzqDer.setIzq(i);
			}
		}

		int sumaMaxParteDer = 0;
		int sumaParteDer = 0;
		for (int i = centro + 1; i <= der; i++) {
			sumaParteDer += subsecuencia.datosModelo[i];
			if (sumaParteDer > sumaMaxParteDer) {
				sumaMaxParteDer = sumaParteDer;
				solIzqDer.setDer(i);
			}
		}

		int SumaMaxima = max3(sumaMaxIzq, sumaMaxDer, sumaMaxParteIzq
				+ sumaMaxParteDer);

		solIzqDer.setSumaMax(sumaParteIzq + sumaParteDer);
		// en funcion de que suma sea maxima se devuelve la solucion oportuna
		if (SumaMaxima == sumaMaxIzq) {
			return solucion[0];
		} else if (SumaMaxima == sumaMaxDer) {
			return solucion[1];
		} else {
			return solIzqDer;
		}
	}

	/**
	 * Metodo que devuelve el maximo de 3 enteros
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return el maximo de a, b ,c
	 */
	private static int max3(int a, int b, int c) {
		return a > b ? a > c ? a : c : b > c ? b : c;
	}

	/**
	 * Metodo que soluciona el problema y actualiza los valores para la solucion
	 */
	public void resolver() {

		solucion = dYV(problema);
		sumaMax = ((SolucionSubsecuencia) solucion).getSumaMax();
		secIni = ((SolucionSubsecuencia) solucion).getIzq();
		secFin = ((SolucionSubsecuencia) solucion).getDer();
	}
}
