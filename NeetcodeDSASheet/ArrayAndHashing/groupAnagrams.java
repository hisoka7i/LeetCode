package NeetcodeDSASheet.ArrayAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(filledMap(Arrays.asList(strs)).values());
    }
    public Map<String, List<String>> filledMap(List<String> sample){
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0;i<sample.size();i++){
            char[] current = sample.get(i).toCharArray();
            Arrays.sort(current);
            String current_sorted = String.valueOf(current);
            if(!map.containsKey(current_sorted)){
                map.put(current_sorted, new ArrayList<>(Arrays.asList(sample.get(i))));
            }else
                map.get(current_sorted).add(sample.get(i));
        }
        return map;
    }
}
