package LeetcodeStreak.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Integer[] newNums = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            newNums[i] = nums[i];
        }

        Arrays.sort(newNums, (n1,n2)->{
            if(freq.get(n1) != freq.get(n2)){
                //sort in terms of freq
                return freq.get(n1) - freq.get(n2);
            }else{
                //sort in terms of value
                return n1-n2;
            }
        });

        for(int i=0;i<newNums.length;i++){
            nums[i] = newNums[i];
        }
        return nums;
    }
    //This solution will not work for negative numbers
    public int[] frequencySort_incorrect(int[] nums) {

        //making a frequency array
        int[] frequency_array = new int[101];


        for(int current_number: nums){
            frequency_array[current_number] += 1;
        }
        //saving the final result
        int[] result = new int[nums.length];
        int result_index = 0;
        for(int current_frequency=0;current_frequency<frequency_array.length;current_frequency++){
            if(frequency_array[current_frequency]!=0){
                for(int i=0;i<frequency_array[current_frequency];i++){
                    result[result_index++] = current_frequency;
                }
            }
        }
        return result;
    }
}
