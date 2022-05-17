package pt.c40task.l05wumpus;

public class ControleJogo { 
	private static Heroi heroi = new Heroi(0,0);
	private static int pontuacao = 0;
	public static char estadoJogo = 'P';
	public static String nome;
	
	private ControleJogo(){
	}
	
	public static void setNome(String nome) {
		ControleJogo.nome = nome;
	}
	
	public static String getNome() {
		return nome;
	}
	
	public static Heroi getHeroi() {
		return heroi;
	}
	
	public static void movimento(String comando) {
		Posicao posDest = new Posicao(heroi.getPosicao().getX(), heroi.getPosicao().getY());
		switch (comando) {
		case "w":
			posDest.setY(posDest.getY() - 1);
			pontuacao += heroi.moverHeroi(posDest);
			if(!heroi.getVivo()) estadoJogo = 'L';
			else if(heroi.ganhou()) { 
				estadoJogo = 'W';
				pontuacao += 1000;
			}
			break;
		case "d":	
			posDest.setX(posDest.getX() + 1);
			pontuacao += heroi.moverHeroi(posDest);
			if(!heroi.getVivo()) estadoJogo = 'L';
			else if(heroi.ganhou()) { 
				estadoJogo = 'W';
				pontuacao += 1000;
			}
			break;
		case "a":	
			posDest.setX(posDest.getX() - 1);
			pontuacao += heroi.moverHeroi(posDest);
			if(!heroi.getVivo()) estadoJogo = 'L';
			else if(heroi.ganhou()) { 
				estadoJogo = 'W';
				pontuacao += 1000;
			}
			break;
		case "s":	
			posDest.setY(posDest.getY() + 1);
			pontuacao += heroi.moverHeroi(posDest);
			if(!heroi.getVivo()) estadoJogo = 'L';
			else if(heroi.ganhou()) { 
				estadoJogo = 'W';
				pontuacao += 1000;
			}
			break;
		case "k":
			heroi.setEquipado(true); // SO pode uma vez !! Depois mudamos isso.
			break; 
		case "c":
			heroi.pegarOuro();
			break;
		case "q":
			estadoJogo = 'q';
			break;
		}
	}
	
	public static char getEstadoJogo() {
		return estadoJogo;
	}
	
	public static int getPontuacao() {
		return pontuacao;
	}
}
