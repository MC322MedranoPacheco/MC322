package pt.c40task.l05wumpus;

public abstract class Componente {
	public Posicao posicao;
	public Caverna caverna;

	public Componente(int x, int y) {
		setPosicao(x,y);
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(int x, int y) {
		posicao.setPosicaoX(x);
		posicao.setPosicaoY(y);
	}

	public abstract String toString();
	
}