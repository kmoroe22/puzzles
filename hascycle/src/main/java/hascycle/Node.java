package hascycle;

public class Node {
        public Node(int data) {
            this.data = data;
        }

        int data;

        public void setNext(Node next) {
            this.next = next;
        }

        Node next;
    }