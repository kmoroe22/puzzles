public class InsertionSort {


    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22};
        sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(Integer.toString(array[i]));
        }
    }

    static void sort(int[] array, boolean bool) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            int newElement = array[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i--) {
                array[i] = array[i - 1];
            }
            array[i] = newElement;
        }
    }

    static void sort(int[] array) {
        sort(array, 0);
    }

    static void sort(int[] array, int currentUnsortedIndex) {
        if (currentUnsortedIndex >= array.length) {
            return;
        }
        place(array, array[currentUnsortedIndex], currentUnsortedIndex);
        sort(array, currentUnsortedIndex + 1);
    }

    static void place(int[] array, int newValue, int index) {
        if (index < 1 || array[index - 1] < newValue) {
            array[index] = newValue;
            return;
        }
        array[index] = array[index - 1];
        place(array, newValue, index - 1);
    }

}
