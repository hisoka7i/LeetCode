package LeetcodeStreak.Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class a872 {

    // complete solution, we are going give each Island a unique ID. All the ones
    // will be converted into that unique ID,
    // then we will look for all the 0 in the matrix and we will check around if
    // there is any island around
    // if present then we will add its id in a unique data structure, and then
    // calculate the max_area
    public int largestIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Map<Integer, Integer> uniqueIslands = new HashMap<>();
        int uniqueId = 2; // avoiding 0 and 1 since they are input data

        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    // this function will calculate area and it will, change the values of
                    // matrix to corresponding to island area
                    int area = calculateArea(visited, grid, i, j, uniqueId);
                    uniqueIslands.put(uniqueId, area);
                    uniqueId++;
                }
            }
        }

        //now we need to know the max_area
        int max_area = uniqueIslands.values().stream().max(Integer::compare).orElse(0);

        //now we need to find all zeros and then, find the max_area accordingly.
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                //we need to find the zeros
                if(grid[i][j] == 0){
                    
                    //now we need to check around if there is any island around it
                    int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}}; //down, up, left, right
                    Set<Integer> islands = new HashSet<>();

                    for(int[] direction: directions){
                        int newRow = i + direction[0];
                        int newCol = j + direction[1];

                        if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] > 1){
                            islands.add(grid[newRow][newCol]);
                        }
                    }
                    int newArea = 1;
                    for(int id: islands){
                        newArea += uniqueIslands.get(id);
                    }

                    max_area = Math.max(max_area, newArea);
                }
            }
        }
        return max_area;
    }

    private int calculateArea(boolean[][] visited, int[][] grid, int row, int col, int uniqueID) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0
                || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;
        grid[row][col] = uniqueID;
        return 1 + calculateArea(visited, grid, row - 1, col,uniqueID)
                + calculateArea(visited, grid, row + 1, col,uniqueID)
                + calculateArea(visited, grid, row, col - 1,uniqueID)
                + calculateArea(visited, grid, row, col + 1,uniqueID);
    }

    // my intutition is to find 0 who has atleast one 1 around if yes then change
    // from 0 to 1 and find the area,
    // after area turn it back to 0
    // this solution also works, but 3 test cases are failing.
    public int largestIsland2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int max_area = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0 && hasOneAround(grid, row, col)) {
                    boolean[][] visited = new boolean[rows][cols];
                    grid[row][col] = 1;
                    max_area = Math.max(max_area, calculateArea(visited, grid, row, col));
                    grid[row][col] = 0;
                }
            }
        }
        if (max_area == 0 && grid[0][0] == 0) {
            return 1;
        }
        return max_area == 0 ? rows * cols : max_area;
    }

    private boolean hasOneAround(int[][] grid, int row, int col) {
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int[] dir : directions) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                    && grid[newRow][newCol] == 1) {
                return true;
            }
        }
        return false;
    }

    private int calculateArea(boolean[][] visited, int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0
                || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;

        return 1 + calculateArea(visited, grid, row - 1, col)
                + calculateArea(visited, grid, row + 1, col)
                + calculateArea(visited, grid, row, col - 1)
                + calculateArea(visited, grid, row, col + 1);
    }
}
