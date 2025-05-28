package LeetcodeStreak.Hard.Tree;

public class a3068 {

    //this was a solution provided by youtuber I wasted half an hour on this, what a waste
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long max_sum = 0;
        int n = nums.length;
        int min_loss = Integer.MAX_VALUE;
        int count  = 0;
        long total_sum = 0;

        for(int i = 0; i < n; i++) {
            total_sum += nums[i];
            if((nums[i] ^ k) > nums[i]) {
                max_sum += nums[i] ^ k;
                count++;
            } else {
                max_sum += nums[i];
            }

            if((nums[i] ^ k) < nums[i]) {
                min_loss = Math.min(min_loss, Math.abs(nums[i] - (nums[i] ^ k)));
            }
        }
        if(count%2 != 0 ) {
            max_sum -= min_loss;
        }
        if(total_sum > max_sum) {
            return total_sum;
        }
        return max_sum;
    }
}
