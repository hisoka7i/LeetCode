package LeetcodeStreak.Easy;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class a2053 {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        //adding values into map
        for(String current_character: arr){
            map.put(current_character, map.getOrDefault(current_character, 0)+1);
        }
        String result = "";
        for(Entry<String,Integer> current_entry: map.entrySet()){
            if(current_entry.getValue() == 1){
                //that means this is a distinct string
                if(k==1){
                    result = current_entry.getKey();
                }
                k--;
            }
        }
        return result;
    }
}
