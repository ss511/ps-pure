package com.shashank.ps.graph;

import lombok.*;

import java.util.*;

public class WeightedGraphApp {

    public static void main (String[] args) {

        WeightedGraphApp graphApp = new WeightedGraphApp();
        String s1 = "Jack";
        String s2 = "John";
        String s3 = "Jill";
        String s4 = "Jane";
        String s5 = "Bill";
        String s6 = "Mac";
        String s7 = "Sam";
        Map<VertexNode, Set<Edge>> graph = new HashMap<>();
        graphApp.addVertex(graph, s1);
        graphApp.addVertex(graph, s2);
        graphApp.addVertex(graph, s3);
        graphApp.addVertex(graph, s4);
        graphApp.addVertex(graph, s5);
        graphApp.addVertex(graph, s6);
        graphApp.addVertex(graph, s7);

        graphApp.addEdge(graph, s1, s2, 10);
        graphApp.addEdge(graph, s1, s3, 12);
        graphApp.addEdge(graph, s1, s4, 15);
        graphApp.addEdge(graph, s1, s6, 17);
        graphApp.addEdge(graph, s2, s7, 5);
        graphApp.addEdge(graph, s2, s5, 6);
        graphApp.addEdge(graph, s3, s7, 6);
        graphApp.addEdge(graph, s3, s5, 12);
        graphApp.addEdge(graph, s4, s6, 9);
        graphApp.addEdge(graph, s4, s5, 10);
        graphApp.addEdge(graph, s5, s7,11);

        VertexNode root = new VertexNode(s1);

        Set<VertexNode> bfsSet = graphApp.graphBFS(graph, root);
        Set<VertexNode> dfsSet = graphApp.graphDFS(graph, root);

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

        System.out.println("\n Weight between s1 and s2: " + graphApp.getWeight(graph, s1, s2));
        System.out.println("\n Weight between s1 and s7: " + graphApp.getWeight(graph, s1, s7));

    }

    public void addVertex(Map<VertexNode, Set<Edge>> graph, String label) {
        graph.putIfAbsent(new VertexNode(label), new HashSet<>());
    }

    public void removeVertex(Map<VertexNode, Set<Edge>> graph, String label) {
        VertexNode vertexNode = new VertexNode(label);
        Edge edge = new Edge(vertexNode);
        graph.values().forEach(e -> e.remove(edge));
        graph.remove(vertexNode);
    }

    public void addEdge(Map<VertexNode, Set<Edge>> graph, String label1, String label2, int weight) {
        VertexNode vn1 = new VertexNode(label1);
        VertexNode vn2 = new VertexNode(label2);

        if(!graph.containsKey(vn1)) {
            addVertex(graph, label1);
        }
        if(!graph.containsKey(vn2)) {
            addVertex(graph, label2);
        }

        graph.get(vn1).add(new Edge(vn2, weight));
        graph.get(vn2).add(new Edge(vn1, weight));

    }

    public void removeEdge(Map<VertexNode, Set<Edge>> graph, String label1, String label2) {
        VertexNode vn1 = new VertexNode(label1);
        VertexNode vn2 = new VertexNode(label2);

        Edge edge1 = new Edge(vn1);
        Edge edge2 = new Edge(vn2);

        graph.get(vn1).remove(edge2);
        graph.get(vn2).remove(edge1);

    }

    public void displayTraversal(Set<VertexNode> set) {
        for(VertexNode vertex: set) {
            System.out.print(vertex.getLabel() + "\t");
        }
        System.out.println();
    }

    public int getWeight(Map<VertexNode, Set<Edge>> graph, String label1, String label2) {

        VertexNode vertexNode1 = new VertexNode(label1);
        VertexNode vertexNode2 = new VertexNode(label2);

        List<Edge> edges = new LinkedList<>(graph.get(vertexNode1));
        for (Edge edge : edges) {
            if (vertexNode2.equals(edge.getDestination())) {
                return edge.getWeight();
            }
        }
        return -1;
    }

    public Set<VertexNode> graphBFS(Map<VertexNode, Set<Edge>> graph, VertexNode root) {
        Queue<VertexNode> bfsQueue = new LinkedList<>();
        Set<VertexNode> visited = new LinkedHashSet<>();
        bfsQueue.add(root);
        while (!bfsQueue.isEmpty()) {
            VertexNode node = bfsQueue.poll();
            if (!visited.contains(node)) {
                visited.add(node);
                List<Edge> tempEdges = new LinkedList<>(graph.get(node));
                for (Edge edge: tempEdges) {
                    bfsQueue.add(edge.getDestination());
                }
            }
        }
        return visited;
    }

    public Set<VertexNode> graphDFS(Map<VertexNode, Set<Edge>> graph, VertexNode root) {
        Stack<VertexNode> dfsStack = new Stack<>();
        Set<VertexNode> visited = new LinkedHashSet<>();
        dfsStack.add(root);
        while (!dfsStack.isEmpty()) {
            VertexNode node = dfsStack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                List<Edge> tempEdges = new LinkedList<>(graph.get(node));
                for (Edge edge: tempEdges) {
                    dfsStack.add(edge.getDestination());
                }
            }
        }
        return visited;
    }

}


@Getter
@AllArgsConstructor
class VertexNode {

    private final String label;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof VertexNode)) {
            return false;
        }
        VertexNode v = (VertexNode) o;
        return this.label.equalsIgnoreCase(v.getLabel());
    }

    @Override
    public int hashCode() {
        int prime = 31;
        return prime + Objects.hashCode(this.getLabel());
    }
}

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
class Edge {

    @NonNull
    private VertexNode destination;
    private int weight;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Edge)) {
            return false;
        }
        Edge g = (Edge) o;
        return this.destination.getLabel().equalsIgnoreCase(g.getDestination().getLabel());
    }

    @Override
    public int hashCode() {
        int prime = 31;
        return prime + Objects.hashCode(this.getDestination().getLabel());
    }
}
