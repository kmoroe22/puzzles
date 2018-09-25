public class CountingSort {

    public static void main(String[] args) {
        int[] array = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
        sort(array,1,10);

        for (int i = 0; i < array.length; i++) {
            System.out.println(Integer.toString(array[i]));
        }
    }


    public static void sort(int[] array, int min, int max) {
        int[] countingArray = new int[(max - min) + 1];
        for (int i = 0; i < array.length; i++) {
            countingArray[array[i] - min]++;
        }
        int originalArrayIndex = 0;
        for (int i = 0; i < countingArray.length; i++) {
            for (int j = 0; j < countingArray[i]; j++) {
                array[originalArrayIndex] = i + min;
                originalArrayIndex += 1;
            }
        }
    }
}
