import java.util.Arrays;
import java.util.Comparator;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int answer = helper_function_memo(coins, amount,memo);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }


    public int helper_function(int[] coins, int amount){
        if(amount == 0)return 0;
        if(amount < 0)return Integer.MAX_VALUE;
        int min_count = Integer.MAX_VALUE;
        for(int coin : coins){
            int count = helper_function(coins, amount-coin);
            if(count != Integer.MAX_VALUE){
                min_count = Math.min(min_count, 1+count);
            }
        }
        return min_count;
    }

    public int helper_function_memo(int[] coins, int amount, int[] memo){
        if(amount == 0)return 0;
        if(amount < 0)return Integer.MAX_VALUE;
        if(memo[amount] != -1)return memo[amount];
        int min_count = Integer.MAX_VALUE;
        for(int coin : coins){
            int count = helper_function_memo(coins, amount-coin, memo);
            if(count != Integer.MAX_VALUE){
                min_count = Math.min(min_count, 1+count);
            }
        }
        memo[amount] = min_count;
        return memo[amount];
    }
}
