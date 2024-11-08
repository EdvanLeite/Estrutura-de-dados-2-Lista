package Application;

import java.util.Random;

import Entities.Lista;
import Entities.Node;
import Entities.Tree;

public class Program {
	public static void main(String Args[]) {
		
		Random rd =  new Random();
		
		Tree arvore = new Tree();
		Lista list = new Lista();
		
		arvore.initTree(1000);
	
		int values[] = new int[50];
		
		for(int i =0;i<50;i++) {
			values[i] = i;
		}
		
		
		for(int i =0;i<10;i++) {
			list.addElemento(rd.nextInt(90));
			arvore.exibir(arvore.rootNode);
			System.out.println();
			arvore.addNode(null, rd.nextInt(90), new Node());
		
		}
		
		System.out.println();
        System.out.print("Arvore: "); 
		arvore.exibir(arvore.rootNode);
		System.out.println();
		System.out.println("Numero de Nós: " + arvore.countNodes());
		System.out.println("Altura da Arvore: "+arvore.getHeight(arvore.rootNode));
		System.out.println("Folha Aleatoria: " + arvore.locateLeaf().getValor());
		System.out.println();
		
		System.out.print("Lista Aleatoria: ");
		list.exibirLista();
		
		arvore.addLista(list);
		System.out.println();
		System.out.println();
		System.out.println("Arvore Após Adicionar a lista: ");
		arvore.exibir(arvore.rootNode);
		System.out.println();
		System.out.println("Numero de Nós: " + arvore.countNodes());
		System.out.println("Altura da Arvore: "+arvore.getHeight(arvore.rootNode));
		System.out.println("Folha Aleatoria: " + arvore.locateLeaf().getValor());
		System.out.println();
		
		
		System.out.println();
		System.out.println("Lista criada Apartir da Arvore: " );
		arvore.list(arvore.rootNode, new Lista()).exibirLista();
		System.out.println();
		
		

		System.out.println();
		System.out.println("Lista criada Apartir da Arvore, somente com valores presentes no vetor (1 até 50): " );
		arvore.listArray(arvore.rootNode, list, values).exibirLista();
		
		Node rmv = new Node();
		
		rmv = arvore.locateLeaf();
		System.out.println();
		System.out.println("Nó removido: " + rmv.getValor());
		
		arvore.removeSubtree(rmv);
		System.out.println();
		arvore.exibir(arvore.rootNode);
		
		
	
		
	}

}
