package pt.c40task.l05wumpus;

public class Heroi extends Componente{
	private boolean flecha = true;
	private boolean equipado = false;
	private boolean ouro = false;
	private boolean vivo = true;
	
	public Heroi(int x, int y) {
		super(x, y);
	}
	
	private static boolean combate() {
		Random rand = new Random();
		boolean venceu = false;
		if(rand.nextInt(1) == 1)
			venceu = true;
		return venceu;
	}
	
	public void moverHeroi(Posicao posicaoFinal) {
		if (!posicaoFinal.Valida()) 
			;
		else if(caverna.getSala(posicaoFinal.getX(), posicaoFinal.getY()).toString().equals("B"))
			vivo = false;
		else if(caverna.getSala(posicaoFinal.getX(), posicaoFinal.getY()).toString().equals("W") && equipado == false)
			vivo = false;
		else if(caverna.getSala(posicaoFinal.getX(), posicaoFinal.getY()).toString().equals("W") && equipado == true) {
			if(!combate())
				vivo = false;
			else {
				caverna.moverComponente("P", this.posicao, posicaoFinal);
				caverna.getSala(posicaoFinal.getX(), posicaoFinal.getY()).descobrir();
			}
		}
		else {
			caverna.moverComponente("P", this.posicao, posicaoFinal);
			caverna.getSala(posicaoFinal.getX(), posicaoFinal.getY()).descobrir();
		}
	}
	
	public void setFlecha(boolean flecha) {
		this.flecha = flecha;
	}
	
	public void setEquipado(boolean equipado) {
		if(flecha)
			this.equipado = equipado;
	}
	
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	
	public void pegarOuro() {
		if(caverna.getSala(posicao.getX(), posicao.getY()).procurarComponente("O")) {
			caverna.getSala(posicao.getX(), posicao.getY()).removerComponente("O");
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
	
	
}
