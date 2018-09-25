import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and an integer k, break up the string into multiple texts such that each text has a length of k or less. You must break it up so that words don't break across lines. If there's no way to break the text up, then return null.
 * You can assume that there are no spaces at the ends of the string and that there is exactly one space between each word.
 * For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10, you should return: ["the quick", "brown fox", "jumps over", "the lazy", "dog"]. No string in the list has a length of more than 10.
 * We will be sending the solution tomorrow, along with tomorrow's question. As always, feel free to shoot us an email if there's anything we can help with.
 * Have a great day!
 */
public class Problem57 {

    public static void main(String[] args) {
        System.out.print((partition("the quick brown fox jumps over the lazy dog", 10)).toString());
    }


    private static List<String> partition(String sentence, int k) {
        int currentIndex = k;
        sentence.split("");
        List<String> partitions = new ArrayList<>();
        int lastStartIndex = 0;
        while (currentIndex < sentence.length()) {
            int nextSpace = currentIndex;
            while (nextSpace > (currentIndex - k) && sentence.charAt(nextSpace) != ' ') {
                nextSpace--;
            }
            if (sentence.charAt(nextSpace) == ' ') {
                partitions.add(sentence.substring(lastStartIndex, nextSpace));
                lastStartIndex = nextSpace + 1;
            } else {
                partitions.add(null); //??
            }
            currentIndex += k;
        }
        if (lastStartIndex < sentence.length()) {
            partitions.add(sentence.substring(lastStartIndex, sentence.length()));
        }
        return partitions;
    }
}
