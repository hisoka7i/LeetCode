package MediumProblems;

import java.util.HashMap;
import java.util.Map;

public class a424 {
    public static void main(String[] args) {
        
    }
    public static int func(String s, int k){
        int l = 0, r= 0, maxFreq = 0, maxLength =0;
       int[] map = new int[26];

        while(r<s.length()){
            map[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq, map[s.charAt(r)-'A']);

            //check for validity
            //by validity i mean, ki if we change the character
            while((r-l+1)-maxFreq>k){
                //this means that it is not a valid one
                map[s.charAt(l)-'A']--;
                maxFreq = 0;
                //we need to upadate the max freq
                for(int i=0;i<26;i++){
                    maxFreq = Math.max(maxFreq, map[i]);
                }
                l++;
            }
            //if (r-l+1)<=k //means it is a valid 
            if((r-l+1)-maxFreq<=k){
                maxLength = Math.max(r-l+1, maxLength);
            }
            r++;
        }
        return maxLength;
    }
}
