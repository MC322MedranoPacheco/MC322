package pt.c40task.l05wumpus;

public class Sala {
	public Componente[] componentes = new Componente[4];
	public boolean descoberta = false;
	public int numComponentes = 0;
	
	public void descobrir() {
		descoberta = true;
	}
	
	private String maiorPrioridade() {
		String tipoPeca;
		for (int i = 0; i < numComponentes; i++) {
			tipoPeca = componentes[i].toString();
			if (tipoPeca == "W" || tipoPeca == "B" || tipoPeca == "O")
				return tipoPeca;
		}
		for (int i = 0; i < numComponentes; i++) {
			tipoPeca = componentes[i].toString();
			if (tipoPeca == "H")
				return tipoPeca;
		}
		for (int i = 0; i < numComponentes; i++) {
			tipoPeca = componentes[i].toString();
			if (tipoPeca == "f")
				return tipoPeca;
		}
		else return "b";
			
	}
	
	public String toString() {
		String string;
		if (!descoberta)
			string = "-";
		else if(numComponentes == 0)
			string = "#";
		else
			string = componentes[0].toString();
		return string;		
	}
	
	// Adiciona um componente. O componente de maior prioridade fica sempre na primeira posicao
	public void adicionarComponente(Componente componente) {
		int i = 0;
		while(componentes[i] != null)
			i++;
		componentes[i] = componente;
		numComponentes++;
	}
	
	public boolean procurarComponente(String componente) {
		boolean bool = false;
		for (int i = 0; i < numComponentes; i++) {
			if(componentes[i].toString() == componente)
				bool = true;
			}
		return bool;
	}
	
	public void removerComponente(String componente) {
		private Componente removido;
		for (int i = 0; i < numComponentes; i++)
			if (componentes[i].toString() == componente)
				removido = componentes[i];
				componentes[i] = null;
		numComponentes--;
		return removido;
	}
}
	
