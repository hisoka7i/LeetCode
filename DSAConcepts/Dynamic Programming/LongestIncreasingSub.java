import java.util.Arrays;
import java.util.Stack;

public class LongestIncreasingSub {

    //this is a wrong implementation.
    public int wrong_lengthOfLIS(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int final_value = Integer.MIN_VALUE;
        for(int i=0;i<n; i++){
            stack.clear();
            int value = nums[i];
            stack.push(value);
            for(int j = i+1; j < n; j++){
                int next = nums[j];
                if(next >= stack.peek()){
                    stack.push(next);
                }
                final_value = Math.max(final_value, stack.size());
            }
        }
        return final_value;
    }

    public int lengthOfLIS(int[] nums){
        int[][] memo = new int[nums.length][nums.length + 1];
        for(int[] m: memo){
            Arrays.fill(m, -1);
        }
        return helper_memo_function(nums, 0, -1, memo);
    }

    public int helper_memo_function(int[] nums, int curr, int prev, int[][] memo){
        if(curr == nums.length){
            return 0;
        }

        if(memo[curr][prev + 1] != -1){
            return memo[curr][prev + 1];
        }

        //excluding the current
        int exclude = helper_memo_function(nums, curr+1, prev, memo);
        int include = 0;
        if(prev == -1 || nums[curr] > nums[prev]){
            //including the current, moving the currnet forward and setting the prev as next
            include = 1 + helper_memo_function(nums, curr+1, curr, memo);
        }

        return memo[curr][prev+1] = Math.max(exclude, include);
    }


}
