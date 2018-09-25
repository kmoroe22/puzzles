package runningmedian;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner = null;

    public static void main(String[] args) throws FileNotFoundException {
        scanner = new Scanner(new File("./runningmedian/src/main/resources/input02.txt"));
        int n = scanner.nextInt();
//        int n = 6;
//        int n = 10;
//        int[] a = new int[]{12,4,5,3,8,7};
//        int[] a = new int[]{1,2,3,4,5,6,7,8,9,10};
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        MedianCollection medianCollection = new MedianCollection();
        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            a[i] = aItem;
            medianCollection.add(a[i]);
//            medianCollection.add(aItem);
            System.out.println(Double.toString(medianCollection.getMedian()));
        }

        scanner.close();
    }

    private static final class MedianCollection {

        private PriorityQueue<Double> lowerHalfQueue;
        private PriorityQueue<Double> upperHalfQueue;

        public MedianCollection() {
            this.upperHalfQueue = new PriorityQueue<>(Comparator.reverseOrder());
            this.lowerHalfQueue = new PriorityQueue<>(Comparator.naturalOrder());
        }

        public double getMedian() {
            PriorityQueue<Double> queueWithMedian = null;

            if (lowerHalfQueue.size() > upperHalfQueue.size()) {
                queueWithMedian = lowerHalfQueue;
            } else if (upperHalfQueue.size() > lowerHalfQueue.size()) {
                queueWithMedian = upperHalfQueue;
            }

            if (queueWithMedian != null) {
                return queueWithMedian.peek();
            }

            return (upperHalfQueue.peek() + lowerHalfQueue.peek()) / 2.0;
        }

        public void add(double integer) {
            if (lowerHalfQueue.isEmpty() && upperHalfQueue.isEmpty()) {
                lowerHalfQueue.add(integer);
                return;
            }

            double median = getMedian();
            if (lowerHalfQueue.isEmpty() || median < integer) {
                lowerHalfQueue.add(integer);
            } else if (upperHalfQueue.isEmpty() || median > integer) {
                upperHalfQueue.add(integer);
            } else {
                lowerHalfQueue.add(integer);
            }
            balance();
        }

        public void balance() {
            PriorityQueue<Double> biggerQueue = lowerHalfQueue.size() > upperHalfQueue.size() ? lowerHalfQueue : upperHalfQueue;
            PriorityQueue<Double> smallerQueue = biggerQueue == lowerHalfQueue ? upperHalfQueue : lowerHalfQueue;
            while (biggerQueue.size() - smallerQueue.size() > 1) {
                smallerQueue.add(biggerQueue.poll());
            }
        }

    }


}
