package Graph.Medium;

import java.util.ArrayList;
import java.util.List;

public class a547 {
    public int findCircleNum(int[][] isConnected) {
    List<List<Integer>> adjacency = new ArrayList<>();

    // Create adjacency list
    for (int i = 0; i < isConnected.length; i++) {
        adjacency.add(new ArrayList<>());
    }

    // Fill adjacency list from the matrix
    for (int i = 0; i < isConnected.length; i++) {
        for (int j = 0; j < isConnected[i].length; j++) {
            if (isConnected[i][j] == 1 && i != j) {
                adjacency.get(i).add(j);
            }
        }
    }

    // Visited array to track nodes
    boolean[] visited = new boolean[isConnected.length];
    int count = 0;

    // Traverse each node
    for (int i = 0; i < isConnected.length; i++) {
        if (!visited[i]) { // If not visited
            count++;
            dfs(i, adjacency, visited); // Explore all connected nodes
        }
    }
    return count;
}

private void dfs(int i, List<List<Integer>> adjacency, boolean[] visited) {
    visited[i] = true; // Mark current node as visited
    for (Integer neighbor : adjacency.get(i)) {
        if (!visited[neighbor]) {
            dfs(neighbor, adjacency, visited); // Recursively visit neighbors
        }
    }
}
}
