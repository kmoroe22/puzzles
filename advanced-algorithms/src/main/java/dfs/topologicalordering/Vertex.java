package dfs.topologicalordering;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String data;
    private boolean visited;
    private List<Vertex> neighbours;

    public Vertex(String data) {
        this.data = data;
        neighbours = new ArrayList<Vertex>();
    }

    public void addNeighbour(Vertex vertex) {
        neighbours.add(vertex);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Vertex> neighbours) {
        this.neighbours = neighbours;
    }

    @Override
    public String toString() {
        return data;
    }
}

