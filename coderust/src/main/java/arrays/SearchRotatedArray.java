package arrays;

public class SearchRotatedArray {

    public static void main(String[] args) {
        System.out.println(binary_search_rotated(new int[]{6, 7, 1, 2, 3, 4, 5}, 3));
        System.out.println(binary_search_rotated(new int[]{6, 7, 1, 2, 3, 4, 5}, 6));
        System.out.println(binary_search_rotated(new int[]{4, 5, 6, 1, 2, 3}, 3));
        System.out.println(binary_search_rotated(new int[]{4, 5, 6, 1, 2, 3}, 6));
    }

    static int binary_search_rotated(int[] arr, int key) {
        //TODO: Write - Your - Code
        int rotationIndex = findRotationIndex(arr, 0, arr.length - 1);
        if (rotationIndex == -1) {
            return BinarySearch.binSearch(arr, key, 0, arr.length - 1);
        } else {
            if (arr[0] > key && arr[rotationIndex] > key) {
                return BinarySearch.binSearch(arr, key, rotationIndex + 1, arr.length - 1);
            } else {
                return BinarySearch.binSearch(arr, key, 0, rotationIndex);
            }
        }
    }

    private static int findRotationIndex(int[] arr, int left, int right) {
        if (left == right) {
            if (left + 1 < arr.length - 1 && arr[left + 1] < arr[left]) {
                return left;
            } else {
                return -1;
            }
        }
        if (right < left) {
            return -1;
        }
        int mid = left + ((right - left) / 2);
        int rotationIndex = findRotationIndex(arr, left, mid);
        if (rotationIndex == -1) {
            return findRotationIndex(arr, mid + 1, right);
        }
        return rotationIndex;
    }

}
