package grafo;

import java.util.InputMismatchException;

import java.util.LinkedList;

import java.util.Queue;

public class BFS {

	private Queue<Integer> queue;
	

	public BFS() {

		queue = new LinkedList<Integer>();
	}

	public void/*int[] */bfs(int adjacency_matrix[][], String source) {
		ReferenciaVertice verticeBusca = new ReferenciaVertice();
		int elementoBusca = verticeBusca.converter(source);
		System.out.println("Indice matriz elementoBusca: "+elementoBusca);
		
		for (int i = 0; i < adjacency_matrix.length; i++) {
			for (int j = 0; j < adjacency_matrix.length; j++) {
				if (adjacency_matrix[i][j] > 0) {
					
				}
			}
		}
		
		
		
/*		int number_of_nodes = adjacency_matrix[source].length - 1;
		System.out.println("Numero de nos: "+ number_of_nodes);

		int[] visited = new int[number_of_nodes + 1];
		int i, element;
		visited[source] = 1;

		queue.add(source);
		while (!queue.isEmpty()) {
			element = queue.remove();
			System.out.println("Element: "+element);
			i = element;
			System.out.println("i: "+i + "\t");
			while (i <= number_of_nodes) {
				if (adjacency_matrix[element][i] == 1 && visited[i] == 0) {
					queue.add(i);
					visited[i] = 1;
				}
				i++;
			}
		}
		return visited;*/
	}
	
}
