//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 8, Ejercicio 3
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica8.ejercicio3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Clase usada para realizar operaciones de I/O con imagenes
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 23/05/2009
 */
public class ImagenDAO {

	/**
	 * Metodo para leer una imagen a partir de un fichero
	 * 
	 * @param cabecera
	 *            la ruta donde se leera la imagen
	 * @return la imagen
	 */
	public static Imagen leerArchivo(String cabecera) {
		try {
			File c = new File(cabecera);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					new FileInputStream(c)));
			String str;
			ArrayList aux = new ArrayList();
			while ((str = in.readLine()) != null) {
				aux.add(str);
			}
			StringTokenizer tokens = new StringTokenizer((String) aux.get(3),
					"[];");
			Imagen imagen = new Imagen(Integer.parseInt(((String) aux.get(4))),
					Integer.parseInt(((String) aux.get(5))), (String) aux
							.get(1));
			String[] banda = new String[tokens.countTokens()];
			int i = 0;
			while (tokens.hasMoreElements()) {
				banda[i++] = tokens.nextToken();
			}
			in.close();
			String datpath = c.getParent() + File.separator
					+ (String) aux.get(0);

			return leerBSQ(datpath, imagen, banda);

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Metodo privado para la lectura de la informacion BSQ
	 * 
	 * @param nombreArchivo
	 *            el nombre y ruta del archivo
	 * @param imagen
	 *            la imagen a tratar
	 * @param nbandas
	 *            un array de String con el nombre de cada banda
	 * @return la imagen con los datos BSQ
	 * @throws IOException
	 *             si se produce un problema de lectura
	 */
	private static Imagen leerBSQ(String nombreArchivo, Imagen imagen,
			String[] nbandas) throws IOException {
		DataInputStream dis = new DataInputStream(new FileInputStream(
				nombreArchivo));
		for (int k = 0; k < nbandas.length; k++) {
			int[][] datos = new int[imagen.getLineas()][imagen.getColumnas()];
			for (int j = 0; j < imagen.getColumnas(); j++) {
				for (int i = 0; i < imagen.getLineas(); i++) {
					datos[i][j] = dis.readInt();
				}
			}
			imagen.getBandas().add(new BandaInt(nbandas[k], datos));
		}
		dis.close();
		return imagen;

	}

	/**
	 * Metodo que escribe el archivo en una ruta especifica
	 * 
	 * @param salida
	 *            la ruta donde se escribira el archivo
	 * @param imagen
	 *            la imagen a escribir
	 */
	public static void escribirArchivo(String salida, Imagen imagen) {
		try {
			File c = new File(salida);
			String datPath = salida.substring(0, salida.length() - 8) + "dat";
			File d = new File(datPath);
			PrintStream psc = new PrintStream(new FileOutputStream(c));
			psc.println(d.getName());
			psc.println(imagen.getFormatoImagen());
			psc.println(imagen.getNumeroBandas());
			StringBuffer aux = new StringBuffer("[");
			for (int i = 0; i < imagen.getNumeroBandas(); i++) {
				aux.append(((BandaInt) imagen.getBandas().get(i))
						.getNombreBanda()
						+ ";");
			}
			aux.setLength(aux.length() - 1);
			aux.append("]");
			psc.println(aux.toString());
			psc.println(imagen.getLineas());
			psc.println(imagen.getColumnas());
			psc.close();
			escribirBSQ(datPath, imagen);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo privado que escribe la informacion BSQ en un archivo
	 * 
	 * @param nombreArchivo
	 *            el nombre y ruta del archivo
	 * @param imagen
	 *            la imagen a tratar
	 * @throws IOException
	 *             si se produce algun error en la escritura
	 */
	private static void escribirBSQ(String nombreArchivo, Imagen imagen)
			throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(
				nombreArchivo));
		for (int k = 0; k < imagen.getNumeroBandas(); k++) {
			for (int j = 0; j < imagen.getColumnas(); j++) {
				for (int i = 0; i < imagen.getLineas(); i++) {
					dos.writeInt(((BandaInt) imagen.getBandas().get(k))
							.getDatoXY(i, j));
				}
			}
		}
		dos.close();
	}
}
