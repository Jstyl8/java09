package com.mp.excepciones;

/**
 * Indica un intento de acceder a un elemento inferior inexistente
 */
public class DesbordamientoInferiorException extends Exception {
	/**
	 * Constructor para la excepcion.
	 * 
	 * @param error
	 *            inicializa con mensaje de la expecption
	 */
	public DesbordamientoInferiorException(String error) {
		super(error);
	}
}
