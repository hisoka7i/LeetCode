package ArrayQuestions;
import java.util.*;
class Solution{
  static int max_count = 1;
  public static void main(String[] args){
    int a[] = {0,4,5,2,6};
    System.out.println("Length of the Subsequence is:"+lengthOfLIS(a));
  }
  public static int lengthOfLIS(int []nums) {
    int max_count =1, right = 1, left = 0;
    Arrays.sort(nums);
    while(right<nums.length){
      if(nums[right]-nums[left]==1){
        System.out.println("If part is working");
        max_count = Math.max(max_count, right-left+1);
      }else{
        System.out.println("Else part is working!");
        left++;
      }
      right++;
    }
    return max_count = 1;
  }
}
