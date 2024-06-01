package ArrayQuestions

import java.util.ArrayList;
import java.util.List;

.2Pointers;

public class a821 {
    public static void main(String[] args) {
        
    }
    public static int[] shortestToChar(String s, char c) {
        //step 1. to get the closest distance, we will 
        //find the min distance, with respect to left and right character
        //since at the very extremes this method, will not work, so we will assume 
        //one character at very extreme of each, list on the left and right

        List<Integer> indexes = new ArrayList<>();
        indexes.add(Integer.MIN_VALUE);
        

        for(int i=0;i<s.length();i++){
            //
            if(s.charAt(i)==c){
                indexes.add(i);
            }
        }
        //This will come at the very end.
        indexes.add(Integer.MAX_VALUE);

        //taking 2 pointer approach here
        int ptr1 = indexes.get(0);
        int ptr2 = indexes.get(1);
        //This is to iterate through the list
        int k = 2;
        //creating a result array 
        int[] result = new int[s.length()];
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i)!=c){
                result[i] = Math.min(ptr1-i,ptr2-i);
            }else{
                result[i] = 0;
                ptr1 = ptr2;
                k++;
                ptr2 = indexes.get(k);
            }
        }
        return result;
    }
}
