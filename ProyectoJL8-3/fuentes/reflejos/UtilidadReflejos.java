package reflejos;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class UtilidadReflejos {

	// private ArrayList tiempos;
	private NumberFormat formatter;

	private double[] difTiempos;// en ns
	private int numTiempos;
	private long tiempoBase;// en segundos

	public final static double tos = 0.000000001;
	public final static double tons = 1000000000;

	public long getTiempoBase() {
		return tiempoBase;
	}

	public double getTiempoBasens() {
		return (tiempoBase * tons);
	}

	public NumberFormat getFormatter() {
		return formatter;
	}

	public UtilidadReflejos(long tiempoB) {
		// tiempos = new ArrayList();
		tiempoBase = tiempoB;
		difTiempos = new double[5];
		numTiempos = 0;
		formatter = new DecimalFormat("0.#######");
	}

	public void insertarOrdenado(double tiempo) {
		boolean colocado = false;
		int i;
		asegurarCapacidad();
		for (i = numTiempos; i > 0 && colocado == false;) {
			if (Math.abs(tiempo) < Math.abs(difTiempos[i - 1])) {
				difTiempos[i] = difTiempos[i - 1];
				i--;
			} else {
				colocado = true;
			}
		}
		difTiempos[i] = tiempo;
		numTiempos++;

		/*
		 * boolean colocado = false; int i; for (i = tiempos.size(); i > 0 &&
		 * colocado == false;) { Long anterior = (Long) tiempos.get(i - 1); if
		 * (anterior.compareTo(tiempo) > 0) { tiempos.add(i, anterior); i--; }
		 * else { colocado = true; } } tiempos.add(i, tiempo);
		 */
	}

	public void borrarDatos() {
		for (int i = 0; i < numTiempos; i++) {
			difTiempos[i] = 0;
		}
		numTiempos = 0;
	}

	private void asegurarCapacidad() {
		if (numTiempos == difTiempos.length) {
			double[] aux = new double[difTiempos.length * 2];
			for (int i = 0; i < difTiempos.length; i++) {
				aux[i] = difTiempos[i];
			}
			difTiempos = aux;
		}
	}

	public String RealizarListado() {
		String listado = "";
		for (int i = 0; i < numTiempos; i++) {
			listado += i + 1 + " -> " + formatter.format(difTiempos[i] * tos)
					+ "\n";
		}
		return listado;
		/*
		 * String listado = ""; Iterator i = tiempos.iterator(); int n = 1;
		 * while (i.hasNext()) { listado += n++ + " - " + formatter
		 * .format(((Long) i.next()).longValue() 0.000000001) + "\n"; } return
		 * listado;
		 */
	}
}
