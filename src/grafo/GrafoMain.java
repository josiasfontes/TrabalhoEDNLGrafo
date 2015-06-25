package grafo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GrafoMain{

	public static void main(String... arg){

		System.out.println("GRAFO ORIENTADO!");
		
		int numero_vertices, peso, count = 1;
		String origem,destino,xx;
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		Grafo adjacencyMatrix;

		try{
			System.out.print("Digite o numero de Vertices: ");
			numero_vertices = scan.nextInt();
			adjacencyMatrix = new Grafo(numero_vertices);
			
			System.out.print("Digite o numero de Aresta: ");
			int numero_arestas = scan.nextInt();
			System.out.println("Digite as arestas do Grafo :<ORIGEM><DESTINO><PESO> ");

			while (count <= numero_arestas){
				
				xx = scan2.nextLine();
				origem = String.valueOf(xx.charAt(0));
				destino = String.valueOf(xx.charAt(1));
				peso = Integer.parseInt(xx.substring(2));
				
				System.out.println(origem);
				System.out.println(destino);
				System.out.println(peso);
				
				int vorigem = adjacencyMatrix.converter(origem.toUpperCase());
				int vdestino = adjacencyMatrix.converter(destino.toUpperCase());
				adjacencyMatrix.setAresta(vorigem, vdestino, peso);
				count++;
			}
			
			adjacencyMatrix.printMatriz(numero_vertices);
			
		} catch (InputMismatchException inputMisMatch){

			System.out
					.println("Error in Input Format.<source index> <destination index>");
		}
		scan.close();
		scan2.close();
	}
}