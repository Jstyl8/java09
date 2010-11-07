//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 8, Ejercicio 3
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica8.ejercicio3;

import java.util.ArrayList;

/**
 * Clase que representa una imagen
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 23/05/2009
 */
public class Imagen {

	/**
	 * Variable privada de tipo String que representa el formato de la imagen
	 */
	private String formatoImagen;
	/**
	 * ArrayList privado que representa las bandas de la imagen
	 */
	private ArrayList bandas;
	/**
	 * Variable privada de tipo entero que representa el numero de lineas(filas)
	 * de la imagen
	 */
	private int lineas;
	/**
	 * Variable privada de tipo entero que representa el numero de columnas de
	 * la imagen
	 */
	private int columnas;

	/**
	 * Genera un objeto de tipo Imagen con parametros
	 * 
	 * @param lineas
	 *            el numero de lineas de la imagen
	 * @param columnas
	 *            el numero de columnas de la imagen
	 * @param formatoImagen
	 *            el formato de la imagen
	 */
	public Imagen(int lineas, int columnas, String formatoImagen) {
		this.lineas = lineas;
		this.columnas = columnas;
		this.formatoImagen = formatoImagen;
		bandas = new ArrayList();
	}

	/**
	 * Metodo de acceso para la propiedad formatoImagen
	 * 
	 * @return el formato de Imagen
	 */
	public String getFormatoImagen() {
		return formatoImagen;
	}

	/**
	 * Metodo modificador para la propiedad formatoImagen
	 * 
	 * @param formatoImagen
	 *            el formato de Imagen a poner
	 */
	public void setFormatoImagen(String formatoImagen) {
		this.formatoImagen = formatoImagen;
	}

	/**
	 * Metodo de acceso para la propiedad bandas
	 * 
	 * @return el ArrayList bandas
	 */
	public ArrayList getBandas() {
		return bandas;
	}

	/**
	 * Metodo modificador para la propiedad bandas
	 * 
	 * @param bandas
	 *            el ArrayList bandas a poner
	 */
	public void setBandas(ArrayList bandas) {
		this.bandas = bandas;
	}

	/**
	 * Metodo de acceso para la propiedad lineas
	 * 
	 * @return el numero de lineas
	 */
	public int getLineas() {
		return lineas;
	}

	/**
	 * Metodo modificador para la propiedad lineas
	 * 
	 * @param lineas
	 *            el numero de lineas a poner
	 */
	public void setLineas(int lineas) {
		this.lineas = lineas;
	}

	/**
	 * Metodo de acceso para la propiedad columnas
	 * 
	 * @return el numero de columnas
	 */
	public int getColumnas() {
		return columnas;
	}

	/**
	 * Metodo modificador para la propiedad columnas
	 * 
	 * @param columnas
	 *            el numero de columnas a poner
	 */
	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	/**
	 * Metodo de acceso al numero de bandas
	 * 
	 * @return el numero de bandas
	 */
	public int getNumeroBandas() {
		return bandas.size();

	}

	/**
	 * Metodo de acceso a una banda del ArrayList bandas
	 * 
	 * @param i
	 *            la posicion de la banda a obtener
	 * @return la BandaInt en la posicion i del arrayList
	 */
	public BandaInt getBanda(int i) {
		return (BandaInt) bandas.get(i);
	}

	/**
	 * Metodo que añade una banda al ArrayList bandas
	 * 
	 * @param banda
	 *            la BandaInt a poner
	 */
	public void añadirBanda(BandaInt banda) {
		bandas.add(banda);
	}

	/**
	 * Metodo que elimina la banda en la posicion i del ArrayList bandas
	 * 
	 * @param i
	 *            la posicion de la banda a quitar
	 */
	public void eliminarBanda(int i) {
		bandas.remove(i);
	}

	/**
	 * Metodo que realiza una extraccion de una parte de una imagen
	 * 
	 * @param x1
	 *            coordenada x primera
	 * @param y1
	 *            coordenada y primera
	 * @param x2
	 *            coordenada x segunda
	 * @param y2
	 *            coordenada y segunda
	 * @return la imagen entre las coordenadas dadas
	 * @throws XYFueraImagenException
	 *             si se da un rango no valido
	 */
	public Imagen extraerImagen(int x1, int y1, int x2, int y2)
			throws XYFueraImagenException {
		if (!XYValida(x1, y1, x2, y2)) {
			throw new XYFueraImagenException("Rango de posicion no valido");
		}
		Imagen imagen = new Imagen(y2 - y1 + 1, x2 - x1 + 1, formatoImagen);
		imagen.bandas = this.bandas;
		return imagen;
	}

	/**
	 * Metodo que obtiene los valores del pixel x,y de las bandas
	 * 
	 * @param x
	 *            la fila x
	 * @param y
	 *            la columna y
	 * @return un array con los valores de los pixeles
	 * @throws XYFueraImagenException
	 *             si se produce un intento de acceder a pixel inexistente
	 */
	public int[] getDatosPixel(int x, int y) throws XYFueraImagenException {
		// (x >= lineas || x < 0) || (y >= columnas || y <0)
		if (!XYValida(x, y, x, y)) {
			throw new XYFueraImagenException("Pixel Inexistente");
		}
		int[] aux = new int[bandas.size()];
		for (int i = 0; i < bandas.size(); i++) {
			aux[i] = ((BandaInt) (bandas.get(i))).getDatoXY(x, y);
		}
		return aux;
	}

	/**
	 * Metodo que comprueba si una posicion XY es valida
	 * 
	 * @param x1
	 *            la fila de inicio
	 * @param y1
	 *            la columna de inicio
	 * @param x2
	 *            la fila final
	 * @param y2
	 *            la columna final
	 * @return true si es valida y false en caso contrario
	 * 
	 */
	private boolean XYValida(int x1, int y1, int x2, int y2) {
		if (((x1 < 0 || x1 >= lineas) || (y1 < 0 || y1 >= columnas))
				|| ((x2 < 0 || x2 >= lineas) || (y2 < 0 || y2 >= columnas))) {
			return false;
		} else {
			return true;
		}
	}
}
