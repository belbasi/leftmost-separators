package main;

import main.graph.Edge.Edge;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class IOUtility {

    public static short readFromFile(String path) {
        final JSONParser jsonParser = new JSONParser();
        try {
            final JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(path));
            final int numOfVertices = (int) jsonObject.get("numberOfVertices");
            final Optional<JSONArray> edges = (Optional<JSONArray>) jsonObject.get("edges");
            final Optional<JSONObject> adjacencyMatrix = (Optional<JSONObject>) jsonObject.get("adjacencyMatrix");
            if (edges.isPresent()) {
                Set<Edge> graphEdges = new HashSet<>();
                edges.get().forEach(edge -> {
                    System.out.println(edge);
                });
            }
            if (adjacencyMatrix.isPresent()) {

            }
            throw new RuntimeException("Neither edges nor adjacency matrix was given as input!");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
