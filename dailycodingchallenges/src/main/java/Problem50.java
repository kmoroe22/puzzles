public class Problem50 {

    public static void main(String[] args) {
        Node node = new Node("*");
        Node left = new Node("+");
        Node right = new Node("+");
        node.setLeftChild(left);
        node.setRightChild(right);
        Node leftleft = new Node("3");
        Node leftright = new Node("2");
        left.setRightChild(leftright);
        left.setLeftChild(leftleft);
        Node rightleft = new Node("4");
        Node rightright = new Node("5");
        left.setRightChild(leftright);
        left.setLeftChild(leftleft);
        right.setRightChild(rightright);
        right.setLeftChild(rightleft);

        System.out.println(String.format("%f", node.evaluate()));

    }

    private static class Node {

        private String value;
        private Node leftChild;
        private Node rightChild;

        public Node(String value) {
            this.value = value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public boolean isLeaf() {
            return leftChild == null && rightChild == null;
        }

        private double evaluate() {
            if (isLeaf()) {
                return Integer.valueOf(value);
            } else {
                return applyOperation(leftChild.evaluate(), value.charAt(0), rightChild.evaluate());
            }
        }

        private double applyOperation(double left, char operation, double right) {
            switch (operation) {
                case '+':
                    return left + right;
                case '-':
                    return left - right;
                case '*':
                    return left * right;
                case '/':
                    return left / right;
                default:
                    throw new IllegalArgumentException(String.format("%f %s %f not legal mathematical operation", left, operation, right));
            }
        }


    }
}
