package pt.c40task.l05wumpus;

public class ControleJogo {
	Heroi heroi;
	public ControleJogo(Heroi heroi) {
		this.heroi = heroi;
	}
	
	public void movimento(String comando) {
		Posicao posDest = new Posicao(heroi.getPosicao().getX(), heroi.getPosicao().getY());
		switch (comando) {
		case "w":
			posDest.setY(posDest.getY() - 1);
			heroi.moverHeroi(posDest);
			break;
		case "s":
			posDest.setY(posDest.getY() + 1);
			heroi.moverHeroi(posDest);
			break;
		case "d":	
			posDest.setX(posDest.getX() + 1);
			heroi.moverHeroi(posDest);
			break;
		case "a":	
			posDest.setX(posDest.getX() - 1);
			heroi.moverHeroi(posDest);
			break;
		case "k":
			heroi.setEquipado(true);
			break; 
		case "c":
			heroi.pegarOuro();
			break;
		case "q":
			// Quitar
			break;
		}
	}
}
