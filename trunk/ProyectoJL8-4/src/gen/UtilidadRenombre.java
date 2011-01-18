package gen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

/**
 * Clase que contiene utilidades para renombrar ficheros
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 28/12/2009
 */
public class UtilidadRenombre {

	private ArrayList<String> hechos;

	private ArrayList<String> mal;

	private String patron;

	private String nuevo;

	private String rutaBase;

	public UtilidadRenombre(String rutaBase, String patron, String nuevo) {
		this.patron = patron;
		this.nuevo = nuevo;
		this.rutaBase = rutaBase;
		hechos = new ArrayList<String>();
		mal = new ArrayList<String>();
	}

	public void renombrarFicheros() {
		File base = new File(rutaBase);
		File[] files = base.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile())
				renombrar(files[i]);
		}
	}

	public void generarLog() {
		try {
			Calendar ahora = new GregorianCalendar();
			Date now = new Date();
			int dia = ahora.get(Calendar.DATE);
			int mes = ahora.get(Calendar.MONTH);
			int year = ahora.get(Calendar.YEAR);
			mes++;
			String ruta = rutaBase + File.separator + "info-" + dia + "" + mes
					+ "" + year + ".log";

			PrintWriter pw = new PrintWriter(new FileWriter(ruta, true));
			pw.println("NUEVA EJECUCION");
			pw.println(now);
			// CORRECTOS
			Iterator i = hechos.iterator();
			pw.println("------RENOMBRADOS------");
			if (i.hasNext()) {
				while (i.hasNext()) {
					pw.println((String) i.next());
				}
			} else
				pw.println("NINGUNO");
			// INCORRECTOS
			Iterator i2 = mal.iterator();
			pw.println("------ERRORES EN------");
			if (i2.hasNext()) {
				while (i2.hasNext()) {
					pw.println((String) i2.next());
				}
			} else
				pw.println("NINGUNO");

			pw.println();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean renombrar(File old) {
		String oldName = old.getName();
		if (oldName.indexOf(patron) == -1)
			return false;
		String nuevoName = replace(oldName, patron, nuevo);
		File nuevo = new File(rutaBase + File.separator + nuevoName);
		if (old.renameTo(nuevo)) {
			hechos.add(oldName + "->" + nuevoName);
			return true;
		} else {
			mal.add(oldName + "->" + nuevoName);
			return false;
		}
	}

	private String replace(String str, String pattern, String replace) {
		int s = 0;
		int e = 0;
		StringBuffer result = new StringBuffer();
		// busca las coincidencias de pattern en str a partir de s
		// y mete en result str sin pattern
		while ((e = str.indexOf(pattern, s)) >= 0) {
			result.append(str.substring(s, e));
			result.append(replace);
			s = e + pattern.length();
		}
		result.append(str.substring(s));// mete el resto
		return result.toString();
	}
}
