package Entities;

public class Bloco {
	
	public int valor;
	public Bloco prox;
	
	
	public Bloco() {
	}
	
	public Bloco(int valor) {
		this.valor = valor;
	}

	public Bloco(int valor, Bloco prox) {
		this.valor = valor;
		this.prox = prox;
	}

	@Override
	public String toString() {
		return valor + "";
	}

	
	
	

}