package com.mp.practica6.ejercicio3;

public class Laberinto {

    private char[][] laberinto;

    private int entradaX;

    private int entradaY;

    public Laberinto(char[][] laberinto, int entradaX, int entradaY) {
        super();
        // TODO Auto-generated constructor stub
        this.laberinto = (char[][]) laberinto.clone();
        this.entradaX = entradaX;
        this.entradaY = entradaY;
    }

    public void imprimir() {

        //A completar
    }

    public boolean valido(int x, int y) {

        int N = laberinto.length;
        int M = laberinto[0].length;
        boolean ok = false;
        if (x < N && x >= 0 && y < M && y >= 0
                && (laberinto[x][y] == ' ' || laberinto[x][y] == 's')) {
            ok = true;
        }
        return ok;
    }

    public boolean resolver() {

        return resolver(entradaX, entradaY);
    }

    public boolean resolver(int x, int y) {

	//A completar

    }

}
