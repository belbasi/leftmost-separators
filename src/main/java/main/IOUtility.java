package main;

import main.graph.Edge.Edge;
import main.graph.Graph;
import main.graph.GraphUtility;
import main.graph.Vertex.Vertex;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class IOUtility {

    public static InputToLeftmostSeparators readFromFile(String path) {
        final JSONParser jsonParser = new JSONParser();
        try {
            final JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(path));
            final long numOfVertices = (long) jsonObject.get("numberOfVertices");
            final JSONArray edges = (JSONArray) jsonObject.get("edges");
            //final JSONObject adjacencyMatrix = (JSONObject) jsonObject.get("adjacencyMatrix");
            Set<Edge> graphEdges = new HashSet<>();
            Set<Vertex> graphVertices = new HashSet<>();
            edges.forEach(edge -> {
                final String[] endPts = edge.toString().split(",");
                final Vertex firstVertex = new Vertex(Integer.parseInt(endPts[0]));
                final Vertex secondVertex = new Vertex(Integer.parseInt(endPts[1]));
                graphVertices.add(firstVertex);
                graphVertices.add(secondVertex);
                final Edge actualEdge = new Edge(firstVertex, secondVertex);
                graphEdges.add(actualEdge);
            });
            final Graph graph = new Graph(graphVertices, graphEdges);
            final JSONArray xLine = (JSONArray) jsonObject.get("X");
            final Set<Vertex> xSub = fetchVerticesFromJSONArray(xLine, graph);
            final JSONArray yLine = (JSONArray) jsonObject.get("Y");
            final Set<Vertex> ySub = fetchVerticesFromJSONArray(yLine, graph);
            return new InputToLeftmostSeparators(graph, xSub, ySub);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Set<Vertex> fetchVerticesFromJSONArray(final JSONArray array, final Graph graph) {
        return new HashSet<>(
                array.stream()
                        .map(Object::toString)
                        .map(s -> Integer.parseInt((String) s))
                        .map(id -> GraphUtility.getVertexById.apply(graph, (Integer) id))
                        .toList()
        );
    }
}
