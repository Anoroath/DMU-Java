package dicegames;

import java.util.Scanner;

public class CrapsPlay {

    // Create 2 dice.
    private PairOfDices dice;
    private Scanner scan;
    private int rolls = 0;
    private boolean win = false;
    private int firstRoll = 0;
    private boolean finished = false;
    private int antalWins = 0;
    private int antalLoss = 0;
    private int antalSpil = 0;

    public CrapsPlay() {
        dice = new PairOfDices();
        scan = new Scanner(System.in);
    }

    public void welcomeToGame() {
        System.out.println("Velkommen til spillet Craps! Vil du kaste med terningerne? ");
    }

    public void gameOver() {
        if (win) {
            System.out.println("Tillykke, Du har vundet! Tak for spillet. ");
            antalWins++;
        } else {
            System.out.println("Tak for spillet! Du vandt desværre ikke.");
            antalLoss++;
        }
        antalSpil++;
        finished = true;
    }

    private void takeTurn() {
        dice.RollBothDices();
        int roll = dice.SumOfDices();
        rolls++;
        System.out.println("Du har rullet " + roll);
        if (rolls == 1) {

            if (roll == 7 || roll == 11) {
                win = true;
                gameOver();
            } else if (roll == 2 || roll == 3 || roll == 12) {
                gameOver();
            } else {
                firstRoll = roll;
            }
        }
        if (rolls > 1) {
            if (roll == 7) {
                gameOver();
            } else if (roll == firstRoll) {
                win = true;
                gameOver();
            }
        }
    }

    public void startGame() {
        welcomeToGame();

        while (!finished) {
            takeTurn();
        }
        System.out.println("Du har spillet " + antalSpil + " gange.");
        System.out.println("Du har vundet " + antalWins + " gange.");
        System.out.println("Du jar tabt " + antalLoss + " gange.");
        System.out.println("Vil du spille igen, ja eller nej? ");
        String startNewGame = scan.nextLine();
        if (startNewGame.equalsIgnoreCase("ja")) {
            finished = false;
            win = false;
            rolls = 0;
            startGame();
        }
        scan.close();
    }

}
