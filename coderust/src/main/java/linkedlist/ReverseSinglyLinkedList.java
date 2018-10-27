package linkedlist;

import java.util.Stack;

public class ReverseSinglyLinkedList {

    public static void main(String[] args) {

        LinkedListNode node = new LinkedListNode(4);
        node.next = new LinkedListNode(3);
        node.next.next = new LinkedListNode(2);
        node.next.next.next = new LinkedListNode(1);
        LinkedListNode.printList(reverse_list(node));
    }

    public static LinkedListNode reverse_list_doublePass(
            LinkedListNode head) {
        LinkedListNode currentNode = head;
        Stack<LinkedListNode> tempStack = new Stack<>();
        while (currentNode != null) {
            tempStack.push(currentNode);
            currentNode = currentNode.next;
        }
        LinkedListNode reversed_list = tempStack.pop();
        currentNode = reversed_list;
        while (!tempStack.isEmpty()) {
            LinkedListNode nextNode = tempStack.pop();
            currentNode.next = nextNode;
            currentNode = nextNode;
        }
        currentNode.next = null;
        return reversed_list;
    }

    public static LinkedListNode reverse_list(
            LinkedListNode head) {
        if (head.next ==  null) {
            return head;
        }
        LinkedListNode reversed_list = head;
        LinkedListNode leftOverList = head.next;
        reversed_list.next = null;
        while (leftOverList != null) {
            LinkedListNode temp = leftOverList.next;
            leftOverList.next = reversed_list;
            reversed_list = leftOverList;
            leftOverList = temp;
        }
        return reversed_list;
    }

    public static LinkedListNode reverse_recursive(
            LinkedListNode head) {
        if (head == null ||
                head.next == null) {
            return head;
        }

        LinkedListNode reversed_list =
                reverse_recursive(head.next);

        head.next.next = head;
        head.next = null;
        return reversed_list;
    }
}
