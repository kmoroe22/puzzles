package dfs.topologicalordering;

import java.util.Stack;

public class TopologocaOrdering {

    private Stack<Vertex> stack;


    public TopologocaOrdering() {
        stack = new Stack<Vertex>();
    }

    public void dfs(Vertex root) {
        root.setVisited(true);

        for (Vertex v: root.getNeighbours()) {
            if (!v.isVisited()) {
                dfs(v);
            }
        }
        stack.push(root);
    }

    public Stack<Vertex> getStack() {
        return stack;
    }
}
