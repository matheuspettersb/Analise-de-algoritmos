import java.util.Random;

public class NRainhas {
	private int n = 8;
	int tabuleiro[][] = new int[n][n];
	int vetor[] = new int[n];
	
	public void printaSolucao(int tabuleiro[][], int vetor[]) {
		System.out.println(	"Em tabuleiro:");
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(" "+tabuleiro[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("Em vetor:");
				
		int i = 0;
		while (i<n) {
			System.out.print(" "+(vetor[i]+1));
			i++;
		}
	}
	
	public void sortear() {
		Random random = new Random();
		int i=0;
		
		while(i<n) {
			int x = random.nextInt(n*1000)/1000;
			vetor[i] = x;		//criou o tabuleiro (em vetor)
			i++;
		} 
		
		for (i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (j==vetor[i]) {
					tabuleiro[j][i] = 1;
				} else {
					tabuleiro[j][i] = 0;
				}
			}
		}
		return;
	}
	
	public boolean checaSafe() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if (tabuleiro[i][j]==1) {
					if (!checaSafeSub(i, j)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	public boolean checaSafeSub(int i,int j) {
		//verificação horizontal
		for (int k=0; k<n; k++) {
			if (k!=j) {
				if (tabuleiro[i][k]==1) {
					return false;
				}
			}
		}
		//verificação vertical
		for (int k=0; k<n; k++) {
			if (k!=i) {
				if (tabuleiro[k][j]==1) {
					return false;
				}
			}
		}
		//verificação diagonal > 4 verificações
		int k = i;
		int	l = j;
		//diagonal superior esquerda (--)
		if (k!=0 && l!=0) {
			k--;
			l--;
			while (k>-1 && l>-1) {
				if (tabuleiro[k][l]==1) {
					return false;
				}
				k--;
				l--;
			}
		}
		
		//diagonal superior direita (-+)
		k = i;
		l = j;
		if (k!=0 && l!=n) {
			k--;
			l++;
			while (k>-1 && l<n) {
				if (tabuleiro[k][l]==1) {
					return false;
				}
				k--;
				l++;
			}
		}
		
		//diagonal inferior esquerda (+-)
		k = i;
		l = j;
		if (k!=n && l!=0) {
			k++;
			l--;
			while (k<n && l>-1) {
				if (tabuleiro[k][l]==1) {
					return false;
				}
				k++;
				l--;
			}
		}
		
		//diagonal inferior direita (++)
		k = i;
		l = j;
		if (k!=n && l!=n) {
			k++;
			l++;
			while (k<n && l<n) {
				if (tabuleiro[k][l]==1) {
					return false;
				}
				k++;
				l++;
			}
		}
		
		//System.out.println("k: "+k+", l: "+l);
		return true;
	}
	
	public void solucionaRainhas() {		
		System.out.println("Situação inicial:");
		sortear();
		printaSolucao(tabuleiro, vetor);
		
		int counter = 0;
		while(!checaSafe() || counter<500) {
			sortear();
			counter++;
		}
		if (checaSafe()) {
			System.out.println("\n\nSolução encontrada:");
			printaSolucao(tabuleiro, vetor);
			return;
		}
		if (counter == 500) {
			System.out.println("Não encontrou solução");
			return;
		}
	}
}

















