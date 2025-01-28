package LeetcodeStreak.Medium;

public class a2658 {
    public int findMaxFish(int[][] grid) {
        /*
         * We will use DFS, for every point to find max
         */
        int rows = grid.length;
        int cols = grid[0].length;
        int maxfishCount = 0;

        // 2D array to track to track visited ones
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxfishCount = Math.max(maxfishCount, calculate(i, j, visited, grid));
            }
        }
    }

    private int calculate(int i, int j, boolean[][] visited, int[][] grid) {
        // TODO Auto-generated method stub

        if(i<0 || i>= grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0 || visited[i][j]){
            return 0;
        }

        visited[i][j] = true;
        return(grid[i][j] +
        calculate(i-1, j, visited, grid) +
        calculate(i+1, j, visited, grid) +
        calculate(i, j-1, visited, grid) +
        calculate(i, j+1, visited, grid)
        );
        // throw new UnsupportedOperationException("Unimplemented method 'calculate'");
    }

}
