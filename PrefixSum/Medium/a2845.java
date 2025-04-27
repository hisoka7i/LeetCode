package PrefixSum.Medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a2845 {

    //I am trying to solve this question using hints
    //This question is a simple variation of sub array sum equal to k
    //in the prefix sum, we are storing the binary values
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int count = 0 ;
        int prefix = 0;
        Map<Integer, Integer> map = new HashMap<>(); //this is for prefix and its count
        map.put(0,1);
        for(int num: nums){
            prefix += num%modulo == k?1:0;
            count += map.getOrDefault((prefix - k + modulo)%modulo, 0);
            //now we need to the prefix sum into the map
            map.put(prefix%modulo, map.getOrDefault(prefix%modulo, 0)+1);
        }
        return count;
    }

    //this solutions is working but this is giving time limit exceeded issue
    public long countInterestingSubarraysBruteForce(List<Integer> nums, int modulo, int k) {
        //first we need to make prefix sum for the arrays
        int[] prefixCount = new int[nums.size()]; //this is for the modulo count
        int n = nums.size();
        if (isValid(nums.get(0), modulo, k)) {
            prefixCount[0] = 1;
        }
        for (int i = 1; i < n; i++) {
            prefixCount[i] = prefixCount[i - 1];
            if (isValid(nums.get(i), modulo, k)) {
                prefixCount[i]++;
            }
        }

        long count = 0;

        // For all possible subarrays
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int validCount = prefixCount[j];
                if (i > 0) {
                    validCount -= prefixCount[i - 1];
                }

                // Only check validCount, not size
                if (validCount % modulo == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isValid(int val, int modulo, int k) {
        return (val % modulo == k);
    }
}