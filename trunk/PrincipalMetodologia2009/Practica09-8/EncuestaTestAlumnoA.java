package com.mp.practica8.ejercicio5.encuesta.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

import com.mp.practica8.ejercicio5.encuesta.Encuesta;
import com.mp.practica8.ejercicio5.encuesta.PreguntaContestacion;

import junit.framework.TestCase;

public class EncuestaTestAlumnoA extends TestCase {

	String mensaje;

	Encuesta encuesta = null;
	ArrayList validacionMultiple = null;
	ArrayList validacionSINO = null;

	public EncuestaTestAlumnoA(String name) {
		super(name);
		encuesta = new Encuesta();

		validacionMultiple = new ArrayList();
		validacionMultiple.add("-1");
		validacionMultiple.add("0");
		validacionMultiple.add("1");
		validacionMultiple.add("2");
		validacionMultiple.add("3");
		validacionMultiple.add("4");
		validacionMultiple.add("5");

		validacionSINO = new ArrayList();
		validacionSINO.add("SI");
		validacionSINO.add("NO");
		validacionSINO.add("Si");
		validacionSINO.add("No");
		validacionSINO.add("si");
		validacionSINO.add("no");

	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testEncuesta() throws FileNotFoundException {

		// método que debe rellenar por código

		cargarPreguntas();

		String directorio = System.getProperty("user.dir");
		directorio = directorio + File.separator + "PracticasMetodologia"
				+ File.separator + "com" + File.separator + "mp"
				+ File.separator + "practica8" + File.separator + "ejercicio5"
				+ File.separator + "encuesta" + File.separator + "test"
				+ File.separator;

		for (Iterator iterator = encuesta.getEncuesta().iterator(); iterator
				.hasNext();) {
			PreguntaContestacion pc = (PreguntaContestacion) iterator.next();

			mensaje = pc.getTipo() + "-->" + pc.getContestacion();
			assertTrue(mensaje, validar(pc.getTipo(), pc.getContestacion()));

		}

		File file = new File(directorio
				+ ((PreguntaContestacion) encuesta.getEncuesta().get(0))
						.getContestacion() + ".encuesta");
		PrintStream ps = new PrintStream(file);

		for (Iterator iterator = encuesta.getEncuesta().iterator(); iterator
				.hasNext();) {

			PreguntaContestacion pc = (PreguntaContestacion) iterator.next();

			ps.print(pc.getNumero() + ";");
			ps.print(pc.getTipo() + ";");
			ps.print(pc.getPregunta() + ";");
			ps.print(pc.getContestacion() + ";");
			ps.print("\n");

		}

		ps.close();

	}

	private void cargarPreguntas() {

		// Debe rellenar todos los nulls de las contestaciones

		// Hay tres tipos de preguntas:

		// ABIERTA
		// en estas debe sustituir el null por un texto

		// SI/NO
		// en estas debe elegir entre SI o NO

		// MULTIPLE
		// debe contestar con el valor que más se aproxime a su opinión
		// -1 (No sabe/No contesta), o un valor en una escala de 0 a 5
		// 0 (nada),1 (muy poco), 2 (poco), 3 (regular), 4(bien), 5 (muy bien)

		PreguntaContestacion pc;
		String pregunta;
		String contestacion;
		String tipo;
		int numero = 0;

		numero++;
		tipo = "ABIERTA";
		pregunta = "Escriba su Apellido1Aplellido2Nombre";
		// Por ejemplo MartinezPerezJulian
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha hecho usted las prácticas?";
		// Parece lógico delcir algo como SI
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		//practica 2

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 2 ejercicio 1?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 2 ejercicio 2?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 2 ejercicio 3?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 2 ejercicio 4?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 2 ejercicio 5?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 2 ejercicio 6?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		//practica 3

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 3 ejercicio 1?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 3 ejercicio 2?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 3 ejercicio 3?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica  ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 3 ejercicio 4?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica  ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		//practica 4

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 4 ejercicio 1?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica  ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 4 ejercicio 2?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica  ?";
		contestacion = "SI";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 4 ejercicio 3?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica  ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 4 ejercicio 4?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica  ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 4 ejercicio 5?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica  ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 4 ejercicio 6?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		//practica 5

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 5 ejercicio 1?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 5 ejercicio 2?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 5 ejercicio 3?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica  ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 5 ejercicio 4?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 5 ejercicio 5?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica  ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		//practica 6

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 6 ejercicio 1?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica  ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 6 ejercicio 2?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 6 ejercicio 3?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica  ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		//practica 7

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 7 ejercicio 1?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 7 ejercicio 2?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 7 ejercicio 3?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 7 ejercicio 4?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 7 ejercicio 5?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 7 ejercicio 6?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		//practica 8

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 8 ejercicio 1?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 8 ejercicio 2?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 8 ejercicio 3?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la practica 8 ejercicio 4?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "¿Ha realizado la documentación con javadoc de la practica ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		// preguntas sobre el trabajo en parejas

		numero++;
		tipo = "MULTIPLE";
		pregunta = "Este año hemos utilizado un sistema de trabajo en parejas"
				+ "¿ Le ha resultado sencillo encontrar una pareja ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "Este año hemos utilizado un sistema de trabajo en parejas"
				+ "En alguna ocasión ha pensado: "
				+ "¿ tengo que esforzarme para trabajar más para cumplir mis compromisos"
				+ "con mi pareja de programación ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "Este año hemos utilizado un sistema de trabajo en parejas"
				+ "En alguna ocasión ha pensado: "
				+ "¿ Voy ha hacer lo justo, y que mi pareja trabaje ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "Este año hemos utilizado un sistema de trabajo en parejas"
				+ "Esta de acuerdo con esta afirmación: "
				+ " Es preferible que el profesor forme las pareja al azar ";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "ABIERTA";
		pregunta = "Este año hemos utilizado un sistema de trabajo en parejas"
				+ "Escriba su opinión sobre como se puede mejorar el trabajo por parejas: ";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		// preguntas sobre control de versiones Subversión

		numero++;
		tipo = "MULTIPLE";
		pregunta = "Este año hemos utilizado un sistema de control de versiones"
				+ "basado en Subversion"
				+ "¿ Le ha resultado sencillo empezar a utilizarlo ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "MULTIPLE";
		pregunta = "Este año hemos utilizado un sistema de control de versiones"
				+ "basado en Subversion"
				+ "¿ Le ha facilitado el control del código que iba realizando ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "MULTIPLE";
		pregunta = "Este año hemos utilizado un sistema de control de versiones"
				+ "basado en Subversion"
				+ "¿ Creé que es una herramienta util para el trabajo "
				+ "en grupo(pareja) ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = "Este año hemos utilizado un sistema de control de versiones"
				+ "basado en Subversion"
				+ "¿ Ha necesitado recurrir a él en alguna ocasión para "
				+ "recuperar una copia de seguridad ?";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		// preguntas sobre las clases

		numero++;
		tipo = "SI/NO";
		pregunta = " Está usted de acuerdo con la siguiente afirmación "
				+ "No suelo acudir a clases porque me coincide el horario "
				+ "con otras asignaturas ";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = " Está usted de acuerdo con la siguiente afirmación "
				+ "No suelo acudir a clases porque prefiero ir por mi cuenta "
				+ "ya que tengo todo lo que necesito en la Web ";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = " Está usted de acuerdo con la siguiente afirmación "
				+ "No suelo acudir a clases porque prefiero "
				+ "dedicar mi tiempo a otras asignaturas y dejar esta para más adelante ";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "ABIERTA";
		pregunta = "Escriba su opinión sobre "
				+ "¿ Por qué asisten pocos alumnos a las clases ? ";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

	}

	private boolean validar(String tipo, String contestacion) {

		if (contestacion == null) {
			return false;
		}

		if (tipo.equals("ABIERTA")) {

			return true;
		}

		if (tipo.equals("SI/NO")) {

			return validacionSINO.contains(contestacion);
		}

		if (tipo.equals("MULTIPLE")) {

			return validacionMultiple.contains(contestacion);
		}

		return false;

	}
}

