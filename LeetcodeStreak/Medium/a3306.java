package LeetcodeStreak.Medium;

import java.util.HashMap;
import java.util.Map;

public class a3306 {
    public long countOfSubstrings(String word, int k) {
        return countAllSubs(word, k) - countAllSubs(word, k+1);

    }

    public long countAllSubs(String word, int k){
        long count = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>(); //to count vowels
        int consonent = 0;

        while(end < word.length()){
            char ch = word.charAt(end);
            if(isVowel(ch)){
                map.put(
                    ch, 
                    map.getOrDefault(ch, 0)+1);
            }else{
                consonent++;
            }

            //now we will check if the substring is valid
            while(map.size() == 5 && consonent >= k){
                //now we are getting all the valid string
                count  += word.length() - end;
                //now we need to shrink the left window
                char startLetter = word.charAt(start);

                if(isVowel(startLetter)){
                    map.put(
                        startLetter, 
                        map.get(startLetter)-1);
                    if(map.get(startLetter) == 0){
                        map.remove(startLetter);
                    }
                }else{
                    consonent--;
                }
                start++;
            }
            end++;
        }
        return count;
    }

    public boolean isVowel(char ch){
        return (ch == 'a' || ch == 'i' || ch == 'e' || ch == 'o' || ch == 'u');
    }

}
