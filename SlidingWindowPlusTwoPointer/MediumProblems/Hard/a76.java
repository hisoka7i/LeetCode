package MediumProblems.Hard;

public class a76 {
    /*
     * 76. Minimum Window Substring
Given two strings s and t of lengths m and n respectively, return the minimum window 
substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.
    */
    public String minWindow(String s, String t) {
        //We will make a hashmap for string t
        //now we will iterate through string s, and we will check, if we have 
        //the character in it or not, if the character is not present then
        //add it into the hashmap and with a negative count

        //we will also maintain a count variable, which will be used for comparison with the size of string t

        //one we have count number, which is matching with size of string t. 
        //we will start to move left pointer forward, and from the hashmap we will remove the entry. 

        //once the entry of a character, which is also present in string t until it becomes 1 . 

        //Now we can check by moving the right pointer forward, if the count is still valid.
        if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }

        int[] hashmap = new int[128];
        int l = 0, r = 0, min_value = Integer.MAX_VALUE, count = t.length();
        int startIndex = 0, n = s.length(), m = t.length();

        //here we will iterate through the string t, and we will fill the hashmap
        for(char current_character_t: t.toCharArray()){
            hashmap[current_character_t]++;
        }
        char[] character_array_s = s.toCharArray();

        //now we will iterate through the string s
        while(r<n){
            //we will decrement the value of the character in the hashmap
            if(hashmap[character_array_s[r++]]-- >0){
                //This condition means that we have this character present in string t as well
                //so now, we will decrement our count
                count -= 1;   
            }
           
            
            //This condition will be used to shrink the size of the output string, while maintaining the intial condition
            while(count == 0){
                if(r - l <min_value){
                    min_value = r - l ;
                    startIndex = l;
                }
                //we will incement the left pointer
                if(hashmap[character_array_s[l++]]++ == 0)count = count+1;
            }
        }
        return min_value == Integer.MAX_VALUE?"":new String(character_array_s,startIndex, min_value);
    }
}
