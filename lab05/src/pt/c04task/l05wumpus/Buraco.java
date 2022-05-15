package pt.c40task.l05wumpus;

public class Buraco extends Componente{

	public Buraco(int x, int y, Caverna caverna) {
		super(x, y, caverna);
		Posicao adjacentes[] = posicao.adjacentes_validos();
		for(int i = 0; i < 4; i++) {
			if(adjacentes[i] != null) {
				Componente brisa = new Brisa(adjacentes[i].getX(), adjacentes[i].getY(), caverna);
				caverna.adicionarComponente(adjacentes[i], brisa);
			}
		}
	}

	public String toString() {
		return "B";
	}

	
}
