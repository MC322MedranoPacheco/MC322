package pt.c40task.l05wumpus;

public class MontadorCaverna {
	
	/* Funcao estatica que monta uma caverna a partir dos arquivos.
	 * Alem disso, ela verifica se a caverna foi montada de maneira correta
	 */
	public static Caverna montar(String arquivoCaverna, String arquivoSaida,
            String arquivoMovimentos) {
		
		Caverna caverna = new Caverna();
		Componente.setCaverna(caverna);
		Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
		String caverna_str[][] = tk.retrieveCave();
		
		int numB = 0;
		int numW = 0;
		int numH = 0;
		int numO = 0;
		
		// Loop for que pega cada linha da tabela e adiciona o respectivo componente na sua posicao
		for (int i = 0; i < caverna_str.length; i++) {
				 Posicao pos = new Posicao(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1);
	        	 if(caverna_str[i][2].equals("P")) {
	        		 numH++;
	        		 caverna.getSala(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1).descobrir();
	        		 Componente heroiCaverna = ControleJogo.getHeroi();
	        		 heroiCaverna.setPosicao(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1);
	        		 caverna.adicionarComponente(pos, heroiCaverna);
	        	 }
	        	 else if(caverna_str[i][2].equals("W")) {
		        	 	numW++;
		        	 	Componente wumpus = new Wumpus(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1);
		        	 	caverna.adicionarComponente(pos, wumpus);
	        	 }
	        	 else if(caverna_str[i][2].equals("B")) {
		        	 	numB++;
		        	 	Componente buraco = new Buraco(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1);
		        	 	caverna.adicionarComponente(pos, buraco);
		         }
	        	 else if(caverna_str[i][2].equals("O")) {
		        	 	numO++;
		        	 	Componente ouro = new Ouro(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1);		    	
		        	 	caverna.adicionarComponente(pos, ouro);
	        	 }        			 
		}
		
	return caverna;
	}
}
