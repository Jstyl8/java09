

public class TorresHanoi {

	private int movimientos;

	private int n; //número de discos

	private int a;

	private String[] posteA;

	private int b;

	private String[] posteB;

	private int c;

	private String[] posteC;

	public TorresHanoi(int n) {

		// por hacer ...

	}


	public void solucionRec(int n, int a, int c, int b) {
		hanoi(n, a, c, b);
	}


	private void hanoi(int n, int a, int c, int b) {
		if (n == 1) {
			System.out.println("Movimiento: " + movimientos + " Mover disco "
					+ n + " desde " + a + " hasta " + c);
			//moverDisco(a, c);
			//estado();

		} else {
			hanoi(n - 1, a, b, c);
			System.out.println("Movimiento: " + movimientos + " Mover disco "
					+ n + " desde " + a + " hasta " + c);
			//moverDisco(a, c);
			//estado();
			hanoi(n - 1, b, c, a);
		}
	}


	public void estado() {
		
		// por hacer ...
		
	}
	
	public void moverDisco(int desde, int hasta) {

		// por hacer ...
		
	}

}
