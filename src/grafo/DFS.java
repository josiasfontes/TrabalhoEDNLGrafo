package grafo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {
	Stack<Vertice> verticesVisitadas2 = new Stack<Vertice>();
	Queue<Vertice> verticesVisitadas = new LinkedList<Vertice>();
	ReferenciaVertice stringInt = new ReferenciaVertice();
	ReferenciaVertice intString = new ReferenciaVertice();
	int tempo = 0;
	int x = 0;

	public String dfs(int adjacency_matrix[][], Vertice[] verticesGrafo,
			String source) {
		String verticeBuscado = "Nao encontrado";
		for (int i = 0; i < verticesGrafo.length; i++) {
			if (verticesGrafo[i].getCor().equals("B")) {
				if (DFSvisit(adjacency_matrix, verticesGrafo[i], verticesGrafo,
						source)) {
					verticeBuscado = source;
					printVerticesVisitados2(source);
					return verticeBuscado;
				}
			}
		}
		return verticeBuscado;
	}

	private boolean DFSvisit(int adjacency_matrix[][], Vertice vertice,
			Vertice[] verticesGrafo, String source) {
		vertice.cor = "C";
		tempo = tempo + 1;
		vertice.distancia = tempo;
		int indiceElemento = stringInt.converter(vertice.getSimbolo());
		verticesVisitadas2.add(vertice);
		if (!vertice.getSimbolo().equals("A") && (vertice.getPredecessor() == null)) {
			System.out.println("vertice.getSimbolo(): "+vertice.getSimbolo());
			System.out.println("verticesVisitadas2.remove(): "+verticesVisitadas2.pop().simbolo);
			verticesVisitadas2.pop();
		}
		for (int i = 0; i < adjacency_matrix.length; i++) {
			if (adjacency_matrix[indiceElemento][i] != 1000 && adjacency_matrix[indiceElemento][i] != 0) {
				if (verticesGrafo[i].getCor().equals("B")) {
					verticesGrafo[i].predecessor = vertice;
					DFSvisit(adjacency_matrix,verticesGrafo[i], verticesGrafo,source);
				}
			}
		}
		vertice.cor = "P";
		tempo = tempo + 1;
		vertice.tempoFinal = tempo;
		verticesVisitadas.add(vertice);
		
		for (Vertice v : verticesVisitadas2) {
			if (v.getSimbolo().equals(source)) {
				return true;
			}
		}
		return false;
	}

	public String printVerticesVisitados2(String source) {
		System.out.print("\nVertices percorridos2:");
		for (Vertice v : verticesVisitadas2) {
			if (!v.getSimbolo().equals(source)) {
				System.out.print("\n[VERTICE: " + v.simbolo + ",");
				System.out.print(" COR: " + v.cor + ",");
				System.out.print(" TEMPO CHEGADA : " + v.distancia + ",");
				System.out.print(" TEMPO FINAL: " + v.tempoFinal + "]\n");

			}else if(v.getSimbolo().equals(source)){
				System.out.print("\n[VERTICE: " + v.simbolo + ",");
				System.out.print(" COR: " + v.cor + ",");
				System.out.print(" TEMPO CHEGADA : " + v.distancia + ",");
				System.out.print(" TEMPO FINAL: " + v.tempoFinal + "]\n");
				return "";
			}
		}
		return "";
	}
}
