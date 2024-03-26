import java.util.Arrays;
public class a594 {
    public static void main(String[] args) {
        int a[] = {1,2,4,3,1,35};
        System.out.println(findLHS(a));
    }
    public static int findLHS(int[] nums) {
        int max_length = 0, left = 0, right = 1;
        Arrays.sort(nums);
        while(right<nums.length){
            if(nums[right]-nums[left]>1){
                left++;
            }
            if(nums[right]-nums[left]==1){
                max_length = Math.max(max_length, right-left+1);
            }
            right++;
        }
        return max_length;
    }
}
