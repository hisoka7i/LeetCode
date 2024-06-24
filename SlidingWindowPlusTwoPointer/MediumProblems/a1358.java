package MediumProblems;

import java.util.Arrays;

public class a1358 {
    public static void main(String[] args) {
        
    }
    /*
     * Given a string s consisting only of characters a, b and c.
     Return the number of substrings containing at least one occurrence of all these characters a, b and c.
     */
    public int numberOfSubstrings(String s) {
        //for every character we can find the minimum window

        //we will have a hashmap for a, b and c
        //in hashmap we will have the last seen value 
        
        int[] last_seen = new int[3];
        Arrays.fill(last_seen, -1);

        int count = 0;
        for(int i=0;i<s.length();i++){
            last_seen[s.charAt(i) - 'a'] = i;
            int last = findLast(last_seen);
            /*
             * The line count = count + 1 + last; is crucial for 
             * incrementing the total count of substrings containing all three 
             * characters 'a', 'b', and 'c'. It adds the number of valid 
             * substrings ending at the current character by considering
             *  the minimum index up to which all three characters have been seen.
             */
            count = count + 1 + last;
        }
        return count;
    }
    public int findLast(int[] a)
    {
        int last = Integer.MAX_VALUE;
        for(int i = 0 ; i < a.length ; i++)
            last = Math.min(last , a[i]);
        return last;            
    }
}
