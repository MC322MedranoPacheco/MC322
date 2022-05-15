package pt.c40task.l05wumpus;

public abstract class Componente {
	public Posicao posicao = new Posicao(0, 0);
	public Caverna caverna; // Sepa q isso podia ser static

	public Componente(int x, int y, Caverna caverna) {
		setPosicao(x,y);
		this.caverna = caverna;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(int x, int y) {
		posicao.setX(x);
		posicao.setY(y);
	}

	public void setCaverna(Caverna caverna) {
		this.caverna = caverna;
	}
	
	public abstract String toString();
	
}