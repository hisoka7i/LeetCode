package PracticeQuestion;

public class a392 {
    public static void main(String[] args) {
        String s = "leeeeetcode";
        System.out.println(isSubsequence(s, t));
        ;
    }
    public static boolean isSubsequence(String s, String t) {
        int s_pointer = 0;
        int p_pointer = 0;
        while(s_pointer<s.length() && p_pointer<t.length()){
            if(s.charAt(s_pointer)==t.charAt(p_pointer)){
                s_pointer++;
            }
            p_pointer++;
        }
        return s_pointer==s.length();
    }

    //This is my approach 
    //I should not have tought like this xP
    public static boolean isSubsequence2(String s, String t) {
        int[] character_set = new int[26];

        for(int i=0;i<t.length();i++){
            character_set[t.charAt(i)-'a'] = i+1;
        }
        int max = 0;
        for(int i=0;i<s.length();i++){
            if(character_set[s.charAt(i)-'a']==0){
                return false;
            }
            if(character_set[s.charAt(i)-'a']<max){
                return false;
            }else{
                max = character_set[s.charAt(i)-'a'];
            }
        }
        return true;
    }
}
