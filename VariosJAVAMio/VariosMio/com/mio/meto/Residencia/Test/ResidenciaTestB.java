package com.mio.meto.Residencia.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mio.meto.Residencia.Cuidador;
import com.mio.meto.Residencia.Habitacion;
import com.mio.meto.Residencia.Reserva;
import com.mio.meto.Residencia.Residencia;
import com.mio.meto.Residencia.Residente;

import junit.framework.TestCase;


public class ResidenciaTestB extends TestCase {

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

	public ResidenciaTestB(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();

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

	}

	public void testEncapsuladoArrays() {

		// Para cuidadores
		Cuidador[] cuidadores = residencia.getCuidadores();
		assertTrue(residencia.getNCuidadores() == 3);
		assertTrue(cuidadores[0].equals(cuidador1));

		String string1 = residencia.buscarCuidador(cuidador1.getNombre())
				.getNombre();
		String string2 = cuidador1.getNombre();

		assertTrue(string1.equals(string2));
		
		cuidadores[0] = new Cuidador("Marquez Lopez, Miguel", "3333333");
		assertTrue(residencia.buscarCuidador(cuidador1.getNombre()).equals(
				cuidador1));

		// Para habitaciones
		Habitacion[] habitaciones = residencia.getHabitaciones();
		assertTrue(residencia.getNHabitaciones() == 5);
		assertTrue(habitaciones[0].equals(habitacion1));

		assertTrue(residencia.buscarHabitacion(habitacion1.getNumero())
				.getNumero().equals(habitacion1.getNumero()));

		habitaciones[0] = new Habitacion("808");
		assertTrue(residencia.buscarHabitacion(habitacion1.getNumero()).equals(
				habitacion1));

	}

	public void testNoNulos() {

		Cuidador[] cuidadores = { cuidador1, null, cuidador3 };
		Habitacion[] habitaciones = { habitacion1, null, habitacion3,
				habitacion4, habitacion5 };
		Residencia residencia = new Residencia("Las Olmos", cuidadores,
				habitaciones);

		assertTrue(residencia.getNCuidadores() == 2);
		assertTrue(residencia.getNHabitaciones() == 4);

	}

	public void testCuidadoresIguales() {

		assertTrue(residencia.getNCuidadores() == 3);
		Cuidador cuidador4 = new Cuidador("Marquez Lopez, Miguel", "26262680");
		residencia.insertarCuidador(cuidador4);
		assertTrue(residencia.getNCuidadores() == 4);

		Cuidador cuidador5 = new Cuidador("Martinez Lopez, Miguel", "26262680");
		residencia.insertarCuidador(cuidador5);
		assertTrue(residencia.getNCuidadores() == 4);

	}

	public void testHabitacionesIguales() {

		Habitacion habitacionA = new Habitacion("701");

		assertTrue(residencia.getNHabitaciones() == 5);
		residencia.insertarHabitacion(habitacionA);
		assertTrue(residencia.getNHabitaciones() == 6);

		Habitacion habitacionB = new Habitacion("701");
		residencia.insertarHabitacion(habitacionB);
		assertTrue(residencia.getNHabitaciones() == 6);

	}
	
	public void testResidentesIguales() throws ParseException {
		
		residencia.ingreso(residente1, habitacion1, dateFormat
				.parse("01-01-2007"), dateFormat.parse("15-01-2007"));
		residencia.ingreso(residente2, habitacion2, dateFormat
				.parse("01-02-2007"), dateFormat.parse("15-02-2007"));

		assertTrue(residencia.getNReservas() == 2);
		assertTrue(residencia.getNResidentes() == 2);
		
		residencia.ingreso(residente2, habitacion3, dateFormat
				.parse("01-02-2007"), dateFormat.parse("15-02-2007"));
		
		assertTrue(residencia.getNReservas() == 2);
		assertTrue(residencia.getNResidentes() == 2);

	}


	public void testAutoincrementadoReservas() throws ParseException {

		residencia.ingreso(residente1, habitacion1, dateFormat
				.parse("12-01-2007"), dateFormat.parse("12-01-2008"));
		residencia.ingreso(residente2, habitacion2, dateFormat
				.parse("12-02-2007"), dateFormat.parse("12-01-2008"));
		residencia.ingreso(residente3, habitacion3, dateFormat
				.parse("12-02-2007"), dateFormat.parse("12-01-2008"));

		assertTrue(residencia.getNReservas() == 3);
		assertTrue(residencia.getNResidentes() == 3);

		Reserva[] reservas = residencia.getReservas();
		int n = Reserva.getUltimoNumero();

		for (int i = 0; i < residencia.getNReservas(); i++) {
			//System.out.println(reservas[i].getNumeroReserva());
			assertTrue(reservas[i].getNumeroReserva() == n - (2 - i));
		}

		residencia.salida(residente1, dateFormat.parse("12-05-2007"));

		assertTrue(residencia.getNReservas() == 3);
		assertTrue(residencia.getNResidentes() == 2);

		reservas = residencia.getReservas();

		for (int i = 0; i < residencia.getNReservas(); i++) {
			assertTrue(reservas[i].getNumeroReserva() == n - (2 - i));
		}

	}

	public void testControlFechasReserva() throws ParseException {

		residencia.ingreso(residente1, habitacion1, dateFormat
				.parse("01-01-2007"), dateFormat.parse("15-01-2007"));
		residencia.ingreso(residente2, habitacion2, dateFormat
				.parse("01-02-2007"), dateFormat.parse("15-02-2007"));

		assertTrue(residencia.getNReservas() == 2);
		assertTrue(residencia.getNResidentes() == 2);

		residencia.ingreso(residente3, habitacion3, dateFormat
				.parse("01-03-2007"), dateFormat.parse("15-02-2007"));

		assertTrue(residencia.getNReservas() == 2);
		assertTrue(residencia.getNResidentes() == 2);

		residencia.ingreso(residente3, habitacion3, dateFormat
				.parse("01-03-2007"), dateFormat.parse("01-03-2007"));

		assertTrue(residencia.getNReservas() == 3);
		assertTrue(residencia.getNResidentes() == 3);

	}

	public void testControlHabitacionOcupada() throws ParseException {

		residencia.ingreso(residente1, habitacion1, dateFormat
				.parse("01-01-2007"), dateFormat.parse("15-01-2007"));
		residencia.ingreso(residente2, habitacion2, dateFormat
				.parse("01-02-2007"), dateFormat.parse("15-02-2007"));

		assertTrue(residencia.getNReservas() == 2);
		assertTrue(residencia.getNResidentes() == 2);

		Date date = dateFormat.parse("02-01-2007");
		assertTrue(residencia.isHabitacionOcupada(habitacion1, date));
		assertFalse(residencia.isHabitacionOcupada(habitacion2, date));

		date = dateFormat.parse("01-01-2007");
		assertTrue(residencia.isHabitacionOcupada(habitacion1, date));
		date = dateFormat.parse("15-01-2007");
		assertTrue(residencia.isHabitacionOcupada(habitacion1, date));

		residencia.ingreso(residente3, habitacion2, dateFormat
				.parse("08-02-2007"), dateFormat.parse("15-02-2007"));
		residencia.ingreso(residente3, habitacion2, dateFormat
				.parse("01-02-2007"), dateFormat.parse("15-02-2007"));
		residencia.ingreso(residente3, habitacion2, dateFormat
				.parse("15-02-2007"), dateFormat.parse("15-02-2007"));

		assertTrue(residencia.getNReservas() == 2);
		assertTrue(residencia.getNResidentes() == 2);

	}

	public void testListadoHabitacionesLibres() throws ParseException {

		residencia.ingreso(residente1, habitacion1, dateFormat
				.parse("01-01-2007"), dateFormat.parse("15-01-2007"));
		residencia.ingreso(residente2, habitacion2, dateFormat
				.parse("01-02-2007"), dateFormat.parse("15-02-2007"));
		residencia.ingreso(residente3, habitacion3, dateFormat
				.parse("01-03-2007"), dateFormat.parse("15-03-2007"));

		assertTrue(residencia.getNReservas() == 3);
		assertTrue(residencia.getNResidentes() == 3);

		Date date = dateFormat.parse("01-01-2007");
		String string = residencia.listadoHabitacionesLibres(date);
		//System.out.println(dateFormat.format(date) + " ---> " + string);
		assertTrue(string.contains("102"));
		assertTrue(string.contains("103"));

		date = dateFormat.parse("01-03-2007");
		string = residencia.listadoHabitacionesLibres(date);
		//System.out.println(dateFormat.format(date) + " ---> " + string);
		assertTrue(string.contains("101"));
		assertTrue(string.contains("102"));

		date = dateFormat.parse("15-03-2007");
		string = residencia.listadoHabitacionesLibres(date);
		//System.out.println(dateFormat.format(date) + " ---> " + string);
		assertTrue(string.contains("101"));
		assertTrue(string.contains("102"));

		date = dateFormat.parse("01-05-2007");
		string = residencia.listadoHabitacionesLibres(date);
		//System.out.println(dateFormat.format(date) + " ---> " + string);
		assertTrue(string.contains("101"));
		assertTrue(string.contains("102"));
		assertTrue(string.contains("103"));

		System.out.println();

	}

	public void testlistadoResidentesHabitaciones() throws ParseException {

		residencia.ingreso(residente1, habitacion1, dateFormat
				.parse("01-01-2007"), dateFormat.parse("15-01-2007"));
		residencia.ingreso(residente2, habitacion2, dateFormat
				.parse("01-02-2007"), dateFormat.parse("15-02-2007"));
		residencia.ingreso(residente3, habitacion3, dateFormat
				.parse("01-03-2007"), dateFormat.parse("15-03-2007"));

		assertTrue(residencia.getNReservas() == 3);
		assertTrue(residencia.getNResidentes() == 3);

		Date date = dateFormat.parse("02-01-2007");
		String string = residencia.listadoResidentesHabitaciones(date);
		//System.out.println(dateFormat.format(date) + " ---> " + string);
		assertTrue(string.contains("Martinez Gomez, Adrian"));

		date = dateFormat.parse("01-03-2007");
		string = residencia.listadoResidentesHabitaciones(date);
		//System.out.println(dateFormat.format(date) + " ---> " + string);
		assertTrue(string.contains("Roquero Sanchez, Luis"));

		date = dateFormat.parse("01-05-2007");
		string = residencia.listadoResidentesHabitaciones(date);
		//System.out.println(dateFormat.format(date) + " ---> " + string);
		assertTrue(string.equals(""));

		residencia.salida(residente1, dateFormat.parse("02-01-2007"));
		residencia.salida(residente2, dateFormat.parse("02-02-2007"));
		residencia.salida(residente3, dateFormat.parse("02-03-2007"));

		date = dateFormat.parse("05-03-2007");
		string = residencia.listadoResidentesHabitaciones(date);
		//System.out.println(dateFormat.format(date) + " ---> " + string);
		assertTrue(string.equals(""));

		residencia.ingreso(residente1, habitacion1, dateFormat
				.parse("10-05-2007"), dateFormat.parse("15-05-2007"));
		residencia.ingreso(residente2, habitacion2, dateFormat
				.parse("10-05-2007"), dateFormat.parse("15-05-2007"));
		residencia.ingreso(residente3, habitacion3, dateFormat
				.parse("10-05-2007"), dateFormat.parse("15-05-2007"));
		residencia.ingreso(residente4, habitacion4, dateFormat
				.parse("10-05-2007"), dateFormat.parse("15-05-2007"));

		date = dateFormat.parse("12-05-2007");
		string = residencia.listadoResidentesHabitaciones(date);
		//System.out.println(dateFormat.format(date) + " ---> " + string);

		int[] posicion = new int[4];

		assertTrue(string.contains("Del Aguila Imperial, Ana Maria"));
		posicion[0] = string.indexOf("Del Aguila Imperial, Ana Maria");
		assertTrue(string.contains("Lopez Lopez, Luisa"));
		posicion[1] = string.indexOf("Lopez Lopez, Luisa");
		assertTrue(string.contains("Martinez Gomez, Adrian"));
		posicion[2] = string.indexOf("Martinez Gomez, Adrian");
		assertTrue(string.contains("Roquero Sanchez, Luis"));
		posicion[3] = string.indexOf("Roquero Sanchez, Luis");

		for (int i = 0; i < posicion.length - 1; i++) {
			assertTrue(posicion[i] < posicion[i + 1]);
		}

	}

	public void testlistadoEdadMediaPorSexo() throws ParseException {

		Date date = dateFormat.parse("12-03-2007");

		assertTrue(residencia.listadoEdadMediaPorSexo(date).contains("0.0"));

		residencia.ingreso(residente1, habitacion1, dateFormat
				.parse("01-01-2007"), dateFormat.parse("15-01-2007"));
		assertTrue(residencia.listadoEdadMediaPorSexo(date).contains("0.0"));
		assertTrue(residencia.listadoEdadMediaPorSexo(date).contains("67.0"));

		residencia.ingreso(residente2, habitacion2, dateFormat
				.parse("01-02-2007"), dateFormat.parse("15-02-2007"));
		residencia.ingreso(residente3, habitacion3, dateFormat
				.parse("01-03-2007"), dateFormat.parse("15-03-2007"));
		residencia.ingreso(residente4, habitacion4, dateFormat
				.parse("01-03-2007"), dateFormat.parse("15-03-2007"));

		assertTrue(residencia.listadoEdadMediaPorSexo(date).contains("66.5"));
		assertTrue(residencia.listadoEdadMediaPorSexo(date).contains("62.0"));

	}
}
