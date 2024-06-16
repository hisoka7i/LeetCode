package HashTable.PracticeProblems;

import java.util.HashMap;
import java.util.Map;

public class a771 {
    public static int numJewelsInStones(String jewels, String stones) {
        Map<Character,Integer> mapping = new HashMap<>();
        int count = 0;
        for(char currentJewel: jewels.toCharArray()){
            mapping.put(currentJewel, 0);
        }
        for(char currentStone: stones.toCharArray()){
            if(mapping.containsKey(currentStone))
                count++;
        }
        return count;
    }
}
