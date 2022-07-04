package trabaurelio;

public class Mochila {
//	private int capacidade;
//	private int pesos[];
//	private int valores[];
//	private int numItens;
//	
//	public Mochila(int capacidade, int[] pesos, int[] valores, int numItens) {
//		this.capacidade = 8;
//		this.pesos = pesos;
//		this.valores = valores;
//		this.numItens = numItens;
//	}



	public int forcaBruta(int valor[], int[]peso, int numItens) {
		//recebe 2 arrays, um com o peso e um com o valor dos itens, e o numero de itens que deve ser igual
		int lucro = 0;
		int possibilidades = (int) Math.pow(2, numItens);
		for (int i=0; i < possibilidades; i++) {
			String str = Integer.toBinaryString(i);
			int pesoTotal = 0, novoValor = 0;
			for (int j=0; j<str.length(); j++) {
				if (str.charAt(j) == '1') {
					novoValor = novoValor + valor[j];
					pesoTotal = pesoTotal + peso[j];
				}			
			}
			if (pesoTotal <= 8) { 						//teste de viabilidade
				if (lucro < novoValor) { 				//teste de lucro
					lucro = novoValor;
				}	
			}
		}
		return lucro;
	}
}