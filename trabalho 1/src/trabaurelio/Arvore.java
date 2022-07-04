package trabaurelio;

import java.util.ArrayList;
import java.util.TreeMap;

public class Arvore {
	private NoArvore raiz;

	public Arvore(NoArvore raiz) {
		this.raiz = raiz;
	}

	public NoArvore getRaiz() {
		return this.raiz;
	}

	public void setRaiz(NoArvore r) {
		this.raiz = r;
	}

	public String questao1(NoArvore raiz) {
		if (raiz == null) {
			return null;
		}
		TreeMap<Integer, Integer> mapaArvore = new TreeMap<Integer, Integer>();
		// Chama submetodo para armazenar os valores da soma vertical em mapaArvore
		questao1Sub(raiz, 0, mapaArvore);
		return mapaArvore.toString();
	}

	private void questao1Sub(NoArvore raiz, int distanciaHorizontal, TreeMap<Integer, Integer> mapaArvore) {
		if (raiz == null) {
			return;
		}
		// Armazaena os valores da subarvore a esquerda
		questao1Sub(raiz.getEsq(), distanciaHorizontal - 1, mapaArvore);
		// atualiza a soma pro nó atual

		int soma;
		if (mapaArvore.get(distanciaHorizontal) == null) {
			soma = 0;
		} else {
			soma = mapaArvore.get(distanciaHorizontal);
		}
		mapaArvore.put(distanciaHorizontal, soma + raiz.getInfo());
		// armazena os valores da subarvore a direita
		questao1Sub(raiz.getDir(), distanciaHorizontal + 1, mapaArvore);
	}
}
