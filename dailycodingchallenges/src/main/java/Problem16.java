import java.util.ArrayList;
import java.util.List;

public class Problem16 {


    public static void main(String [] args) {
        LogHolder logHolder = new LogHolder(10);
        logHolder.record("1");
        logHolder.record("2");
        logHolder.record("3");
        logHolder.record("4");
        logHolder.record("5");

        System.out.println(logHolder.getLast(1));
        System.out.println(logHolder.getLast(3));
    }


    private static class LogHolder {

        private List<String> orderIds;
        int lastIndex;

        public LogHolder(int size) {
            orderIds = new ArrayList<>(size);
            lastIndex = 0;
        }


        public void record(String id) {
            orderIds.add(id);
            lastIndex += 1;
        }

        public String getLast(int index) {
            return orderIds.get(lastIndex-index);
        }
    }
}
