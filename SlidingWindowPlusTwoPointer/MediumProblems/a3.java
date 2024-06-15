package SlidingWindowPlusTwoPointer.MediumProblems;

import java.util.HashMap;
import java.util.Map;

public class a3 {
    //longest substring without repeating characters
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)return -1;
        //we will need a hashmap which will contain character and the index
        Map<Character,Integer> indexMap = new HashMap<>();

        //now we will have a variable which will keep the highest length 
        int maxLength = 0;
        //we will be using two pointers
        int r = 0,l =0;
        //now we will iterate the string 
        while(r<s.length()){
            if(indexMap.containsKey(s.charAt(r)))
                //if have the character present in the hashmap then we need
                //to shift the left pointer to, next to this present occurance
                l = Math.max(indexMap.get(s.charAt(r))+1,l);

                //we need to update the hashmap to new index
                indexMap.put(s.charAt(r), r);
                r++;
                maxLength = Math.max(maxLength, r-l+1);
        }
        return maxLength-1;
    }
}
