
package pt.c40task.l05wumpus;

public class Sala {
	public Componente[] componentes = new Componente[4];
	public boolean descoberta = false;
	public int numComponentes = 0;
	
	public Sala() {};
	
	public void descobrir() {
		descoberta = true;
	}
	
	public String maiorPrioridade() {
		String tipoPeca;
		for (int i = 0; i < 4; i++) {
			if (componentes[i] != null) {
				tipoPeca = componentes[i].toString();
				if (tipoPeca == "W" || tipoPeca == "B" || tipoPeca == "O")
					return tipoPeca;
			}
		}
		for (int i = 0; i < 4; i++) {
			if (componentes[i] != null) {
				tipoPeca = componentes[i].toString();
				if (tipoPeca == "P")
					return tipoPeca;
			}
		}
		for (int i = 0; i < 4; i++) {
			if (componentes[i] != null) { 
				tipoPeca = componentes[i].toString();
				if (tipoPeca == "f")
					return tipoPeca;
			}
		}
		for (int i = 0; i < 4; i++) {
			if (componentes[i] != null) { 
				tipoPeca = componentes[i].toString();
				if (tipoPeca == "b")
					return tipoPeca;
			}
		}
		return "#";
			
	}
	
	public String toString() {
		String string;
		if (!descoberta)
			string = "-";
		else if(numComponentes == 0)
			string = "#";
		else 
			string = maiorPrioridade();
			
		return string;		
	}
	public void adicionarComponente(Componente componente) {
		int i = 0;
		while(componentes[i] != null)
			i++;
		componentes[i] = componente;
		numComponentes++;
	}
	
	public boolean procurarComponente(String componente) {
		boolean bool = false;
		for (int i = 0; i < 4; i++) {
			if(componentes[i] !=null && componentes[i].toString() == componente)
				bool = true;
			}
		return bool;
	}
	
	public Componente removerComponente(String componente) {
		Componente removido = null;
		for (int i = 0; i < 4; i++) {
			if (componentes[i] !=null && componentes[i].toString().equals(componente)) {
				removido = componentes[i];
				componentes[i] = null;
				numComponentes--;
			}
		}
		return removido;
	}
	
	public Heroi getPrimeiro() {
		return (Heroi) componentes[0]; // Depois a gente pensa num jeito melhor
	}
}