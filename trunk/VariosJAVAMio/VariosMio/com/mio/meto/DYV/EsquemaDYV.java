/**
 * EsquemaDyV.java
 */
package com.mio.meto.DYV;

/**
 * Contiene el esquema para la resolución de problemas utilizando el esquema DYV
 * propuesto en teoría. Es una clase abstracta.
 * 
 * @version 1.0
 */

abstract public class EsquemaDYV {
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
