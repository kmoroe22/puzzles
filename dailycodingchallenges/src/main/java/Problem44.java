import java.util.Arrays;

public class Problem44 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 4, 1, 3, 5};
        int[] arr2 = new int[]{5, 4, 3, 2, 1};
        int[] arr3 = new int[]{3, 5, 8, 6, 7, 2};

        System.out.println(countInversions(arr1));
        System.out.println(countInversions(arr2));
        System.out.println(countInversions(arr3));
    }

    private static int countInversions(int[] array) {
        return countInversionsHelper(array).getCount();
    }

    private static Tuple countInversionsHelper(int[] array) {
        if (array.length <= 1) {
            return new Tuple(0, array);
        }
        int mid = array.length / 2;
        int[] a = Arrays.copyOfRange(array, 0, mid);
        int[] b = Arrays.copyOfRange(array, mid, array.length);

        Tuple leftCount = countInversionsHelper(a);
        Tuple rightCount = countInversionsHelper(b);
        Tuple betweenCount = mergeAndCount(a, b);
        return new Tuple(leftCount.getCount() + rightCount.getCount() + betweenCount.getCount(), betweenCount.array);
    }

    private static Tuple mergeAndCount(int[] a, int[] b) {
        int[] sortedArray = new int[a.length + b.length];
        int i = 0, j = 0;
        int index = 0;
        int count = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[i]) {
                sortedArray[index] = a[i];
                i++;
            } else {
                sortedArray[index] = b[j];
                j++;
                count++;
            }
            index += 1;
        }
        if (a.length == i) {
            System.arraycopy(b, j, sortedArray, index, b.length - j);
        } else {
            System.arraycopy(a, i, sortedArray, index, a.length - i);
        }
        return new Tuple(count, sortedArray);
    }

    private static class Tuple {
        public Tuple(int count, int[] array) {
            this.count = count;
            this.array = array;
        }

        int count;

        public int getCount() {
            return count;
        }

        public int[] getArray() {
            return array;
        }

        int[] array;
    }


}
