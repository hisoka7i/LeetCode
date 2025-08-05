import java.util.Arrays;

public class MinCostClimbing {
    public int minCostClimbingStairs(int[] cost) {
        // int sum = 0;
        int n = cost.length;
        int[][] memo = new int[n + 1][n + 1];
        for(int[] num: memo)Arrays.fill(num, -1);
        return Math.min(helper_function_with_memo(cost, n - 1, memo), helper_function_with_memo(cost, n - 2, memo))        ;
    }

    //tjos ome is wrong
    public int helper_function(int[] cost, int n, int sum){
        if( n < 2){
            return 0;
        }
        return sum + Math.min(helper_function(cost, n - 1 ,sum), helper_function(cost, n - 2, sum));
    }

    public int helper_function2(int[] cost, int n){
        if( n < 0 )return 0;
        if(n == 1 || n == 0) return cost[n];

        return cost[n] + Math.min(helper_function2(cost, n - 1), helper_function2(cost, n - 2));
    }

    public int helper_function_with_memo(int[] cost, int n, int[][] memo){
        if(n < 0)return 0;
        if(n == 1 || n == 0 )return cost[n];

        if(memo[n-1][n-2] != -1)return memo[n-1][n-2];

        return memo[n-1][n-2] = cost[n] + Math.min(helper_function_with_memo(cost, n - 1, memo), helper_function_with_memo(cost, n-2, memo));
    }
}
