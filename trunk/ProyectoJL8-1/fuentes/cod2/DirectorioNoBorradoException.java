package cod2;

import java.io.IOException;

/**
 * Excepcion provocada por un error de borrado
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 14/06/2009
 */
public class DirectorioNoBorradoException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1996806672787210803L;

	/**
	 * Genera un objeto de tipo DirectorioNoBorradoException usando el
	 * constructor de su superclase
	 * 
	 * @param a
	 *            la explicacion del error
	 */
	public DirectorioNoBorradoException(String a) {
		super(a);

	}

}
