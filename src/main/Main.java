package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Integer> listaHeap = new ArrayList<Integer>();

		Character c = 'S';

		while (c.equals('S')) {
			System.out.println("Digite um numero na lista :");
			Integer numeroLista = sc.nextInt();
			listaHeap.add(numeroLista);

			System.out.println("Adicionar outro numero S/N");
			c = sc.next().charAt(0);
		}

		System.out.println("Vetor original :");
		for (int i = 0; i < listaHeap.size(); i++) {
			System.out.print(listaHeap.get(i) + " ");
		}

		List<Integer> ordenado = new ArrayList<Integer>();

		while (listaHeap.size() != 0) {
			Integer tamanhoLista = listaHeap.size();
			for (int i = tamanhoLista / 2 - 1; i >= 0; i--) {
				buscarMenorValor(listaHeap, tamanhoLista, i);
			}
			ordenado.add(listaHeap.get(0));
			listaHeap.remove(0);
		}

		System.out.println();
		System.out.println("ordenado");
		for (int i = 0; i < ordenado.size(); i++) {
			System.out.print(ordenado.get(i) + " ");
		}
	}

	private static void buscarMenorValor(List<Integer> listaHeap, int tamanhoLista, int indiceRaiz) {
		int raiz = indiceRaiz;
		int filhoEsquerdo = 2 * indiceRaiz + 1;
		int filhoDireita = 2 * indiceRaiz + 2;

		if (filhoEsquerdo < tamanhoLista && listaHeap.get(filhoEsquerdo) < listaHeap.get(raiz)) {
			raiz = filhoEsquerdo;
		}
		if (filhoDireita < tamanhoLista && listaHeap.get(filhoDireita) < listaHeap.get(raiz)) {
			raiz = filhoDireita;
		}

		if (raiz != indiceRaiz) {
			int aux = listaHeap.get(indiceRaiz);
			listaHeap.set(indiceRaiz, listaHeap.get(raiz));
			listaHeap.set(raiz, aux);
			buscarMenorValor(listaHeap, tamanhoLista, raiz);
		}
	}
}