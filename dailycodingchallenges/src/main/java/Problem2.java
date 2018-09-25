import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem2 {

    public static void main(String[] args) {
        int[] elements1 = {1, 2, 3, 4, 5};
        int[] elements2 = {3, 2, 1};

        System.out.println(Arrays.toString(convert(elements1)));
        System.out.println(Arrays.toString(convert(elements2)));
        System.out.println(32 ^ 40);
    }

//    public static int[] convert(int[] elements) {
//        int product = 1;
//        for (int i : elements) {
//            product *= i;
//        }
//        int[] newArray = new int[elements.length];
//        for (int i = 0; i < newArray.length; i++) {
//            newArray[i] = product / elements[i];
//        }
//        return newArray;
//    }

    public static int[] convert(int[] elements) {
        int[] newArray = new int[elements.length];
        int before = 1;
        for (int i = 0; i < elements.length; i++){
            newArray[i] = before;
            before *= elements[i];
        }
        int after = 1;
        for (int i = newArray.length-1; i >= 0; i--) {
            newArray[i] *= after;
            after *= elements[i];
        }
        return newArray;
    }

}
