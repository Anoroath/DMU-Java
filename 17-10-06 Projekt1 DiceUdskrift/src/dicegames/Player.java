package dicegames;

public class Player {
    private String name;
    private int score = 0;
    private int amountOfRolls;
    private int amountOfTurns;
    private int amountOfOnes;
    private boolean won = false;
    
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }
    
    public int getAmountOfRolls() {
        return amountOfRolls;
    }

    public void setAmountOfRolls(int amountOfRolls) {
        this.amountOfRolls = amountOfRolls;
    }

    public int getAmountOfTurns() {
        return amountOfTurns;
    }

    public void setAmountOfTurns(int amountOfTurns) {
        this.amountOfTurns = amountOfTurns;
    }
    
    public int getAmountOfOnes() {
        return amountOfOnes;
    }

    public void setAmountOfOnes(int amountOfOnes) {
        this.amountOfOnes = amountOfOnes;
    }
}
