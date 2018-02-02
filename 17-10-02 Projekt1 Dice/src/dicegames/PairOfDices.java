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

    // Field for remembering the amount of times the dice have been rolled.
    private int rolls = 0;

    // Field for remembering the amount of times the dice have rolled 6.
    private int sixes = 0;

    // Field for remembering the amount of times the dice have rolled 5.
    private int fives = 0;

    // Field for remembering the amount of times the dice have rolled 4.
    private int fours = 0;

    // Field for remembering the amount of times the dice have rolled 3.
    private int threes = 0;

    // Field for remembering the amount of times the dice have rolled 2.
    private int twos = 0;

    // Field for remembering the amount of times the dice have rolled 1.
    private int ones = 0;

    // Field for remembering the amount of times the dice have rolled doubles.
    private int doubles = 0;

    // Field for remembering largest sum rolled.
    private int largest = 0;

    /**
     * Constructor for objects of class PairOfDices
     */
    public PairOfDices() {
        // Constructor for the objects die1 and die2.
        die1 = new Die(6);
        die2 = new Die(6);
    }

    public PairOfDices(int die1Sides, int die2Sides) {
        // Constructor for the objects die1 and die2 with a specific number of sides on
        // the dice.
        die1 = new Die(die1Sides);
        die2 = new Die(die2Sides);
    }

    public void RollBothDices() {
        // Rolls both the dice.
        die1.setFaceValue((int) ((Math.random() * die1.sides) + 1));
        die2.setFaceValue((int) ((Math.random() * die2.sides) + 1));
        rolls++;

        if (die1.getFaceValue() == 6) {
            sixes++;
        } else if (die1.getFaceValue() == 5) {
            fives++;
        } else if (die1.getFaceValue() == 4) {
            fours++;
        } else if (die1.getFaceValue() == 3) {
            threes++;
        } else if (die1.getFaceValue() == 2) {
            twos++;
        } else if (die1.getFaceValue() == 1) {
            ones++;
        }

        if (die2.getFaceValue() == 6) {
            sixes++;
        } else if (die2.getFaceValue() == 5) {
            fives++;
        } else if (die2.getFaceValue() == 4) {
            fours++;
        } else if (die2.getFaceValue() == 3) {
            threes++;
        } else if (die2.getFaceValue() == 2) {
            twos++;
        } else if (die2.getFaceValue() == 1) {
            ones++;
        }

        if (die1.getFaceValue() == die2.getFaceValue()) {
            doubles++;
        }

        if (SumOfDices() > largest) {
            largest = SumOfDices();
        }

    }

    public int getSixes() {
        return this.sixes;
    }

    public int getFives() {
        return this.fives;
    }

    public int getFours() {
        return this.fours;
    }

    public int getThrees() {
        return this.threes;
    }

    public int getTwos() {
        return this.twos;
    }

    public int getOnes() {
        return this.ones;
    }

    public int getDoubles() {
        return this.doubles;
    }

    public int SumOfDices() {
        int sumOfDice = die1.getFaceValue() + die2.getFaceValue();
        return sumOfDice;
    }

    public int getRolls() {
        return rolls;
    }

    public int getLargest() {
        return largest;
    }

    public void ResetPairOfDices() {
        rolls = 0;
        sixes = 0;
        fives = 0;
        fours = 0;
        threes = 0;
        twos = 0;
        ones = 0;
        doubles = 0;
        largest = 0;
    }
    // TODO: put the constructor here!
    // Remember, the constructor should initialize die1 and die2.

}
