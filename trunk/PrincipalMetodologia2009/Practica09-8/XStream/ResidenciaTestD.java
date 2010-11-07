package com.mp.practica8.ejercicio4.test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mp.practica8.ejercicio4.Cuidador;
import com.mp.practica8.ejercicio4.Habitacion;
import com.mp.practica8.ejercicio4.Residencia;
import com.mp.practica8.ejercicio4.ResidenciaXML;
import com.mp.practica8.ejercicio4.Residente;
import com.mp.practica8.ejercicio4.ResidenciaDAO;

import junit.framework.TestCase;


public class ResidenciaTestD extends TestCase {

	String mensaje;
	String directorioEntrada;

	Residencia residencia;

	Cuidador cuidador1;

	Cuidador cuidador2;

	Cuidador cuidador3;

	Habitacion habitacion1;

	Habitacion habitacion2;

	Habitacion habitacion3;

	Habitacion habitacion4;

	Habitacion habitacion5;

	Habitacion habitacion6;

	Habitacion habitacion7;

	Habitacion habitacion8;

	Habitacion habitacion9;

	Residente residente1;

	Residente residente2;

	Residente residente3;

	Residente residente4;

	SimpleDateFormat dateFormat;


	protected void setUp() throws Exception {
		super.setUp();
		directorioEntrada = System.getProperty("user.dir");
	}

	 public void testEscribir() throws IOException, ParseException {

		cuidador1 = new Cuidador("Martinez Martinez, Juan", "27272727");
		cuidador2 = new Cuidador("Lopez Segura, Ana", "26262628");
		cuidador3 = new Cuidador("Marquez Lopez, Anabel", "26262629");

		habitacion1 = new Habitacion("101");
		habitacion2 = new Habitacion("102");
		habitacion3 = new Habitacion("103");
		habitacion4 = new Habitacion("201");
		habitacion5 = new Habitacion("202");
		habitacion6 = new Habitacion("203");
		habitacion7 = new Habitacion("301");
		habitacion8 = new Habitacion("302");
		habitacion9 = new Habitacion("303");

		dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		residente1 = new Residente("Martinez Gomez, Adrian", "27272727", 'V',
				dateFormat.parse("12-02-1940"));
		residente2 = new Residente("Lopez Lopez, Luisa", "27272728", 'M',
				dateFormat.parse("12-03-1940"));
		residente3 = new Residente("Roquero Sanchez, Luis", "27272729", 'V',
				dateFormat.parse("12-04-1940"));
		residente4 = new Residente("Del Aguila Imperial, Ana Maria",
				"27272730", 'M', dateFormat.parse("12-02-1950"));

		Cuidador[] cuidadores = { cuidador1, cuidador2, cuidador3 };
		Habitacion[] habitaciones = { habitacion1, habitacion2, habitacion3,
				habitacion4, habitacion5 };

		residencia = new Residencia("Las Acacias", cuidadores, habitaciones);

		String salida = directorioEntrada + File.separator
				+ "PracticasMetodologia" + File.separator + "com"
				+ File.separator + "mp" + File.separator + "practica8"
				+ File.separator + "ejercicio4" + File.separator + "test"
				+ File.separator + "residencia.xml";

		residencia.ingreso(residente1, habitacion1, dateFormat
				.parse("12-01-2007"), dateFormat.parse("12-06-2007"));
		residencia.ingreso(residente2, habitacion2, dateFormat
				.parse("12-02-2007"), dateFormat.parse("12-06-2007"));

		ResidenciaXML residenciaXML = new ResidenciaXML(salida);

		residenciaXML.escribir(residencia);

	 }

	 public void testLeer() throws IOException {

		 String salida = directorioEntrada + File.separator
			+ "PracticasMetodologia" + File.separator + "com"
			+ File.separator + "mp" + File.separator + "practica8"
			+ File.separator + "ejercicio4" + File.separator + "test"
			+ File.separator + "residencia.xml";

	        ResidenciaXML residenciaXML = new ResidenciaXML(salida);

	        Residencia residencia = residenciaXML.leer();

	        assertTrue(residencia.getNombre().equals("Las Acacias"));

	        Cuidador[] cuidadores = residencia.getCuidadores();

	        assertEquals(cuidadores[0].getNombre(), "Martinez Martinez, Juan");
	        assertEquals(cuidadores[1].getNombre(), "Lopez Segura, Ana");
	        assertEquals(cuidadores[2].getNombre(), "Marquez Lopez, Anabel");

	        Habitacion[] habitaciones = residencia.getHabitaciones();

	        assertEquals(habitaciones[0].getNumero(), "101");
	        assertEquals(habitaciones[1].getNumero(), "102");
	        assertEquals(habitaciones[2].getNumero(), "103");
	        assertEquals(habitaciones[3].getNumero(), "201");
	        assertEquals(habitaciones[4].getNumero(), "202");
	 }
}
