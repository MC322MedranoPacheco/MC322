package pt.c40task.l05wumpus;

public abstract class Componente {
	public Posicao posicao = new Posicao(0, 0);
	public Caverna caverna;

	public Componente(int x, int y) {
		setPosicao(x,y);
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(int x, int y) {
		posicao.setX(x);
		posicao.setY(y);
	}

	public abstract String toString();
	
}