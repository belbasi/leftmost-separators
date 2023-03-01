package main.graph;

import main.graph.Vertex.Vertex;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class GraphUtility {

    public static BiFunction<Graph, Integer, Vertex> getVertexById =
            (graph, id) -> graph.getVertices().stream()
                    .filter(vertex -> vertex.getId() == id)
                    .findAny()
                    .orElse(null);

    public static BiPredicate<Set<Vertex>, Set<Vertex>> subsetContainment =
            (superset, subset) -> subset.stream()
                    .allMatch(superset::contains);

    public static BiPredicate<Set<Vertex>, Set<Vertex>> setDisjointment =
            (setA, setB) -> Collections.disjoint(setA, setB);

    public static Function<Set<Vertex>, Integer> sumWeights = s -> s.stream()
            .map(Vertex::getWeight)
            .mapToInt(Integer::intValue)
            .sum();

    public static BiPredicate<Set<Vertex>, Set<Vertex>> xIsHeavierThanY =
            (x, y) -> sumWeights.apply(x) > sumWeights.apply(y);

    public static Set<Vertex> unionOfVertexSets(Set<Vertex>... args) {
        Set<Vertex> union = new HashSet<>();
        for (Set<Vertex> set : args) {
            union.addAll(set);
        }
        return union;
    }

    public static boolean checkUnionCovers(Graph graph, Set<Vertex>... args) {
        final Set<Vertex> graphVertices = graph.getVertices();
        final Set<Vertex> union = unionOfVertexSets(args);
        return graphVertices.containsAll(union) && union.containsAll(graphVertices);
    }
}
