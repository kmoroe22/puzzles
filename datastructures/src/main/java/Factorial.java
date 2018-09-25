public class Factorial {

    public static void main(String[] args) {

    }

    public static int factorialIterative(int num) {
        if (num == 0) {
            return 1;
        }

        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static int factorial(int num) {
        if ( num == 0) {
            return 1;
        } else {
            return num * factorial(num-1);
        }
    }

}
