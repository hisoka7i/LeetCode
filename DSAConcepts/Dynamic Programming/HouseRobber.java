import java.util.Arrays;

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 1)return nums[0];
        if(nums.length == 2)return nums[0] > nums[1] ? nums[0]: nums[1];
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return Math.max(helper_function_memoised(0, nums, memo), helper_function_memoised(1, nums, memo));
    }
    public int helper_function(int i, int[] nums){
        if( i >= nums.length)return 0;
        return nums[i] + Math.max(helper_function(i+2, nums), helper_function(i+3, nums));
    }

    public int helper_function_memoised(int i , int[] nums, int[] memo){
        if( i >= nums.length)return 0;
        if(memo[i] != -1)return memo[i];

        memo[i] = nums[i] + Math.max(helper_function_memoised(i+2, nums, memo),helper_function_memoised(i+3, nums, memo));
        return memo[i];
    }
}
