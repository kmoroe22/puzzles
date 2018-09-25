/**
 * ????????????????
 */
public class Problem61 {

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            System.out.println(Integer.toString(i << 10) + ":" + Integer.toBinaryString(i) + ":" + Integer.toBinaryString(i << 10));
        }

    }


    private static int power(int root, int exp) {
        return root << exp;
    }

}
