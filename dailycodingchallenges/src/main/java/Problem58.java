/**
 * An sorted array of integers was rotated an unknown number of times.
 * <p>
 * Given such an array, find the index of the element in the array in faster than linear time. If the element doesn't exist in the array, return null.
 * <p>
 * For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).
 * <p>
 * You can assume all the integers in the array are unique.
 * <p>
 * We will be sending the solution tomorrow, along with tomorrow's question. As always, feel free to shoot us an email if there's anything we can help with.
 * <p>
 * Have a great day!
 */
public class Problem58 {

    public static void main(String[] args) {
        int[] array = {13, 18, 25, 2, 8, 10};
        System.out.println(findIndexOf(array, 8, 0, array.length - 1));
    }

    private static int findIndexOf(int[] array, int value, int subArrayLeftIndex, int subArrayRightIndex) {
        if (array.length == 1) {
            if (array[0] == value) {
                return 0;
            } else {
                return -1;
            }
        }
        if (array[subArrayLeftIndex] == value) {
            return subArrayLeftIndex;
        }
        if (array[subArrayRightIndex] == value) {
            return subArrayRightIndex;
        }
        int midpoint = subArrayLeftIndex + ((subArrayRightIndex - subArrayLeftIndex) / 2);
        if (isWithinPortionOfArray(array, value, subArrayLeftIndex, midpoint)) {
            return findIndexOf(array, value, subArrayLeftIndex, midpoint);
        } else if (isWithinPortionOfArray(array, value, midpoint + 1, subArrayRightIndex)) {
            return findIndexOf(array, value, midpoint + 1, subArrayRightIndex);
        }
        return -1;
    }

    private static boolean isWithinPortionOfArray(int[] array, int value, int startPosition, int endPosition) {
        if (array[startPosition] < array[endPosition]) { //incrementing range
            if ((array[startPosition] <= value && value <= array[endPosition])) {
                return true;
            } else {
                return false;
            }
        }
        if (array[startPosition] > array[endPosition]) { //rotation has happened
            if (array[startPosition] < value || array[endPosition] > value) {
                return true;
            }
        }
        return false;
    }
}
