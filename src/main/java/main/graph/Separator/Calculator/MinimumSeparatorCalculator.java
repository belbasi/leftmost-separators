package main.graph.Separator.Calculator;

import main.graph.Graph;
import main.graph.Vertex.Vertex;

import java.util.*;

public class MinimumSeparatorCalculator {
    Set<Vertex> open;
    Set<Vertex> closed;

    public SeparatorSnapshot calculate(final SeparationInputSnapshot inputSnapshot) {
        return null; //TODO
    }

    public void disjointPathFinder(final SeparationInputSnapshot inputSnapshot) {
        final Graph graph = inputSnapshot.graph();
        final Set<Vertex> vertices = graph.getVertices();
        final Set<Vertex> xSub = inputSnapshot.xSub();
        final Set<Vertex> ySub = inputSnapshot.ySub();
        final int k = inputSnapshot.k();

        Set<Vertex> unVisited = new HashSet<>(vertices);
        Vertex current;




    }
}
