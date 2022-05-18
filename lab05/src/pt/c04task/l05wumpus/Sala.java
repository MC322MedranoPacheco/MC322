package pt.c40task.l05wumpus;

public class Sala {
	public Componente[] componentes = new Componente[4];
	public boolean descoberta = false;
	public int numComponentes = 0;
	
	public Sala() {};
	
	public void descobrir() {
		descoberta = true;
	}
	
	public String toString() {
		String string;
		if (!descoberta)
			string = "-";
		else if(numComponentes == 0)
			string = "#";
		else { 
			int i = 0;
			while (componentes[i] == null)
				i++;
			string = componentes[i].toString();
		}
		return string;		
	}
	
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
			if (componentes[i] != null && componentes[i].toString().equals(componente)) {
				removido = componentes[i];
				componentes[i] = null;
				numComponentes--;
			}
		}
		return removido;
	}
}
