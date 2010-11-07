//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 8, Ejercicio 1
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica8.ejercicio1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Clase que contiene utilidades para trabajar con ficheros y directorios
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 22/05/2009
 */
public class UtilidadDirectorios {

	/**
	 * Arraylist usado para guardar los directorios y archivos
	 */
	ArrayList aux;

	/**
	 * Genera un objeto de tipo UtilidadDirectorios
	 */
	public UtilidadDirectorios() {
		aux = new ArrayList();
		aux.clear();
	}

	/**
	 * Metodo que realiza un listado con todos los subdirectorios y archivos de
	 * un directorio dado
	 * 
	 * @param dir
	 *            el directorio a listar
	 * @return un ArrayList con todos los directorios
	 */
	public ArrayList listarDA(File dir) {
		aux.add(dir);
		if (dir.isDirectory()) {
			String[] subdirectorios = dir.list();
			for (int i = 0; i < subdirectorios.length; i++) {
				listarDA(new File(dir, subdirectorios[i]));
			}
		}
		return aux;
	}

	/**
	 * Genera un fichero zip con un nombre especifico en un directorio de salida
	 * a partir de un directorio origen
	 * 
	 * @param dir
	 *            el directorio origen a recorrer
	 * @param salida
	 *            el directorio donde se guardara el zip
	 * @param nombreFichero
	 *            el nombre del fichero
	 * @throws FileNotFoundException
	 */
	public void zip(File dir, String salida, String nombreFichero) {

		// Crea un buffer para leer los archivos
		byte[] buf = new byte[1024];

		try {

			// Crea el archivo zip
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
					salida + File.separator + nombreFichero));
			listarDA(dir);
			// Comprime el archivo
			for (Iterator iter = aux.iterator(); iter.hasNext();) {
				File archivo = (File) iter.next();
				if (archivo.isDirectory()) {
					continue;
				}
				FileInputStream in = new FileInputStream(archivo.getPath());

				// Añade el ZipEntry al outputStream
				out.putNextEntry(new ZipEntry(archivo.getPath()));

				// Transfiere los datos del archivo al Zip
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}

				// Completa la entrada
				out.closeEntry();
				in.close();
			}
			// Completa el archivo zip
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
