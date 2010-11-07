package com.mp.excepciones;
public class DesbordamientoInferiorException extends Exception
{
    /**
     * Constructor para la excepcion.
     * @param inicializa con mensaje de la expecption
     */
    public DesbordamientoInferiorException(String error)
    {
        super( error );
    }
}
