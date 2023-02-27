package main.graph.Vertex;

import java.util.HashSet;

public class Vertex {
    private final int id;
    HashSet<Vertex> neighbors;

    public Vertex(int id) {
        this.id = id;
    }

    public void connectTo(Vertex v) {
        // TODO
    }

    public int getId() {
        return id;
    }

    public HashSet<Vertex> getNeighbors() {
        return neighbors;
    }
}
