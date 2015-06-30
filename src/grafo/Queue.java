package grafo;

public class Queue {
	private final int SIZE = 26;
	private Vertice[] fila;
	private int inicio, fim;
	private int quantElementos = 0;

	// -------------------------------------------------------------
	public Queue() {// constructor

		this.fila = new Vertice[SIZE];
		this.inicio = -1;
		this.fim = -1;
	}

	public void enfileirar(Vertice v) { // put item at rear of queue
		if (inicio == -1) {
			inicio = 0;
		}
		fim++;
		fila[fim] = v;
		quantElementos++;
	}

	// -------------------------------------------------------------
	public Vertice remove() { // take item from front of queue
		Vertice verticeRemovido = fila[inicio];
		inicio++;
        quantElementos--;
        return verticeRemovido;
	}
	
	public boolean filaVazia(){
		if (quantElementos == 0) {
			return true;
		}
		return false;
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFim() {
		return fim;
	}

	public void setFim(int fim) {
		this.fim = fim;
	}
	
	public Vertice elementoFila(){
		return fila[inicio];
	}

}
