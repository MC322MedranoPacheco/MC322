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
			        	 	if(caverna.getSala(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1).procurarComponente("B"))
			        	 		throw new IllegalArgumentException("Tentou colocar Wumpus em sala com Buraco");
			        	 	if(caverna.getSala(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1).procurarComponente("O"))
			        	 		throw new IllegalArgumentException("Tentou colocar Wumpus em sala com Ouro");
			        	 	numW++;
			        	 	Componente wumpus = new Wumpus(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1);
			        	 	caverna.adicionarComponente(pos, wumpus);
		        	 }
		        	 else if(caverna_str[i][2].equals("B")) {
		        		 	if(caverna.getSala(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1).procurarComponente("B"))
			        	 		throw new IllegalArgumentException("Tentou colocar Buraco em sala com Buraco");
			        	 	if(caverna.getSala(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1).procurarComponente("O"))
			        	 		throw new IllegalArgumentException("Tentou colocar Buraco em sala com Ouro");
			        	 	if(caverna.getSala(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1).procurarComponente("W"))
			        	 		throw new IllegalArgumentException("Tentou colocar Buraco em sala com Wumpus");
			        	 	numB++;
			        	 	Componente buraco = new Buraco(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1);
			        	 	caverna.adicionarComponente(pos, buraco);
			         }
		        	 else if(caverna_str[i][2].equals("O")) {
		        		 	if(caverna.getSala(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1).procurarComponente("B"))
			        	 		throw new IllegalArgumentException("Tentou colocar Ouro em sala com Buraco");
			        	 	if(caverna.getSala(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1).procurarComponente("W"))
			        	 		throw new IllegalArgumentException("Tentou colocar Ouro em sala com Wumpus");
			        	 	numO++;
			        	 	Componente ouro = new Ouro(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1);		    	
			        	 	caverna.adicionarComponente(pos, ouro);
		        	 }        			 
			}
			
			if(numW != 1 || numO != 1 || numB < 2 || numB > 3)
				throw new IllegalArgumentException("Numero de objetos difere do permitido");
	
		
	return caverna;
	}
}
