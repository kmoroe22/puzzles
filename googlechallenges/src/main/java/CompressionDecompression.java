import java.util.Stack;

public class CompressionDecompression {

    public static void main(String[] args) {
        String value1 = "3[abc]4[ab]c";
        String value2 = "2[3[a]b]";
        String value3 = "10[a]";
        String value4 = "10[2[3[a]b]a]";

        System.out.println(decompress(value1));
        System.out.println(decompress(value2));
        System.out.println(decompress(value3));
        System.out.println(decompress(value4));
    }

    private static String decompress(String word) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (character == ']') {
                String poppedChar = null;
                StringBuilder poppedBuilder = new StringBuilder();
                do {
                    poppedChar = stack.pop();
                    poppedBuilder.insert(0, poppedChar);

                } while (!poppedChar.equals("["));
                while (!stack.isEmpty() && isDigit(stack.peek())) {
                    poppedBuilder.insert(0, stack.pop());

                }
                poppedBuilder.append(character);
                String expanded = expand(poppedBuilder.toString());
                stack.push(expanded);
            } else {
                stack.push(String.valueOf(character));
            }
        }
        StringBuilder finalString = new StringBuilder();
        while (!stack.isEmpty()) {
            finalString.insert(0, stack.pop());
        }
        return finalString.toString();

    }

    private static boolean isDigit(String source) {
        try {
            Integer.parseInt(source);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String expand(String source) {
        if (source.length() < 3) {
            return ""; //[]
        }
        StringBuilder numberStringBuilder = new StringBuilder();
        int charIndex = 0;
        char currentChar = source.charAt(charIndex);
        while (currentChar != '[') {
            numberStringBuilder.append(currentChar);
            charIndex++;
            currentChar = source.charAt(charIndex);
        }
        String letters = source.substring(charIndex + 1, source.length() - 1);
        int times = 1;
        String numberString = numberStringBuilder.toString();
        if (numberString.length() > 0) {
            times = Integer.parseInt(numberString);
        }
        String result = "";
        for (int i = 0; i < times; i++) {
            result = result.concat(letters);
        }
        return result;
    }
}
