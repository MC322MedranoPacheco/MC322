package pt.c40task.l05wumpus;

import java.util.Scanner;

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
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println("Escreva o seu nome:");
      String nome = keyboard.nextLine();
      ControleJogo.setNome(nome);
      
      caverna.printCaverna();
      System.out.println("Player: " + ControleJogo.getNome());
      System.out.printf("Score: %d\n", ControleJogo.getPontuacao());
      
      while(ControleJogo.getEstadoJogo() == 'n') {
    	  String comando = keyboard.nextLine();
    	  ControleJogo.movimento(comando);
    	  caverna.printCaverna();
          System.out.println("Player: " + ControleJogo.getNome());
          System.out.printf("Score: %d\n", ControleJogo.getPontuacao());
      }   		  
      
      switch (ControleJogo.getEstadoJogo()) {
    	  case 'q':
    		  System.out.println("Volte Sempre !");
    		  break;
    	  case 'p':
    		  System.out.println("Voce perdeu =( ...");
    		  break;
    	  case 'g':
    		  System.out.println("Voce ganhou =D !!!");
    		  break;
      }
      tk.stop();
   }

}
