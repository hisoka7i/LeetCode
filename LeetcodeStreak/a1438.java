package LeetcodeStreak;

import java.util.ArrayDeque;

public class a1438 {
    /*Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between 
    any two elements of this subarray is less than or equal to limit.

    Example 1:
    Input: nums = [8,2,4,7], limit = 4
    Output: 2  */

    /*Intution: 
    We will use monotonic increasing queue and decreasing queue 
    we get a sliding window, and we will maintain the min and max element of it
    and to verify the condition we will simply subtract and check
    */
    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer> increasing = new ArrayDeque<>();
        ArrayDeque<Integer> decreasing = new ArrayDeque<>();

        int result  = 0;
        //we will have a left and right pointer 
        int left = 0;
        for(int right = 0; right< nums.length ;right++){
            while(!increasing.isEmpty() && increasing.getLast() > nums[right]){
                increasing.removeLast();
            }

            while(!decreasing.isEmpty() && decreasing.getLast() < nums[right]){
                decreasing.removeLast();
            } 

            increasing.add(nums[right]);
            decreasing.add(nums[right]);

            //we will check and if the condition is not satisfied 
            //then we will simply destroy the window from the left
            while (decreasing.getFirst() - increasing.getFirst() > limit) {
                if(decreasing.getFirst() == nums[left]){
                    decreasing.removeFirst();
                }
                //suppose we add 2, 8 into the increasing and decreasing window
                //then increasing window will have 2, 8 as values 
                //and decreasing window will have 8 as value
                //we will remove the left element from the increasing window
                if(increasing.getFirst() == nums[left]){
                    increasing.removeFirst();
                }
                left++;
            }
            result = Math.max(result, right-left + 1);
        }
        return result;
    }
}
