package PracticeQuestion;

public class a383 {
    public static void main(String[] args) {
        
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] trie = new int[26];

        //This fill maintain count of words in magazine
        for(int i=0;i<magazine.length();i++){
            trie[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            if(trie[ransomNote.charAt(i)-'a']<=0){
                return false;
            }else{
                trie[ransomNote.charAt(i)-'a']--;
            }
        }
        return true;
    }
}
