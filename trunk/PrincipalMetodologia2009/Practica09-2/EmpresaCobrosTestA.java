package com.mp.practica2.ejercicio5.test;

import com.mp.practica2.ejercicio5.Cliente;
import com.mp.practica2.ejercicio5.Deudor;
import com.mp.practica2.ejercicio5.EmpresaCobros;

import junit.framework.TestCase;

public class EmpresaCobrosTestA extends TestCase {

	private EmpresaCobros empresa;
	Cliente cliente0;
	private String mensaje;

	public EmpresaCobrosTestA(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();

		empresa = new EmpresaCobros("El buitre negro");

		Deudor deudor0 = new Deudor("00000", 300.0, 100.0);
		Deudor deudor1 = new Deudor("11111", 1300.0, 1000.0);
		Deudor deudor2 = new Deudor("22222", 2300.0, 2000.0);
		Deudor deudor3 = new Deudor("33333", 3300.0, 3000.0);
		Deudor deudor4 = new Deudor("44444", 4400.0, 4000.0);

		Deudor[] deudores0 = { deudor0, deudor1 };
		Deudor[] deudores1 = { deudor2, deudor3, deudor4 };
		Deudor[] deudores2 = { deudor0, deudor3, deudor4 };

		cliente0 = new Cliente("Juan", "212121", deudores0);
		Cliente cliente1 = new Cliente("Antonio", "212121", deudores1);
		Cliente cliente2 = new Cliente("Alberto", "212121", deudores2);

		Cliente[] clientes = { cliente0, cliente1, cliente2 };

		empresa.setClientes(clientes);
	}

	public void testNombreEmpresa() {
		mensaje = "Deben ser iguales";
		assertTrue(mensaje, empresa.getNombre().equals("El buitre negro"));
		mensaje = "No son iguales";
		assertFalse(mensaje, empresa.getNombre().equals("El Buitre negro"));
	}

	public void testCantidadTotalNoCobrada() {
		mensaje = "Deben ser iguales, el cliente0 debe 500";
		assertTrue(mensaje, cliente0.cantidadTotalNoCobrada() == 500.0);

		mensaje = "Deben ser iguales, todos los cliente deben 2400";
		assertTrue(mensaje, empresa.cantidadTotalNoCobrada() == 2400.0);

	}

	public void testMaximoPrestado() {
		String maximoPrestado = empresa.maximoPrestado();
		mensaje = "Debe contener las cadenas";
		assertTrue(mensaje, maximoPrestado.contains("44444"));
		assertTrue(mensaje, maximoPrestado.contains("4400.0"));
	}

	public void testListadoAlfabetico() {

		String listadoAlfabetico = empresa.listadoAlfabetico(300.0);
		int[] posicion = new int[3];
		assertTrue(listadoAlfabetico.contains("Alberto"));
		posicion[0] = listadoAlfabetico.indexOf("Alberto");
		assertTrue(listadoAlfabetico.contains("Antonio"));
		posicion[1] = listadoAlfabetico.indexOf("Antonio");
		assertTrue(listadoAlfabetico.contains("Juan"));
		posicion[2] = listadoAlfabetico.indexOf("Juan");
		assertFalse(listadoAlfabetico.contains("Luis"));

		for (int i = 0; i < posicion.length - 1; i++) {
			assertTrue(posicion[i] < posicion[i + 1]);
		}

		listadoAlfabetico = empresa.listadoAlfabetico(2000.0);
		int[] posicion1 = new int[2];
		assertTrue(listadoAlfabetico.contains("Alberto"));
		posicion[0] = listadoAlfabetico.indexOf("Alberto");
		assertTrue(listadoAlfabetico.contains("Antonio"));
		posicion[1] = listadoAlfabetico.indexOf("Antonio");
		for (int i = 0; i < posicion1.length - 1; i++) {
			assertTrue(posicion[i] < posicion[i + 1]);
		}
	}
}
