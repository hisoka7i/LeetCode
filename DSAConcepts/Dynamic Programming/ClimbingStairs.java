package DSAConcepts.DynamicProgramming.Tabulation;

public class ClimbingStairs {
    public int climbStairs(int n) {
        //we need to start counting from the bottom
        int[] dp = new int[n+1];
        //if we are at step 0, then there is only way
        dp[0] = 1;
        //if we are at step 1, then there is only way
        dp[1] = 1;
        for(int i = 2; i<=n;i++){
            dp[i] = dp[i-1] + di[i-2];
        }
        return dp[n];
    }
}
