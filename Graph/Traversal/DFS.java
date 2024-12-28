package Graph.Traversal;

import java.util.ArrayList;

public class DFS {

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adjancancy) {
        //data structure for answer 
        ArrayList<Integer> output = new ArrayList<>();
        Boolean[] visited = new Boolean[V + 1];
        dfs(0, adjancancy, visited, output);
        return output;
    }

    private void dfs(int i, ArrayList<ArrayList<Integer>> adjancancy, Boolean[] visited, ArrayList<Integer> output) {
        // TODO Auto-generated method stub
        visited[i] = true;
        output.add(i);

        for(Integer current: adjancancy.get(i)){
            if(visited[current] == false)
                dfs(current, adjancancy, visited, output);
        }

    }

}
