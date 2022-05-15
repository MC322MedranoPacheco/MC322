package pt.c40task.l05wumpus;

public class MontadorCaverna {
	public static Caverna montar(String arquivoCaverna, String arquivoSaida,
            String arquivoMovimentos) {
		Caverna caverna = new Caverna();
		Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
		String caverna_str[][] = tk.retrieveCave();
		
		int numB = 0;
		int numW = 0;
		int numH = 0;
		int numO = 0;
		
		for (int i = 0; i < caverna_str.length; i++) {
				 Posicao pos = new Posicao(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1);
	        	 if(caverna_str[i][2].equals("P")) {
	        		 numH++;
	        		 Componente heroi = new Heroi(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1, caverna);
	        		 caverna.adicionarComponente(pos, heroi);
	        	 }
	        	 else if(caverna_str[i][2].equals("W")) {
		        	 	numW++;
		        	 	Componente wumpus = new Wumpus(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1, caverna);
		        	 	caverna.adicionarComponente(pos, wumpus);
	        	 }
	        	 else if(caverna_str[i][2].equals("B")) {
		        	 	numB++;
		        	 	Componente buraco = new Buraco(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1, caverna);
		        	 	caverna.adicionarComponente(pos, buraco);
		         }
	        	 else if(caverna_str[i][2].equals("O")) {
		        	 	numO++;
		        	 	Componente ouro = new Ouro(Integer.parseInt(caverna_str[i][1]) - 1, Integer.parseInt(caverna_str[i][0]) - 1, caverna);		    	
		        	 	caverna.adicionarComponente(pos, ouro);
	        	 }
	        			 
		}
	return caverna;
	}
}
