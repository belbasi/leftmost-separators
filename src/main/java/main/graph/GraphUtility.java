package main.graph;

import main.graph.Vertex.Vertex;

import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class GraphUtility {

    public static Vertex getVertexById(final Graph graph, final int id) {
        return graph.getVertices().stream()
                .filter(vertex -> vertex.getId() == id)
                .findAny()
                .orElse(null);
    }
}
