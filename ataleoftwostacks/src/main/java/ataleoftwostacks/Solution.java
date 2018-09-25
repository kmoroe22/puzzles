package ataleoftwostacks;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public T peek() {
            if (stackOldestOnTop.empty()) {
                flipStacks();
            }
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            if (stackOldestOnTop.empty()) {
                flipStacks();
            }
            return stackOldestOnTop.pop();
        }

        private void flipStacks() {
            while (!stackNewestOnTop.empty()) {
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
        PriorityQueue priorityQueue = new PriorityQueue();

        for (int i = 0; i < 10; i++) {
            int value = new Random().nextInt();
            System.out.println(Integer.toString(value));
            queue.enqueue(value);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(Integer.toString(queue.dequeue()));
        }
//        scan.close();
    }
}
