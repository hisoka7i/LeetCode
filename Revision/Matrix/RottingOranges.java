package Revision.Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        return  bruteForceSolution(grid);
    }

    //my brute force solution
    public int bruteForceSolution(int[][] grid){
        // I was going for the right solution but I did not spend enough time on it. 
        //should have spent enough time on it
        int time = 0;
        Queue<int[]> rottenPositions = new LinkedList<>();
        int countFresh = 0;
        int countRotten = 0;
        //sabse pehle saare rotten daal do apni queue mai
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    rottenPositions.add(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    countFresh++;
                }
            }
        }

        if(countFresh == 0)return  0;

        //now we need to make a array for directions so that from a point we can move in all the four directions
        int[] dx = {-1,1,0,0}; //this is to move left and then right
        int[] dy = {0,0,-1,1}; //this is to move from bottom and then top

        while (rottenPositions.isEmpty() == false) {   
            int size = rottenPositions.size();
            countRotten += size; 
            
            for(int i=0; i<size; i++){
                //now we are gonna pull out every rotten oranges 
                int[] position = rottenPositions.poll();
                for(int j=0;j<4;j++){
                    //we are iterate in all for directions to search for fresh oranges
                    int x = position[0] + dx[j];
                    int y = position[1] + dy[j];
                    if(x < 0 || y < 0 || x >= grid[0].length || y >= grid.length || grid[x][y] == 0 || grid[x][y] == 2){
                        continue;
                    }

                    //otherwise this means it is a fresh orange which is getting rot
                    grid[x][y] = 2;
                    rottenPositions.add(new int[]{x,y});
                }
                
                
            }
            if(!rottenPositions.isEmpty())
                time++; //means go to the next
        }
        if(countRotten != countFresh) return  -1;

        return time;
    }
}
