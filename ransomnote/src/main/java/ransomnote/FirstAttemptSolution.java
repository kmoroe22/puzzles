package ransomnote;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FirstAttemptSolution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> magazineSet = new HashMap<>();
        Arrays.stream(magazine)
                .forEach(word -> {
                    magazineSet.merge(word, 1, (count1, count2) -> count1 + count2);
                });
        boolean allMatch = Arrays.stream(note).allMatch(word -> findAndRemove(word, magazineSet));
        if (allMatch) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean findAndRemove(String string, Map<String, Integer> set) {
        if (set.containsKey(string)) {
            set.compute(string, (a,b)-> b-1);
            if (set.get(string).equals(0)) {
                set.remove(string);
            }
            return true;
        }
//        System.out.println(String.format("couldn't find for %s", string));
        return false;
    }

    private static Scanner scanner = null;

    public static void main(String[] args) throws FileNotFoundException {
        scanner = new Scanner(new File("./ransomnote/src/main/resources/sample.txt"));
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }
        checkMagazine(magazine, note);
//        checkMagazine(new String[]{"two", "times", "three", "is", "not", "four"}, new String[]{"two" ,"times", "two", "is", "four"});

        scanner.close();
    }
}
