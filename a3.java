import java.util.HashSet;
import java.util.Set;

public class a3 {
    public static void main(String[] args) {
        lengthOfLongestSubstring("abccccabcd");
    }
    //we are using method of sliding window in this question
    public static int lengthOfLongestSubstring(String s) {
        Set<Character>set=new HashSet<>();
        int maxLength=0;
        int left=0;
        for(int right=0;right<s.length();right++){
           //if character is unique in subarray then add
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLength=Math.max(maxLength,right-left+1);
                
            }
            //if repeating character is found in array.
            else{
                System.out.println(right);
                //to clean the window till charcter on the right pointer is found
                //we move the left pointer forward
                while(s.charAt(left)!=s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                //we remove the duplicate character. and move the left pointer forward
                set.remove(s.charAt(left));left++;
                System.out.println(set);
                set.add(s.charAt(right));
                System.out.println(set);
            }
            
        }
        return maxLength;
    }
}
