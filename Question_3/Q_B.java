package Question_3;

import java.util.*;

// Class to represent an edge in the graph
class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    // Compare edges based on weight
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

// Class to represent a subset for union-find
class Subset {
    int parent;
    int rank;

    public Subset(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }
}

public class Q_B {
    private int V; // Number of vertices
    private List<Edge> edges; // List of edges in the graph

    public Q_B(int V) {
        this.V = V;
        edges = new ArrayList<>();
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }

    // Find set of an element i (uses path compression technique)
    private int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    // Union of two sets of x and y (uses union by rank)
    private void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // Kruskal's algorithm to find Minimum Spanning Tree
    public List<Edge> kruskalMST() {
        List<Edge> mst = new ArrayList<>();
        
        // Sort the edges in non-decreasing order of their weight
        Collections.sort(edges);
        
        Subset[] subsets = new Subset[V];
        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset(i, 0);
        }
        
        int edgeCount = 0;
        int edgeIndex = 0;
        
        // Keep adding edges until MST is formed or all edges are processed
        while (edgeCount < V - 1 && edgeIndex < edges.size()) {
            Edge nextEdge = edges.get(edgeIndex++);
            int x = find(subsets, nextEdge.source);
            int y = find(subsets, nextEdge.destination);
            
            // If including this edge doesn't cause cycle, include it in MST
            if (x != y) {
                mst.add(nextEdge);
                union(subsets, x, y);
                edgeCount++;
            }
        }
        
        return mst;
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        Q_B graph = new Q_B(V);
        
        // Adding edges to the graph (source, destination, weight)
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);
        
        // Finding Minimum Spanning Tree
        List<Edge> mst = graph.kruskalMST();
        
        // Printing the Minimum Spanning Tree
        System.out.println("Edges in Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.destination + " : " + edge.weight);
        }
    }
}

