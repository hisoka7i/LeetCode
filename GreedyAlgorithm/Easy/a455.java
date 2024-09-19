package GreedyAlgorithm.Easy;

import java.util.Arrays;

public class a455 {
    /*
     * Intution behind the solution is, we will give the smallest cookies to
     * least greedy child
    */
    public int findContentChildren(int[] num1, int[] num2) {
        Arrays.sort(num1);
        Arrays.sort(num2);
        
        //we will make 2 indexes
        int left = 0, right = 0;
        int count = 0;
        while(left<num1.length && right<num2.length){
            if(num1[left] <= num2[right]){
                left++;
                right++;
                count++;
            }else
                right++;
        }
        return count;
    }
}
