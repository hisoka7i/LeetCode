package LeetcodeStreak.Easy;

public class a2460 {
    public int[] applyOperations(int[] nums) {
        int length = nums.length;
        for(int i=0;i<length-1;i++){
            if(nums[i] == nums[i+1]){
                nums[i] = nums[i]*2;
                nums[i+1] = 0;
                continue;
            }
        }
        int[] output = new int[length];
        int i2 = 0;
        for(int i=0;i<length;i++){
            if(nums[i] != 0){
                output[i2++] = nums[i];
            }
        }
        return output;
    }
}
