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

        Assertions.assertEquals(getVertexById.apply(lineGraph, 0), new Vertex(0));

    }
}
