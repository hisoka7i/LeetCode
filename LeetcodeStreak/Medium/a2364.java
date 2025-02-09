package LeetcodeStreak.Medium;

import java.util.HashMap;
import java.util.Map;

public class a2364 {
    public long countBadPairs(int[] nums) {
        long badPair = 0;
        Map<Integer, Integer> diffCount = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff = nums[i] - i;

            //getting al the good pairs
            int goodpairs = diffCount.getOrDefault(diff, 0);

            //count the bad pair by subtracting good pairs from overall
            badPair += i - goodpairs;

            //update count of position
            diffCount.put(diff, goodpairs+1);
        }
        return badPair;
    }
    //brute force and out of memory
    public long countBadPairs_OOM(int[] nums) {
        long count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(j-i == nums[j]-nums[i])
                    count++;
            }
        }
        return count;
    }
}
