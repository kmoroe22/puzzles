package comparatorsorting;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {


    public static void main(String[] args) {
        Player[] players = new Player[5];
        players[0] = new Player("amy", 100);
        players[1] = new Player("david", 100);
        players[2] = new Player("heraldo", 50);
        players[3] = new Player("aakansha", 75);
        players[4] = new Player("aleksa", 150);
        Arrays.sort(players, new Checker());

        System.out.println(Arrays.toString(players));
    }

    public static class Checker implements Comparator<Player> {

        @Override
        public int compare(Player o1, Player o2) {
            int comparision = Integer.compare(o1.score, o2.score);
            if (comparision != 0) {
                return comparision * -1;
            } else {
                return o1.name.compareTo(o2.name);
            }
        }
    }


    public static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return String.format("%s %d", name, score);
        }
    }

}
