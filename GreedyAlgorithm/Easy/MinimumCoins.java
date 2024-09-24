package GreedyAlgorithm.Easy;

import java.util.Arrays;

public class MinimumCoins {
    static int minCoins(Integer coins[], int m, int sum){
        Arrays.sort(coins, (x,y)->y-x);
        int count = 0;
        for(int i=0;i<coins.length;){
            int current_coin = coins[i];
            if(current_coin <= sum){
                sum -= current_coin;
                count++;
            }else{
                i++;
            }
            if (sum == 0) {
                break;
            }
        }
        return count;
    }
}
