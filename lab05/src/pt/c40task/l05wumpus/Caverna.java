package pt.c40task.l05wumpus;

public class Caverna {
	 
	// fazer um get sala por posicao

	private Sala[][] salas = new Sala[4][4];
	
	/* Cria a matriz de sala da caverna */
	public Caverna() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4;j++) {
				salas[i][j] = new Sala();
			}
		}
	}
	
	/*Imprime a Caverna */
	public void printCaverna() {
		for (int i = 0; i < 4; i++) {
			for(int k = 0; k < 4; k++)
				System.out.print(salas[i][k] + " ");
			System.out.println("");
		}
	}
	
	public char[][] montaMatriz() {
		char[][] matriz = new char[4][4];
		for (int i = 0; i < 4; i++) {
			for(int k = 0; k < 4; k++)
				matriz[i][k] = salas[i][k].toString().charAt(0);
		}
		return matriz;
	}
	
	/* Dado um tipo de componente representado por uma string, uma posicao inicial e uma final,
	 * Move o componente ate a posicao correta
	 */
	public void moverComponente(String componente, Posicao posicaoInicial, Posicao posicaoFinal) {
		Componente mudado;
		mudado = salas[posicaoInicial.getY()][posicaoInicial.getX()].removerComponente(componente); // Remove o componente
		mudado.setPosicao(posicaoFinal.getX(), posicaoFinal.getY()); //Atualiza a posicao
		salas[posicaoFinal.getY()][posicaoFinal.getX()].adicionarComponente(mudado); // Realoca o componente
	}
	
	// Adiciona determinado componente em uma posicao
	public void adicionarComponente(Posicao posicao, Componente componente) {
		salas[posicao.getY()][posicao.getX()].adicionarComponente(componente); 	
	}
	
	public Sala getSala(int x, int y) {
		return salas[y][x]; 
	}
	
	public Sala getSala(Posicao posicao) {
		return getSala(posicao.getX(), posicao.getY());
	}
}
