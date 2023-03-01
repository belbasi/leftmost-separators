package FactoryTest;

import main.graph.Graph;
import main.graph.Vertex.Vertex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static main.graph.GraphUtility.getVertexById;
import static main.graph.GraphUtility.subsetContainment;

public class GraphUtilityTest {

    @Test
    public void testGetVertexById() {
        final Graph lineGraph = GraphSnapshot.lineGraph();

        Vertex vertex0 = new Vertex(0);
        Vertex vertex1 = new Vertex(1);
        vertex1.getNeighbors().add(vertex0);
        vertex0.getNeighbors().add(vertex1);

        final Vertex returnedVertex = getVertexById.apply(lineGraph, 0);
        Assertions.assertEquals(returnedVertex.getId(), vertex0.getId());
        Assertions.assertEquals(returnedVertex.getNeighbors().size(), vertex0.getNeighbors().size());

    }

    @Test
    public void testSubsetContainment() {
        final Vertex v0 = new Vertex(0);
        final Vertex v1 = new Vertex(1);
        final Vertex v2 = new Vertex(2);
        final Vertex v3 = new Vertex(3);

        final Set<Vertex> superset = Set.of(v0, v1, v2);
        final Set<Vertex> subset = Set.of(v1, v2);
        final Set<Vertex> nonSubset = Set.of(v3);

        Assertions.assertTrue(subsetContainment.test(superset, subset));
        Assertions.assertFalse(subsetContainment.test(superset, nonSubset));
    }
}
