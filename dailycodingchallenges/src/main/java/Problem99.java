import java.util.PriorityQueue;

/**
 * This problem was asked by Microsoft.
 * <p>
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * For example, given [100, 4, 200, 1, 3, 2], the longest consecutive element sequence is [1, 2, 3, 4]. Return its length: 4.
 * <p>
 * Your algorithm should run in O(n) complexity.
 * <p>
 * We will be sending the solution tomorrow, along with tomorrow's question. As always, feel free to shoot us an email if there's anything we can help with.
 * <p>
 * Have a great day!
 */
public class Problem99 {

    public static void main(String[] args) {
        int[] input = new int[]{100, 4, 200, 1, 3, 2};
        int result = findLongestSequence(input);
        System.out.println(result);
    }

    private static int findLongestSequence(int[] input) {
        if (input.length <= 1) {
            return 0;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int anInput : input) {
            heap.add(anInput);
        }
        int longestSequence = 0;
        int currentSequence = 1;
        int lastSeen = heap.poll();
        while (!heap.isEmpty()) {
            if (Math.abs(lastSeen - heap.peek()) == 1) {
                currentSequence++;
                if (longestSequence < currentSequence) {
                    longestSequence = currentSequence;
                }
            } else {
                currentSequence = 1;
            }
            lastSeen = heap.poll();
        }
        return longestSequence;
    }

}
