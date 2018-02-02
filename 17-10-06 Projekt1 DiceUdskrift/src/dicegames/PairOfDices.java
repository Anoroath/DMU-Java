package dicegames;

/**
 * This class models one pair of dices. This is useful for games where you have
 * to throw two dice at once.
 */
public class PairOfDices {
    /**
     * The first die in the pair.
     */
    private Die die1;
    /**
     * The second die in the pair.
     */
    private Die die2;

    // Field for remembering number of rolls with both dices
    private int rolls = 0;
    // Increases by the specific eyes a die have shown
    private int ones = 0;
    private int twos = 0;
    private int threes = 0;
    private int fours = 0;
    private int fives = 0;
    private int sixes = 0;
    // Remembers the number of times
    private int doubles = 0;
    // Remembers highest number rolled
    private int highest = 0;

    /**
     * Constructor for objects of class PairOfDices
     */
    public PairOfDices() {
        die1 = new Die();
        die2 = new Die();
    }

    // Constructor for 2 dices with x sides
    public PairOfDices(int sidesOfDice1, int sidesOfDice2) {
        die1 = new Die(sidesOfDice1);
        die2 = new Die(sidesOfDice2);
    }

    public void rollBothDices() {
        // Roll both dices and increase the number of times both dices are rolled by 1
        die1.setFaceValue((int) ((Math.random() * die1.sides) + 1));
        die2.setFaceValue((int) ((Math.random() * die2.sides) + 1));
        rolls++;

        // Checks facevalue and increases the times a number have been rolled
        if (die1.getFaceValue() == 1) {
            ones++;
        } else if (die1.getFaceValue() == 2) {
            twos++;
        } else if (die1.getFaceValue() == 3) {
            threes++;
        } else if (die1.getFaceValue() == 4) {
            fours++;
        } else if (die1.getFaceValue() == 5) {
            fives++;
        } else if (die1.getFaceValue() == 6) {
            sixes++;
        }

        if (die2.getFaceValue() == 1) {
            ones++;
        } else if (die2.getFaceValue() == 2) {
            twos++;
        } else if (die2.getFaceValue() == 3) {
            threes++;
        } else if (die2.getFaceValue() == 4) {
            fours++;
        } else if (die2.getFaceValue() == 5) {
            fives++;
        } else if (die2.getFaceValue() == 6) {
            sixes++;
        }

        // If you have rolled doubles
        if (die1.getFaceValue() == die2.getFaceValue()) {
            doubles++;
        }

        // sumOfDices();
        // Increases the highest number rolled if the sum of the dices are higher than
        // previously
        if (sumOfDices() > highest) {
            highest = sumOfDices();
        }
    }

    public int sumOfDices() {
        // Get sum of both dices
        int sumOfDices = die1.getFaceValue() + die2.getFaceValue();
        return sumOfDices;
    }

    // Method to return the number of times a specific number was rolled
    public int getAmountOfOnes() {
        return this.ones;
    }

    public int getAmountOfTwos() {
        return this.twos;
    }

    public int getAmountOfThrees() {
        return this.threes;
    }

    public int getAmountOfFours() {
        return this.fours;
    }

    public int getAmountOfFives() {
        return this.fives;
    }

    public int getAmountOfSixes() {
        return this.sixes;
    }

    // Returns amount of times the dices have rolled the same
    public int getAmountOfDoubles() {
        return this.doubles;
    }

    public int getRolls() {
        return this.rolls;
    }

    public int getHighest() {
        return this.highest;
    }

    public void resetPairOfDice() {
        rolls = 0;
        ones = 0;
        twos = 0;
        threes = 0;
        fours = 0;
        fives = 0;
        sixes = 0;
        doubles = 0;
        highest = 0;
    }
}
