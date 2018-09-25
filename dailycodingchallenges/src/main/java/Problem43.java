import java.util.PriorityQueue;
import java.util.Stack;

public class Problem43 {

    private static class MaxStack {
        Stack<Integer> stack = new Stack<>();

        PriorityQueue<Integer> max = new PriorityQueue<>();

        public int pop() {
            Integer pop = stack.pop();
            if (pop.equals(max.peek())) {
                max.poll();
            }
            return pop;
        }

        public void push(Integer value) {
            stack.push(value);
            if (max.peek() == null || max.peek() <= value) {
                max.poll();
                max.add(value);
            }
        }

        private Integer max() {
            return max.peek();
        }


    }
}
