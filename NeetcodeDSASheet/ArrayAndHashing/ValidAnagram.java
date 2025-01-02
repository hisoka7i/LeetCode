package NeetcodeDSASheet.ArrayAndHashing;

public class ValidAnagram {
    public boolean isValidAnagram(String s, String t){
        if(s.length() != t.length())return false;

        //solving this question using trie
        int[] trie = new int[26];
        for(int i=0;i<s.length();i++){
            trie[s.charAt(i) - 'a']++;
            trie[t.charAt(i) - 'a']--;
        }

        for(int i=0;i<s.length();i++){
            if(trie[s.charAt(i) - 'a']!=0 || trie[t.charAt(i) - 'a']!=0){
                return false;
            }
        }

        return true;
    }
}
