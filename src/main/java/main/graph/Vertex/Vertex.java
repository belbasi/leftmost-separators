package main.graph.Vertex;

import java.util.HashSet;
import java.util.Objects;

public class Vertex {
    private final int id;
    HashSet<Vertex> neighbors;

    public Vertex(int id) {
        this.id = id;
        neighbors = new HashSet<>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return id == vertex.id && Objects.equals(neighbors, vertex.neighbors);
    }

}
