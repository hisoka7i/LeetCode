public class OptimalStrategyGame {
    // Given an array arr[] of size n which represents a row of n coins of values V1 . . . Vn, where n is even. We play a game against an opponent by alternating turns. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin. Determine the maximum possible amount of money we can definitely win if we move first.
    public int helper_function(int i , int j, int[] arr){
        if(i > j){
            return 0;
        }

        
        int takeFirst = arr[i] + Math.min(
            //suppose opponent takes the second item
            helper_function(i+1, j, arr),
            //suppose the opponent takes the lasat element
            helper_function(+1, j-1, arr)
        );

        int takeLast = arr[j] + Math.min(
            //suppose opponentt takes the second last
            helper_function(i, j-1, arr),
            //suppose the element takes the first element
            helper_function(i+1, j-1, arr)
        );

        return Math.max(takeFirst,takeLast);
    }

    public int helper_function_memo(int i, int j, int[] nums, int[][] memo){
        if(i > j){
            return memo[i][j] = 0;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int takeFirst = nums[i] + Math.min(
            helper_function_memo(i+2, j, nums, memo), 
            helper_function_memo(i+1, j-1, nums, memo));

        int takesecond = nums[j] + Math.min(
            helper_function_memo(i+1, j-1, nums, memo), 
            helper_function_memo(i, j-2, nums, memo));


        return memo[i][j] = Math.max(takeFirst, takesecond);
    }
}
