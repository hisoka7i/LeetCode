package LeetcodeStreak.Medium;

import java.util.HashMap;
import java.util.Map;

public class a2981 {
    public int maximumLength(String s) {
        //brute force method
        Map<String, Integer> hashmap = new HashMap<>();

        for(int i = 0; i<s.length();i++){
            for(int j = i; j<s.length(); j++){
                if(s.charAt(i) != s.charAt(j))break;
                String temp = s.substring(i , j+1);
                hashmap.put(temp, hashmap.getOrDefault(temp, 0) + 1); 
            }
        }
        int length = -1;
        for(String key: hashmap.keySet()){
            if(key.length() > length && hashmap.get(key) >= 3){
                length = key.length();
            }
        }
        return length;
    }
}
