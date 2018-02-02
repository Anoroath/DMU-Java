package dicegames;

public class PigPlayer {

    private String name;
    private int score;
    private boolean win = false;
    private boolean turn;
    private int rolls;
    private int turns;

    public PigPlayer(String name, boolean turn) {
        this.name = name;
        setTurn(turn);
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

    public boolean isWin() {
        return this.win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public int getRolls() {
        return rolls;
    }

    public void setRolls(int rolls) {
        this.rolls = rolls;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

}
