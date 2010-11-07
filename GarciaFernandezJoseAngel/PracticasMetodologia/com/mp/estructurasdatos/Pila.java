package com.mp.estructurasdatos;

import com.mp.excepciones.DesbordamientoInferiorException;

// Interfaz Pila
// *********************** OPERACIONES PUBLICAS **********************
// void apilar(x)         -> Inserta x
// void desapilar()       -> Elimina el ultimo elmento insertado
// Object cima()          -> Devuelve el ultimo elmento insertado
// Object cimaYDespilar() -> Devuelve y elimina elemento mas reciente
// boolean esVacia()      -> Devuelve true si pila vacia, sino false
// void vaciar()          -> Elimina todos los elementos
// int tamaño()			  -> Devuelve el tamaño de la pila
// ******************************************************************* 
// ERRORES: cima, desapilar o cimaYDesapilar sobre pila vacia

public interface Pila {
    /**
     * Comprueba si la pila esta vacia
     * 
     * @return true si pila vacia, sino false
     */
    boolean esVacia();

    /**
     * Obtiene el elemento mas recientemente insertado en pila No altera pila
     * 
     * @return el elemento mas recientemente insertado
     * @exception DesbordamientoInferiorException
     *                si la pila esta vacia
     */
    Object cima() throws DesbordamientoInferiorException;

    /**
     * Elimina el elemnto mas recientemente insertado
     * 
     * @exception DesbordamientoInferiorException
     *                si la pila esta vacia
     */

    void desapilar() throws DesbordamientoInferiorException;

    /**
     * Devuelve y elimina el elemento mas recientemente inserta en pila
     * 
     * @return elemento insertado
     * @exception DesbordamientoInferiorException
     *                si la pila esta vacia
     */
    Object cimaYDesapilar() throws DesbordamientoInferiorException;

    /**
     * Inserta un elemento nuevo en la pila
     * 
     * @param x
     *            el elmento a insertar
     */
    void apilar(Object x);

    /**
     * pone pila logicamente a vacio
     */
    void vaciar();

    /**
     * Devuelve el tamaño de la pila
     */
    int tamaño();
}
