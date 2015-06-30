package grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	private final int NUMERO_MAXIMO_VERTICES;
	private int matriz_adjacencia[][];
	private int pos[];
	/**/
	Vertice A = new Vertice("B", "A", 1000, null);
	Vertice B = new Vertice("B", "B", 1000, null);
	Vertice C = new Vertice("B", "C", 1000, null);
	Vertice D = new Vertice("B", "D", 1000, null);
	Vertice E = new Vertice("B", "E", 1000, null);
	Vertice F = new Vertice("B", "F", 1000, null);
	Vertice G = new Vertice("B", "G", 1000, null);
	Vertice H = new Vertice("B", "H", 1000, null);
	Vertice I = new Vertice("B", "I", 1000, null);
	Vertice J = new Vertice("B", "J", 1000, null);
	Vertice K = new Vertice("B", "K", 1000, null);
	Vertice L = new Vertice("B", "L", 1000, null);
	Vertice M = new Vertice("B", "M", 1000, null);
	Vertice N = new Vertice("B", "N", 1000, null);
	Vertice O = new Vertice("B", "O", 1000, null);
	Vertice P = new Vertice("B", "P", 1000, null);
	Vertice Q = new Vertice("B", "Q", 1000, null);
	Vertice R = new Vertice("B", "R", 1000, null);
	Vertice S = new Vertice("B", "S", 1000, null);
	Vertice T = new Vertice("B", "T", 1000, null);
	Vertice U = new Vertice("B", "U", 1000, null);
	Vertice V = new Vertice("B", "V", 1000, null);
	Vertice W = new Vertice("B", "W", 1000, null);
	Vertice X = new Vertice("B", "X", 1000, null);
	Vertice Y = new Vertice("B", "Y", 1000, null);
	Vertice Z = new Vertice("B", "Z", 1000, null);

	private Vertice[] vertices = { A, B, C, D, E, F, G, H, I, J, K, L, M, N, O,
			P, Q, R, S, T, U, V, W, X, Y, Z };

	public Grafo(int numero_vertices) {

		NUMERO_MAXIMO_VERTICES = numero_vertices;
		this.matriz_adjacencia = new int[NUMERO_MAXIMO_VERTICES][NUMERO_MAXIMO_VERTICES];
	}
	

	public boolean existeAresta(int origem, int destino) {
		return (this.matriz_adjacencia[origem][destino] > 0);
	}

	public List<Integer> listaAdjVazia(int v) {
		List<Integer> listaAdjacencias = new ArrayList<Integer>();
		for (int i = 0; i < this.NUMERO_MAXIMO_VERTICES; i++) {
			if (this.matriz_adjacencia[v][i] > 0) {
				listaAdjacencias.add(i);
			}
		}
		return listaAdjacencias;
	}

	public void printMatriz(int numero_vertices) {
		for (int i = 0; i < numero_vertices; i++) {
			System.out.print("   " + vertices[i].getSimbolo() + "");
		}
		System.out.println();

		for (int i = 0; i < numero_vertices; i++) {
			System.out.print(vertices[i].getSimbolo());
			for (int j = 0; j < numero_vertices; j++) {
				System.out.print("  " + matriz_adjacencia[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void setAresta(int vertice_origem, int vertice_destino,
			int pesoAresta) {
		try {

			matriz_adjacencia[vertice_origem][vertice_destino] = pesoAresta;
		} catch (ArrayIndexOutOfBoundsException indexBounce) {

			System.out.println("Vertice nao presente!");
		}

	}

	public int getAresta(int vertice_origem, int vertice_destino) {

		try {

			return matriz_adjacencia[vertice_origem][vertice_destino];

		} catch (ArrayIndexOutOfBoundsException indexBounce) {

			System.out.println("Vertice nao presente!");
		}

		return -1;
	}

	public int getTamanho() {

		return NUMERO_MAXIMO_VERTICES;
	}

	public int[][] getMatriz_adjacencia() {
		return matriz_adjacencia;
	}

	public void setMatriz_adjacencia(int[][] matriz_adjacencia) {
		this.matriz_adjacencia = matriz_adjacencia;
	}

}
