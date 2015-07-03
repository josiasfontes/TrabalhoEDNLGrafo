package grafo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {
	Stack<Vertice> pilhaexecucao = new Stack<Vertice>();
	Queue<Vertice> verticesVisitadas = new LinkedList<Vertice>();
	ReferenciaVertice stringInt = new ReferenciaVertice();
	ReferenciaVertice intString = new ReferenciaVertice();
	int tempo = 0;
	
	public String dfs(int adjacency_matrix[][], Vertice[] verticesGrafo,String source){
		String verticeBuscado = "Nao encontrado";
		for (int i = 0; i < verticesGrafo.length; i++) {
			if (verticesGrafo[i].getCor().equals("B")) {
				verticesGrafo[i].distancia = tempo;
				//System.out.println("verticesGrafo[i].getDistancia(): "+verticesGrafo[i].getDistancia());
				pilhaexecucao.push(verticesGrafo[i]);
				if (DFSvisit(adjacency_matrix, verticesGrafo[i],verticesGrafo,source).equals(source)) {
					verticeBuscado = verticesGrafo[i].getSimbolo();
				}
			}
		}
		return verticeBuscado;
	}

	private String DFSvisit(int adjacency_matrix[][],Vertice vertice,Vertice[] verticesGrafo,String source) {
		String verticeBuscado = "Nao encontrado";
		
		vertice.cor = "C";
		tempo = tempo + 1;
		vertice.distancia = tempo;
		
		//System.out.println(pilhaexecucao.peek().getSimbolo());
		int indiceElemento = stringInt.converter(vertice.getSimbolo());
		verticesVisitadas.add(vertice);
		if (vertice.getSimbolo().equals(source)) {
			verticeBuscado = source;
		}else{
			indiceElemento = intString.converter(pilhaexecucao.peek().getSimbolo());
			for (int i = 0; i < adjacency_matrix.length; i++) {
				System.out.println("adjacency_matrix[indiceElemento][i]: ["+indiceElemento+"]["+i+"]"+adjacency_matrix[indiceElemento][i]);
				if (adjacency_matrix[indiceElemento][i] != 1000 && adjacency_matrix[indiceElemento][i] != 0) {
					String simbolo = intString.converterString(i);
					/*if (simbolo.equals(source)) {
						verticeBuscado = simbolo;
					}else{*/
						int indiceSimbolo = stringInt.converter(simbolo);
						if (verticesGrafo[indiceSimbolo].getSimbolo().equals(simbolo)) {
							if(verticesGrafo[indiceSimbolo].getCor().equals("B")){
								verticesGrafo[indiceSimbolo].predecessor = vertice;
								pilhaexecucao.push(verticesGrafo[indiceSimbolo]);
								DFSvisit(adjacency_matrix,verticesGrafo[indiceSimbolo] , verticesGrafo, source);
							}
						}
						/*//indice elemento = indice que foi removido da pilha
						//int xx = intString.converter(pilhaexecucao.peek().getSimbolo());
						for (int j = indiceElemento; j < verticesGrafo.length; j++) {
							if (verticesGrafo[j].getSimbolo().equals(simbolo)) {
								if (verticesGrafo[j].getCor().equals("B")) {
									verticesGrafo[j].predecessor = vertice;
									pilhaexecucao.push(verticesGrafo[j]);
									DFSvisit(adjacency_matrix,verticesGrafo[j] , verticesGrafo, source);
								}
							}
						}*/
					}
//				}else{
					
	//			}
			}
			vertice.cor = "P";
			tempo = tempo + 1;
			vertice.tempoFinal = tempo;
			pilhaexecucao.pop();
		}
		
		
		if (!verticeBuscado.equals("Nao encontrado")) {
			System.out.print("\nVertices percorridos:");
			for (Vertice v: verticesVisitadas) {
				System.out.print("\n[VERTICE: "+v.simbolo+",");
				System.out.print(" COR: "+v.cor+",");
				System.out.print(" TEMPO CHEGADA : "+v.distancia+",");
				System.out.print(" TEMPO FINAL: "+v.tempoFinal+"]");
			}
		}

		return verticeBuscado;
	}
}
