package main.graph.Edge;

import main.graph.Vertex.Vertex;
import org.parboiled.common.Preconditions;

import java.util.Objects;

public class Edge {
    private final Vertex firstVertex;
    private final Vertex secondVertex;

    public Edge(Vertex firstVertex, Vertex secondVertex) {
        Preconditions.checkArgument(firstVertex.getId() < secondVertex.getId(),
                "The id of first vertex (=%s) should be smaller than the id of second vertex (=%s)!",
                firstVertex.getId(),
                secondVertex.getId());
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
        firstVertex.getNeighbors().add(secondVertex);
        secondVertex.getNeighbors().add(firstVertex);
    }

    public Vertex getFirstVertex() {
        return firstVertex;
    }

    public Vertex getSecondVertex() {
        return secondVertex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return firstVertex.equals(edge.firstVertex) && secondVertex.equals(edge.secondVertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstVertex, secondVertex);
    }
}
