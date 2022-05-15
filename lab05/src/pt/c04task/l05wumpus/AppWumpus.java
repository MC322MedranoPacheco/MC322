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
      ControleJogo controle = new ControleJogo(caverna.getSala(0, 0).getPrimeiro());
      
      caverna.printCaverna();

      controle.movimento("d");
      caverna.printCaverna();
      System.out.println("");
      
      controle.movimento("d");
      caverna.printCaverna();
      System.out.println("");
      
      controle.movimento("s");
      caverna.printCaverna();
      System.out.println("");
      
      controle.movimento("c");
      caverna.printCaverna();
      System.out.println("");
       
      tk.stop();
   }

}