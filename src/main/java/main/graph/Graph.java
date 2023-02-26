package main.graph;

import com.google.common.collect.ImmutableSet;
import main.graph.Edge.Edge;
import main.graph.Vertex.Vertex;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
    List<Vertex> vertices;
    List<Edge> edges;
    Map<Vertex, ImmutableSet<Vertex>> adjacencyMatrix;

    public Graph() {
    }

    public Graph(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public Graph(List<Vertex> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
        produceAdjacencyMatrix();
    }

    public Graph(Map<Vertex, ImmutableSet<Vertex>> adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    void produceAdjacencyMatrix() {

    }

    void addVertex(Vertex u) {

    }
    void addEdge(Vertex head, Vertex tail) {
        
    }


}
