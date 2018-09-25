import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * There is an N by M matrix of zeroes. Given N and M, write a function to count the number of ways of starting at the top-left corner and getting to the bottom-right corner. You can only move right or down.
 * <p>
 * For example, given a 2 by 2 matrix, you should return 2, since there are two ways to get to the bottom-right:
 * <p>
 * Right, then down
 * Down, then right
 * Given a 5 by 5 matrix, there are 70 ways to get to the bottom-right.
 * <p>
 * We will be sending the solution tomorrow, along with tomorrow's question. As always, feel free to shoot us an email if there's anything we can help with.
 * <p>
 * Have a great day!
 */
public class Problem62 {


    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {0, 0},
//                {0, 0}
//        };
        int[][] matrix = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        Graph graph = new Graph(matrix);

        System.out.println(graph.countPathsToEnd(4, 4));
    }


    static class Graph {

        private Node start;

        public Graph(int[][] matrix) {
            start = new Node(0, 0, matrix);
        }

        public int countPathsToEnd(int x, int y) {
            return start.findPath(new Point(x, y));
        }
    }


    static class Node {

        private Set<Node> neighbours;
        private Point point;

        public Node(int x, int y, int[][] matrix) {
            neighbours = new HashSet<>();
            if (x + 1 < matrix.length) {
                neighbours.add(new Node(x + 1, y, matrix));
            }
            if (y + 1 < matrix[x].length) {
                neighbours.add(new Node(x, y + 1, matrix));
            }
            point = new Point(x, y);
        }

        public Set<Node> getNeighbours() {
            return neighbours;
        }

        public Point getPoint() {
            return point;
        }

        public int findPathHelper(Point point, Map<Point, Integer> ways) {
            if (this.point.equals(point)) {
                ways.put(this.point, 1);
                return 1;
            }
            if (neighbours.isEmpty()) {
                ways.put(this.point, 0);
                return 0;
            }
            int sum = neighbours.stream().mapToInt(a -> a.findPathHelper(point, ways)).sum();
            ways.put(this.point, sum);
            return sum;
        }

        public int findPath(Point point) {
            return findPathHelper(point, new HashMap<>());
        }
    }
}
