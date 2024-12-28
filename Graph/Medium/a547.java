package Graph.Medium;

import java.util.ArrayList;
import java.util.List;

public class a547 {

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
            visited[current] = true;
        }
    }
}
