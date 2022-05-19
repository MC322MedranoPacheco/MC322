package pt.c40task.l05wumpus;

/* Classa abstrata que representa um componente,
 * Sera herdada por tipos de componentes
 */
public abstract class Componente {
	protected Posicao posicao = new Posicao(0, 0);
	protected static Caverna caverna; 

	public Componente(int x, int y) {
		setPosicao(x, y);
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(int x, int y) {
		posicao.setX(x);
		posicao.setY(y);
	}

	public static void setCaverna(Caverna caverna) {
		Componente.caverna = caverna;
	}
	
	public abstract String toString();
	
}
