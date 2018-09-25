import java.util.Random;
import java.util.stream.IntStream;

public class Problem45 {

    private static Random random = new Random();


    public static void main(final String[] args) {
        IntStream.range(0, 1000).forEach(a -> System.out.println("Random: " + rand7()));
    }

    private static int rand5() {
        return random.nextInt(5) + 1;
    }

    private static int rand7() {
        int initial = rand5();
        System.out.println(Integer.toString(initial));
        return initial + random.nextInt(3);
    }

}
