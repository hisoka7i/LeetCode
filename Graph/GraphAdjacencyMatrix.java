package Graph;

import java.util.Scanner;

public class GraphAdjacencyMatrix {
    private int[][] adjMatrix; // Adjacency matrix
    private int vertices;      // Number of vertices

    // Constructor
    public GraphAdjacencyMatrix(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    // Add an edge (Directed)
    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
    }

    // Add an edge (Undirected)
    public void addEdgeUndirected(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;
    }

    // Remove an edge (Directed)
    public void removeEdge(int src, int dest) {
        adjMatrix[src][dest] = 0;
    }

    // Remove an edge (Undirected)
    public void removeEdgeUndirected(int src, int dest) {
        adjMatrix[src][dest] = 0;
        adjMatrix[dest][src] = 0;
    }

    // Print the adjacency matrix
    public void printMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(vertices);

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        System.out.println("Enter edges (format: src dest):");
        for (int i = 0; i < edges; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            graph.addEdgeUndirected(src, dest); // Use addEdge for directed graphs
        }

        graph.printMatrix();

        sc.close();
    }
}

