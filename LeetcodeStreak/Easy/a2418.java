package LeetcodeStreak.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class a2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> mapping_heights = new HashMap<>();
        
        //adding data into hash map
        for(int i=0;i<names.length;i++){
            mapping_heights.put(heights[i],names[i]);
        }

        Arrays.sort(heights);

        String[] result_array = new String[heights.length];
        int index = 0;
        for(int i=heights.length-1;i>=0;i--){
            result_array[index++] = mapping_heights.get(heights[i]);
        }

        return result_array;
    }
}
