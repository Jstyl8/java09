/**
 * 
 */
package borrado;

import java.io.File;

/**
 * Clase que contiene metodos utiles para el borrado
 * 
 * @author Jstyl_8
 * 
 */
public class UtilidadBorrado {

	private File archivo;

	private boolean subdirs;

	/**
	 * @return the archivo
	 */
	public File getArchivo() {
		return archivo;
	}

	/**
	 * @param archivo
	 *            the archivo to set
	 */
	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}

	/**
	 * @param subdirs
	 *            the subdirs to set
	 */
	public void setSubdirs(boolean subdirs) {
		this.subdirs = subdirs;
	}

	/**
	 * @return the subdirs
	 */
	public boolean isSubdirs() {
		return subdirs;
	}

	public UtilidadBorrado(File archivo) {
		this.archivo = archivo;
		subdirs = false;
	}

	public void deleteFilesSubDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				deleteFilesSubDir(new File(dir, children[i]));
			}
		} else {
			dir.delete();
		}
	}

	public void deleteFilesPatronDir(File dir, String patron)
			throws ArchivoNoBorradoException {
		if (dir.isDirectory() && dir.list().length != 0) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				if ((children[i].indexOf(patron)) != -1) {
					File a = new File(dir, children[i]);
					a.delete();
				}
			}
		} else {
			throw new ArchivoNoBorradoException(
					"No es directorio/No existe/Es vacio");
		}
	}

	public void deleteFilesDir(File dir) throws ArchivoNoBorradoException {
		if (dir.isDirectory() && dir.list().length != 0) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				File a = new File(dir, children[i]);
				a.delete();
			}
		} else {
			throw new ArchivoNoBorradoException(
					"No es directorio/No existe/Es vacio");
		}
	}

	public void deleteFilesPatronAll(File dir, String patron) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				deleteFilesPatronAll(new File(dir, children[i]), patron);
			}
		} else {
			if ((dir.getName().indexOf(patron)) != -1) {
				dir.delete();
			}
		}
	}

	public boolean deleteFile() throws ArchivoNoBorradoException {
		if (archivo.isFile()) {
			return archivo.delete();
		} else {
			throw new ArchivoNoBorradoException("No es archivo/No existe");
		}
	}
}
