public class Problem7 {

    public static void main(String[] array) {
        System.out.println(ways("111", 0));
    }


    public static int ways(String word, int currentIndex) {
        if (currentIndex >= word.length() - 1) {
            return 1;
        }
        int ways = ways(word, currentIndex + 1);
        if (Integer.parseInt(word.substring(currentIndex, currentIndex + 2)) <= 26) {
            ways += ways(word, currentIndex + 2);
        }
        return ways;
    }

}
