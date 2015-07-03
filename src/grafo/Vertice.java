package grafo;

public class Vertice {

	public String cor;
	public String simbolo;
	public int distancia;
	public int tempoFinal;
	public Vertice predecessor;
	
	public Vertice(String cor,String simbolo, int distancia,int tempoFinal , Vertice predecessor) {
		super();
		this.cor = cor;
		this.simbolo = simbolo;
		this.distancia = distancia;
		this.tempoFinal = tempoFinal;
		this.predecessor = predecessor;
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	public int getTempoFinal() {
		return tempoFinal;
	}

	public void setTempoFinal(int tempoFinal) {
		this.tempoFinal = tempoFinal;
	}

	public Vertice getPredecessor() {
		return predecessor;
	}
	public void setPredecessor(Vertice predecessor) {
		this.predecessor = predecessor;
	}
}
