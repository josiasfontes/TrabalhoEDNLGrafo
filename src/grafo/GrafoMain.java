package grafo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GrafoMain{
	
	public static void main(String... arg){
		
		BFS bfs = new BFS();
		DFS dfs = new DFS();
		int teste[][] = null;
		
		System.out.println("GRAFO ORIENTADO!");
		
		int numero_vertices, peso, count = 1;
		String origem,destino,entrada;
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		ReferenciaVertice verticeReferencia = new ReferenciaVertice();
		Grafo adjacencyMatrix = null;

		try{
			//System.out.print("Digite o numero de Vertices: ");
			//numero_vertices = scan.nextInt();
			numero_vertices = 4;
			adjacencyMatrix = new Grafo(numero_vertices);
			
			//System.out.print("Digite o numero de Aresta: ");
			//int numero_arestas = scan.nextInt();
			int numero_arestas = 3;
			//System.out.println("Digite as arestas do Grafo :<ORIGEM><DESTINO><PESO> ");
			
			
			/*while (count <= numero_arestas){
				entrada = scan2.nextLine();
				origem = String.valueOf(entrada.charAt(0));
				destino = String.valueOf(entrada.charAt(1));
				peso = Integer.parseInt(entrada.substring(2));
				
				int vorigem = verticeReferencia.converter(origem.toUpperCase());
				int vdestino = verticeReferencia.converter(destino.toUpperCase());
				adjacencyMatrix.setAresta(vorigem, vdestino, peso);
				
				count++;
			}*/
			
			adjacencyMatrix.setAresta(0, 1, 1);
			adjacencyMatrix.setAresta(1, 2, 1);
			adjacencyMatrix.setAresta(0, 3, 1);
			teste = adjacencyMatrix.getMatriz_adjacencia();
			adjacencyMatrix.printMatriz(numero_vertices);
		} catch (InputMismatchException inputMisMatch){

			System.out
					.println("Error in Input Format.<source index> <destination index>");
		}
		System.out.println("Digite o vertice a ser buscado: ");
		String busca;
//		busca = scan2.nextLine();
		busca = "D";	
		//System.out.print("\nResultado da busca: "+bfs.bfs(teste,adjacencyMatrix.getVerticesGrafo(), busca.toUpperCase()));
		System.out.print("\nResultado da busca: "+dfs.dfs(teste,adjacencyMatrix.getVerticesGrafo(), busca.toUpperCase()));
		
		scan.close();
		scan2.close();
	}
}