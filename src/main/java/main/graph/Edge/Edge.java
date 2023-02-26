package main.graph.Edge;

import main.graph.Vertex.Vertex;

public class Edge {
    private final Vertex firstVertex;
    private final Vertex secondVertex;

    public Edge(Vertex firstVertex, Vertex secondVertex) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
    }

    public Vertex getFirstVertex() {
        return firstVertex;
    }

    public Vertex getSecondVertex() {
        return secondVertex;
    }
}
