package grafo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GrafoMain{
	
	public static void main(String... arg){
		//Grafo grafo = new Grafo();
		BFS bfs = new BFS();
		int teste[][] = null;
		
		System.out.println("GRAFO ORIENTADO!");
		
		int numero_vertices, peso, count = 1;
		String origem,destino,entrada;
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		ReferenciaVertice verticeReferencia = new ReferenciaVertice();
		Grafo adjacencyMatrix;

		try{
			System.out.print("Digite o numero de Vertices: ");
			numero_vertices = scan.nextInt();
			adjacencyMatrix = new Grafo(numero_vertices);
			
			System.out.print("Digite o numero de Aresta: ");
			int numero_arestas = scan.nextInt();
			System.out.println("Digite as arestas do Grafo :<ORIGEM><DESTINO><PESO> ");
			
			
			while (count <= numero_arestas){
				entrada = scan2.nextLine();
				origem = String.valueOf(entrada.charAt(0));
				destino = String.valueOf(entrada.charAt(1));
				peso = Integer.parseInt(entrada.substring(2));
				
				int vorigem = verticeReferencia.converter(origem.toUpperCase());
				int vdestino = verticeReferencia.converter(destino.toUpperCase());
				adjacencyMatrix.setAresta(vorigem, vdestino, peso);
				
				count++;
			}
			teste = adjacencyMatrix.getMatriz_adjacencia();
			adjacencyMatrix.printMatriz(numero_vertices);
		} catch (InputMismatchException inputMisMatch){

			System.out
					.println("Error in Input Format.<source index> <destination index>");
		}
		
		String busca;
		busca = scan2.nextLine();
		/*int teste2[]= bfs.bfs(teste, busca);
        System.out.println("Vertices Visitados: ");
        for (int i = 0; i < teste.length; i++) {
        	System.out.println("Vertice: "+teste2[i]);
		}*/
		bfs.bfs(teste, busca);
        
		
		scan.close();
		scan2.close();
	}
}