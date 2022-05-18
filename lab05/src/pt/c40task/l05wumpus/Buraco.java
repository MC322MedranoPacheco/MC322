package pt.c40task.l05wumpus;

public class Buraco extends Componente{
	
	/* construtor que coloca os componentes secundarios do mesmo nas salas corretas */
	public Buraco(int x, int y) {
		super(x, y);
		Posicao adjacentes[] = posicao.adjacentes_validos();
		for(int i = 0; i < 4; i++) {
			if(adjacentes[i] != null) {
				Componente brisa = new Brisa(adjacentes[i].getX(), adjacentes[i].getY());
				caverna.adicionarComponente(adjacentes[i], brisa); // Adiciona na caverna as brisas
			}
		}
	}

	public String toString() {
		return "B";
	}

	
}
