package com.mio.general.examen.ejer5.test;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mio.general.examen.ejer5.UtilidadDirectorios;

import junit.framework.TestCase;

public class UtilidadDirectoriosTest extends TestCase {

	private String mensaje;
	private String directorioEntrada;
	private List listaControl;

	public UtilidadDirectoriosTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		directorioEntrada = System.getProperty("user.dir");
		listaControl = new ArrayList();
	}

	public void testDirectoriosFicherosJava() throws IOException {

		// Comprueba que los .java del proyecto

		cargarArchivoControl("http://acacia.ual.es/metodologia2009/descargas/javas.txt");

		directorioEntrada = directorioEntrada + File.separator;

		File dir = new File(directorioEntrada);

		System.out.println("ReferenciaPracticas: ");
		System.out.println(dir.getAbsolutePath());

		UtilidadDirectorios directorios = new UtilidadDirectorios();
		ArrayList listado = directorios.listarDA(dir);
		ArrayList listadoFiltrado = new ArrayList();

		// System.out.println("Listado de los test: ");
		for (Iterator iter = listado.iterator(); iter.hasNext();) {
			File file = (File) iter.next();
			String salida = file.getAbsolutePath();
			if (salida.contains(".java") & !salida.contains("Test")
					& !salida.contains(".svn")) {
				// System.out.println(salida+";"+file.length());
				listadoFiltrado.add(salida);
			}
		}

		System.out.println("Listado de los Filtrados: ");
		for (Iterator iterator = listadoFiltrado.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}

		System.out.println("Listado de los test: ");
		for (Iterator iterator = listaControl.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}

		ArrayList listadoJavasNoEstan = new ArrayList();
		// System.err.println("Los test que han sido modificados aparecen en rojo: ");

		for (Iterator iterA = listaControl.iterator(); iterA.hasNext();) {

			String elemento = (String) iterA.next();
			boolean control = false;

			for (Iterator iter = listadoFiltrado.iterator(); iter.hasNext();) {
				String cadena = (String) iter.next();
				if (cadena.endsWith(elemento)) {
					control = true;
					break;
				}
			}

			if (control) {
				assertTrue(control);
				System.out.println(elemento);
			} else {
				assertFalse(control);
				// El siguiente test ha sido modificado, aparece en rojo:
				System.err.println(elemento);
				listadoJavasNoEstan.add(elemento);
			}
		}
		mensaje = "Algún fichero java no esta en su sitio";
		assertEquals(mensaje, 0, listadoJavasNoEstan.size());

	}

	public void testComprobarTests() {

		// Comprueba que los test no han sido modificados

		cargarArchivoControl("http://acacia.ual.es/metodologia2009/descargas/test.txt");

		directorioEntrada = directorioEntrada.substring(0, directorioEntrada
				.lastIndexOf(File.separator));

		directorioEntrada = directorioEntrada + File.separator
				+ "PracticasMetodologia2009" + File.separator;

		File dir = new File(directorioEntrada);

		UtilidadDirectorios directorios = new UtilidadDirectorios();

		ArrayList listado = directorios.listarDA(dir);

		ArrayList listadoFiltrado = new ArrayList();

		// System.out.println("Listado de los test: ");
		for (Iterator iter = listado.iterator(); iter.hasNext();) {

			File file = (File) iter.next();
			String salida = file.getAbsolutePath();
			if (salida.contains(".java") & salida.contains("Test")
					& !salida.contains(".svn")) {
				System.out.println(salida + ";" + file.length());
				listadoFiltrado.add(salida + ";" + file.length());
			}
		}

		ArrayList listadoTestModificados = new ArrayList();

		for (Iterator iterA = listaControl.iterator(); iterA.hasNext();) {

			String elemento = (String) iterA.next();
			boolean control = false;

			for (Iterator iter = listadoFiltrado.iterator(); iter.hasNext();) {
				String cadena = (String) iter.next();
				if (cadena.endsWith(elemento)) {
					control = true;
					break;
				}
			}

			if (control) {
				assertTrue(control);
				System.out.println(elemento);
			} else {
				assertFalse(control);
				// El siguiente test ha sido modificado, aparece en rojo:
				System.err.println(elemento);
				listadoTestModificados.add(elemento);
			}
		}
		mensaje = "Algún test ha sido modificado";
		assertEquals(mensaje, 0, listadoTestModificados.size());

	}

	public void testZip() {

		// Será creado en la carpeta por encima del proyecto
		// para no modificarlo incrementando su tamaño

		String directorioZip = directorioEntrada + File.separator
				+ "PracticasMetodologia" + File.separator;
		File directorio = new File(directorioZip);

		File directorioSalida = new File(directorioEntrada);
		String salida = directorioSalida.getParent();

		File fichero = new File(directorioEntrada);
		String nombreFichero = fichero.getName();
		nombreFichero = nombreFichero + ".zip";

		UtilidadDirectorios directorios = new UtilidadDirectorios();

		/* Directorio a recorrer; directorio de salida; nombre del archivo */
		directorios.zip(directorio, salida, nombreFichero);

		String control = salida + File.separator + nombreFichero;
		File archivoZip = new File(control);

		mensaje = "El zip ha sido creado y existe";
		assertTrue(mensaje, archivoZip.exists());
		mensaje = "Su tamaño debe ser mayor que 10000";
		assertTrue(mensaje, archivoZip.length() > 100000);

	}

	public void cargarArchivoControl(String direccion) {
		// método de utilidad que cargar ficheros desde una dirección URL.
		URL url = null;
		try {
			url = new URL(direccion);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		try {
			InputStream is = url.openStream();
			DataInputStream dis = new DataInputStream(is);

			String str;
			while ((str = dis.readLine()) != null) {
				listaControl.add(str);
			}
			is.close();
		} catch (IOException e) {
		}
	}

	public void testCopiarArchivo() {

		// Será creado en la carpeta por encima del proyecto
		// para no modificarlo incrementando su tamaño
		File aux = new File(directorioEntrada);
		File destino = new File(aux.getParent() + File.separator + "copia.txt");

		File origen = new File(directorioEntrada + File.separator
				+ "notasfinales.txt");
		UtilidadDirectorios directorios = new UtilidadDirectorios();

		directorios.copiar(origen, destino);

		String control = aux.getParent() + File.separator + "copia.txt";
		File archivoCopiado = new File(control);

		mensaje = "El archivo ha sido creado y existe";
		assertTrue(mensaje, archivoCopiado.exists());
		mensaje = "Su tamaño debe ser igual al original";
		assertTrue(mensaje, archivoCopiado.length() == origen.length());

	}
}
