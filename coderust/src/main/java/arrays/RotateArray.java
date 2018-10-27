package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {
    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 10, 20, 0, 59, 86, 32, 11, 9, 40));
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 10, 20, 0, 59, 86, 32, 11, 9, 40));
        rotate_array(arr1, 2);
        rotate_array(arr2, -1);
        System.out.println(arr1);
        System.out.println(arr2);
    }

    static void rotate_array(List<Integer> arr, int n) {
        reverse(arr, 0, arr.size() - 1);
        if (n > 0) {
            reverse(arr, 0, n - 1);
            reverse(arr, n, arr.size() - 1);
        } else {
            reverse(arr, arr.size() - Math.abs(n), arr.size() - 1);
            reverse(arr, 0, arr.size() - Math.abs(n) - 1);
        }
    }

    private static void reverse(List<Integer> array, int start, int end) {
        while (end > start) {
            int temp = array.get(start);
            array.set(start, array.get(end));
            array.set(end, temp);
            end--;
            start++;
        }
    }

}
