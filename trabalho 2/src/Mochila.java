import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.Instant;

public class Mochila {

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
	
	public int MochilaRecursivo(int n, int v[], int w[], int W) {
		if (n == 0 || W == 0) {
			return 0;
		}
		if (w[n] > W) {
			return MochilaRecursivo(n-1, v, w, W);
		} else {
			int usa = v[n] + MochilaRecursivo((n-1), v, w, (W-w[n]));
			int naousa =  MochilaRecursivo(n-1, v, w, W);
			return Math.max(naousa, usa);
		}
	}
	
	public void ChamaMochilaRecursivo() {
		File arquivo = new File(
				"C:\\Users\\Usuario\\Downloads\\furb\\5º SEMESTRE\\Análise de Algoritmos\\mochila5000.in");
		try {
			BufferedReader br = new BufferedReader(new FileReader(arquivo));
			int n, W;
			String str = br.readLine();
			String [] str2 = str.split("\t");
			W = Integer.parseInt(str2[0]);
			n = Integer.parseInt(str2[1]);
			
			int w[] = new int[n];
			int v[]	= new int[n];
			
			n=0;
			while ((str = br.readLine()) != null) {
				String [] str3 = str.split("\t");
				w[n] = Integer.parseInt(str3[0]);
				v[n] = Integer.parseInt(str3[1]);
				n++;
			}
			System.out.println("deu boa");
			
			//long t2 = System.nanoTime();
			//long t2 = System.currentTimeMillis();
			
			Instant inst1 = Instant.now();
			System.out.println(this.MochilaRecursivo(n-1, v, w, W)); //n-1 pq adiciona uma vez a mais
			Instant inst2 = Instant.now();
			
			//long t3 = System.currentTimeMillis();
			//long t3 = System.nanoTime();
			System.out.println("Demorou "+Duration.between(inst1, inst2)+" nano-segundos pra fazer mochila recursivo");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int MochilaDinamicaBottomUp(int n, int v[], int w[], int W) {
		int matriz[][] = new int [n][W];
		for (int x=0; x<W; x++) {
			matriz[0][x] = 0;
		}
		for (int j=0; j<n; j++) {
			matriz[j][0] = 0;
		}
		for (int j=1; j<n; j++) {
			for (int x=0; x<W; x++) {
				if (w[j] > x) {
					matriz[j][x] = matriz[j-1][x];
				} else {
					int usa = v[j] + matriz[j-1][x-w[j]];
					int naousa = matriz[j-1][x];
					matriz[j][x] = Math.max(usa, naousa);
				}
			}
		}
		return matriz[n-1][W-1];
	}
	
	public void ChamaMochilaDinamico() {
		File arquivo = new File(
				"C:\\Users\\Usuario\\Downloads\\furb\\5º SEMESTRE\\Análise de Algoritmos\\mochila5000.in");
		try {
			BufferedReader br= new BufferedReader(new FileReader(arquivo));
			int n, W;
			String str = br.readLine();
			String [] str2 = str.split("\t");
			W = Integer.parseInt(str2[0]);
			n = Integer.parseInt(str2[1]);
			
			int w[] = new int[n];
			int v[]	= new int[n];
			
			n=0;
			while ((str = br.readLine()) != null) {
				String [] str3 = str.split("\t");
				w[n] = Integer.parseInt(str3[0]);
				v[n] = Integer.parseInt(str3[1]);
				n++;
			}
			System.out.println("deu boa");
			
			//long t1 = System.nanoTime();
			//long t1 = System.currentTimeMillis();
			
			Instant inst1 = Instant.now();
			System.out.println(this.MochilaDinamicaBottomUp(n-1, v, w, W)); //n-1 pq adiciona uma vez a mais
			Instant inst2 = Instant.now();
			
			//long t2 = System.currentTimeMillis();
			//long t2 = System.nanoTime();
			//System.out.println("Demorou "+(t2-t1)+" nano-segundos pra fazer mochila recursivo");
			System.out.println("Demorou "+Duration.between(inst1, inst2)+" nano-segundos pra fazer mochila recursivo");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}






























