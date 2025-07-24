import java.lang.reflect.Array;
import java.util.Arrays;

public class PartitionarrayMinimizeDiff {
    public int minimumDifference(int[] nums) {
        int total_sum = Arrays.stream(nums).sum();
        int ans[] = new int[1];

        ans[0] = Integer.MAX_VALUE;

        helper_function_meet_in_the_middle(nums.length - 1, 0, nums.length/2, total_sum, ans, nums);

        return ans[0];
    }

    public void helper_function_meet_in_the_middle(int index, int current_sum, int length, int total_sum, int[] ans, int[] nums){
        if(length == 0){
            ans[0] = Math.min(ans[0], Math.abs(total_sum - 2*current_sum));
            return;
        }
        if(index == 0)return;

        helper_function_meet_in_the_middle(index -1 , current_sum + nums[index], length - 1, total_sum, ans, nums);
        helper_function_meet_in_the_middle(index-1, current_sum, length, total_sum, ans, nums);
    }


    //gfg gave this approach and this one is in correct
    public int helper_memo_function(int[] nums, int index, int sum, int total_sum, int[][] memo){
        if(index == 0){
            return Math.abs(sum - (total_sum-sum));
        }

        if(memo[index][sum] != -1){
            return memo[index][sum];
        }

       //this is the picking part
        int include = helper_memo_function(nums, index-1, sum + nums[index-1], total_sum, memo);

        //this is the non picking part

        int exclude = helper_memo_function(nums, index-1, sum, total_sum, memo);


        return memo[index][sum] = Math.min(include, exclude);
    }
}
