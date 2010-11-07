package com.mio.meto.DYV;

/**
 * @author Angel Nieto Lopez
 * @category Clase SubsecuenciaRecDYV derivada de EsquemaDYV
 */

public class SubsecuenciaRecDV extends EsquemaDYV {
	/**
	 * Variable privada que almacena el problema de la subsecuencia
	 */
	private Problema problema;

	/**
	 * Variable privada que almacena la solucion de la subsecuencia
	 */
	private Solucion solucion;

	/**
	 * Vector privado que almacena el vector de la subsecuencia que tiene
	 * elementos de tipo entero
	 */
	private int[] vector;

	/**
	 * Varianble privada que almacena un objeto subsecuencia
	 */
	private Subsecuencia subsecuencia;

	/**
	 * Variable privada de tipo entero que almacena el inicio de la subsecuencia
	 */
	private int secIni;

	/**
	 * Variable privada de tipo entero que almacena el fin de la subsecuencia
	 */
	private int secFin;

	/**
	 * Variable privada de tipo entero que almacena la suma maxima de la subsecuencia
	 */
	private int sumaMax;

	/**
	 * Metodo constructor que crea un objeto de tipo SubsecuenciaRecDYV
	 * en funcion de un objeto de tipo subsecuencia
	 *
	 * @param subsecuencia
	 *            Objeto de tipo subsecuencia
	 */
	public SubsecuenciaRecDV(Subsecuencia subsecuencia) {
		this.subsecuencia = subsecuencia;
		vector = subsecuencia.getSubsecuencia();
		problema = new ProblemaSubsecuencia(subsecuencia.getSubsecuencia(), 0,
				subsecuencia.getNumeroElementos() - 1);
	}

	/**
	 * Metodo que se encarga de evaluar si el problema es caso base o no lo es
	 *
	 * @param problema
	 *            Parametro que almacena un problema
	 * @return Valor de tipo booleano que almacena true si es caso base o false si no lo es
	 */
	protected boolean esCasoBase(Problema problema) {
		return ((ProblemaSubsecuencia) problema).getIzq() == ((ProblemaSubsecuencia) problema)
				.getDer();
	}

	/**
	 * Metodo que se encarga de implementar la interfaz problema y devuelve la solucion si es caso base
	 *
	 * @param problema
	 *             Parametro que almacena un problema
	 * @return la solucion al problema dado si es caso base
	 */
	protected Solucion resuelveCasoBase(Problema problema) {
		ProblemaSubsecuencia p = (ProblemaSubsecuencia) problema;
		SolucionSubsecuencia s = new SolucionSubsecuencia(p.getVector(), p
				.getIzq(), p.getDer());
		if (p.getElementoVector(p.getIzq()) > 0) {
			s.setSumaMax(p.getElementoVector(p.getIzq()));
			s.setIzq(p.getIzq());
			s.setDer(p.getDer());
			return s;
		} else {
			s.setSumaMax(0);
			s.setIzq(0);
			s.setDer(0);
			return s;
		}
	}

	/**
	 * Metodo que divide el problema en problemas mas pequeños
	 *
	 * @param problema
	 *            Parametro que almacena un problema
	 * @return vector con los distintos problemas
	 */
	protected Problema[] divide(Problema problema) {
		ProblemaSubsecuencia p = (ProblemaSubsecuencia) problema;
		ProblemaSubsecuencia[] pDividido = new ProblemaSubsecuencia[2];

		int centro = (p.getIzq() + p.getDer()) / 2;

		pDividido[0] = new ProblemaSubsecuencia(p.getVector(), p.getIzq(),
				centro);
		pDividido[1] = new ProblemaSubsecuencia(p.getVector(), centro + 1, p
				.getDer());
		return pDividido;
	}

	/**
	 * Metodo que combina las distintas soluciones de los problemas en una sola
	 *
	 * @param solucion
	 *            Vector que almacena soluciones
	 * @return devuelve una unica solucion
	 */
	protected Solucion combina(Solucion[] solucion) {

		SolucionSubsecuencia sCentro = new SolucionSubsecuencia(vector, 0,
				vector.length - 1);

		int sumaMaximaIzquierda = ((SolucionSubsecuencia) solucion[0])
				.getSumaMax();
		int sumaMaximaDerecha = ((SolucionSubsecuencia) solucion[1])
				.getSumaMax();
		int izquierda = ((SolucionSubsecuencia) solucion[0]).getIzq();
		int derecha = ((SolucionSubsecuencia) solucion[1]).getDer();
		int centro = (izquierda + derecha) / 2;

		int sumaMaximaLadoIzquierdo = 0;
		int sumaLadoIzquierdo = 0;
		for (int i = centro; i >= izquierda; i--) {
			sumaLadoIzquierdo = sumaLadoIzquierdo
					+ subsecuencia.getElementoSubsecuencia(i);

			if (sumaLadoIzquierdo > sumaMaximaLadoIzquierdo) {
				sumaMaximaLadoIzquierdo = sumaLadoIzquierdo;
				sCentro.setIzq(i);
			}
		}

		int sumaMaximaLadoDerecho = 0;
		int sumaLadoDerecho = 0;
		for (int i = centro + 1; i <= derecha; i++) {
			sumaLadoDerecho = sumaLadoDerecho
					+ subsecuencia.getElementoSubsecuencia(i);
			if (sumaLadoDerecho > sumaMaximaLadoDerecho) {
				sumaMaximaLadoDerecho = sumaLadoDerecho;
				sCentro.setDer(i);
			}
		}

		sCentro.setSumaMax(sumaMaximaLadoIzquierdo + sumaMaximaLadoDerecho);

		int maximo = Maximo(sumaMaximaIzquierda, sumaMaximaDerecha, sCentro
				.getSumaMax());

		if (maximo == sumaMaximaIzquierda)
			return solucion[0];
		else if (maximo == sumaMaximaDerecha)
			return solucion[1];
		else
			return sCentro;
	}

	/**
	 * Metodo privado para obtener el maximo de tres valores
	 *
	 * @param a
	 *            Parametro de tipo entero
	 * @param b
	 *            Parametro de tipo entero
	 * @param c
	 *            Parametro de tipo entero
	 * @return Valor de tipo entero que es el maximo de los tres valores
	 */
	private static int Maximo(int a, int b, int c) {
		int max;
		if (a > b) {
			max = a;
		} else {
			max = b;
		}
		if (c > max) {
			max = c;
		}
		return max;
	}

	/**
	 * Metodo inicial de llamada
	 */
	public void resolver() {
		solucion = dYV(problema);

		sumaMax = ((SolucionSubsecuencia) solucion).getSumaMax();
		secIni = ((SolucionSubsecuencia) solucion).getIzq();
		secFin = ((SolucionSubsecuencia) solucion).getDer();

	}

	/**
	 * Metodo que devuelve la posicion final de las subsecuencia
	 *
	 * @return Valor de tipo entero que almacena la posicion final
	 */
	public int getSecFin() {
		return secFin;
	}

	/**
	 * Metodo que devuelve la posicion inicial de las subsecuencia
	 *
	 * @return Valor de tipo entero que almacena la posicion inicial
	 */
	public int getSecIni() {
		return secIni;
	}

	/**
	 * Metodo que devuelve la suma maxima
	 *
	 * @return Valor de tipo entero que almacena la suma maxima
	 */
	public int getSumaMax() {
		return sumaMax;
	}
}
