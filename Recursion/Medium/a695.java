package Medium;

public class a695 {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // a data stucture to maintain visited notes
        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxArea = Math.max(maxArea, computeArea(i, j, visited, grid));
            }
        }
        return maxArea;
    }

    private int computeArea(int i, int j, boolean[][] visited, int[][] grid) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'computeArea'");
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length || grid[i][j] == 0 || visited[i][j]){
            return 0;
        }

        visited[i][j] = true;
        return grid[i][j] + 
        computeArea(i-1, j, visited, grid) +
        computeArea(i+1, j, visited, grid) +
        computeArea(i, j-1, visited, grid) +
        computeArea(i, j + 1, visited, grid);
    }
}
