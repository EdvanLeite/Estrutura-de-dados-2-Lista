package Entities;

public class Lista {

	Bloco inicio;

	public Bloco addElemento(int valor, boolean posicaoIncio) {

		Bloco novo = null;

		if (posicaoIncio == true) {

			novo = this.addElementoInicio(valor);

		} else {

			novo = this.addElementoFim(valor);
		}

		return novo;
	}

	public Bloco addElemento(int valor) {

		Bloco novo = null;

		novo = this.addElementoFim(valor);

		return novo;
	}

	public Bloco addElemento(int valor, int posiçao) {

		Bloco novo = new Bloco(valor);
		Bloco aux;

		if (posiçao == 0) {
			novo.prox = inicio;
			inicio = novo;
		}
		if (posiçao > this.tamanho()) {

			aux = this.localizarBloco(this.tamanho());

			for (int i = this.tamanho(); i < posiçao; i++) {
				Bloco aux2 = new Bloco(0);
				aux.prox = aux2;
				aux = aux.prox;
			}

			novo.prox = aux.prox;
			aux.prox = novo;

		} else {

			aux = this.localizarBloco(posiçao);
			novo.prox = aux.prox;
			aux.prox = novo;
		}

		return novo;
	}

	public Bloco removerElementoFim() {

		Bloco result = null;

		if (this.isVazia()) {
			return result;
		}

		if (this.tamanho() == 1) {
			// this.inicio = null;
			result = this.removerElementoInicio();
		} else {

			Bloco target = this.localizarBloco(this.tamanho() - 1);

			result = target.prox;
			target.prox = null;
		}

		return result;
	}

	public Bloco removerElementoInicio() {

		Bloco result = this.inicio;
		if (!this.isVazia()) {

			this.inicio = this.inicio.prox;
		}

		return result;
	}

	public boolean isVazia() {

		return this.inicio == null;
	}

	private Bloco addElementoInicio(int valor) {

		Bloco novo = new Bloco();
		novo.valor = valor;

		novo.prox = this.inicio;
		this.inicio = novo;

		return novo;
	}

	private Bloco addElementoFim(int valor) {

		Bloco novo = null;

		Bloco fim = this.localizarBloco(this.tamanho());

		if (fim == null) {

			novo = this.addElementoInicio(valor);
		} else {

			novo = new Bloco();
			novo.valor = valor;

			fim.prox = novo;
		}

		return novo;
	}

	public Bloco localizarBloco(int pos) {

		Bloco aux = this.inicio;
		int cont = 0;

		while (aux != null && cont < pos - 1) {

			cont++;
			aux = aux.prox;
		}

		return aux;
	}

	public int tamanho() {

		Bloco aux = this.inicio;
		int cont = 0;

		while (aux != null) {

			cont++;
			aux = aux.prox;
		}

		return cont;
	}

	// Questao 07 (Classe criada em sala de aula)

	public Lista inverterLista() {

		if (this.inicio == null) {
			return null;
		}

		Bloco anterior = null;
		Bloco atual = this.inicio;
		Bloco proximo = null;

		while (atual != null) {
			proximo = atual.prox;
			atual.prox = anterior;
			anterior = atual;
			atual = proximo;

		}

		Lista listaInvertida = new Lista();
		listaInvertida.inicio = anterior;

		return listaInvertida;
	}

	public void exibirLista() {
		Bloco aux = inicio;
		while (aux != null) {
			System.out.print(aux.valor + ", ");
			aux = aux.prox;
		}
	}

	public Lista concatenarListas(Lista list1, Lista list2) {

		Bloco aux = this.localizarBloco(this.tamanho());

		aux.prox = list2.inicio;
		return list1;

	}

	public void removeDuplicados() {
		Bloco aux = this.inicio;

		while (aux != null) {
			Bloco anterior = aux;
			Bloco atual = aux.prox;

			while (atual != null) {
				if (atual.valor == aux.valor) {

					anterior.prox = atual.prox;

				} else {

					anterior = atual;
				}
				atual = atual.prox;
			}

			aux = aux.prox;
		}
	}

	public Lista Clone() {
		Lista list = new Lista();
		Bloco aux = this.inicio;

		while (aux != null) {
			list.addElemento(aux.valor);
			aux = aux.prox;
		}

		return list;

	}

	public void removerComPos(int pos) {
		if (pos == 0) {
			this.removerElementoInicio();
		} else if (pos == this.tamanho()) {
			this.removerElementoFim();
		} else {

			Bloco aux = this.localizarBloco(pos - 1);

			aux.prox = aux.prox.prox;
		}
	}

	
	
	public Lista localizarMaior(int valor) {
		Lista list = new Lista();
		Bloco aux = this.inicio;
		
		while(aux !=null ) {
			if(aux.valor >= valor) {
				list.addElemento(aux.valor);
			}
			
			aux = aux.prox;
		}
		
		return list;
	}
	
	
}