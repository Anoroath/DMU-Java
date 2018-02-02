package dicegames;

import java.util.Scanner;

public class PigPlayApp {
    
    public static void main(String[] args) {
        
        //Makes 2 scanners, one for int and one for strings
        Scanner scanInt = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        
        //Prints the rules
        System.out.println("Vi skal spille PIG, her er reglerne:");
        System.out.println("Hver spiller skiftes til at kaste med en terning\n" +
                "indtil spilleren enten kaster 1, eller beslutter sig for at stoppe.\n" + 
                "Hvis spilleren slår en 1’er, får spilleren ingen point i denne omgang.\n" +
                "Hvis spilleren beslutter sig for at stoppe inden har slår en 1’er,\n" +
                "lægges summen af alle spillerens kast i denne tur sammen med spillerens\n" + 
                "samlede antal point, og turen går videre til næste spiller.\n" +
                "Den første spiller der samlet når det ønskede antal point, har vundet.\n");
        
        
        //Amount of points to play up to
        System.out.println("Hvor mange point vil i spille til?");
        int amount = scanInt.nextInt();
        
        //Ask if you want to play againt an AI
        System.out.println("Vil du spille imod en computer? (Skriv Ja for computer)");
        String AI = scan.nextLine();
        
        //Name of first player  
        System.out.println("Hvad hedder spiller 1?");
        String P1 = scan.nextLine();
        // Checks if player 2 is an AI
        if (AI.equalsIgnoreCase("Ja")) {
            // Constructs a AI Game
            PigPlay play = new PigPlay(P1, amount);
            play.startGame();
        } else {
            //Name of second player
            System.out.println("Hvad hedder spiller 2?");
            String P2 = scan.nextLine();
            PigPlay play = new PigPlay(P1, P2, amount);
            play.startGame();
        }
      
        //Closes used scanners
        scan.close();
        scanInt.close();
        
    }
}
