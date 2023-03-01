package main.graph;

import main.graph.Graph;
import main.graph.Vertex.Vertex;
import org.parboiled.common.Preconditions;

import java.util.Set;

import static main.graph.GraphUtility.*;

public record SeparatorSnapshot(Graph graph,
                                Set<Vertex> S,
                                Set<Vertex> xSub,
                                Set<Vertex> ySub,
                                Set<Vertex> vXs,
                                Set<Vertex> vSy,
                                Set<Vertex> vZ) {
    public SeparatorSnapshot(Graph graph,
                             Set<Vertex> S,
                             Set<Vertex> xSub,
                             Set<Vertex> ySub,
                             Set<Vertex> vXs,
                             Set<Vertex> vSy,
                             Set<Vertex> vZ) {
        final Set<Vertex> graphVertices = graph.getVertices();
        Preconditions.checkArgument(subsetContainment.test(graphVertices, S),
                "S should be subset of V");
        Preconditions.checkArgument(subsetContainment.test(graphVertices, xSub),
                "X should be subset of V");
        Preconditions.checkArgument(subsetContainment.test(graphVertices, ySub),
                "Y should be subset of V");
        Preconditions.checkArgument(subsetContainment.test(graphVertices, vXs),
                "V_xs should be subset of V");
        Preconditions.checkArgument(subsetContainment.test(graphVertices, vSy),
                "V_sy should be subset of V");
        Preconditions.checkArgument(subsetContainment.test(graphVertices, vZ),
                "V_z should be subset of V");
        Preconditions.checkArgument(setDisjointment.test(vXs, vSy),
                "V_xs and V_sy should be disjoint.");
        Preconditions.checkArgument(setDisjointment.test(vXs, vZ),
                "V_xs and V_z should be disjoint.");
        Preconditions.checkArgument(setDisjointment.test(vZ, vSy),
                "V_z and V_sy should be disjoint.");
        Preconditions.checkArgument(checkUnionCovers(graph, xSub, ySub, vXs, vSy, vZ),
                "Subsets X, Y, S, V_xs, V_sy, V_z don't cover V!");
        Preconditions.checkArgument(xIsHeavierThanY.test(xSub, ySub),
                "X (subset of the left) should be heavier than Y (subset on the right)");
        this.S = S;
        this.graph = graph;
        this.xSub = xSub;
        this.ySub = ySub;
        this.vXs = vXs;
        this.vSy = vSy;
        this.vZ = vZ;
    }
}
