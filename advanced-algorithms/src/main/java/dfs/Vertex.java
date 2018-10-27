package dfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private boolean visited;
    private List<Vertex> neighbours;

    public Vertex(String name) {
        this.name = name;
        neighbours = new ArrayList<Vertex>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void addNeighbours(Vertex neighbour) {
        this.neighbours.add(neighbour);
    }

    @Override
    public String toString() {
        return name;
    }
}
