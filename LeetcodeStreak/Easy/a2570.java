package LeetcodeStreak.Easy;

import java.util.Map;
import java.util.TreeMap;

public class a2570 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer,Integer> hashmap = new TreeMap<>();
        for(int i=0;i<nums1.length;i++){
            int id = nums1[i][0];
            int value = hashmap.getOrDefault(id, 0) + nums1[i][1];
            hashmap.put(id, value);
        }

        for(int i=0;i<nums2.length;i++){
            int id = nums2[i][0];
            int value = hashmap.getOrDefault(id, 0) + nums2[i][1];
            hashmap.put(id, value);
        }

        int[][] output = new int[hashmap.size()][2];
        int i = 0;

        for(Map.Entry<Integer, Integer> currentMap: hashmap.entrySet()){
            output[i][0] = currentMap.getKey();
            output[i][1] = currentMap.getValue();
            i++;
        }

        return output;
    }
}
