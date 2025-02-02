package LeetcodeStreak.Easy;

public class a1752 {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        check(nums);
    }
    public static boolean check(int[] nums) {
        int pivot=0;
        int n = nums.length;
         for(int i=nums.length-1;i>=1;i--){
             if(nums[i] >= nums[i-1]){
                 continue;
             }else{
                 pivot = i;
                 break;
             }
         }
         int[] sorted = new int[nums.length];
         for(int i=0;i<nums.length;i++,pivot++){
             sorted[i] = nums[pivot%n];
             if(i > 0 && i < n-1){
                 if(sorted[i] < sorted[i-1]){
                     return false;
                 }
             }
         }
         return  true;
     }
}
