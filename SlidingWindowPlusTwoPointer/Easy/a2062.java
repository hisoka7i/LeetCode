package Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

public class a2062 {
    //using O(n^2)
    public int countVowelSubstrings(String word){
        if(word.length() < 5)return 0;
        Set<Character> vowels = new HashSet<>();
        int n = word.length();
        int count = 0;
        for(int i = 0; i<n-4; i++){
            vowels.clear();
            for(int j = i; j<n; j++){
                char ch = word.charAt(j);
                if(isVowel(ch)){
                    vowels.add(ch);
                    if(vowels.size() == 5){
                        count++;
                    }
                }else
                    break;
            }
        }
        return count;
    }
    public boolean isVowel(char character){
        return (character == 'a' || character == 'e' || character == 'o' || character == 'i'
        || character == 'u');
    }
    // I made it too complex,  i was trying a O(n) complexity solution
    public int countVowelSubstrings2(String word) {
        if(word.length() < 2)return 0;
        Map<Character, Integer> hashmap = new HashMap<>();
        int left = 0;
        int right = 1;

        char[] arr = word.toCharArray();
        int n = arr.length;
        int count = 0;
        while(right<n){
            char lChar = arr[left];
            if(isVowel(lChar)){
                hashmap.put(lChar, hashmap.getOrDefault(lChar, 0)+1);
            }
            if(!hashmap.containsKey(lChar)){
                left++;
                right++;
                continue;
            }
            char rChar = arr[right];
            if(isVowel(rChar)){
                hashmap.put(rChar, hashmap.getOrDefault(rChar, 0)+1);
            }else{
                left = right;
                hashmap.clear();
            }
            if(hashmap.size() == 5){
                //this means that we all the character
                hashmap.forEach((k,v)->{
                    
                });
            }
            
        }
    }
    
}
