import java.util.Arrays;

public class Problem51 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println(Arrays.toString(arr));
        shuffle(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shuffle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            int random = randpm(i, arr.length - 1);
            int temp = arr[random];
            arr[random] = arr[i];
            arr[i] = temp;
        }
    }

    private static int randpm(double min, double max) {
        return (int) ((int) (Math.random() * ((max - min) + 1)) + min);
    }
}
