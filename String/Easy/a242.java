public class a242 {
    public static void main(String[] args) {
        
    }
    //solution using trie data structure
    public static boolean isAnagram(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        int[] trie = new int[26];
        //we are adding and decreasing the count at the same time
        for(int i=0;i<s.length();i++){
            trie[s.charAt(i)-'a']++;
            trie[t.charAt(i)-'a']--;
        }
        //in the end the count should be 0 through out 
        //for it to be true
        for(int i=0;i<trie.length;i++){
            if(trie[i]!=0)
                return false;
        }
        return true;
    }
}
