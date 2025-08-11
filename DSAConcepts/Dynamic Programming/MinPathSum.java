import java.util.Arrays;

public class MinPathSum {
     public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m+1][n+1];
        for(int[] cm: memo)Arrays.fill(cm, -1);
        return  helper_function_memo(grid, m, n, 0, 0,memo);
    }

    public int helper_function(int[][] grid, int m, int n, int cm, int cn){
        if(cm >= m || cn >= n)return Integer.MAX_VALUE - 10000;
        if(cm == m - 1 && cn == n-1)return grid[m-1][n-1];

        int right = grid[cm][cn] + helper_function(grid, m, n, cm+1, cn);
        int down = grid[cm][cn] + helper_function(grid, m, n, cm, cn+1);

        return  Math.min(right, down);
    }

    public int helper_function_memo(int[][] grid, int m, int n, int cm, int cn, int[][] memo){
        if(cm >= m || cn >= n)return  Integer.MAX_VALUE - 10000;
        if(cm == m-1 && cn == n-1)return grid[cm][cn];

        if(memo[cm][cn] != -1)return memo[cm][cn];

        int right = grid[cm][cn] + helper_function_memo(grid, m, n, cm+1, cn, memo);
        int down = grid[cm][cn] + helper_function_memo(grid, m, n, cm, cn+1,memo);

        memo[cm][cn] = Math.min(right, down);
        return memo[cm][cn];
    }
}
