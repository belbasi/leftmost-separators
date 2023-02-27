package main.graph;

import com.google.common.collect.ImmutableSet;
import main.graph.Edge.Edge;
import main.graph.Vertex.Vertex;
import org.parboiled.common.Preconditions;

import java.util.*;

import static jdk.internal.org.jline.utils.Log.warn;

public class Graph {
    private Set<Vertex> vertices;
    private Set<Edge> edges;
    private Map<Vertex, Set<Vertex>> adjacencyMatrix;

    public Graph() {
    }

    public Graph(Set<Vertex> vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new HashMap<>();
        warn("No edges are added and adjacency matrix is empty! Are you sure?");
    }

    public Graph(Set<Vertex> vertices, Set<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
        produceAdjacencyMatrix();
    }

    public Graph(Map<Vertex, Set<Vertex>> adjacencyMatrix) {
        vertices = new HashSet<>();
        edges = new HashSet<>();
        this.adjacencyMatrix = adjacencyMatrix;
        adjacencyMatrix.forEach((vertex, neighbors) -> {
            vertices.add(vertex);
            neighbors.stream().forEach(vertex1 -> {
                vertices.add(vertex1);
                Preconditions.checkArgument(vertex.getId() != vertex1.getId(),
                        "No self loop is allowed!"); // Allow no self-loop
                // Add edges so that the head has lower id than the tail (symmetric since the graph is undirected.)
                edges.add(vertex.getId() < vertex1.getId() ? new Edge(vertex, vertex1) : new Edge(vertex1, vertex));
            });
        });
    }

    void produceAdjacencyMatrix() {
        adjacencyMatrix = new HashMap<>();
        edges.forEach(edge -> {
            final Vertex firstEndPt = edge.getFirstVertex();
            final Vertex secondEndPt = edge.getSecondVertex();
            addNeighborsToAdjacencyMatrixRowSymmetrically(firstEndPt, secondEndPt);
        });
    }

    private void addNeighborToAdjacencyMatrixRow(final Vertex firstKey, final Vertex secondPartOfValue) {
        final Set<Vertex> currentNeighborFirst = adjacencyMatrix.containsKey(firstKey) ?
                adjacencyMatrix.get(firstKey) : new HashSet<>();
        currentNeighborFirst.add(secondPartOfValue);
        adjacencyMatrix.put(firstKey, currentNeighborFirst);
    }

    private void addNeighborsToAdjacencyMatrixRowSymmetrically(final Vertex firstV, final Vertex secondV) {
        addNeighborToAdjacencyMatrixRow(firstV, secondV);
        addNeighborToAdjacencyMatrixRow(secondV, firstV);
    }
    void addVertex(Vertex u) {

    }
    void addEdge(Vertex head, Vertex tail) {

    }

    public Set<Vertex> getVertices() {
        return vertices;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public Map<Vertex, Set<Vertex>> getAdjacencyMatrix() {
        return adjacencyMatrix;
    }
}
