package com.shashank.ps.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Dijkstra Algorithm Implementation, using graph based on adjacency list. Makes use of Maps and WeightedGraph object.
 */
public class DijkstraAlgorithmApp {

    public static void main (String[] args) {
        DijkstraAlgorithmApp dijkstraAlgorithmApp = new DijkstraAlgorithmApp();
        WeightedGraphApp graphApp = new WeightedGraphApp();
        String s1 = "Jack";
        String s2 = "John";
        String s3 = "Sam";
        String s4 = "Bill";
        String s5 = "Mac";

        Map<VertexNode, Set<Edge>> graph = new HashMap<>();
        graphApp.addVertex(graph, s1);
        graphApp.addVertex(graph, s2);
        graphApp.addVertex(graph, s3);
        graphApp.addVertex(graph, s4);
        graphApp.addVertex(graph, s5);

        graphApp.addEdge(graph, s1, s2, 1);
        graphApp.addEdge(graph, s1, s3, 10);
        graphApp.addEdge(graph, s2, s4, 4);
        graphApp.addEdge(graph, s3, s4, 12);
        graphApp.addEdge(graph, s3, s5, 5);
        graphApp.addEdge(graph, s4, s5, 3);

        VertexNode root = new VertexNode(s1);

        dijkstraAlgorithmApp.dijkstra(graph, root);
    }

    public void dijkstra (Map<VertexNode, Set<Edge>> graph, VertexNode root) {
        Map<VertexNode, Integer> distanceMap = new HashMap<>();
        Map<VertexNode, Boolean> visitedNode = new HashMap<>();

        int max = Integer.MAX_VALUE;

        for (Map.Entry<VertexNode, Set<Edge>> vertexEntry : graph.entrySet()) {
            VertexNode key = vertexEntry.getKey();
            if (key.equals(root)) {
                distanceMap.put(key, 0);
                visitedNode.put(key, true);
            } else {
                distanceMap.put(key, max);
                visitedNode.put(key, false);
            }
        }

        int graphSize = graph.size();

        for (int i = 0; i < graphSize; i++) {
            List<VertexNode> alreadyVisited = visitedNode.entrySet()
                    .stream()
                    .filter(Map.Entry::getValue)
                    .map(Map.Entry::getKey).collect(Collectors.toList());

            VertexNode nodeVisited = null;
            int minAll = Integer.MAX_VALUE;
            for (VertexNode visited: alreadyVisited) {
                List<Edge> edges = new ArrayList<>(graph.get(visited));
                for (Edge edge: edges) {
                    VertexNode temp = edge.getDestination();
                    if (!visitedNode.get(edge.getDestination())) {
                        if (distanceMap.get(temp) == Integer.MAX_VALUE || distanceMap.get(temp) >= (distanceMap.get(visited) + edge.getWeight())) {
                            distanceMap.replace(temp, distanceMap.get(visited) + edge.getWeight());
                        } else {
                            distanceMap.replace(temp, distanceMap.get(temp));
                        }
                        if (distanceMap.get(temp) < minAll) {
                            minAll = distanceMap.get(temp);
                            nodeVisited = temp;
                        }
                    }
                }
            }
            visitedNode.replace(nodeVisited, true);
        }
        for (Map.Entry<VertexNode, Integer> entry: distanceMap.entrySet()) {
            System.out.println("Vertex: " + entry.getKey().getLabel() + "\t\t Distance: " + entry.getValue());
        }
    }
}
