public class Problem49 {


    /**
     * Kadanes algorithm: https://medium.com/@marcellamaki/finding-the-maximum-contiguous-sum-in-an-array-and-kadanes-algorithm-e303cd4eb98c
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(Integer.toString(maxSum(new int[]{34, -50, 42, 14, -5, 86})));
    }

    public static int maxSum(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max + arr[i]) {
                max = arr[i];
            } else {
                max += arr[i];
            }
        }
        return max;
    }


}
