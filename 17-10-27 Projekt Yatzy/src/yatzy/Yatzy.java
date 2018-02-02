package yatzy;

import java.util.Random;

/**
 * Models a game of Yatzy.
 */
public class Yatzy {
    /**
     * Face values of the 5 dice. <br/>
     * 1 <= values[i] <= 6.
     */
    private int[] values = new int[5];

    /**
     * Number of times the 5 dice have been thrown. <br/>
     * 0 <= throwCount <= 3.
     */
    private int throwCount = 0;

    /**
     * Random number generator.
     */
    private Random random = new Random();

    /**
     * Rolls the 5 dice. <br/>
     * Only roll dice that are not hold. <br/>
     * Requires: holds contain 5 boolean values.
     */
    public void throwDice(boolean[] holds) {
        for (int i = 0; i < values.length; i++) {
            if (!holds[i]) {
                values[i] = random.nextInt(6) + 1;
            }
        }
        throwCount++;
    }

    /**
     * Returns the number of times the five dice have been thrown.
     */
    public int getThrowCount() {
        return throwCount;
    }

    /**
     * Resets the throw count.
     */
    public void resetThrowCount() {
        throwCount = 0;
    }

    /**
     * Get current dice values
     */
    public int[] getValues() {
        return values;
    }

    /**
     * Set the current dice values
     */
    public void setValues(int[] values) {
        this.values = values;
    }

    /**
     * Returns all results possible with the current face values. <br/>
     * The order of the results is the same as on the score board.
     */
    public int[] getPossibleResults() {
        int[] results = new int[15];
        for (int i = 0; i <= 5; i++) {
            results[i] = valueSpecificFace(i + 1);
        }
        results[6] = valueOnePair();
        results[7] = valueTwoPair();
        results[8] = valueThree();
        results[9] = valueFour();
        results[10] = valueFullHouse();
        results[11] = valueSmallStraight();
        results[12] = valueLargeStraight();
        results[13] = valueChance();
        results[14] = valueYatzy();
        return results;
    }

    /**
     * Returns an int[7] containing the frequency of face values. <br/>
     * Frequency at index v is the number of dice with the face value v, 1 <= v <=
     * 6. <br/>
     * Index 0 is not used.
     */
    private int[] freqFaceValue() {
        int[] rolls = new int[7];
        for (int roll : values) {
            rolls[roll]++;
        }
        return rolls;
    }

    /**
     * Returns the total value for the dice currently showing the given face value
     *
     * @param face
     *            the face value to return values for
     */
    public int valueSpecificFace(int face) {
        int total = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == face) {
                total += face;
            }
        }
        return total;
    }

    /**
     * Returns the maximum value for n-of-a-kind for the given n. <br/>
     * For example, valueManyOfAKind(3) returns the maximum value for 3 of-a-kind.
     * <br/>
     * Requires: 1 <= faceValue and faceValue <= 6
     *
     * @param n
     *            number of kind
     */
    public int valueManyOfAKind(int n) {
        for (int i = 6; i > 0; i--) {
            if (freqFaceValue()[i] >= n) {
                return n * i;
            }
        }
        return 0;
    }

    /**
     * The current value if you try to score the current face values as Yatzy.
     */
    public int valueYatzy() {
        for (int i = 6; i > 0; i--) {
            if (freqFaceValue()[i] == 5) {
                return 50;
            }
        }
        return 0;
    }

    /**
     * Returns the current score if used as "chance".
     */
    public int valueChance() {
        int total = 0;
        for (int val : values) {
            total += val;
        }
        return total;
    }

    /**
     * Returns the current score for one pair.
     */
    public int valueOnePair() {
        for (int i = 6; i > 0; i--) {
            if (freqFaceValue()[i] >= 2) {
                return i * 2;
            }
        }
        return 0;
    }

    /**
     * Returns the current score for two pairs.
     */
    public int valueTwoPair() {
        int val = 0;
        for (int i = 6; i > 0; i--) {
            if (freqFaceValue()[i] >= 2) {
                val += 2 * i;
            }
        }
        return val;
    }

    /**
     * Returns the current score for three of a kind.
     */
    public int valueThree() {
        for (int i = 6; i > 0; i--) {
            if (freqFaceValue()[i] >= 3) {
                return i * 3;
            }
        }
        return 0;
    }

    /**
     * Returns the current score for four of a kind.
     */
    public int valueFour() {
        for (int i = 6; i > 0; i--) {
            if (freqFaceValue()[i] >= 4) {
                return i * 4;
            }
        }
        return 0;
    }

    /**
     * Returns the value of a small straight with the current face values.
     */
    public int valueSmallStraight() {
        boolean sStraight = true;
        for (int face : values) {
            if (freqFaceValue()[face] != 1) {
                sStraight = false;
            }
        }
        if (freqFaceValue()[6] == 1) {
            sStraight = false;
        }
        if (sStraight) {
            return 15;
        } else {
            return 0;
        }
    }

    /**
     * Returns the value of a large straight with the current face values.
     */
    public int valueLargeStraight() {
        boolean lStraight = true;
        for (int face : values) {
            if (freqFaceValue()[face] != 1) {
                lStraight = false;
            }
        }
        if (freqFaceValue()[1] == 1) {
            lStraight = false;
        }
        if (lStraight) {
            return 20;
        } else {
            return 0;
        }
    }

    /**
     * Returns the value of a full house with the current face values.
     */
    public int valueFullHouse() {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 6; i > 0; i--) {
            if (freqFaceValue()[i] == 2) {
                sum1 = i * 2;
            }
            if (freqFaceValue()[i] == 3) {
                sum2 = i * 3;
            }
            if (sum1 != 0 && sum2 != 0) {
                return sum1 + sum2;
            }
        }
        return 0;
    }
}
