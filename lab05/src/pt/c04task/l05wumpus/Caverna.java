package pt.c40task.l05wumpus;

public class Caverna {

	public Sala[][] salas;

	public void moverComponente(String componente, Posicao posicaoInicial, Posicao posicaoFinal) {
		Componente mudado;
		mudado = salas[posicaoInicial.getY()][posicaoInicial.getX()].removerComponente(componente);
		salas[posicaoFinal.getY()][posicaoFinal.getX()].adicionarComponente(mudado);
	}

}
