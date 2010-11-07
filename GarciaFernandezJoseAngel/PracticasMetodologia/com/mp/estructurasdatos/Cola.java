package com.mp.estructurasdatos;

// Interfaz Cola
//
// CONSTRUCCION: sin ninguna inicialización
//
// ******************OPERACIONES PUBLICAS**************************************
// void insertar( x ) 		--> Inserta x
// Object primero( ) 		--> Devuelve el último elemento insertado
// Object quitarPrimero( ) 	--> Devuelve y elimina el último elemento insertado
// boolean esVacia( ) 		--> Devuelve true if empty; sino false
// void vaciar( ) 			--> Elimina todos los elementos
// int tamaño()				--> Devuelve el tamaño de la cola
// ******************ERRORES***************************************************
// primero o quitarPrimero en una cola vacia
import com.mp.excepciones.DesbordamientoInferiorException;

public interface Cola {
    /**
     * Comprueba si la cola esta lógicamente vacia.
     * 
     * @return true si esta vacia, sino false.
     */
    boolean esVacia();

    /**
     * Devuelve el elemento insertado primero en la cola. No altera la cola.
     * 
     * @return Devuelve el elemento insertado primero en la cola.
     * @exception DesbordamientoInferiorException
     *                si la cola es vacia.
     */
    Object primero() throws DesbordamientoInferiorException;

    /**
     * Devuelve y elimina el elemento insertado primero en la cola. No altera la
     * cola.
     * 
     * @return Devuelve el elemento insertado primero en la cola.
     * @exception DesbordamientoInferiorException
     *                si la cola es vacia.
     */
    Object quitarPrimero() throws DesbordamientoInferiorException;

    /**
     * Inserta un elemento nuevo en la cola.
     * 
     * @param x
     *            el elemento a insertar.
     */
    void insertar(Object x);

    /**
     * Hace la cola vacia logicamente.
     */
    void vaciar();

    /**
     * Devuelve el tamaño de la cola
     */
    int tamaño();
}
