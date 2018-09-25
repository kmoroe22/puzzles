public class MergeSort {

    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22};
        sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(Integer.toString(array[i]));
        }
    }

    public static void sort(int[] array) {
        mergeSort(array, 0, array.length);
    }

    public static void mergeSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    private static void merge(int[] input, int start, int mid, int end) {
        //optimization
        if (input[mid - 1] <= input[mid]) {
            return;
        }
        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            // smaller or equals maintains stable sort
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        //optimization
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }


}
