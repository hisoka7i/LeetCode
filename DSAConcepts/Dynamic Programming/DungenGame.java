import java.util.Arrays;
import java.util.Map;

public class DungenGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int answer = helper_function(dungeon, m, n, m, n);
        return answer;
    }

    public int helper_function(int[][] grid, int m, int n, int cm, int cn){
        if(cm == 0 || cn == 0)return grid[0][0];
        if(cm < 0 || cn < 0)return Integer.MAX_VALUE - 10000;

        int up = grid[cm][cn] + helper_function(grid, m, n, cm - 1, cn);
        int left = grid[cm][cn] + helper_function(grid, m, n, cm, cn - 1);

        return Math.min(up, left);
    }

    public int helper_function_tabulation(int[][] dungeon){
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        int[][] dp = new int[m+1][n+1];

        for(int[] row: dp)Arrays.fill(row, Integer.MAX_VALUE);
        dp[m][n-1] = 1;
        dp[m-1][n] = 1;

        for(int i = m - 1; i>= 0 ; i--){
            for(int j = n-1; j>=0 ; j--){
                int need = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
                dp[i][j] = Math.max(1, need);
            }
        }
        return dp[0][0];
    }


    
}
