package pt.c40task.l05wumpus;

public class AppWumpus {

   public static void main(String[] args) {
      AppWumpus.executaJogo(
            (args.length > 0) ? args[0] : null,
            (args.length > 1) ? args[1] : null,
            (args.length > 2) ? args[2] : null);
   }
   
   public static void executaJogo(String arquivoCaverna, String arquivoSaida,
                                  String arquivoMovimentos) {
      Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
      
      Caverna caverna = new Caverna();
      caverna = MontadorCaverna.montar(arquivoCaverna, arquivoSaida, arquivoMovimentos);
      for (int i = 0; i < 4; i ++)
    	  for (int j = 0; j < 4; j++)
    		  caverna.salas[i][j].descobrir();
      caverna.printCaverna();
      
      tk.stop();
   }

}