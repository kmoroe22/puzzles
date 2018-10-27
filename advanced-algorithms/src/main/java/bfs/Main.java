package bfs;

public class Main {

    public static void main(String[] args) {
        BFS bfs = new BFS();

        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);

        vertex1.addNeigbour(vertex2);
        vertex1.addNeigbour(vertex4);
        vertex4.addNeigbour(vertex5);
        vertex2.addNeigbour(vertex3);

        bfs.bfs(vertex1);

    }
}
