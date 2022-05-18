package pt.c40task.l05wumpus;

/*Classe que controla o jogo, seu estado e a pontuacao */
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
	
	/* Funcao que recebe um comando para o heroi e o realiza, atualizando o valor da pontuacao conforme o esperado */
	public static void movimento(String comando) {
		Posicao posDest = new Posicao(heroi.getPosicao());
		switch (comando) {
		case "w":
			posDest.setY(posDest.getY() - 1);
			pontuacao += heroi.moverHeroi(posDest); // Adiciona a pontuacao o tanto de pontos feito pelo heroi e realiza o movimento
			if(!heroi.getVivo()) estadoJogo = 'L'; // Caso o heroi tenha morrido, muda-se o estado do jogo
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
			heroi.setEquipado(true); // Equipa a flecha
			break; 
		case "c":
			heroi.pegarOuro(); // Pega o ouro
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
