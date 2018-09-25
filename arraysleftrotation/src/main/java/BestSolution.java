import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BestSolution {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] newArray = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            newArray[(i + (a.length - d)) % a.length] = a[i];
        }
        return newArray;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] result = rotLeft(new int[]{1, 2, 3, 4, 5}, 4);
        System.out.println(Arrays.toString(result));
        int[] result2 = rotLeft(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 4);
        System.out.println(Arrays.toString(result2));


//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./out/out.txt"));
//
//        String[] nd = scanner.nextLine().split(" ");
//
//        int n = Integer.parseInt(nd[0]);
//
//        int d = Integer.parseInt(nd[1]);
//
//        int[] a = new int[n];
//
//        String[] aItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int aItem = Integer.parseInt(aItems[i]);
//            a[i] = aItem;
//        }
//
//        int[] result = rotLeft(a, d);
//
//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write(" ");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
