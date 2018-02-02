package dicegames;

import java.util.Scanner;

public class PlayPairOfDice {

    private Scanner scan;

    private PairOfDices dice;

    public PlayPairOfDice() {
        dice = new PairOfDices();
        scan = new Scanner(System.in);
    }

    public void takeTurn() {
        dice.RollBothDices();
        int roll = dice.SumOfDices();
        System.out.println("Du har med to terninger slået: " + roll);
    }

    public void welcomeToGame() {
        System.out.println("Velkommen til spillet KAST TO TERNINGER ");
    }

    public void gameOver() {
        System.out.println("Tak for spillet! Du kastede " + dice.getRolls() + "gange.");
        System.out.println("Du kastede ens " + dice.getDoubles() + "gange.");
        System.out.println("Dit største kast var " + dice.getLargest());
        System.out.println("Du kastede 6 " + dice.getSixes() + "gange.");
        System.out.println("Du kastede 5 " + dice.getFives() + "gange.");
        System.out.println("Du kastede 4 " + dice.getFours() + "gange.");
        System.out.println("Du kastede 3 " + dice.getThrees() + "gange.");
        System.out.println("Du kastede 2 " + dice.getTwos() + "gange.");
        System.out.println("Du kastede 1 " + dice.getOnes() + "gange.");
        scan.close();
    }

    public void startGame() {
        welcomeToGame();

        boolean finished = false;

        while (!finished) {
            System.out.println("Vil du kaste med to terninger? Angiv Ja eller Nej: ");
            String proceedWithGame = scan.nextLine();
            if (proceedWithGame.equalsIgnoreCase("nej")) {
                finished = true;
            } else {
                takeTurn();

            }
        }

        gameOver();
    }
}
