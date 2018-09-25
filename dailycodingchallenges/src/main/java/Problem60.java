import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a multiset of integers, return whether it can be partitioned into two subsets whose sums are the same.
 * <p>
 * For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, it would return true, since we can split it up into {15, 5, 10, 15, 10} and {20, 35}, which both add up to 55.
 * <p>
 * Given the multiset {15, 5, 20, 10, 35}, it would return false, since we can't split it up into two subsets that add up to the same sum.
 * <p>
 * We will be sending the solution tomorrow, along with tomorrow's question. As always, feel free to shoot us an email if there's anything we can help with.
 * <p>
 * Have a great day!
 */

public class Problem60 {


    public static void main(String[] args) {
        List<Integer> set = new ArrayList<>(Arrays.asList(15, 5, 20, 10, 35, 15, 10));
        System.out.print(canBeSplit(set));
    }

    private static boolean canBeSplit(List<Integer> numbers) {
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int expectedSum = sum / 2;
        List<List<Integer>> sets = powerSet(numbers);
        return sets.stream().anyMatch(a -> a.stream().mapToInt(b -> b).sum() == expectedSum);
    }

    public static <T> List<List<T>> powerSet(List<T> originalSet) {
        List<List<T>> sets = new ArrayList<>();
        if (originalSet.isEmpty()) {
            sets.add(new ArrayList<>());
            return sets;
        }
        List<T> list = new ArrayList<T>(originalSet);
        T head = list.get(0);
        List<T> rest = new ArrayList<>(list.subList(1, list.size()));
        for (List<T> set : powerSet(rest)) {
            List<T> newSet = new ArrayList<>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }
}
