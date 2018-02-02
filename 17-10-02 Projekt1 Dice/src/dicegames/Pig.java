package dicegames;

import java.util.Scanner;

public class Pig {

    private Die die;
    private Scanner scan;
    private boolean welcome = false;
    private PigPlayer P1;
    private PigPlayer P2;
    private boolean finished = false;
    private int roll;
    private int winAmount = 100;
    private PigPlayer active;

    public Pig(String player1, String player2, int winAmount) {
        die = new Die();
        scan = new Scanner(System.in);
        P1 = new PigPlayer(player1, true);
        P2 = new PigPlayer(player2, false);
        this.winAmount = winAmount;
        active = P1;

    }

    public void welcomeToGame() {
        System.out.println("Velkommen til spillet Pig!");

    }

    public void takeTurn() {
        int tempPoints = 0;
        boolean stop = false;

        System.out.println(active.getName() + " det er din tur og du har " + active.getScore() + " point.");

        while (!stop) {
            if ((active.getScore() + tempPoints) >= winAmount) {
                gameOver();
                stop = true;
            }
            if (!finished) {
                die.roll();
                roll = die.getFaceValue();
                active.setRolls(active.getRolls() + 1);
                if (roll != 1) {
                    System.out.println("Du har rullet: " + roll);

                    System.out.println("Du har: " + (tempPoints + roll) + " midlertidige points.");
                    if ((active.getScore() + tempPoints + roll) >= winAmount) {
                        gameOver();
                        stop = true;
                    }
                    if (!active.isWin()) {
                        System.out.println("Vil du kaste igen?");
                        String proceedWithRolling = scan.nextLine();
                        if (proceedWithRolling.equalsIgnoreCase("ja")) {
                            tempPoints = tempPoints + roll;
                        } else {
                            tempPoints = tempPoints + roll;
                            stop = true;
                        }
                    }
                } else {
                    System.out.println("Du har rullet 1 og turen går videre.");
                    stop = true;
                    tempPoints = 0;
                }
            }

        }
        active.setScore(active.getScore() + tempPoints);

        if (active.isWin() == false) {
            active.setTurns(active.getTurns() + 1);
            if (active == P1) {

                active = P2;
            } else {
                active = P1;
            }
        }
        System.out.println("");
        tempPoints = 0;

    }

    public void gameOver() {
        System.out.println("Tak for spillet, " + active.getName() + " har vundet.");
        finished = true;
        active.setWin(true);
    }

    public void startGame() {
        if (welcome == false) {
            welcomeToGame();
            welcome = true;
        }
        while (!finished) {
            takeTurn();
        }
        System.out.println(P1.getName() + " har haft: " + P1.getTurns() + " ture.");
        System.out.println(P1.getName() + " har haft :" + P1.getRolls() + " kast.");
        System.out.println(
                P1.getName() + " har defor haft: " + P1.getRolls() / P1.getTurns() + " rul per tur i gennemsnit.");
        System.out.println(P2.getName() + " har haft: " + P2.getTurns() + " ture.");
        System.out.println(P2.getName() + " har haft: " + P2.getRolls() + " kast.");
        System.out.println(
                P2.getName() + " har defor haft: " + P2.getRolls() / P2.getTurns() + " rul per tur i gennemsnit.");
        scan.close();
    }
}