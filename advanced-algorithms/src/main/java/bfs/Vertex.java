package bfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private int data;
    private boolean visited;
    private List<Vertex> neighbours;


    public Vertex(int data) {
        this.data = data;
        neighbours = new ArrayList<Vertex>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
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

    public void addNeigbour(Vertex neigbour) {
        this.neighbours.add(neigbour);
    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }
}
