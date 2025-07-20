package Dynamic Programming;

import java.util.*;
public class BellmanFordAlgo {
    public int[] shortestPath(int n, int[][] edges, int src){
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e8);

        dist[src] = 0; //we are setting source as zero 

        for(int i = 0; i < n; i ++){
            //we will be doing relaxation n - 1 times
            for(int[] edge: edges){
                int start = edge[0];
                int end = edge[1];
                int weight = edge[2];

                if(dist[start] != (int)1e8 && dist[start] + weight < dist[end]){
                    if( i == n-1){
                        return  new int[]{-1};
                    }

                    dist[end] = dist[start]  + weight;
                }
            }
        }
        return dist;
    }
}
