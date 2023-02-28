package main.graph;

import main.graph.Vertex.Vertex;

import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class GraphUtility {
    public static BiFunction<Graph, Integer, Vertex> getVertexById =
            (graph, id) -> (Vertex) graph.getVertices().stream().filter(v -> v.getId()==id);

    public static Vertex getVertexById(final Graph graph, final int id) {
        return graph.getVertices().stream().filter(v -> v.getId() == id).toList().get(0);
    }
}
