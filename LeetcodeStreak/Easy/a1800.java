package LeetcodeStreak.Easy;

public class a1800 {
    public int maxAscendingSum(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 0){
            return 0;
        }
        int sum = 0;
        int ascending_sum = 0;
        for(int i=0; i<nums.length-1;i++){
            sum = Math.max(sum, nums[i]);
            if(nums[i] < nums[i+1]){
                //this means acsending
                if(ascending_sum == 0)
                    ascending_sum = nums[i] + nums[i+1];
                else
                    ascending_sum += nums[i+1];
            }else{
                ascending_sum = 0;
            }
            sum = Math.max(ascending_sum, sum);
        }

        return sum;
    }
}
