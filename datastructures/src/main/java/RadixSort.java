
public class RadixSort {
    public static void main(String[] args) {
        int[] array = {4725, 4586, 1330, 8792, 1594, 5729};
        String[] arrayString = {"bcdef", "dbaqc", "abcde","omadd", "bbbbb"};
        radixSort(array, 10, 4);
        radixSort(arrayString, 26, 5);

        for (int i = 0; i < array.length; i++) {
            System.out.println(Integer.toString(array[i]));
        }

        for (int i = 0; i < arrayString.length; i++) {
            System.out.println(arrayString[i]);
        }
    }

    public static void radixSort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    //TODO: broken fix logic
    public static void radixSort(String[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    private static void radixSingleSort(String[] input, int position, int radix) {
        int numItems = input.length;
        int[] countArray = new int[radix];
        for (String value : input) {
            countArray[getDigit(position, value)]++;
        }
        //for stability
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        String[] temp = new String[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex])]] = input[tempIndex];
        }

        //TODO: review methodology here that keeps this counting sort stable
        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }


    private static void radixSingleSort(int[] input, int position, int radix) {
        int numItems = input.length;
        int[] countArray = new int[radix];
        for (int value : input) {
            countArray[getDigit(position, value, radix)]++;
        }
        //for stability
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }

        //TODO: review methodology here that keeps this counting sort stable
        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }

    private static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(10, position) % radix;
    }

    private static int getDigit(int position, String value) {
        return value.charAt(position) - 'a';
    }


}
