package main.graph;

import main.graph.Vertex.Vertex;

import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class GraphUtility {

    public static BiFunction<Graph, Integer, Vertex> getVertexById =
            (graph, id) -> graph.getVertices().stream()
                    .filter(vertex -> vertex.getId() == id)
                    .findAny()
                    .orElse(null);
}
