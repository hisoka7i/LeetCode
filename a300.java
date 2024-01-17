import java.util.*;
class Solution{
  public static void main(String[] args){
    int a[] = {0,1,0,3,2,3};
    System.out.println("Length of the Subsequence is:"+lengthOfLIS(a));
  }
  public static int lengthOfLIS(int []nums) {
    Stack<Integer> numsStack = new Stack();
        numsStack.push(nums[0]);
        for(int i=0;i<nums.length-1;i++){
          int ind = i+1;
            if(numsStack.contains(nums[ind])) continue;
            if(nums[i+1]<=numsStack.peek()){
                numsStack.removeIf(n->(n>=nums[ind]));
                numsStack.push(nums[i+1]);
            }else{
                numsStack.push(nums[i+1]);
            }
            System.out.println(numsStack.toString());
        }
        return numsStack.size();
  }
}
