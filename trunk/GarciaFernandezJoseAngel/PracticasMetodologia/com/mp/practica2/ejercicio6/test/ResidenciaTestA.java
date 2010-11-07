package com.mp.practica2.ejercicio6.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mp.practica2.ejercicio6.Cuidador;
import com.mp.practica2.ejercicio6.Habitacion;
import com.mp.practica2.ejercicio6.Residencia;
import com.mp.practica2.ejercicio6.Residente;

import junit.framework.TestCase;

public class ResidenciaTestA extends TestCase {

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
	
	public ResidenciaTestA(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		
		cuidador1 = new Cuidador("Martinez Martinez, Juan","27272727");
		cuidador2 = new Cuidador("Lopez Segura, Ana","27272728");
		cuidador3 = new Cuidador("Mazquez Lopez, Anabel","27272729");
		
		
		
		habitacion1 = new Habitacion("101");
		habitacion2 = new Habitacion("102");
		habitacion3 = new Habitacion("103");
		habitacion4 = new Habitacion("201");
		habitacion5 = new Habitacion("202");
		habitacion6 = new Habitacion("203");
		habitacion7 = new Habitacion("301");
		habitacion8 = new Habitacion("302");
		habitacion9 = new Habitacion("303");
		
		dateFormat = new SimpleDateFormat ("dd-MM-yyyy");
		
		residente1 = new Residente("Martinez Gomez, Adrian","27272727",'V', dateFormat.parse("12-02-1940"));
		residente2 = new Residente("Lopez Lopez, Luisa","27272728",'M', dateFormat.parse("12-03-1940"));
		residente3 = new Residente("Roquero Sanchez, Luis","27272729",'V', dateFormat.parse("12-04-1940"));
		residente4 = new Residente("Del Aguila Imperial, Ana Maria","27272730",'M', dateFormat.parse("12-02-1950"));
			
		Cuidador[] cuidadores = {cuidador1, cuidador2, cuidador3};
		Habitacion[] habitaciones = {habitacion1,habitacion2,habitacion3,habitacion4,
				habitacion5};
		
		residencia = new Residencia("Las Acacias",cuidadores,habitaciones);
		
	}

	public void testSetsGets() throws ParseException {
		
		// Probar que estan los sets gets de Cuidador
		
		assertTrue(cuidador1.getNombre().equals("Martinez Martinez, Juan"));
		assertTrue(cuidador1.getDni().equals("27272727"));
		
		cuidador1.setNombre("Martinez Martinez, Jose");
		cuidador1.setDni("26272727");
		
		assertTrue(cuidador1.getNombre().equals("Martinez Martinez, Jose"));
		assertTrue(cuidador1.getDni().equals("26272727"));
		
		// Probar que estan los sets gets de Residente
		
		assertTrue(residente1.getNombre().equals("Martinez Gomez, Adrian"));
		assertTrue(residente1.getDni().equals("27272727"));
		assertTrue(residente1.getSexo() == 'V');
		Date date = dateFormat.parse("12-02-1940");
		assertTrue(residente1.getFechaNacimiento().equals(date));
		
		residente1.setNombre("Martinez Cano, Adrian");
		residente1.setDni("26272727");
		residente1.setSexo('M');
		residente1.setFechaNacimiento(dateFormat.parse("13-02-1980"));
		
		assertTrue(residente1.getNombre().equals("Martinez Cano, Adrian"));
		assertTrue(residente1.getDni().equals("26272727"));
		assertTrue(residente1.getSexo() == 'M');
		assertTrue(residente1.getFechaNacimiento().equals(dateFormat.parse("13-02-1980")));

		//	Probar que estan los sets gets de Habitación		
		
		assertTrue(habitacion1.getNumero().equals("101"));
		
		habitacion1.setNumero("110");
		
		assertTrue(habitacion1.getNumero().equals("110"));

	}
	
	public void testTotalesCuidadoresHabitaciones(){
		
		assertTrue(residencia.getNCuidadores() == 3);
		assertTrue(residencia.getNHabitaciones() == 5);
		
	}
	
	public void testInsertarCuidador() {
		
		Cuidador cuidador = new Cuidador("Fernandez Fernandez, Juan", "27272730");
		assertTrue(residencia.getNCuidadores() == 3);
		residencia.insertarCuidador(cuidador);
		assertTrue(residencia.getNCuidadores() == 4);
		
		for (int i = 0; i < 100; i++) {
			Cuidador cuidadorA = new Cuidador("Fernandez Fernandez, Juan"+i, "27272727"+i);
			residencia.insertarCuidador(cuidadorA);
		}
		assertTrue(residencia.getNCuidadores() == 104);
		
	}
	
	public void testBuscarCuidadorPorNombre() {
		
		assertTrue(residencia.getNCuidadores() == 3);
		
		Cuidador cuidador = residencia.buscarCuidador("Mazquez Lopez, Anabel");
		assertTrue(cuidador.equals(cuidador3));
		assertFalse(cuidador.equals(cuidador2));
		
		Cuidador cuidadorA = residencia.buscarCuidador("Mazquez LOPEZ, Anabel");
		assertTrue(cuidadorA.equals(cuidador3));
		
		Cuidador cuidadorB = residencia.buscarCuidador("Ibrahin Lopez, Anabel");
		
		assertTrue(cuidadorB == null);
		
		assertTrue(residencia.getNCuidadores() == 3);
		
	}
	
	public void testEliminarCuidador() {
		
		assertTrue(residencia.getNCuidadores() == 3);
		residencia.eliminarCuidador(cuidador3);
		assertTrue(residencia.getNCuidadores() == 2);
		assertTrue(residencia.buscarCuidador(cuidador3.getNombre()) == null);
		
	}
	
	public void testInsertarHabitacion() {
		
		Habitacion habitacion = new Habitacion("501");
		assertTrue(residencia.getNHabitaciones() == 5);
		residencia.insertarHabitacion(habitacion);
		assertTrue(residencia.getNHabitaciones() == 6);
		
		for (int i = 0; i < 100; i++) {
			Habitacion habitacionA = new Habitacion("80"+i);
			residencia.insertarHabitacion(habitacionA);
		}
		assertTrue(residencia.getNHabitaciones() == 106);
		
	}
	
	public void testBuscarHabitacionPorNumero() {
		
		assertTrue(residencia.getNHabitaciones() == 5);
		
		Habitacion habitacion = residencia.buscarHabitacion("101");
		assertTrue(habitacion.equals(habitacion1));
		assertFalse(habitacion.equals(habitacion2));
		
		Habitacion habitacionA = residencia.buscarHabitacion("701");
		
		assertTrue(habitacionA == null);
		
		assertTrue(residencia.getNHabitaciones() == 5);
		
	}
	
	public void testEliminarHabitacion() {
		
		assertTrue(residencia.getNHabitaciones() == 5);
		
		residencia.eliminarHabitacion(habitacion1);
		
		assertTrue(residencia.getNHabitaciones() == 4);
		
		assertTrue(residencia.buscarCuidador(habitacion1.getNumero()) == null);
		
		
	}
	
	public void testEdadResidente() throws ParseException {
		
	    Date date = dateFormat.parse("12-03-2007");
		assertTrue(residente1.getEdad(date)==67);
		assertTrue(residente2.getEdad(date)==67);
		assertTrue(residente3.getEdad(date)==66);
		assertTrue(residente4.getEdad(date)==57);
	}
	
	public void testIngresoSalida() throws ParseException {
		
		residencia.ingreso(residente1, habitacion1, dateFormat.parse("12-01-2007"), dateFormat.parse("12-06-2007"));
		residencia.ingreso(residente2, habitacion2, dateFormat.parse("12-02-2007"), dateFormat.parse("12-06-2007"));
		
		assertTrue(residencia.getNReservas() == 2);
		assertTrue(residencia.getNResidentes() == 2);
		
		residencia.ingreso(residente3, habitacion3, dateFormat.parse("12-02-2007"), dateFormat.parse("12-03-2007"));
		assertTrue(residencia.getNReservas() == 3);
		assertTrue(residencia.getNResidentes() == 3);
		
		residencia.salida(residente1, dateFormat.parse("12-05-2007"));
		
		assertTrue(residencia.getNReservas() == 3);
		assertTrue(residencia.getNResidentes() == 2);
		
	}
	
	public void testIngresoCienResidentes() throws ParseException {
		
		assertTrue(residencia.getNReservas() == 0);
		
		for (int i = 0; i < 100; i++) {
			Residente residente = new Residente("nombre"+i,"272727"+i,'V',dateFormat.parse("12-02-1950") );
			Habitacion habitacion = new Habitacion("100"+i);
			residencia.ingreso(residente,habitacion,dateFormat.parse("12-02-2007"),dateFormat.parse("12-02-2008"));
			
		}
		assertTrue(residencia.getNReservas() == 100);
		
	}
	

	public void testCambioHabitacion() throws ParseException {
		
		residencia.ingreso(residente1, habitacion1, dateFormat.parse("12-01-2007"), dateFormat.parse("12-03-2007"));
		residencia.ingreso(residente2, habitacion2, dateFormat.parse("12-02-2007"), dateFormat.parse("12-03-2007"));
		
		assertTrue(residencia.getNReservas() == 2);
		assertTrue(residencia.getNResidentes() == 2);
		
		residencia.ingreso(residente3, habitacion3, dateFormat.parse("12-02-2007"), dateFormat.parse("12-03-2007"));
		assertTrue(residencia.getNReservas() == 3);
		assertTrue(residencia.getNResidentes() == 3);
		
		residencia.cambiarHabitacion(residente1, habitacion4, dateFormat.parse("12-02-2007"), dateFormat.parse("12-03-2007"));
		assertTrue(residencia.getNReservas() == 4);
		assertTrue(residencia.getNResidentes() == 3);
		
	}
	
}
