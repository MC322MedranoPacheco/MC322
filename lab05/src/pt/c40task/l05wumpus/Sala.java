package pt.c40task.l05wumpus;

public class Sala {
	private Componente[] componentes = new Componente[4];
	private boolean descoberta = false;
	private int numComponentes = 0;
	
	public Sala() {};
	
	public void descobrir() {
		descoberta = true;
	}
	
	public String toString() {
		String string;
		if (!descoberta) // Caso a sala nao esteja descoberta, a string passa a ser "-"
			string = "-";
		else if(numComponentes == 0) // Caso a sala esteja vazia, a string passa a ser "#"
			string = "#";
		else { // A string passa a ser o toString do componente de maior prioridade
			int i = 0;
			while (componentes[i] == null)
				i++;
			string = componentes[i].toString();
		}
		return string;		
	}
	
	/* Adiciona um componente na sua devida posicao do vetor */
	public void adicionarComponente(Componente componente) {
		if(componente.toString().equals("B") || componente.toString().equals("W") || componente.toString().equals("O"))
			componentes[0] = componente;
		else if(componente.toString().equals("P"))
			componentes[1] = componente;
		else if(componente.toString().equals("f"))
			componentes[2] = componente;
		else 
			componentes[3] = componente;
		numComponentes++;
	}
	
	/* Verifica se um componente, que é representado por uma String, esta na sala*/
	public boolean procurarComponente(String componente) {
		boolean bool = false;
		for (int i = 0; i < 4; i++) {
			if(componentes[i] !=null && componentes[i].toString() == componente)
				bool = true;
			}
		return bool;
	}
	
	/* Remove um componente da sala retornando o mesmo */
	public Componente removerComponente(String componente) {
		Componente removido = null;
		for (int i = 0; i < 4; i++) {
			if (componentes[i] != null && componentes[i].toString().equals(componente)) {
				removido = componentes[i];
				componentes[i] = null;
				numComponentes--;
			}
		}
		return removido;
	}
}
