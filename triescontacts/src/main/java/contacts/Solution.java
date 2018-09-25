package contacts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {


    private static Scanner scanner = null;

    public static void main(String[] args) throws FileNotFoundException {

        scanner = new Scanner(new File("./triescontacts/src/main/resources/input02.txt"));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        HashMap<Character, Trie> rootTries = new HashMap<>();
        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];

            String contact = opContact[1];

            if (op.equalsIgnoreCase("add")) {
                add(rootTries, contact);
            } else if (op.equalsIgnoreCase("find")) {
                System.out.println(Integer.toString(find(rootTries, contact)));
            }
        }

        scanner.close();
    }

    public static void add(Map<Character, Trie> rootTries, String prefix) {
        rootTries.putIfAbsent(prefix.charAt(0), new Trie(prefix.charAt(0)));
        rootTries.get(prefix.charAt(0)).add(prefix, 0);
    }

    public static int find(Map<Character, Trie> rootTries, String prefix) {
        rootTries.putIfAbsent(prefix.charAt(0), new Trie(prefix.charAt(0)));
        TrieSearchResult trieSearchResult = rootTries.get(prefix.charAt(0)).find(prefix);
        if (trieSearchResult.trie == null) {
            return 0;
        } else {
            return trieSearchResult.trie.count();
        }
    }

    public static class Trie {

        private Character character;
        private Map<Character, Trie> next;
        int wordsFromHere;

        public Trie(Character character) {
            this.character = character;
            next = new HashMap<>();
            wordsFromHere = 0;
        }

        public int count() {
            return wordsFromHere;
        }

        public TrieSearchResult find(String prefix) {
            return find(prefix, 0);
        }

        public int add(String prefix, int currentIndex) {
            if (currentIndex + 1 == prefix.length()) {
                wordsFromHere+=1;
                return 1;
            }
            next.putIfAbsent(prefix.charAt(currentIndex + 1), new Trie(prefix.charAt(currentIndex + 1)));
            int add = next.get(prefix.charAt(currentIndex + 1)).add(prefix, currentIndex + 1);
            wordsFromHere +=add;
            return add;
        }

        public TrieSearchResult find(String prefix, int currentIndex) {
            if (prefix.charAt(currentIndex) != character) {
                return null;
            }
            if (prefix.length() == currentIndex + 1) {
                return new TrieSearchResult(this, currentIndex);
            } else {
                Trie nextTrie = next.get(prefix.charAt(currentIndex + 1));
                if (nextTrie == null) {
                    return new TrieSearchResult(null, currentIndex);
                }
                return nextTrie.find(prefix, currentIndex + 1);
            }
        }
    }

    public static class TrieSearchResult {

        private Trie trie;
        private int index;

        public TrieSearchResult(Trie trie, int index) {
            this.trie = trie;
            this.index = index;
        }

        public Trie getTrie() {
            return trie;
        }

        public int getIndex() {
            return index;
        }
    }
}
