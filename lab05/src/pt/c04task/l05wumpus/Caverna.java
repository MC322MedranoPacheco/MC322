package pt.c40task.l05wumpus;

public class Caverna {
	

	public Sala[][] salas = new Sala[4][4];
	
	public Caverna() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4;j++) {
				salas[i][j] = new Sala();
			}
		}
	}
	
	public void printCaverna() {
		for (int i = 0; i < 4; i++) {
			for(int k = 0; k < 4; k++)
				System.out.print(salas[i][k] + " ");
			System.out.println("");
		}
	}
	
	public void moverComponente(String componente, Posicao posicaoInicial, Posicao posicaoFinal) {
		Componente mudado;
		mudado = salas[posicaoInicial.getY()][posicaoInicial.getX()].removerComponente(componente);
		mudado.setPosicao(posicaoFinal.getX(), posicaoFinal.getY());
		salas[posicaoFinal.getY()][posicaoFinal.getX()].adicionarComponente(mudado);
	}
	
	public void adicionarComponente(Posicao posicao, Componente componente) {
		salas[posicao.getY()][posicao.getX()].adicionarComponente(componente); 	
	}
}