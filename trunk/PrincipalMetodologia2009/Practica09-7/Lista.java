package com.mp.practica7.ejercicio5;

/**
 * Una interfaz generica para las listas.
 *
 */
public interface Lista extends Iterable {
    /**
     * Inserta un valor en la lista en la posicion dada. El tamaño de la lista se incrementa en uno.
     *
     * @param indice La posición (0, 1, 2...) en la que debe insertarse.
     * @param valor El valor a añadir.
     * @throws IndexOutOfBoundsException si la posicion especificada cae fuera del rango.
     *                                   
     */
    public void insertar(int indice, Object valor) throws IndexOutOfBoundsException;

    /**
     * Añade un valor al final de la lista. El tamaño de la lista se incrementa en uno.
     *
     * @param valor del El valor que se añade.
     */
    public void añadir(Object valor);

    /**
     * Elimina el valor de una posición dada en la lista. El tamaño se decrementa en uno.
     *
     * @param indice La posición (0, 1, 2...) en la cual se va a eliminar.
     * @return El valor contenido en la posición especificada.
     * @throws IndexOutOfBoundsException si la posición esta fuera del rango.
     *                                  
     */
    public Object eliminar(int indice) throws IndexOutOfBoundsException;

    /**
     * Elimina la primera ocurrencia de un valor especificado. El tamaño de la lista decrece en uno si es encontrado
     * 
     *
     * @param value El valor a eliminar.
     * @return <code>true</code> si es eliminado; en otro caso <code>false</code> si no es encontrado.
     */
    public boolean eliminar(Object valor);

    /**
     * Elimina todos los elementos de la lista. El tamaño de la lista se reposiciona en 0.
     */
    public void vaciar();

    /**
     * Coloca el valor en una posicion determinada en la lista.
     *
     * @param indice La posición (0, 1, 2...) de la que se debe obtener el valor.
     * @param valor El valor a colocar en la posición especificada.
     * @return El valor original de la posición especificada.
     * @throws IndexOutOfBoundsException si la posicion especificada cae fuera del rango.
     *                                   
     */
    public Object set(int indice, Object valor) throws IndexOutOfBoundsException;

    /**
     * Obtiene el valor de una posición especificada de la lista.
     *
     * @param indice La posición (0, 1, 2...) de la que se debe obtener el valor.
     * @return El valor de la posición especificada.
     * @throws IndexOutOfBoundsException si la posicion especificada cae fuera del rango.
     *                                   
     */
    public Object get(int indice) throws IndexOutOfBoundsException;

    /**
     * Obtiene la posición de la primera ocurrencia de un valor especificado dentro de la lista.
     *
     * @param valor El valor situado en el indice requerido.
     * @return La posición (0, 1, 2...) de la primera ocurrencia del valor; en otro caso -1.
     */
    public int indiceDe(Object valor);

    /**
     * Determina si la lista contiene un valor especifico.
     *
     * @param valor El valor que se busca.
     * @return true si es encontrado; otro caso false.
     */
    public boolean contiene(Object valor);

    /**
     * Obtiene el número de elementos de la lista.
     *
     * @return El número de elementos de la lista.
     */
    public int tamaño();

    /**
     * Determina si la lista esta o no vacia.
     *
     * @return true si la lista esta vacia (tamaño() == 0); en otro caso false.
     */
    public boolean esVacia();
}
