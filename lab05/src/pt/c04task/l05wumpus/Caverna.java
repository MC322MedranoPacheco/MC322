package pt.c40task.l05wumpus;

public class Caverna {

	public Sala[][] salas;

	public void moverComponente(String componente, Posicao posicaoInicial, Posicao posicaoFinal) {
		private Componente mudado;
		mudado = salas[posicaoInicial.getPosicaoY()][posicaoInicial.getPosicaoX()].removerComponente(componente);
		salas[posicaoFinal.getPosicaoY()][posicaoFinal.getPosicaoX()].adicionarComponente(mudado);
	}

}
