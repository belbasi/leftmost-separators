package main.graph.Vertex;

import java.util.HashSet;

public class Vertex {
    private final String id;
    HashSet<Vertex> neighbors;

    protected Vertex(String id) {
        this.id = id;
    }

    public void connectTo(Vertex v) {
        // TODO
    }
}
