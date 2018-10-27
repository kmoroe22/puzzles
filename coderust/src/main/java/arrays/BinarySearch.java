package arrays;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binSearch(new int[]{1, 2, 4, 7, 8, 12, 15, 19, 24, 50, 69, 80, 100}, 12));
        System.out.println(binSearch(new int[]{1, 2, 4, 7, 8, 12, 15, 19, 24, 50, 69, 80, 100}, 80));
        System.out.println(binSearch(new int[]{1, 2, 4, 7, 8, 12, 15, 19, 24, 50, 69, 80, 100}, 44));
        System.out.println(binSearch(new int[]{8}, 44));
        System.out.println(binSearch(new int[]{24}, 24));
    }

    public static int binSearch(int[] a, int key) {
        return binSearch(a, key, 0, a.length - 1);

    }

    public static int binSearch(int[] a, int key, int startIndex, int endIndex) {
        if (startIndex == endIndex && a[startIndex] == key) {
            return startIndex;
        }
        if (startIndex >= endIndex) {
            return -1;
        }
        if (a[startIndex] == key) {
            return startIndex;
        }
        if (a[endIndex] == key) {
            return endIndex;
        }
        int midpoint = startIndex + ((endIndex - startIndex) / 2);
        if (key <= a[midpoint]) {
            return binSearch(a, key, startIndex, midpoint);
        } else {
            return binSearch(a, key, midpoint + 1, endIndex);
        }
    }
}
