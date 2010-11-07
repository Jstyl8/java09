package com.mio.estructurasdatos;

/**
 * Interfaz generica para las clases que crean un iterador.
 *
 */
public interface Iterable {
    /**
     * Obtiene un iterador sobre todos los valores.
     *
     * @return un iterador.
     */
    public Iterador iterador();
}
