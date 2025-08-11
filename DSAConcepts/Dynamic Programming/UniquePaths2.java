import java.util.Arrays;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] cm: memo)Arrays.fill(cm, -1);
        return helper_function_memoised(obstacleGrid, obstacleGrid.length, obstacleGrid[0].length, 0, 0, memo);
    }
    public int helper_function(int[][] obstacleGrid, int m, int n, int current_m, int current_n){
        if(current_m >= m || current_n >= n)return 0;
        if(obstacleGrid[current_m][current_n] == 1)return 0;
        if(current_m == m-1 && current_n == n-1)return 1;
        

        return  helper_function(obstacleGrid, m, n, current_m+1, current_n) + helper_function(obstacleGrid, m, n, current_m, current_n+1);
    } 
    public int helper_function_memoised(int[][] obstacleGrid, int m, int n, int current_m, int current_n, int[][] memo){
        if(current_m >= m || current_n >= n)return 0;
        if(obstacleGrid[current_m][current_n] == 1)return 0;
        if(current_m == m-1 && current_n == n-1)return 1;
        

        if(memo[current_m][current_n] != -1)return memo[current_m][current_n];

        memo[current_m][current_n] =  helper_function_memoised(obstacleGrid, m, n, current_m+1, current_n, memo) + helper_function_memoised(obstacleGrid, m, n, current_m, current_n+1, memo);
        return memo[current_m][current_n];
    }
}
