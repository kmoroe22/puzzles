public class Problem48 {

    public static void main(String[] args) {
        Tree node = new Tree(buildTree(new char[]{'a', 'b', 'd', 'e', 'c', 'f', 'g'}, 0, new char[]{'d', 'b', 'e', 'a', 'f', 'c', 'g'}, 0, 6).node);
        System.out.println(node);
    }

    private static NodeTuple buildTree(char[] preorder, int preOrderRootIndex, char[] inorder, int inOrderStart, int inOrderEnd) {
        Node node = new Node(preorder[preOrderRootIndex]);
        if (preorder[preOrderRootIndex] == inorder[inOrderStart] && inOrderStart == inOrderEnd) {
            return new NodeTuple(preOrderRootIndex + 1, node);
        }
        int rootIndex = inOrderStart + ((inOrderEnd - inOrderStart) / 2);
        NodeTuple left = buildTree(preorder, preOrderRootIndex + 1, inorder, inOrderStart, rootIndex - 1);
        NodeTuple right = buildTree(preorder, left.nextIndex, inorder, rootIndex + 1, inOrderEnd);

        node.setLeft(left.node);
        node.setRight(right.node);

        return new NodeTuple(right.nextIndex, node);
    }

    private static class NodeTuple {

        public NodeTuple(int nextIndex, Node node) {
            this.nextIndex = nextIndex;
            this.node = node;
        }

        int nextIndex;
        Node node;
    }

    private static class Node {

        private char value;
        private Node left;
        private Node right;

        public Node(char value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    private static class Tree {

        public Tree(Node root) {
            this.root = root;
        }

        private Node root;


        public String toString() {
            return "<" + toString(root) + ">";
        }

        public static String toString(Node r) {
            if (r == null)
                return "";
            else
                return toString(r.left) + " " + r.value + " " + toString(r.right);
        }
    }

}
