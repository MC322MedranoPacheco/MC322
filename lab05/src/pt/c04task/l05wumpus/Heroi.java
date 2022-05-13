package pt.c40task.l05wumpus;

public class Heroi extends Componente{
	private boolean flecha = true;
	private boolean equipado = false;
	private boolean ouro = false;
	private boolean vivo = true;
	
	public Heroi(int x, int y) {
		super(x,y);
	}
	
	public void moverHeroi(Posicao posicaoFinal) {
		caverna.moverComponente("H", this.posicao, posicaoFinal);
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
		if(caverna.salas[posicao.getY()][posicao.getX()].procurarComponente("O")) { //RUIMZAO
			caverna.salas[posicao.getY()][posicao.getX()].removerComponente("O");
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
		return "H";
	}
	
	
}