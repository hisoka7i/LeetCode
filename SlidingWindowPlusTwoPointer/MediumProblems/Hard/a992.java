package MediumProblems.Hard;

import java.util.HashMap;
import java.util.Map;

public class a992 {
    /*
     * Given an integer array nums and an integer k, return the number of good subarrays of nums.
     * A good array is an array where the number of different integers in that array is exactly k.
     * For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
     * A subarray is a contiguous part of an array.
    */
    public int subarraysWithKDistinct(int[] nums, int k) {
        //we will find all the distinct subarrays which are less than equal to k
        return slidingWindow(nums, k) - slidingWindow(nums, k-1);
    }

    public int slidingWindow(int[] nums, int k){
        int l = 0, r = 0, count = 0;
        Map<Integer,Integer> mpp = new HashMap<>();
        while(r<nums.length){
            mpp.put(nums[r],mpp.getOrDefault(nums[r], 0)+1);
            while(mpp.size()>k){
                //moment we get over sized we, will remove the last element
                mpp.put(nums[l],mpp.get(nums[l])-1);
                if(mpp.get(nums[l])==0){
                    mpp.remove(nums[l]);
                }
                //moving the left pointer forward
                l++;
            }
            count += + r - l +1;
            //moving the right pointer forward
            r++;
        }
        return count;
    }
}
