/**
 * EsquemaDyV.java
 */
package com.mp.practica5.ejercicio4;

/**
 * Contiene el esquema para la resolución de problemas utilizando el esquema DYV
 * propuesto en teoría. Es una clase abstracta.
 * 
 * @version 1.0
 */

public abstract class EsquemaDYV {
    /**
     * el método <code>resuelve</code> contiene el esquema DYV
     */
    protected Solucion dYV(Problema problema) {

        Problema[] subproblemas;
        Solucion[] subsoluciones;
        Solucion solucion;
        int a;

        if (esCasoBase(problema)) {
            solucion = resuelveCasoBase(problema);
        } else {
            subproblemas = divide(problema);
            a = subproblemas.length;
            subsoluciones = new Solucion[a];
            for (int i = 0; i < a; i++) {
                subsoluciones[i] = dYV(subproblemas[i]);
            }
            solucion = combina(subsoluciones);
        }
        return solucion;
    }

    abstract protected boolean esCasoBase(Problema problema);

    abstract protected Solucion resuelveCasoBase(Problema problema);

    abstract protected Problema[] divide(Problema problema);

    abstract protected Solucion combina(Solucion[] solucion);

}
