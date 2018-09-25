public class SelectionSort {


    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22};
        shellSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(Integer.toString(array[i]));
        }
    }

    static void sort(int[] array) {
        int lastSortedIndex = array.length - 1;
        while (lastSortedIndex > 0) {
            int largestIndex = 0;
            for (int i = 0; i <= lastSortedIndex; i++) {
                if (array[i] > array[largestIndex]) {
                    largestIndex = i;
                }
            }
            int temp = array[lastSortedIndex];
            array[lastSortedIndex] = array[largestIndex];
            array[largestIndex] = temp;
            lastSortedIndex = lastSortedIndex - 1;
        }
    }

    static void shellSort(int[] array) {
        for (int gap = array.length; gap > 0; gap /= 2) {
            for (int i = gap; i > array.length; i++) {
                int newElement = array[i];
                int j = i;

                while (j >= gap && array[j - gap] > newElement) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = newElement;
            }
        }
    }
}