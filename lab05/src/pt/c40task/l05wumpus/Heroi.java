package pt.c40task.l05wumpus;
import java.util.Random;

public class Heroi extends Componente{
	private boolean flecha = true;
	private boolean equipado = false;
	private boolean ouro = false;
	private boolean vivo = true;
	
	public Heroi(int x, int y) {
		super(x, y);
	}
	
	private boolean combate() {
		Random rand = new Random();
		boolean venceu = false;
		if(rand.nextInt(2) == 1)
			venceu = true;
			Posicao adjacentes[] = this.posicao.adjacentes_validos();
			for(int i = 0; i < 4; i++) {
				if(adjacentes[i] != null) {
					caverna.getSala(adjacentes[i]).removerComponente("f");
				}
			}
		return venceu;
	}
	
	/* Funcao realiza um movimento heroi para uma posicao final
	 * retornando o quanto de pontos ele fez nesse movimento, as pontuaçoes de morte, movimentacao, atirar flecha
	 * e matar o Wumpus
	 */
	public int moverHeroi(Posicao posicaoFinal) {
		int pontos = 0;
		try {
			if (posicaoFinal.Valida()) {
				caverna.getSala(posicaoFinal).descobrir();
				caverna.moverComponente("P", this.posicao, posicaoFinal);
			}
			if(!posicaoFinal.Valida()) {
				throw new IllegalArgumentException("Posicao invalida digite novamente");
			}
			else if(caverna.getSala(posicaoFinal).toString().equals("B")) {
				vivo = false;
				pontos -= 1000;
			}
			else if(caverna.getSala(posicaoFinal).toString().equals("W") && equipado == false) {
				vivo = false;
				pontos -= 1000;
			}
			else if(caverna.getSala(posicaoFinal).toString().equals("W") && equipado == true) {
				if(!combate()) {
					vivo = false;
					pontos -= 1000;
				}
				else {
					pontos += 500;
					caverna.getSala(posicaoFinal).removerComponente("W");
				}
			}
			pontos -= 15;
			if (equipado == true) {
				pontos -= 100;
				equipado = false;
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println("Voltando a jogada: " + e.getMessage());
		}
		return pontos;
	}
	
	/* Funcao que equipa uma flecha caso ela esteja disponivel */
	public void setEquipado(boolean equipado) {
		if(flecha) {
			this.equipado = equipado;
			flecha = false;
		}
	}
	
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	
	public void pegarOuro() {
		if(caverna.getSala(posicao).procurarComponente("O")) { // Caso haja o ouro na sala, ele é removido e o boolean de ouro do heroi é atualizado
			caverna.getSala(posicao).removerComponente("O"); 
			ouro = true;
		}
	}
	
	public boolean getOuro() {
		return ouro;
	}

	public boolean getVivo() {
		return vivo;
	}
	
	public boolean getEquipado() {
		return equipado;
	}
	
	public String toString() {
		return "P";
	}
	
	/* Funcao que ve se o heroi ganhou o jogo */
	public boolean ganhou() {
		if (posicao.getX() == 0 && posicao.getY() == 0 && ouro) return true;
		return false;
	}
	
}
