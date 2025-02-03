package LeetcodeStreak.Easy;

public class a3105 {
    public static void main(String[] args) {
        int[] sample = {3,2,1};
        longestMonotonicSubarray(sample);
    }
    public static int longestMonotonicSubarray(int[] nums) {
        int increasingLength = 1, decreasingLength = 1;
        int maxLength = 1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1] > nums[i]){
                increasingLength++;
                decreasingLength = 1;
            }else if(nums[i+1] < nums[i]){
                decreasingLength++;
                increasingLength = 1;
            }else{
                increasingLength = 1;
                decreasingLength = 1;
            }
            maxLength = Math.max(maxLength, Math.max(increasingLength, decreasingLength));
        }
        return maxLength;
    }
}
