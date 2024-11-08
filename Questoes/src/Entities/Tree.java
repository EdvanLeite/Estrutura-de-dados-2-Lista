package Entities;

import java.util.Random;

public class Tree {

	public Node rootNode;

	public Node initTree(int value) {
		Node newNode = new Node();
		newNode.setValor(value);
		this.rootNode = newNode;

		return newNode;
	}

	public Node addNode(Boolean decision, int value, Node leafNode) {
		leafNode = this.locateLeaf();

		decision = new Random().nextBoolean();

		if (decision) {

			if (leafNode.getRightNode() == null) {
				Node newNode = new Node();
				newNode.setValor(value);
				leafNode.setRightNode(newNode);
			} else {
				return addNode(null, value, leafNode);
			}
		} else {

			if (leafNode.getLeftNode() == null) {
				Node newNode = new Node();
				newNode.setValor(value);
				leafNode.setLeftNode(newNode);
			} else {
				return addNode(null, value, leafNode);
			}
		}

		return leafNode;
	}

	private int getHeight() {
		return getHeight(rootNode);
	}

	public int getHeight(Node node) {
		if (node == null) {
			return -1;
		}

		int leftHeight = getHeight(node.getLeftNode());
		int rightHeight = getHeight(node.getRightNode());

		return Math.max(leftHeight, rightHeight) + 1;
	}

	public Node locateLeaf() {
		return this.locateNode(this.rootNode);
	}

	public int countNodes() {
		return countNodes(rootNode);
	}

	private int countNodes(Node node) {
		if (node == null) {
			return 0;
		}

		return 1 + countNodes(node.getLeftNode()) + countNodes(node.getRightNode());
	}

	private Node locateNode(Node node) {
		Random decision = new Random();

		if (node.getRightNode() == null || node.getLeftNode() == null) {
			return node;
		}

		if (decision.nextBoolean()) {
			return locateNode(node.getRightNode());
		} else {
			return locateNode(node.getLeftNode());
		}

	}

	private Node addNodeLeft(int value, Node node) {
		Node newLeftNode = new Node();
		newLeftNode.setValor(value);
		node.setLeftNode(newLeftNode);

		return newLeftNode;
	}

	private Node addNodeRight(int value, Node node) {
		Node newRightNode = new Node();
		newRightNode.setValor(value);
		node.setRightNode(newRightNode);

		return newRightNode;
	}

	public Node addLista(Lista list) {
		Bloco bloco = list.inicio;

		while (bloco != null) {
			this.addNode(null, bloco.valor, rootNode);
			bloco = bloco.prox;
		}

		return rootNode;
	}

	public void exibir(Node node) {
		if (node != null) {
			System.out.print(node.getValor() + ", ");
			exibir(node.getLeftNode());
			exibir(node.getRightNode());
		}
	}

	public Lista list(Node node, Lista list) {
	    if (node != null) {
	        list.addElemento(node.getValor());
	        
	        list(node.getLeftNode(), list);
	        
	        list(node.getRightNode(), list);
	    }

	    return list;
	}
	
	
	public Lista listArray(Node node, Lista list, int[] values) {
	    if (node != null) {
	        for (int value : values) {
	            if (node.getValor() == value) {
	                list.addElemento(node.getValor());
	                break; 
	            }
	        }

	        listArray(node.getLeftNode(), list, values);
	        listArray(node.getRightNode(), list, values);
	    }

	    return list;
	}
	
	public void removeSubtree(Node targetNode) {
	    if (targetNode != null) {
	        targetNode.setLeftNode(null);
	        targetNode.setRightNode(null);
	    }
	}
	
	
	
}