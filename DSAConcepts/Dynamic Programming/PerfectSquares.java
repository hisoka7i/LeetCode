import java.util.Arrays;

public class PerfectSquares{
    public int numSquares(int x) {
        int[] memo = new int[x+1];
        Arrays.fill(memo, -1);
        return helper_function_memo(x, memo);
    }
    public int helper_function(int x){
        if (x <= 0)return 0;
        int value = x;
        for(int i = 2; i*i <= x; i++){
            value = Math.min(value, 1 + helper_function(x - i*i));
        }
        return value;
    }
    //putting memo into it =
    public int helper_function_memo(int x, int[] memo){
        if(x <= 0)return 0;
        if(memo[x] != -1)return memo[x];
        int value = x;
        for(int i = 2; i*i <= x;i++){
            value = Math.min(value, 1 + helper_function_memo(x - i*i, memo));
        }
        return memo[x] = value;
    }
}