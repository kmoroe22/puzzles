import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem106 {

    public static void main(String[] args) {
        int[] firstArray = new int[]{2, 0, 1, 0};
        int[] secondArray = new int[]{1, 1, 0, 1};
        System.out.println(canReachLastIndex(firstArray));
        System.out.println(canReachLastIndex(secondArray));
    }

    private static boolean canReachLastIndex(int[] array) {
        if (array.length == 0) {
            return false;
        }
        if (array.length == 1) {
            return true;
        }
        return canReachLastIndex(array, 0, new HashMap<>());
    }

    private static boolean canReachLastIndex(int[] array, int currentIndex, Map<Integer, Boolean> visited) {
        if (visited.containsKey(currentIndex)) {
            return visited.get(currentIndex);
        }
        if (currentIndex >= array.length) {
            visited.put(currentIndex, false);
            return false;
        }

        if (currentIndex == array.length - 1) {
            visited.put(currentIndex, true);
            return true;
        }

        if (array[currentIndex] == 0 && currentIndex != array.length - 1) {
            visited.put(currentIndex, false);
            return false;
        }

        int value = array[currentIndex];
        List<Boolean> responses = new ArrayList<>();
        for (int i = 1; i <= value; i++) {
            responses.add(canReachLastIndex(array, currentIndex + i, visited));
        }
        return responses.stream().anyMatch(a -> a);
    }

}
