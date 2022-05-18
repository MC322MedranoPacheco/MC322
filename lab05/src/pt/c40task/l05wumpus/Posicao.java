package pt.c40task.l05wumpus;

/* Classe que representa uma posicao na caverna */
public class Posicao {
	int x, y;
	public Posicao(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Posicao (Posicao posicao) {
		this.x = posicao.getX();
		this.y = posicao.getY();
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean Valida() {
		return x >= 0 && x < 4 && y >= 0 && y < 4;
	}
	
	/* funcao que verifica se as salas adjacentes sao casas validas e retorna num vetor
	de posicoes as posicoes das mesmas caso sejam validas e null caso nao sejam */
	
	public Posicao[] adjacentes_validos() {
		Posicao cima = new Posicao(x, y - 1);
		Posicao baixo = new Posicao(x, y + 1);
		Posicao esquerda = new Posicao(x - 1, y);
		Posicao direita = new Posicao(x + 1, y);
		
		Posicao adjacentes[] = new Posicao[4];
		adjacentes[0] = cima;
		adjacentes[1] = baixo;
		adjacentes[2] = esquerda;
		adjacentes[3] = direita;
		
		for(int i = 0; i < 4; i++) {
			if(!adjacentes[i].Valida())
				adjacentes[i] = null;
		}
		return adjacentes;
	}
	
}
