package dicegames;

import java.util.Scanner;

public class PigPlay {
    private Scanner scan; // Scanner
    private Die die; // Six sided Die
    private Player P1; //Player 1
    private Player P2; //Player 2
    private int roll; //Holds the value of the roll
    private boolean AI = false; // Checks if there's a AI
    private int aiRollCount; // Amount of times the AI will roll
    private int tempScore; //Holds the temperary score
    private int winAmount; // Win amount
    private boolean finished; // Checks if game is finished
    private Player active; //Holds the player, which is active, starts with player 1
    
    //2 player constructor
    public PigPlay(String player1, String player2, int winAmount) {
        die = new Die();
        scan = new Scanner(System.in);
        this.P1 = new Player(player1);
        this.P2 = new Player(player2);
        active = P1;
        this.winAmount = winAmount;
    }
    
     // AI Constructor
        public PigPlay(String player1, int winAmount) {
            die = new Die();
            scan = new Scanner(System.in);
            P1 = new Player(player1);
            AI = true;
            active = P1;
            P2 = new Player("Computeren");
            this.winAmount = winAmount;
        }

    //Print out a welcome message to the players.
    private void welcomeToGame() {
     // Prints a welcome message
        if (AI != true) {
            System.out.println("\nVelkommen til spillet PIG! I spiller til: " + winAmount + " points!");
        } else {
            System.out.println("\nVelkommen til spillet PIG! Du spiller imod en computer til: " + winAmount + " points!");
        }
        
    }   

    // Take another turn in the game.
    private void takeTurn() {   
        // Sets local variables
        this.tempScore = 0;
        boolean stop = false;
        
        // Says which player it is and how many points the player currently have
        System.out.println("Det er " + active.getName() + "'s tur! og spilleren har " + active.getScore() + " point!\n");
        
        // Counts number of turns for active player
        active.setAmountOfTurns(active.getAmountOfTurns() + 1);
        
        //Loop running until a player have won, rolled a 1 or decices to stop
        while(!stop) {
            
            // Sets a random 1-6 variable for how many times the computer "wants" to roll.
            this.aiRollCount = (int) ((Math.random() * die.getSides()) + 1);
             
            // As long as the game hasn't ended this will run.
            if(!finished) {
                
                // Rolls a dice and increases amount of dice rolled by active player
                die.roll();
                active.setAmountOfRolls(active.getAmountOfRolls() + 1);
                
                // Sets a int to the rolled number.
                roll = die.getFaceValue();
                
                // If you didn't roll a 1 you will get a chance to stop or roll more.
                if(roll != 1) {
                    // Prints a message stating what you rolled and your temporary points.
                    System.out.println(active.getName() + " har rullet: " + roll + " og har nu: " + (this.tempScore + roll) + " midlertidige point!");
                    
                    //Checks if a player has won and ends game.
                    if((active.getScore() + this.tempScore + roll) >= winAmount) {
                        active.setWon(true);
                        gameOver();
                        stop = true;
                    }
                    //Plays the game without a AI
                    if(!AI) {
                        // If active player havent won it asks if the player wants to roll again
                        if(!active.isWon()) {
                            System.out.println("Vil du kaste igen?");
                            String rollAgain = scan.nextLine();
                            
                            if (rollAgain.equalsIgnoreCase("ja")) {
                                this.tempScore = tempScore + roll;
                            }
                            else {
                                System.out.println("");
                                this.tempScore = tempScore + roll;
                                stop = true;
                            }
                        }
                    }
                    //Plays the game with an AI
                    else {                        
                        if (active == P1) {
                            if (active.isWon() == false) {
                                System.out.println("Vil du kaste igen?");
                                String rollAgain = scan.nextLine();
                                if (rollAgain.equalsIgnoreCase("ja")) {
                                    this.tempScore = this.tempScore + roll;
                                } 
                                else {
                                    System.out.println("");
                                    this.tempScore = this.tempScore + roll;
                                    stop = true;
                                }
                            }
                        } 
                        else {
                            if (active.isWon() == false) {
                                // AI check on its random amount of rolls variable or if the temp is above 15 to
                                // decide if it wants to stop (Could change the number it checks on to lower to
                                // play more safe or higher to play more risky!)
                                if (aiRollCount > 0 && (this.tempScore + roll) < 15) {
                                    System.out.println(active.getName() + " vil gerne rulle igen");
                                    this.tempScore = this.tempScore + roll;

                                    aiRollCount--; // Reduces the amount of rolls it wants to do
                                } 
                                else {
                                    System.out.println(active.getName() + "'s tur er over.\n");
                                    this.tempScore = this.tempScore + roll;
                                    stop = true;
                                }
                            }
                        }
                    }
                }
                // Says you have rolled a 1 and changes the turn to the other player
                else {
                    System.out.println("****" + active.getName() + " har rullet en 1'er og turen går videre!****\n");
                    active.setAmountOfOnes(active.getAmountOfOnes() + 1);
                    stop = true;
                    this.tempScore = 0;
                }
            }
            else {
                stop = true;
            }
            
        }
        
        //Sets score
        active.setScore(active.getScore() + this.tempScore);
        
        //resets the temperary score
        this.tempScore = 0;       
        
        // Only runs if active player haven't won.
        if(!active.isWon()) {
            if(active == P1) {
                active = P2;
            }
            else {
                active = P1;
            }        
        }        
    }
        
  //Finishes the game and prints out the winner.
    private void gameOver() {
        if(active.isWon()) {
            System.out.println("\n\n" + active.getName() + " har vundet! Tak for spillet.\n"); 
        }
        
        finished = true;
        
        //Statistics for the game
        System.out.println("Statistik over spillets gang:");
        
        //Player 1
        //Prints the amount of turns
        if(P1.getAmountOfTurns() == 1) {
            System.out.println(P1.getName() + " har haft " + P1.getAmountOfTurns() + " tur");
        } else {
            System.out.println(P1.getName() + " har haft " + P1.getAmountOfTurns() + " turer");
        }
        
        //Prints the amount of rolls
        if(P1.getAmountOfRolls() == 1) {
            System.out.println(P1.getName() + " har rullet " + P1.getAmountOfRolls() + " gang");
        } else {
            System.out.println(P1.getName() + " har rullet " + P1.getAmountOfRolls() + " gange");
        }
            
        //Gets average roll pr turn
        int averageRolls =  P1.getAmountOfRolls()/P1.getAmountOfTurns();
        if(averageRolls == 1) {
            System.out.println(P1.getName() + " har i gennemsnit rullet " 
                               + averageRolls + " gang pr. tur");
        } else{
            System.out.println(P1.getName() + " har i gennemsnit rullet " 
                               + averageRolls + " gange pr. tur");
        }
        
        //Prints the amount of times a player have rolled 1
        System.out.println("Antal 1'er slået af " + P1.getName() + " er: " + P1.getAmountOfOnes() + "\n");
        
        //Player 2
        //Checks if player 2 have had a turn
        if(P2.getAmountOfTurns() != 0) {           
            //Prints the amount of turns
            if(P2.getAmountOfTurns() == 1) {
                System.out.println(P2.getName() + " har haft " + P2.getAmountOfTurns() + " tur");
            } else {
                System.out.println(P2.getName() + " har haft " + P2.getAmountOfTurns() + " turer");
            }
            
            //Prints the amount of rolls
            if(P2.getAmountOfRolls() == 1) {
                System.out.println(P2.getName() + " har rullet " + P2.getAmountOfRolls() + " gang");
            } else {
                System.out.println(P2.getName() + " har rullet " + P2.getAmountOfRolls() + " gange");
            }
        
            //Gets average roll pr turn
            averageRolls = P2.getAmountOfRolls()/P2.getAmountOfTurns();
            if(averageRolls == 1) {
                System.out.println(P2.getName() + " har i gennemsnit rullet " 
                                   + averageRolls + " gang pr. tur");
            } else {
                System.out.println(P2.getName() + " har i gennemsnit rullet " 
                                   + averageRolls + " gange pr. tur");
            }
            
            //Prints the amount of times a player have rolled 1
            System.out.println("Antal 1'er slået af " + P2.getName() + " er: " + P2.getAmountOfOnes() + "\n");
            
        } else {
            System.out.println(P2.getName() + " har ikke haft en tur! :(");
        }
    }

    //Start the game loop
    public void startGame() {
        //Uses the welcome method
        welcomeToGame();
        
        finished = false;
        
        //as long as finished = false take turn
        while (!finished) {
            takeTurn();
        }

        //Close the scanner
        scan.close();
    }
}
