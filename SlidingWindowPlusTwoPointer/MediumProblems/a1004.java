package SlidingWindowPlusTwoPointer.MediumProblems;

public class a1004 {
    public static void main(String[] args) {
        
    }
    public static int longestOnes(int[] nums, int k) {
        //here we have a left pointer, a right pointer 
        //a variable which will keep track of max value 
        //a count for k
        int left = 0,right = 0, max = 0, n = nums.length;  
        while(right<n){
            if(nums[right]==0){
                //this means that we have flipped one 0
                k--;
            }
            while(k<0){
                //this means that we have flipped all the zeros
                if(nums[left]==0)k++;
                left++;
                //this block signifies that we have, changed the last zero to 1
            }
            max = Math.max(max, right-left+1);
            right++;
        }
        return max;
    }
}
