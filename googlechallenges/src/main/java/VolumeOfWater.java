import java.util.LinkedList;
import java.util.List;

public class VolumeOfWater {


    public static void main(String[] args) {
        int[] island = new int[]{1, 3, 2, 4, 1, 3, 1, 4, 5, 2, 2, 1, 4, 2, 2};
        System.out.println(calculateVolumeOfWater(island));
    }

    public static int calculateVolumeOfWater(int[] island) {
        int volume = 0;
        boolean isUphillValley = false;
        List<Integer> counter = new LinkedList<>();
        int valleyStartHeight = 0;
        //uphill and level pass
        for (int i = 0; i < island.length - 1; i++) {
            if (isUphillValley) {
                counter.add(island[i]);
                if (island[i + 1] >= valleyStartHeight) {
                    int actualValleyHeight = valleyStartHeight < island[i+1] ? valleyStartHeight : island[i+1];
                    int totalValleyVolume = counter.stream().mapToInt(a -> actualValleyHeight - a).sum();
                    volume += totalValleyVolume;
                    isUphillValley = false;
                    valleyStartHeight = 0;
                    counter.clear();
                }
            } else {
                int height = island[i];
                int heightOfNext = island[i + 1];
                if (height > heightOfNext) {
                    isUphillValley = true;
                    valleyStartHeight = island[i];
                }
            }
        }
        //downhill
        isUphillValley = false;
        counter = new LinkedList<>();
        valleyStartHeight = 0;
        for (int i = island.length-1; i > 0; i--) {
            if (isUphillValley) {
                counter.add(island[i]);
                if (island[i - 1] >= valleyStartHeight) {
                    int actualValleyHeight = valleyStartHeight < island[i-1] ? valleyStartHeight : island[i-1];
                    int totalValleyVolume = counter.stream().mapToInt(a -> actualValleyHeight - a).sum();
                    volume += totalValleyVolume;
                    isUphillValley = false;
                    valleyStartHeight = 0;
                    counter.clear();
                }
            } else {
                int height = island[i];
                int heightOfNext = island[i - 1];
                if (height > heightOfNext) {
                    isUphillValley = true;
                    valleyStartHeight = island[i];
                }
            }
        }
        return volume;
    }
}
