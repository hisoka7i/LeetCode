package Graph.Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public void levelTraversal(int V, ArrayList<ArrayList<Integer>> adj){
        //We will need a data structure to save the answers
        ArrayList<Integer> answer = new ArrayList<>();
        Boolean[] visited = new Boolean[V];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0); //we are taking starting point as 0
        visited[0] = true;

        while (queue.isEmpty() == false) {
            Integer currentlevel = queue.poll();

            //adding the data into the answer
            answer.add(currentlevel);

            for(Integer it: adj.get(currentlevel)){
                queue.offer(it);
                if(visited[it] == false){
                    visited[it] = true;
                    queue.add(it);
                }
            }
        }
    }
}
