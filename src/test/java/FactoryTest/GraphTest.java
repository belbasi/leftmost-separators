package FactoryTest;

import com.google.common.collect.ImmutableSet;
import main.graph.Edge.Edge;
import main.graph.Graph;
import main.graph.Vertex.Vertex;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GraphTest {

    @Test
    public void testGraphGenerationByAdjacencyMatrix() {
        /*
         * The graph is supposed to look like this:
         *                   v0 ----- v1
         *                    \
         *                     \
         *                      v2
         */
        final Vertex v0 = new Vertex(0);
        final Vertex v1 = new Vertex(1);
        final Vertex v2 = new Vertex(2);

        final Map<Vertex, Set<Vertex>> adjacencyMatrix = Map.of(v0, Set.of(v1, v2),
                v1, Set.of(v0),
                v2, Set.of(v0));
        final Graph graph = new Graph(adjacencyMatrix);

        // Verify the vertex ids are correctly inserted.
        assertEquals(Set.of(0, 1, 2),
                new HashSet<>(graph.getVertices().stream().map(Vertex::getId).toList()));

        // Verify that edges are inserted correctly.
        assertEquals(Set.of(new Edge(v0, v1), new Edge(v0, v2)),
                new HashSet<>(graph.getEdges()));
    }

    @Test
    public void testProduceAdjacencyMatrix() {
        /*
         * The graph is supposed to look like this:
         *                   v0 ----- v1
         *                    \
         *                     \
         *                      v2 ---- v3
         */
        final Vertex v0 = new Vertex(0);
        final Vertex v1 = new Vertex(1);
        final Vertex v2 = new Vertex(2);
        final Vertex v3 = new Vertex(3);

        final Edge edge01 = new Edge(v0, v1);
        final Edge edge02 = new Edge(v0, v2);
        final Edge edge23 = new Edge(v2, v3);

        final Graph graph = new Graph(Set.of(v0, v1, v2, v3), Set.of(edge01, edge02, edge23));

        final Map<Vertex, Set<Vertex>> expectedAdjacencyMatrix = Map.of(
                v0, Set.of(v1, v2),
                v1, Set.of(v0),
                v2, Set.of(v0, v3),
                v3, Set.of(v2)
        );

        assertEquals(expectedAdjacencyMatrix, graph.getAdjacencyMatrix());

    }


}
