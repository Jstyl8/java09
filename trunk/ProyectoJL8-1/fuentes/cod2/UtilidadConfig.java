package cod2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que contiene utilidades para trabajar con configs del cod2
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.2 14/06/2009
 */
public class UtilidadConfig {

	private static final String[] noValidos = { "toggle ", "wait", "vstr",
			"exec" };
	private static final String[] dirValidos = { "main", "miles", "pb", "Docs" };

	private ArrayList direcValidos;

	private ArrayList ilegales;

	private ArrayList lineas;

	private ArrayList size;

	private int nLinea;

	private long sizeDir;

	private File config;

	private ArrayList configLimpia;

	/**
	 * Genera un objeto de tipo UtilidadConfig a partir de un fichero config
	 * 
	 * @param config
	 *            la config con la que trabajar
	 */
	public UtilidadConfig(File config) {
		this.config = config;
		ilegales = new ArrayList();
		configLimpia = new ArrayList();
		lineas = new ArrayList();
		size = new ArrayList();
		direcValidos = new ArrayList();
		for (int i = 0; i < dirValidos.length; i++) {
			direcValidos.add(dirValidos[i]);
		}
		nLinea = 0;
		sizeDir = 0;
	}

	/**
	 * Metodo de acceso para la propiedad direcValidos
	 * 
	 * @return el direcValidos
	 */
	public ArrayList getDirecValidos() {
		return direcValidos;
	}

	/**
	 * Metodo modificador para la propiedad direcValidos
	 * 
	 * @param direcValidos
	 *            el direcValidos a poner
	 */
	public void setDirecValidos(ArrayList direcValidos) {
		this.direcValidos = direcValidos;
	}

	/**
	 * Metodo de acceso para la propiedad ilegales
	 * 
	 * @return el ilegales
	 */
	public ArrayList getIlegales() {
		return ilegales;
	}

	/**
	 * Metodo modificador para la propiedad ilegales
	 * 
	 * @param ilegales
	 *            el ilegales a poner
	 */
	public void setIlegales(ArrayList ilegales) {
		this.ilegales = ilegales;
	}

	/**
	 * Metodo de acceso para la propiedad lineas
	 * 
	 * @return el lineas
	 */
	public ArrayList getLineas() {
		return lineas;
	}

	/**
	 * Metodo modificador para la propiedad lineas
	 * 
	 * @param lineas
	 *            el lineas a poner
	 */
	public void setLineas(ArrayList lineas) {
		this.lineas = lineas;
	}

	/**
	 * Metodo de acceso para la propiedad size
	 * 
	 * @return el size
	 */
	public ArrayList getSize() {
		return size;
	}

	/**
	 * Metodo modificador para la propiedad size
	 * 
	 * @param size
	 *            el size a poner
	 */
	public void setSize(ArrayList size) {
		this.size = size;
	}

	/**
	 * Metodo de acceso para la propiedad nLinea
	 * 
	 * @return el nLinea
	 */
	public int getNLinea() {
		return nLinea;
	}

	/**
	 * Metodo modificador para la propiedad nLinea
	 * 
	 * @param linea
	 *            el nLinea a poner
	 */
	public void setNLinea(int linea) {
		nLinea = linea;
	}

	/**
	 * Metodo de acceso para la propiedad sizeDir
	 * 
	 * @return el sizeDir
	 */
	public long getSizeDir() {
		return sizeDir;
	}

	/**
	 * Metodo modificador para la propiedad sizeDir
	 * 
	 * @param sizeDir
	 *            el sizeDir a poner
	 */
	public void setSizeDir(long sizeDir) {
		this.sizeDir = sizeDir;
	}

	/**
	 * Metodo de acceso para la propiedad config
	 * 
	 * @return el config
	 */
	public File getConfig() {
		return config;
	}

	/**
	 * Metodo modificador para la propiedad config
	 * 
	 * @param config
	 *            el config a poner
	 */
	public void setConfig(File config) {
		this.config = config;
	}

	/**
	 * Metodo de acceso para la propiedad configLimpia
	 * 
	 * @return el configLimpia
	 */
	public ArrayList getConfigLimpia() {
		return configLimpia;
	}

	/**
	 * Metodo modificador para la propiedad configLimpia
	 * 
	 * @param configLimpia
	 *            el configLimpia a poner
	 */
	public void setConfigLimpia(ArrayList configLimpia) {
		this.configLimpia = configLimpia;
	}

	/**
	 * Metodo de acceso para la propiedad noValidos
	 * 
	 * @return el noValidos
	 */
	public static String[] getNoValidos() {
		return noValidos;
	}

	/**
	 * Metodo de acceso para la propiedad dirValidos
	 * 
	 * @return el dirValidos
	 */
	public static String[] getDirValidos() {
		return dirValidos;
	}

	/**
	 * Metodo que realiza un analisis de la config de entrada
	 * 
	 * @param config
	 *            la config a analizar
	 * @return devuelve un arrayList con los binds ilegales
	 */
	public ArrayList analizarConfig(File config) {
		try {
			ilegales.clear();
			configLimpia.clear();
			BufferedReader in = new BufferedReader(new FileReader(config));

			String str;
			boolean añadida = false;
			while ((str = in.readLine()) != null) {

				for (int i = 0; i < noValidos.length && !añadida; i++) {
					if (str.lastIndexOf(noValidos[i]) != -1) {
						if ((str.lastIndexOf("cl_paused") == -1)) {
							ilegales.add(str);
							añadida = true;
							lineas.add(nLinea);
						}
					}
				}
				if (!añadida) {
					configLimpia.add(str);
				}
				añadida = false;
				nLinea++;
			}
			in.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (ArrayList) ilegales.clone();
	}

	/**
	 * Metodo que genera una config limpia en una ruta especifica
	 * 
	 * @param ruta
	 *            la ruta donde se generara la config
	 */
	public void generarConfig(String ruta) {
		try {
			ruta += File.separator + "config_mp-Limpia.cfg";
			PrintWriter pw = new PrintWriter(new FileWriter(ruta));
			Iterator i = configLimpia.iterator();
			while (i.hasNext()) {
				pw.println((String) i.next());
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que analiza los directorios del directorio raiz del cod2
	 * 
	 * @param ruta
	 *            debe ser el directorio raiz del cod2
	 * @return un arraylist con los directorios ilegales
	 */
	public ArrayList analizarDirectorios(String ruta) {
		ilegales.clear();
		size.clear();
		File directorio = new File(ruta);
		String[] dir = directorio.list();
		for (int i = 0; i < dir.length; i++) {
			File a = new File(ruta + File.separator + dir[i]);
			if (a.isDirectory() && !direcValidos.contains(dir[i])) {
				size.add(sizeDir(a));
				ilegales.add(dir[i]);
				sizeDir = 0;
			}
		}
		return (ArrayList) ilegales.clone();
	}

	/**
	 * Metodo que borra todos los directorios no validos del directorio raiz de
	 * cod2
	 * 
	 * @param ruta
	 *            la ruta raiz del cod2
	 * @throws DirectorioNoBorradoException
	 *             si se produce algun problema al borrar
	 */
	public void limpiarDirectorios(String ruta)
			throws DirectorioNoBorradoException {
		Iterator i = ilegales.iterator();
		while (i.hasNext()) {
			File a = new File(ruta + File.separator + i.next());
			boolean exito = deleteDir(a);
			if (!exito)
				throw new DirectorioNoBorradoException("Problema al borrar" + a);
		}
	}

	/**
	 * Metodo que realiza un analisis del directorio main en busca de .cfg
	 * ilegales
	 * 
	 * @param ruta
	 *            la ruta de main
	 * @return un arraylist con los .cfg ilegales
	 */
	public ArrayList analizarMain(String ruta) {
		ilegales.clear();
		size.clear();
		File a = new File(ruta);
		String[] dir = a.list();
		for (int i = 0; i < dir.length; i++) {
			if (dir[i].lastIndexOf(".cfg") != -1) {
				ilegales.add(dir[i]);
				size.add(sizeDir(new File(ruta + File.separator + dir[i])));
				sizeDir = 0;
			}
		}
		return (ArrayList) ilegales.clone();
	}

	/**
	 * Metodo que borra las .cfg ilegales que se encuentren en main
	 * 
	 * @param ruta
	 *            la ruta de main
	 * @throws DirectorioNoBorradoException
	 *             si se produce un error al borrar
	 */
	public void limpiarMain(String ruta) throws DirectorioNoBorradoException {
		Iterator i = ilegales.iterator();
		while (i.hasNext()) {
			File a = new File(ruta + File.separator + i.next());
			boolean exito = a.delete();
			if (!exito)
				throw new DirectorioNoBorradoException("Problema al borrar" + a);
		}
	}

	private long sizeDir(File dir) {
		sizeDir += dir.length();
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				sizeDir(new File(dir, children[i]));
			}
		}
		return sizeDir;

	}

	private static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		// The directory is now empty so delete it
		return dir.delete();
	}
}
