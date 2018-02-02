package dicegames;

import java.util.Scanner;

public class PigApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner scan = new Scanner(System.in);
        System.out.println("Hvor mange point vil i spille til?");
        int winAmount = scan.nextInt();
        String P1 = "Daniel";
        String P2 = "Manuela";
        Pig play = new Pig(P1, P2, winAmount);
        play.startGame();
        scan.close();
    }

}
