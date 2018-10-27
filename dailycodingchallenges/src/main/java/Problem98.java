
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * This problem was asked by Coursera.
 * <p>
 * Given a 2D board of characters and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * For example, given the following board:
 * <p>
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * exists(board, "ABCCED") returns true, exists(board, "SEE") returns true, exists(board, "ABCB") returns false.
 * <p>
 * We will be sending the solution tomorrow, along with tomorrow's question. As always, feel free to shoot us an email if there's anything we can help with.
 * <p>
 * Have a great day!
 */

public class Problem98 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exists(board, "ABCCED"));
        System.out.println(exists(board, "SEE"));
        System.out.println(exists(board, "ABCB"));
    }

    private static boolean exists(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == word.charAt(0)) {
                    if (exists(board, row, column, word, 0, new HashSet<>())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean exists(char[][] board, int row, int column, String word, int currentChar, Set<Pair> visited) {
        if (currentChar >= word.length()) {
            return false;
        }
        if (visited.contains(new Pair(row, column))) {
            return false;
        }
        if (!canVisit(board, row, column)) {
            return false;
        }
        if (word.charAt(currentChar) != board[row][column]) {
            return false;
        }
        if (currentChar == word.length() - 1) {
            return true;
        }
        visited.add(new Pair(row, column));
        return exists(board, row - 1, column, word, currentChar + 1, new HashSet<>(visited)) ||
                exists(board, row, column - 1, word, currentChar + 1, new HashSet<>(visited)) ||
                exists(board, row + 1, column, word, currentChar + 1, new HashSet<>(visited)) ||
                exists(board, row, column + 1, word, currentChar + 1, new HashSet<>(visited));
    }

    private static boolean canVisit(char[][] board, int row, int column) {
        if (row < 0 || column < 0) {
            return false;
        }
        if (row >= board.length) {
            return false;
        }
        return column < board[row].length;
    }

    private static class Pair {

        private int first;
        private int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first &&
                    second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}
