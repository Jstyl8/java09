/**
 * EsquemaVZ.java
 */
package com.mp.practica6.ejercicio2;

/**
 * Contiene el esquema para la resoluci�n de problemas utilizando el esquema
 * voraz propuesto en teor�a. Es una clase abstracta.
 * 
 * @version 1.0, 
 */

public abstract class EsquemaVZ {
    /**
     * el m�todo <code>resuelve</code> contiene el esquema voraz
     */
    public void resuelve() {
        inicializa();

        while (!fin()) {
            seleccionaYElimina();
            if (prometedor())
                anotaEnSolucion();
        }
    }

    abstract protected void inicializa();

    abstract protected boolean fin();

    abstract protected void seleccionaYElimina();

    abstract protected boolean prometedor();

    abstract protected void anotaEnSolucion();
}