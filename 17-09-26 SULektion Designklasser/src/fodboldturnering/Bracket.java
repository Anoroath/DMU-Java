package fodboldturnering;

public class Bracket {

    private int Score;
    private int League;
    private String Teams;

    public Bracket(int iScore, int iLeague, String iTeams) {
        setScore(iScore);
        setLeague(iLeague);
        setTeams(iTeams);
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int iScore) {
        Score = iScore;
    }

    public int getLeague() {
        return League;
    }

    public void setLeague(int iLeague) {
        League = iLeague;
    }

    public String getTeams() {
        return Teams;
    }

    public void setTeams(String iTeams) {
        Teams = iTeams;
    }
}
