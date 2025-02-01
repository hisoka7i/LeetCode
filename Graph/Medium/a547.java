package Graph.Medium;

import java.util.ArrayList;
import java.util.List;

public class a547 {
<<<<<<< HEAD

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjancency = new ArrayList<>();

        //we are converting matrix into a list
        for (int i = 0; i < isConnected.length; i++) {
            adjancency.add(new ArrayList<>());
        }

        //now we are adding the data into the lsit
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    //now we will add data into the adjancency list
                    adjancency.get(i).add(j);
                    adjancency.get(j).add(i);
                }
            }
        }

        //now that we have the adjacency list ready with us,
        boolean[] visited = new boolean[isConnected.length * 2];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[0] == false) {
                count++;
                dfs(i, adjancency, visited);
            }
        }
        return count;
    }

    private void dfs(int i, List<List<Integer>> adjancency, boolean[] visited) {
        // TODO Auto-generated method stub
        visited[i] = true;

        for(Integer current: adjancency.get(i)){
            if(visited[current] == false)
            dfs(current, adjancency, visited);
        }
    }
}
=======
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
>>>>>>> b8d717a0d3f9b797b54fef63106a46e2fae3ec50
