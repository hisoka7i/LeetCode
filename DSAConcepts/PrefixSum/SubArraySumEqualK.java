package DSAConcepts.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualK {
    //look at the striever video for reference
    public int countNumberOfSubArrays(int[] nums, int k){
        int prefix = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        for(int i=0;i<nums.length;i++){
            prefix += nums[i];
            if(map.containsKey(prefix - k)){
                count += map.get(prefix-k);
            }
            map.put(prefix, map.getOrDefault(prefix, 0)+1);
        }
        return count;
    }
}
