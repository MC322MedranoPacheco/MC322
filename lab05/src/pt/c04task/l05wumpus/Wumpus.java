package pt.c40task.l05wumpus;

public class Wumpus extends Componente{

	public Wumpus(int x, int y) {
		super(x, y);
		Posicao adjacentes[] = posicao.adjacentes_validos();
		for(int i = 0; i < 4; i++) {
			if(adjacentes[i] != null) {
				Componente fedor = new Fedor(adjacentes[i].getX(), adjacentes[i].getY());
				caverna.adicionarComponente(adjacentes[i], fedor);
			}
		}
	}

	public String toString() {
		return "W";
	}
	
}
