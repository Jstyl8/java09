package com.mio.estructurasdatos;

import com.mio.excepciones.IteradorFueraLimitesException;

/**
 * Iterador 
 *
 */
public interface Iterador {
    /**
     * Posiciona en el primer elemento.
     *
     */
    public void primero();

    /**
     * Posiciona en el último elemento.
     *
     */
    public void ultimo();

    /**
     * Comprueba que el iterador referencia un elemento.
     *
     * @return true si referencia a un elemento; en otro caso false.
     */
    public boolean estaDentro();

    /**
     * Posiciona en el siguiente elemento.
     *
     */
    public void siguiente();

    /**
     * Posiciona en el anterior elemento.
     *
     */
    public void anterior();

    /**
     * Obtiene el valor de elemento actual.
     *
     * @return El valor del elemento actual.
     * @throws FueraLimitesException si no hay elemento actual.
     */
    public Object actual() throws IteradorFueraLimitesException;
}
