package arrays;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxInSlidingWindow {
    public static void main(String[] args) {
        System.out.println(find_max_sliding_window(new int[]{1, 2, 3, 4, 3, 2, 1, 2, 5}, 4));
        System.out.println(find_max_sliding_window(new int[]{1, 2, 3, 4, 3, 2, 1, 2, 5}, 3));
        System.out.println(find_max_sliding_window(new int[]{1, 2, 3, 4, 3, 2, 1, 2, 5}, 5));
    }

    public static ArrayDeque<Integer> find_max_sliding_window_NaiveApprach(
            int[] array,
            int window_size) {
        ArrayDeque<Integer> result = new ArrayDeque<Integer>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(window_size, Comparator.reverseOrder());

        for (int i = 0; i < window_size; i++) {
            maxQueue.add(array[i]);
        }
        int firstIndexOfCurrentWindow = 0;
        int lastIndexOfCurrentWindow = window_size - 1;

        result.add(maxQueue.peek());
        while (lastIndexOfCurrentWindow < array.length) {
            maxQueue.remove(array[firstIndexOfCurrentWindow]);
            firstIndexOfCurrentWindow += 1;
            lastIndexOfCurrentWindow += 1;
            if (lastIndexOfCurrentWindow == array.length) {
                break;
            }
            maxQueue.add(array[lastIndexOfCurrentWindow]);
            result.add(maxQueue.peek());
        }
        return result;
    }

    public static ArrayDeque<Integer> find_max_sliding_window(
            int[] array,
            int window_size) {
        ArrayDeque<Integer> result = new ArrayDeque<Integer>();
        LinkedList<Integer> indexList = new LinkedList<>();

        if (array.length < window_size) {
            return result;
        }

        for (int i = 0; i < array.length; i++) {
            while (!indexList.isEmpty() && array[indexList.getLast()] < array[i]) {
                indexList.removeLast();
            }
            indexList.addLast(i);
            if (!indexList.isEmpty() && indexList.getFirst() <= i - window_size) {
                indexList.removeFirst();
            }
            if (i >= window_size - 1) {
                result.add(array[indexList.getFirst()]);
            }
        }
        return result;
    }

}
