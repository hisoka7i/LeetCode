package DSAConcepts.DynamicProgramming.Tabulation;

public class minCostClimbingStair {
     public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];

        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i =2; i<cost.length; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-1]);
        }
        return dp[cost.length-1];
    }
}
