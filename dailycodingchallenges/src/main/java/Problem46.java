public class Problem46 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aabcdcb"));
        System.out.println(longestPalindrome("banana"));
        System.out.println(longestPalindrome("Anna"));
        System.out.println(longestPalindrome("civic"));
        System.out.println(longestPalindrome("kayak"));
        System.out.println(longestPalindrome("level"));
        System.out.println(longestPalindrome("rotor"));
        System.out.println(longestPalindrome("rotory"));
        System.out.println(longestPalindrome("stats"));
        System.out.println(longestPalindrome("forgeeksskeegfor"));
    }

    private static String longestPalindrome(String value) {
        if (value.length() < 1) {
            return "";
        }
        if (value.length() == 2) {
            if (value.charAt(0) == value.charAt(1)) {
                return value;
            } else {
                return "";
            }
        }
        if (value.length() == 3) {
            if (value.charAt(0) == value.charAt(2)) {
                return value;
            } else {
                return "";
            }
        }
        String longest = null;
        for (int i = 1; i < value.length() - 2; i ++) {
            int start = i - 1;
            int end = i + 1;
            if (i == value.length() - 1) {
                start = i - 2;
                end = i;
            }
            Palindrome threeLetterPalindrome = findThreeLetterPalindrome(value, start, end);
            if (threeLetterPalindrome != null) {
                Palindrome expandedPalindrome = expand(value, threeLetterPalindrome);
                if (longest == null || expandedPalindrome.getFoundPalineDrome().length() > longest.length()) {
                    longest = expandedPalindrome.getFoundPalineDrome();
                }
            }
        }
        return longest;
    }

    private static Palindrome findThreeLetterPalindrome(String original, int start, int end) {
        if (original.charAt(start) == original.charAt(end)) {
            return new Palindrome(original.substring(start, end + 1), start, end);
        }
        if (original.charAt(start) == original.charAt(start + 1)) {
            return new Palindrome(original.substring(start, end), start, start + 1);
        }

        if (original.charAt(end) == original.charAt(end - 1)) {
            return new Palindrome(original.substring(start + 1, end + 1), end - 1, end);
        }
        return null;
    }


    private static Palindrome expand(String original, Palindrome palinDrome) {
        if (palinDrome.endIndex + 1 >= original.length() || palinDrome.startIndex - 1 < 0) {
            return palinDrome;
        }
        if (original.charAt(palinDrome.startIndex - 1) == original.charAt(palinDrome.endIndex + 1)) {
            palinDrome.expand(original);
            expand(original, palinDrome);
        }
        return palinDrome;
    }

    private static class Palindrome {
        private String foundPalineDrome;

        private int startIndex;

        public String getFoundPalineDrome() {
            return foundPalineDrome;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public int getEndIndex() {
            return endIndex;
        }

        private void expand(String original) {
            startIndex--;
            endIndex++;
            foundPalineDrome = original.substring(startIndex, endIndex + 1);
        }

        private int endIndex;

        public Palindrome(String foundPalineDrome, int startIndex, int endIndex) {
            this.foundPalineDrome = foundPalineDrome;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }

}
