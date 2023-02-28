package main;

import main.graph.Graph;
import main.graph.Vertex.Vertex;
import java.util.Set;

public class InputToLeftmostSeparators {
    private Graph graph;
    private Set<Vertex> xSub; // Bigger side (on left)
    private Set<Vertex> ySub; // Smaller side (on right)

    public InputToLeftmostSeparators(Graph graph, Set<Vertex> xSub, Set<Vertex> ySub) {
        this.graph = graph;
        this.xSub = xSub;
        this.ySub = ySub;
    }

    public Graph getGraph() {
        return graph;
    }

    public Set<Vertex> getxSub() {
        return xSub;
    }

    public Set<Vertex> getySub() {
        return ySub;
    }
}
