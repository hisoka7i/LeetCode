package Graph.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class a994 {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)return 0; //this means that the grid is empty

        int rows = grid.length;
        int cols = grid[0].length;

        //now we need to maintain queue to maintain location of all the rotten tomatoes
        Queue<int[]> rotten = new LinkedList<>();
        int count_fresh = 0; //this is total number of oranges fresh + rotten
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 2){
                    rotten.offer(new int[]{i,j}); //here we are adding data into, queue
                }
                if(grid[i][j] != 0){
                    count_fresh++;
                }
            }
        }

        //now if rotten + fresh are equal
        if(count_fresh == 0)return 0;

        int count_minutes = 0; //a variable to count the total number of minutes required
        int count = 0; //this is to maintain, counter of processed oranges
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        while(!rotten.isEmpty()){
            int size = rotten.size();
            count += size; // this current level rotten tomatoes
            for(int i=0; i<size; i++){ 
                int[] point = rotten.poll(); //remove the rotten tomato in previous minute
                for(int j=0;j<4;j++){
                    int x = point[0] + dx[j]; //neighbours row
                    int y = point[1] + dy[j]; //neighbors col
                    //now for current rotten tomato we need to move in all four directions
                    if(x<0 || y<0 || x>=rows || y>=rows || grid[x][y] == 2 || grid[x][y] == 0){
                        continue;
                    }

                    grid[x][y] = 2; //rotting the current tomato
                    rotten.offer(new int[]{x,y}); 
                }
            }

            if(rotten.isEmpty() == false)count_minutes++;
        }
        return count == count_fresh ? count_minutes : -1;
    }
}
