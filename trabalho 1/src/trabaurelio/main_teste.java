package trabaurelio;

public class main_teste {

	public static void main(String[] args) {	
		//Arvore teste > resultado esperado [6 11 15 19 8]
//		NoArvore a = new NoArvore(7, null, null);	
//		NoArvore b = new NoArvore(14, null, null);	
//		NoArvore c = new NoArvore(6, null, a);
//		NoArvore d = new NoArvore(12, null, b);	
//		NoArvore e = new NoArvore(8, null, null);	
//		NoArvore f = new NoArvore(4, c, null);	
//		NoArvore g = new NoArvore(5, d, e);
//		NoArvore h = new NoArvore(3, f, g);
//		
//		Arvore arv = new Arvore(h);
//		System.out.println(arv.questao1(arv.getRaiz()));
		
		int[] valores = new int[]{ 40,70,140,100,130,230,110,80 };
		int[] pesos = new int[]{ 2,2,3,3,4,4,5,2 };
		for (int i=0; i<8; i++) {
			System.out.println(pesos[i]+" "+valores[i]);
		}
		Mochila mochila = new Mochila();
		System.out.println(mochila.forcaBruta(valores, pesos, 8));
	}
}
