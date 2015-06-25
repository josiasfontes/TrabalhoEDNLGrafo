package grafo;

public class Grafo {
	private final int NUMERO_MAXIMO_VERTICES;

	private int matriz_adjacencia[][];
	private char[] vertices = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z' };

	public Grafo(int numero_vertices) {

		NUMERO_MAXIMO_VERTICES = numero_vertices;
		matriz_adjacencia = new int[NUMERO_MAXIMO_VERTICES][NUMERO_MAXIMO_VERTICES];

		printMatriz(numero_vertices);
	}

	public void printMatriz(int numero_vertices) {
		for (int i = 0; i < numero_vertices; i++) {
			System.out.print("   " + vertices[i] + "");
		}
		System.out.println();

		for (int i = 0; i < numero_vertices; i++) {
			System.out.print(vertices[i]);
			for (int j = 0; j < numero_vertices; j++) {
				System.out.print("  " + matriz_adjacencia[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void setAresta(int vertice_origem, int vertice_destino,int pesoAresta) {
		try {
		
			matriz_adjacencia[vertice_origem][vertice_destino] = pesoAresta;
		} catch (ArrayIndexOutOfBoundsException indexBounce) {

			System.out.println("Vertice nao presente!");
		}

	}

	public int converter(String referenciaVertice) {
		int vertice = -1;

		switch (referenciaVertice) {
		case "A":
			vertice = 0;
			break;
		case "B":
			vertice = 1;
			break;
		case "C":
			vertice = 2;
			break;
		case "D":
			vertice = 3;
			break;
		case "E":
			vertice = 4;
			break;
		case "F":
			vertice = 5;
			break;
		case "G":
			vertice = 6;
			break;
		case "H":
			vertice = 7;
			break;
		case "I":
			vertice = 8;
			break;
		case "J":
			vertice = 9;
			break;
		case "K":
			vertice = 10;
			break;
		case "L":
			vertice = 11;
			break;
		case "M":
			vertice = 12;
			break;
		case "N":
			vertice = 13;
			break;
		case "O":
			vertice = 14;
			break;
		case "P":
			vertice = 15;
			break;
		case "Q":
			vertice = 16;
			break;
		case "R":
			vertice = 17;
			break;
		case "S":
			vertice = 18;
			break;
		case "T":
			vertice = 19;
			break;
		case "U":
			vertice = 20;
			break;
		case "V":
			vertice = 21;
			break;
		case "W":
			vertice = 22;
			break;
		case "X":
			vertice = 23;
			break;
		case "Y":
			vertice = 24;
			break;
		case "Z":
			vertice = 25;
			break;
		default:
			break;
		}
		return vertice;
	}

	public int getAresta(int vertice_origem, int vertice_destino) {

		try {

			return matriz_adjacencia[vertice_origem][vertice_destino];

		} catch (ArrayIndexOutOfBoundsException indexBounce) {

			System.out.println("Vertice nao presente!");
		}

		return -1;
	}
}
