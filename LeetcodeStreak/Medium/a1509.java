package LeetcodeStreak.Medium;

import java.util.Arrays;

public class a1509 {
    public static void main(String[] args) {
        int[] sample = {6,6,0,1,1,4,6};
        System.out.println(minDifference(sample));
    }
    public static int minDifference(int[] nums) {
        if(nums.length<4){
            return 0;
        }
        Arrays.sort(nums);
        //we will first check for last and fist element difference
        int ans = nums[nums.length - 1] - nums[0];
        for(int i=0;i<=3;i++){
            //we first check for first element and fourth last element
            //then for second element and third last element
            //then for third element and second last element 
            //and finally fourth element and last elemet
            int current_pos = nums.length - (3-i) - 1;
            ans = Math.min(ans, nums[current_pos] - nums[i]);
        }
        return ans;
    }
}
