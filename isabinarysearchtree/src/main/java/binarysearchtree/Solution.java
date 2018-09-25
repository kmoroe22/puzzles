package binarysearchtree;

import java.util.LinkedList;

public class Solution {


    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node nodeRoot = new Node(4);
        Node leftToRoot = new Node(2);
        Node rightToRoot = new Node(6);
        Node leftToLeftOfRoot = new Node(1);
        Node rightToLeftOfRoot = new Node(3);
        Node leftToRightOfRoot = new Node(5);
        Node rightToRightOfRoot = new Node(7);

        nodeRoot.left = leftToRoot;
        nodeRoot.right = rightToRoot;

        leftToRoot.left = leftToLeftOfRoot;
        leftToRoot.right =rightToLeftOfRoot;

        rightToRoot.left = leftToRightOfRoot;
        rightToRoot.right = rightToRightOfRoot;

        inOrderTraversal(nodeRoot);
        System.out.println(checkBST(nodeRoot));
    }


    //

    public static boolean checkBST(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        return doBST(root, list);
    }


    public static boolean doBST(Node root, LinkedList<Integer> visited) {
        if (root.left != null) {
            if (!doBST(root.left, visited)) {
                return false;
            }
        }

        if (!visited.isEmpty() && root.data <= visited.getLast()) {
            return false;
        }
        visited.add(root.data);

        if (root.right != null) {
            if (!doBST(root.right, visited)) {
                return false;
            }
        }
        return true;

    }

    //
    static void inOrderTraversal(Node node) {
        if (node.left != null) {
            inOrderTraversal(node.left);
        }

        System.out.println(node.data);

        if (node.right != null) {
            inOrderTraversal(node.right);
        }
    }
}
