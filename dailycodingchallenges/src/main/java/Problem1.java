import java.util.HashSet;
import java.util.Set;

public class Problem1 {

    public static void main(String[] args) {
        int[] elements = {10, 15, 3, 7};
        System.out.println("Pair exist: " + hasPairThatAddUpTo(elements, 17));
        System.out.println("Pair exist: " + hasPairThatAddUpTo(elements, 25));
        System.out.println("Pair exist: " + hasPairThatAddUpTo(elements, 10));
        System.out.println("Pair exist: " + hasPairThatAddUpTo(elements, 19));
        System.out.println("Pair exist: " + hasPairThatAddUpTo(elements, 21));
    }

    public static boolean hasPairThatAddUpTo(int[] elements, int expectedSum) {
        Set<Integer> set = new HashSet<>();
        for (int element : elements) {
            if (set.contains(element)) {
                return true;
            } else {
                set.add(expectedSum - element);
            }
        }
        return false;
    }

}
