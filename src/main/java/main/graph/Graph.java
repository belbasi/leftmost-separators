package main.graph;

import java.util.HashSet;
import java.util.List;

public abstract class Graph {
    List<Vertex> vertices;
    List<Edge> edges;
    List<HashSet> adjacencyMatrix;
}
