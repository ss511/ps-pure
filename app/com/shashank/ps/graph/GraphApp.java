package com.shashank.ps.graph;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * Graph Implementation with A Map of Vertex as key and List of Vertex as value(edges).
 */
public class GraphApp {

    public static void main(String[] args) {
        GraphApp graphApp = new GraphApp();
        String s1 = "Jack";
        String s2 = "John";
        String s3 = "Jill";
        String s4 = "Jane";
        String s5 = "Bill";
        String s6 = "Mac";
        String s7 = "Sam";
        Map<Vertex, List<Vertex>> graph = new HashMap<>();
        graphApp.addVertex(graph, s1);
        graphApp.addVertex(graph, s2);
        graphApp.addVertex(graph, s3);
        graphApp.addVertex(graph, s4);
        graphApp.addVertex(graph, s5);
        graphApp.addVertex(graph, s6);
        graphApp.addVertex(graph, s7);

        graphApp.addEdge(graph, s1, s2);
        graphApp.addEdge(graph, s1, s3);
        graphApp.addEdge(graph, s1, s4);
        graphApp.addEdge(graph, s1, s6);
        graphApp.addEdge(graph, s2, s7);
        graphApp.addEdge(graph, s2, s5);
        graphApp.addEdge(graph, s3, s7);
        graphApp.addEdge(graph, s3, s5);
        graphApp.addEdge(graph, s4, s6);
        graphApp.addEdge(graph, s4, s5);
        graphApp.addEdge(graph, s5, s7);

        Vertex root = new Vertex(s1);

        Set<Vertex> bfsSet = graphApp.graphBFS(graph, root);
        Set<Vertex> dfsSet = graphApp.graphDFS(graph, root);

        System.out.println("BFS Traversal");
        graphApp.displayTraversal(bfsSet);
        System.out.println("DFS Traversal");
        graphApp.displayTraversal(dfsSet);

        graphApp.removeEdge(graph, s1, s6);
        graphApp.removeVertex(graph, s7);

        bfsSet = graphApp.graphBFS(graph, root);
        dfsSet = graphApp.graphDFS(graph, root);

        System.out.println("BFS Traversal After Edge and Vertex Removal");
        graphApp.displayTraversal(bfsSet);
        System.out.println("DFS Traversal After Edge and Vertex Removal");
        graphApp.displayTraversal(dfsSet);

    }

    public void addVertex(Map<Vertex, List<Vertex>> graph, String label) {
        graph.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(Map<Vertex, List<Vertex>> graph, String label) {
        Vertex v = new Vertex(label);
        graph.values().forEach(e -> e.remove(v));
        graph.remove(v);
    }

    public void addEdge(Map<Vertex, List<Vertex>> graph, String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        if(!graph.containsKey(v1)) {
            addVertex(graph, label1);
        }
        graph.get(v1).add(v2);
        if(!graph.containsKey(v2)) {
            addVertex(graph, label2);
        }
        graph.get(v2).add(v1);
    }

    public void removeEdge(Map<Vertex, List<Vertex>> graph, String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        List<Vertex> edge1 = graph.get(v1);
        List<Vertex> edge2 = graph.get(v2);

        if (edge1 != null) {
            edge1.remove(v2);
        }if (edge2 != null) {
            edge2.remove(v1);
        }

    }

    public void displayTraversal(Set<Vertex> set) {
        for(Vertex vertex: set) {
            System.out.print(vertex.getVertexData() + "\t");
        }
        System.out.println();
    }

    public Set<Vertex> graphBFS(Map<Vertex, List<Vertex>> graph, Vertex root) {
        Queue<Vertex> bfsQueue = new LinkedList<>();
        Set<Vertex> visited = new LinkedHashSet<>();
        bfsQueue.add(root);
        while (!bfsQueue.isEmpty()) {
            Vertex node = bfsQueue.poll();
            if (!visited.contains(node)) {
                visited.add(node);
                bfsQueue.addAll(graph.get(node));
            }
        }
        return visited;
    }

    public Set<Vertex> graphDFS(Map<Vertex, List<Vertex>> graph, Vertex root) {
        Stack<Vertex> dfsStack = new Stack<>();
        Set<Vertex> visited = new LinkedHashSet<>();
        dfsStack.add(root);
        while (!dfsStack.isEmpty()) {
            Vertex node = dfsStack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                dfsStack.addAll(graph.get(node));
            }
        }
        return visited;
    }
}

@Getter
@Setter
@AllArgsConstructor
class Vertex {
    private String vertexData;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Vertex)) {
            return false;
        }
        Vertex v = (Vertex) o;
        return this.vertexData.equalsIgnoreCase(v.vertexData);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        return prime + Objects.hashCode(this.vertexData);
    }
}
