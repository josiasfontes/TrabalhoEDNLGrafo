package grafo;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
	Queue<Vertice> fila = new LinkedList<Vertice>();
	Queue<Vertice> verticesVisitadas = new LinkedList<Vertice>();
	ReferenciaVertice stringInt = new ReferenciaVertice();
	ReferenciaVertice intString = new ReferenciaVertice();
	int tempo = 0;

	public String bfs(int adjacency_matrix[][], Vertice[] verticesGrafo,
			String source) {
		String verticeBuscado = "Vertice não encontrado";

		Vertice cabecaFila;

		verticesGrafo[0].cor = "C";
		verticesGrafo[0].predecessor = null;
		verticesGrafo[0].distancia = 0;
		fila.add(verticesGrafo[0]);
		verticesVisitadas.add(verticesGrafo[0]);

		while (!fila.isEmpty()) {
			cabecaFila = fila.peek();
			if (cabecaFila.simbolo.equals(source)) {
				verticeBuscado = source;
				for (Vertice v : verticesVisitadas) {
					v.cor = "P";
				}
				printVerticesVisitados();
				return verticeBuscado;
			} else {
				int indiceCabecaFila = stringInt.converter(cabecaFila
						.getSimbolo());
				for (int i = 0; i < adjacency_matrix.length; i++) {
					System.out.println("[" + indiceCabecaFila + "][" + i+ "] = " + adjacency_matrix[indiceCabecaFila][i]);
					if (adjacency_matrix[indiceCabecaFila][i] != 1000
							&& adjacency_matrix[indiceCabecaFila][i] != 0) {
						String simbolo = intString.converterString(i);
						if (simbolo.equals(source)) {
							verticeBuscado = simbolo;
							printVerticesVisitados();
							return verticeBuscado;
						} else {
							verticesVisitadas.add(verticesGrafo[i]);
							if (verticesGrafo[i].getCor().equals("B")) {
								verticesGrafo[i].cor = "C";
								verticesGrafo[i].predecessor = cabecaFila;
								verticesGrafo[i].distancia = cabecaFila
										.getDistancia() + 1;
								fila.add(verticesGrafo[i]);
							}
						}
					}
				}
				fila.remove();
				cabecaFila.setCor("P");
			}

		}
		return verticeBuscado;
	}

	public void printVerticesVisitados() {
		System.out.print("Vertices percorridos:");
		for (Vertice v : verticesVisitadas) {
			System.out.print("\n[VERTICE: " + v.simbolo + ",");
			System.out.print(" COR: " + v.cor + ",");
			System.out.print(" DISTANCIA: " + v.distancia + "]");
		}
	}

}
