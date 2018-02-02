package searching_exercises;

import java.util.ArrayList;

public class PlayerMethods {
    public Player findScoreLinear(ArrayList<Player> players, int score) {
        boolean found = false;
        int i = 0;
        Player player = null;
        while (!found && i < players.size()) {
            player = players.get(i);
            if (players.get(i).getScore() == score) {
                found = true;
            } else {
                i++;
            }
        }
        if (found) {
            return player;
        } else {
            return null;
        }
    }

    public Player findScoreBinary(ArrayList<Player> players, int score) {
        boolean found = false;
        int left = 0;
        int right = players.size() - 1;
        Player player = null;
        while (!found && left <= right) {
            int middle = (left + right) / 2;
            player = players.get(middle);
            int comp = player.getScore().compareTo(score);
            if (comp == 0) {
                found = true;
            } else if (comp > 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (found) {
            return player;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        PlayerMethods metoder = new PlayerMethods();

        // Test of exercise 4.1
        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(new Player("Hans", 196, 99, 45));
        playerList.add(new Player("Bo", 203, 89, 60));
        playerList.add(new Player("Jens", 188, 109, 32));
        playerList.add(new Player("Finn", 194, 102, 12));
        playerList.add(new Player("Lars", 192, 86, 35));
        playerList.add(new Player("Mads", 200, 103, 37));

        System.out.println("Player who has 35 goals: " + metoder.findScoreLinear(playerList, 35));
        System.out.println("Player who has 30 goals: " + metoder.findScoreLinear(playerList, 30));

        // TODO: test exercise 4.2 og 4.3

    }

}
