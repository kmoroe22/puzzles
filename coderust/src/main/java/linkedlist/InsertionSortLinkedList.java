package linkedlist;

public class InsertionSortLinkedList {

    public static void main(String[] args) {
        LinkedListNode.printList(sort(LinkedListNode.buildList(new int[]{0, 1, 3, 4, 5, 9})));
    }

    private static LinkedListNode sort(LinkedListNode head) {
        LinkedListNode unsorted = head;
        LinkedListNode sorted = null;

        while (unsorted != null) {
            LinkedListNode currentNode = unsorted;
            unsorted = currentNode.next;
            currentNode.next = null;
            sorted = insertNode(currentNode, sorted);
        }
        return sorted;
    }

    private static LinkedListNode insertNode(LinkedListNode currentNode, LinkedListNode sorted) {
        if (sorted == null) {
            return currentNode;
        }
        LinkedListNode previous = null;
        LinkedListNode insertionLocation = sorted;

        while (insertionLocation != null && insertionLocation.data < currentNode.data) {
            previous = insertionLocation;
            insertionLocation = insertionLocation.next;
        }
        previous.next = currentNode;
        currentNode.next = insertionLocation;
        return sorted;
    }

}
