import java.util.Arrays;

public class CountNumberOfWays {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return helper_memo_function(n, memo);
    }

    public int helper_memo_function(int n, int[] memo){
        if(n < 0) return 0;
        if(n == 0)
        {
            return 0;
        }

        if(memo[n] != -1){
            return memo[n];
        }

        return memo[n] = helper_memo_function(n-1, memo) + helper_memo_function(n-2, memo);
    }
}
