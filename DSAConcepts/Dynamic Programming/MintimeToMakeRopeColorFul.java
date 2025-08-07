import java.util.*;
public class MintimeToMakeRopeColorFul {
    //
    public int minCost(String colors, int[] neededTime){
        int max_cost = helper_function(colors, neededTime.length-1, neededTime);
        return Arrays.stream(neededTime).sum() - max_cost;
    }

    //this approach has the right thinking but wrong implementation
    public int helper_function(String colors, int x, int[] neededTime){
        if( x < 0)return 0;

        if( x > 0 && colors.charAt(x) == colors.charAt(x - 1)){
            return Math.max(helper_function(colors, x-1, neededTime), helper_function(colors, x-2, neededTime));
        }
        return neededTime[x]  + helper_function(colors, x-1, neededTime);
    }

    //solution is to just calculate the minimum values
    //if there are same ballon then simply compare there times and, swap them 
    //keep the bigger ballon at right side, and then continue

    public int helper_function_memo(String colors, int x, int[] memo, int[] neededTime){
        if (x >= neededTime.length){
            memo[x] = 0;
            return 0;
        }

        if(memo[x] != -1)return memo[x];

        if(colors.charAt(x) == colors.charAt(x+1)){
            if(neededTime[x] > neededTime[x+1]){
                int teemp = neededTime[x];
                neededTime[x] = neededTime[x+1];
                neededTime[x+1] = teemp;
            }
            return memo[x] = neededTime[x] + helper_function_memo(colors, x + 1, memo, neededTime);
        }else{
            return memo[x] = helper_function_memo(colors, x + 1, memo, neededTime);
        }
    }

}
