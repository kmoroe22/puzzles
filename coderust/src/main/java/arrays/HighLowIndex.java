package arrays;

import java.util.Arrays;
import java.util.List;

public class HighLowIndex {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 20);
        System.out.println("Low: " + find_low_index(arr, 1) + " High: " + find_high_index(arr, 1));
        System.out.println("Low: " + find_low_index(arr, 2) + " High: " + find_high_index(arr, 2));
        System.out.println("Low: " + find_low_index(arr, 5) + " High: " + find_high_index(arr, 5));
        System.out.println("Low: " + find_low_index(arr, 20) + " High: " + find_high_index(arr, 20));
    }


    static int searchChange(List<Integer> a, int key, int low, int high, boolean isLower) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) / 2);
        if (a.get(mid) == key) {
            if (isLower && (mid - 1 < 0 || a.get(mid - 1) != key)) {
                return mid;
            } else if (!isLower && (mid + 1 >= a.size() || a.get(mid + 1) != key)) {
                return mid;
            }
        }
        if (key == a.get(mid)) {
            if (isLower) {
                return searchChange(a, key, low, mid - 1, isLower);
            } else {
                return searchChange(a, key, mid + 1, high, isLower);
            }
        }
        if (key < a.get(mid)) {
            return searchChange(a, key, low, mid - 1, isLower);
        } else {
            return searchChange(a, key, mid + 1, high, isLower);
        }
    }


    static int find_low_index(
            List<Integer> arr,
            int key) {
        return searchChange(arr, key, 0, arr.size() - 1, true);
    }

    static int find_high_index(
            List<Integer> arr,
            int key) {
        return searchChange(arr, key, 0, arr.size() - 1, false);
    }
}
