package dpcoinchange;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {

    private static Scanner scanner = null;

    public static void main(String[] args) throws FileNotFoundException {
        scanner = new Scanner(new File("./dpcoinchange/src/main/resources/input09.txt"));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] coins = new int[m];

        String[] coinsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int coinsItem = Integer.parseInt(coinsItems[i]);
            coins[i] = coinsItem;
        }

        long res = ways(n, coins);

        System.out.println(Long.toString(res));


        scanner.close();
    }

    static long ways(int n, int[] coins) {
        long[] combinations = new long[n + 1];
        combinations[0] = 1;
        for(int coin: coins) {
            for (int currentAmount = 1; currentAmount < combinations.length; currentAmount++) {
                if (currentAmount >= coin) {
                    combinations[currentAmount] +=combinations[currentAmount-coin];
                }
            }
        }
        return combinations[n];
    }

}
