package main.graph.Separator.Calculator;

import main.graph.Graph;
import main.graph.Vertex.Vertex;
import org.parboiled.common.Preconditions;

import java.util.Set;

import static main.graph.GraphUtility.subsetContainment;

public record SeparationInputSnapshot(Graph graph,
                                      Set<Vertex> xSub,
                                      Set<Vertex> ySub,
                                      int k) {
    public SeparationInputSnapshot(Graph graph, Set<Vertex> xSub, Set<Vertex> ySub, int k) {
        final Set<Vertex> graphVertices = graph.getVertices();
        Preconditions.checkArgument(subsetContainment.test(graphVertices, xSub),
                "X should be subset of V");
        Preconditions.checkArgument(subsetContainment.test(graphVertices, ySub),
                "Y should be subset of V");
        this.graph = graph;
        this.xSub = xSub;
        this.ySub = ySub;
        this.k = k;
    }
}
