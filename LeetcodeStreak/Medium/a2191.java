package LeetcodeStreak.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class a2191 {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return nums;
        
        TreeMap<Integer, List<Integer>> value_mapping = new TreeMap<>();

        for(int i=0;i<nums.length; i++){
            String current_value = String.valueOf(nums[i]);

            StringBuilder changed_value = new StringBuilder();
            for(Character current_digit: current_value.toCharArray()){
                changed_value.append(mapping[Character.getNumericValue(current_digit)]);
            }

            int final_changed_value = Integer.valueOf(changed_value.toString());

            //we are saving indexes into it
            if(!value_mapping.containsKey(final_changed_value)){
                value_mapping.put(final_changed_value, new ArrayList < > (Arrays.asList(i)));
            }else{
                value_mapping.get(final_changed_value).add(i);
            }
        }

        int[] result = new int[nums.length];

        int index = 0;
        for (List < Integer > list: value_mapping.values()) {

            for (int k: list) {
                result[index++] = nums[k];
            }
        }

        return result;
    }
}
