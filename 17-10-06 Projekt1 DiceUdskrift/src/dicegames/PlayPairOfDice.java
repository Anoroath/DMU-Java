package dicegames;

import java.util.Scanner;

public class PlayPairOfDice {

    private Scanner scan;
    private PairOfDices dices;

    public PlayPairOfDice() {
        dices = new PairOfDices();
        scan = new Scanner(System.in);
    }

    private void takeTurn() {
        dices.rollBothDices();
        int roll = dices.sumOfDices();
        System.out.println("Du har med 2 terninger kastet: " + roll);
    }

    private void welcomeToGame() {
        System.out.println("Velkommen til spillet KAST terning");
    }

    private void gameOver() {
        System.out.println("Tak for spillet. Du kastede " + dices.getRolls() + " gange.");
        System.out.println("Du har rullet ens: " + dices.getAmountOfDoubles() + " gange.");
        System.out.println("Det største kast har været: " + dices.getHighest());
        System.out.println("Du har rullet en 1'er: " + dices.getAmountOfOnes() + " gange.");
        System.out.println("Du har rullet en 2'er: " + dices.getAmountOfTwos() + " gange.");
        System.out.println("Du har rullet en 3'er: " + dices.getAmountOfThrees() + " gange.");
        System.out.println("Du har rullet en 4'er: " + dices.getAmountOfFours() + " gange.");
        System.out.println("Du har rullet en 5'er: " + dices.getAmountOfFives() + " gange.");
        System.out.println("Du har rullet en 6'er: " + dices.getAmountOfSixes() + " gange.");
        scan.close();
    }

    public void startGame() {
        welcomeToGame();

        boolean finished = false;

        while (!finished) {
            System.out.println("Vil du kaste en terning? Angiv Ja eller Nej: ");
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
