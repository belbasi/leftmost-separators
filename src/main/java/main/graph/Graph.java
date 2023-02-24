package main.graph;

import main.graph.Edge.Edge;
import main.graph.Vertex.Vertex;

import java.util.HashSet;
import java.util.List;

public abstract class Graph {
    List<Vertex> vertices;
    List<Edge> edges;
    List<HashSet> adjacencyMatrix;
}
