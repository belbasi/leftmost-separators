package FactoryTest;

import main.graph.Graph;
import main.graph.Vertex.Vertex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static main.graph.GraphUtility.getVertexById;

public class GraphUtilityTest {

    @Test
    public void testGetVertexById() {
        final Graph lineGraph = GraphSnapshot.lineGraph();

        Vertex vertex0 = new Vertex(0);
        Vertex vertex1 = new Vertex(1);
        vertex1.getNeighbors().add(vertex0);
        vertex0.getNeighbors().add(vertex1);

        final Vertex returnedVertex = getVertexById(lineGraph, 0);
        Assertions.assertEquals(returnedVertex.getId(), vertex0.getId());
        Assertions.assertEquals(returnedVertex.getNeighbors().size(), vertex0.getNeighbors().size());

    }
}
