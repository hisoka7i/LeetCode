package LeetcodeStreak.Medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class a1726 {
    public int tupleSameProduct(int[] nums) {
        if(nums.length < 4){
            return 0;
        }
        int count = 0;
        Map<Integer, Set<Integer[]>> hashtable = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length;j++){
                if(nums[i] != nums[j]){
                    
                }
            }
        }
        return count;
    }
}
