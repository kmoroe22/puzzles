import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem11 {

    public static void main(String[] args) {
        StandardTrie standardTrie = new StandardTrie();
        standardTrie.insert("dog");
        standardTrie.insert("dear");
        standardTrie.insert("deal");
        System.out.println(standardTrie.words("de"));
    }

    public static class StandardTrie {

        public StandardTrie() {
            this.chars = new HashMap<>();
        }

        public void insert(String word) {
            if (word.isEmpty()) {
                return;
            }
            char charAt = word.charAt(0);
            Trie added = add(charAt);
            added.insert(word, 0);

        }

        private List<String> words(String prefix) {
            if (prefix.isEmpty() || !chars.containsKey(prefix.charAt(0))) {
                return null;
            }
            Trie trie = chars.get(prefix.charAt(0));
            Trie foundTrie = trie.find(prefix, 0);
            if (foundTrie == null) {
                return null;
            }
            return foundTrie.printChildren().stream().map(a -> prefix.substring(0, prefix.length() - 1).concat(a)).collect(Collectors.toList());
        }

        private Trie add(char character) {
            if (!chars.containsKey(character)) {
                chars.put(character, new Trie(character));
            }
            return chars.get(character);
        }

        Map<Character, Trie> chars;
    }

    public static class Trie {
        char current;

        public Trie(char current) {
            this.current = current;
            this.nextChars = new HashMap<>();
        }

        Map<Character, Trie> nextChars;

        public void insert(String word, int currentIndex) {
            if (currentIndex == word.length() - 1) {
                return;
            }
            char c = word.charAt(currentIndex + 1);
            if (!nextChars.containsKey(c)) {
                nextChars.put(c, new Trie(c));
            }
            nextChars.get(c).insert(word, currentIndex + 1);
        }

        public List<String> printChildren() {
            if (nextChars.isEmpty()) {
                return Collections.singletonList(String.valueOf(current));
            }
            return nextChars.values().stream()
                    .map(Trie::printChildren)
                    .flatMap(Collection::stream)
                    .map(string -> String.valueOf(current).concat(string))
                    .collect(Collectors.toList());
        }

        public Trie find(String prefix, int currentIndex) {
            if (currentIndex == prefix.length() - 1) {
                return this;
            } else if (nextChars.containsKey(prefix.charAt(currentIndex + 1))) {
                return nextChars.get(prefix.charAt(currentIndex + 1)).find(prefix, currentIndex + 1);
            } else {
                return null;
            }
        }

        @Override
        public String toString() {
            return printChildren().stream().collect(Collectors.joining("\n"));
        }
    }
}
