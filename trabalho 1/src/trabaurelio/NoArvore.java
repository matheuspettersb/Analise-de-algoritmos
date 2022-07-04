package trabaurelio;

import java.util.ArrayList;

public class NoArvore {
	private int info;
	private NoArvore esq;
	private NoArvore dir;

	public NoArvore(int info, NoArvore esq, NoArvore dir) {
		this.info = info;
		this.dir = dir;
		this.esq = esq;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public NoArvore getEsq() {
		return esq;
	}

	public void setEsq(NoArvore esq) {
		this.esq = esq;
	}

	public NoArvore getDir() {
		return dir;
	}

	public void setDir(NoArvore dir) {
		this.dir = dir;
	}

}
