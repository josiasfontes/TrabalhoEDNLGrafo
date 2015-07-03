package grafo;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
	Stack<Vertice> pilhaexecucao = new Stack<Vertice>();
	Queue<Vertice> verticesVisitadas = new LinkedList<Vertice>();
	ReferenciaVertice stringInt = new ReferenciaVertice();
	ReferenciaVertice intString = new ReferenciaVertice();
	int tempo = 0;

	public String bfs(int adjacency_matrix[][], Vertice[] verticesGrafo,
			String source) {
		String verticeBuscado = "Vertice não encontrado";
		Queue<Vertice> verticesVisitadas = new LinkedList<Vertice>();
		Queue<Vertice> fila = new LinkedList<Vertice>();
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
			} else {
				ReferenciaVertice stringInt = new ReferenciaVertice();
				ReferenciaVertice intString = new ReferenciaVertice();
				int indiceCabecaFila = stringInt.converter(cabecaFila.getSimbolo());
				for (int i = 0; i < adjacency_matrix.length; i++) {
					if (adjacency_matrix[indiceCabecaFila][i] != 1000 && adjacency_matrix[indiceCabecaFila][i] != 0) {
						String simbolo = intString.converterString(i);
						if (simbolo.equals(source)) {
							verticeBuscado = simbolo;
						} else {
							for (int j = 0; j < verticesGrafo.length; j++) {
								if (verticesGrafo[j].getSimbolo().equals(simbolo)) {
									verticesVisitadas.add(verticesGrafo[j]);
									if (verticesGrafo[j].getCor().equals("B")) {
										verticesGrafo[j].cor = "C";
										verticesGrafo[j].predecessor = cabecaFila;
										verticesGrafo[j].distancia = cabecaFila.getDistancia() + 1;
										fila.add(verticesGrafo[j]);
									}
								}
							}
						}
					}
				}
			}
			fila.remove();
			cabecaFila.setCor("P");
		}
		if (!verticeBuscado.equals("Vertice não encontrado")) {
			System.out.print("Vertices percorridos:");
			for (Vertice v: verticesVisitadas) {
				System.out.print("\n[VERTICE: "+v.simbolo+",");
				System.out.print(" COR: "+v.cor+",");
				System.out.print(" DISTANCIA: "+v.distancia+"]");
			}
		}
		return verticeBuscado;
	}

	
}
