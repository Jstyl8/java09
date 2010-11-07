//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 5, Ejercicio 4
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica5.ejercicio4;

/**
 * Clase que extiende de EsquemaDYV y se usa para resolver la ordenacion
 * MergeSort
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 24/04/2009
 */
public class MergeSortDYV extends EsquemaDYV {

	/**
	 * Variable privada que representa el problema
	 */
	private Problema problema;

	/**
	 * Variable privada que representa la solucion
	 */
	private Solucion solucion;

	/**
	 * Array privado de elementos comparables usado como auxiliar
	 */
	private Comparable[] vector;

	/**
	 * Variable privada de tipo VectorComparables
	 */
	private VectorComparables mergeSort;

	/**
	 * Genera un objeto de tipo MergeSortDYV con parametros
	 * 
	 * @param mergesort
	 *            la subsecuencia a tratar
	 */
	public MergeSortDYV(VectorComparables mergesort) {
		this.mergeSort = mergesort;
		vector = new Comparable[mergesort.getNumElementos()];
		problema = new ProblemaMergeSort(mergesort.getVector(), 0, mergesort
				.getNumElementos() - 1);
	}

	/**
	 * Metodo de acceso para la propiedad solucion
	 * 
	 * @return la solucion del problema
	 */
	public Solucion getSolucion() {
		return solucion;
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
		ProblemaMergeSort pro = (ProblemaMergeSort) problema;
		// caso base un solo elemento
		if (pro.getIzq() < pro.getDer()) {
			return false;
		} else {
			return true;
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
		ProblemaMergeSort pro = (ProblemaMergeSort) problema;
		SolucionMergeSort sol = new SolucionMergeSort(pro.getVector(), pro
				.getIzq(), pro.getDer());

		return sol;

	}

	/**
	 * Metodo que divide el problema actual en 2 problemas de igual tamaño
	 * 
	 * @param problema
	 *            el problema a tratar
	 * @return array con los 2 subproblemas
	 */
	protected Problema[] divide(Problema problema) {
		ProblemaMergeSort pro = (ProblemaMergeSort) problema;
		ProblemaMergeSort[] pDiv = new ProblemaMergeSort[2];

		int centro = (pro.getIzq() + pro.getDer()) / 2;

		pDiv[0] = new ProblemaMergeSort(pro.getVector(), pro.getIzq(), centro);
		pDiv[1] = new ProblemaMergeSort(pro.getVector(), centro + 1, pro
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

		SolucionMergeSort sol0 = (SolucionMergeSort) solucion[0];
		SolucionMergeSort sol1 = (SolucionMergeSort) solucion[1];

		// se obtienen los valores de las posiciones
		int posIzq = sol0.getIzq();
		int posDer = sol1.getIzq();
		int posFin = sol1.getDer();
		int finIzq = posDer - 1;
		int posAux = posIzq;
		int numElementos = posFin - posIzq + 1;

		// Bucle Principal
		while (posIzq <= finIzq && posDer <= posFin)
			if (mergeSort.getVector()[posIzq]
					.compareTo(mergeSort.getVector()[posDer]) <= 0)
				vector[posAux++] = mergeSort.getVector()[posIzq++];
			else
				vector[posAux++] = mergeSort.getVector()[posDer++];

		// Copia el resto de la primera mitad
		while (posIzq <= finIzq)
			vector[posAux++] = mergeSort.getVector()[posIzq++];

		// Copia el resto de la segunda mitad
		while (posDer <= posFin)
			vector[posAux++] = mergeSort.getVector()[posDer++];

		// Copia el array auxiliar en el original
		for (int i = 0; i < numElementos; i++, posFin--)
			mergeSort.getVector()[posFin] = vector[posFin];

		// Crea la solucion
		SolucionMergeSort solFinal = new SolucionMergeSort(mergeSort
				.getVector(), sol0.getIzq(), sol1.getDer());

		return solFinal;

	}

	/**
	 * Metodo que soluciona el problema
	 */
	public void resuelve() {

		solucion = dYV(problema);
	}

}
