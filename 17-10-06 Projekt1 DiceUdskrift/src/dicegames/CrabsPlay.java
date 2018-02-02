package dicegames;

import java.util.Scanner;

public class CrabsPlay {
    private PairOfDices dices;
    private boolean win;
    private int rolls;
    private int firstRoll;
    private boolean finished;
    private Scanner scan;
    private int amountOfWin;
    private int amountOfLoses;
    private int amountOfGames;
    
    public CrabsPlay() {
        dices = new PairOfDices();
        scan = new Scanner(System.in);
    }
    
    private void welcomeToGame() {
        System.out.println("Velkommen til spillet KAST terning");
    }
    
    private void gameOver() {
        if(win) {
            System.out.println("Tak for spillet. Du har VUNDET spillet!"); 
            amountOfWin++;
        }
        else {
            System.out.println("Tak for spillet. Du har TABT spillet!");
            amountOfLoses++;
        }
        finished = true;
        amountOfGames++;
    }
    
    private void takeTurn() {
        dices.rollBothDices();
        int roll = dices.sumOfDices();
        rolls++;
        System.out.println("Du har med 2 terninger kastet: " + roll);
        if(rolls == 1) {
            if(roll == 7 || roll == 11) {
                win = true;
                gameOver();
            }
            else if(roll == 2 || roll == 3 || roll == 12) {
                win = false;
                gameOver();
            }
            else {
                firstRoll = roll;
            }
        }
        if(rolls > 1) {
            if(roll == 7) {
                win = false;
                gameOver();
            }
            else if(roll == firstRoll) {
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
            System.out.println("\nVil du spille igen?");
            String startNewGame = scan.nextLine();
            if (startNewGame.equalsIgnoreCase("ja")) {
                finished = false;
                win = false;
                rolls = 0;
                System.out.println("");
                startGame();
            }
            else {
                System.out.println("\nTak for spillet");
                System.out.println("Du har spillet: " + amountOfGames + " gange.");
                System.out.println("Du har vundet: " + amountOfWin + " gange.");
                System.out.println("Du har tabt: " + amountOfLoses + " gange.");
                scan.close();
            }
            
  }

}
