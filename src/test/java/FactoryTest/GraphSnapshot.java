package FactoryTest;

import main.graph.Edge.Edge;
import main.graph.Graph;
import main.graph.Vertex.Vertex;

import java.util.Set;

public class GraphSnapshot {

    public static Graph lineGraph() {
        final Vertex v0 = new Vertex(0);
        final Vertex v1 = new Vertex(1);
        final Edge edge = new Edge(v0, v1);
        return new Graph(Set.of(v0, v1), Set.of(edge));
    }
}
