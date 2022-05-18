package pt.c40task.l05wumpus;

public class Wumpus extends Componente{

	/* construtor que coloca os componentes secundarios do mesmo nas salas corretas */
	public Wumpus(int x, int y) {
		super(x, y);
		Posicao adjacentes[] = posicao.adjacentes_validos();
		for(int i = 0; i < 4; i++) {
			if(adjacentes[i] != null) {
				Componente fedor = new Fedor(adjacentes[i].getX(), adjacentes[i].getY());
				caverna.adicionarComponente(adjacentes[i], fedor); // Adiciona o fedor nas salas adjacentes
			}
		}
	}

	public String toString() {
		return "W";
	}
	
}
