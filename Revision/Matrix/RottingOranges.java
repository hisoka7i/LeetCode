package Revision.Matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
    }

    //my brute force solution
    public int bruteForceSolution(int[][] grid){
        int time = 0;
        Stack<List<int[]>> totrace = new Stack<>();
        //now we need to add rotten tomatoes in the list and then add it into the stack
        List<int[]> rottenPositions = new ArrayList<>();
        //we will require a set, that is going to keep trace of the visited positions 
        Set<int[]> set = new HashSet<>();
        for(int i=0;i<grid.length; i++){
            for(int j=0;j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    //which means that the tomato is rotten
                    rottenPositions.add(new int[]{i,j}); 
                    set.add(new int[]{i,j});
                }
            }
        }
        totrace.add(rottenPositions);

        //we will req

        //now if the stack is not empty, 
        return time;
    }
}
