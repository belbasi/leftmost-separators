package IOTest;

import main.InputToLeftmostSeparators;
import main.graph.Edge.Edge;
import main.graph.Graph;
import main.graph.Vertex.Vertex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static main.IOUtility.readFromFile;

public class IOUTilityTest {

    @Test
    public void testReadFromFileGivenEdges() {
        final String path = "C:\\Users\\mahdi\\OneDrive\\Documents\\GitHub\\leftmost-separators\\src\\main\\resources\\configuration\\example-graph-with-edges.json";
        final Vertex v0 = new Vertex(0);
        final Vertex v1 = new Vertex(1);
        final Vertex v2 = new Vertex(2);
        final Vertex v3 = new Vertex(3);
        final Vertex v4 = new Vertex(4);
        final Vertex v5 = new Vertex(5);

        final Edge edge01 = new Edge(v0, v1);
        final Edge edge02 = new Edge(v0, v2);
        final Edge edge05 = new Edge(v0, v5);
        final Edge edge13 = new Edge(v1, v3);
        final Edge edge14 = new Edge(v1, v4);
        final Edge edge25 = new Edge(v2, v5);
        final Edge edge45 = new Edge(v4, v5);

        final Graph graph = new Graph(Set.of(v0, v1, v2, v3, v4, v5),
                Set.of(edge01, edge02, edge05, edge13, edge14, edge25, edge45));

        final Set<Vertex> xSub = Set.of(v0, v1, v2);
        final Set<Vertex> ySub = Set.of(v4);

        final InputToLeftmostSeparators sut = readFromFile(path);
        sut.getGraph().printAdjacencyMatrix();
        Assertions.assertEquals(graph.getVertices().size(), sut.getGraph().getVertices().size());
    }

}
