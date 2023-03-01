package main.graph.Vertex;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Vertex {
    private final int id;
    private Set<Vertex> represents;
    HashSet<Vertex> neighbors;

    public Vertex(int id) {
        this.id = id;
        neighbors = new HashSet<>();
        represents = new HashSet<>();
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

    public int getWeight() {
        return represents.size();
    }

    public boolean isRepresentative() {
        return represents.size() > 0;
    }

}
