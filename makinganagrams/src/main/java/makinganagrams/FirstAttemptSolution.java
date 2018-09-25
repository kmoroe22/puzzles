package makinganagrams;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FirstAttemptSolution {


    private static final Scanner scanner = new Scanner(System.in);

    static int countDeletionsNecessary(String a, String b) {
        int uniqueBCounter = 0;
        Map<Character, Integer> aLetterCount = buildLetterCountMap(a);
        for (int i = 0; i < b.length(); i++) {
            if (aLetterCount.containsKey(b.charAt(i))) {
                aLetterCount.put(b.charAt(i), aLetterCount.get(b.charAt(i)) - 1);
            } else {
                uniqueBCounter += 1;
            }
        }
        return aLetterCount.entrySet().stream().map(Map.Entry::getValue).reduce((x,y)-> Math.abs(x)+Math.abs(y)).get()+uniqueBCounter;
    }

    private static Map<Character, Integer> buildLetterCountMap(String a) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            if (map.containsKey(a.charAt(i))) {
                map.put(a.charAt(i), map.get(a.charAt(i)) + 1);
            } else {
                map.put(a.charAt(i), 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
//        String a = scanner.nextLine();
//
//        String b = scanner.nextLine();
//        System.out.println(countDeletionsNecessary(a,b));
//        42??
        System.out.print(countDeletionsNecessary("fsqoiaidfaukvngpsugszsnseskicpejjvytviya","ksmfgsxamduovigbasjchnoskolfwjhgetnmnkmcphqmpwnrrwtymjtwxget"));
        scanner.close();
    }
}