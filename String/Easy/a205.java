import java.util.HashMap;

public class a205 {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.out.println(isIsomorphic(s, t));
    }
    //So the thing about this question is, Simply replace 
    //the character with another character and make sure that each occurance of that character
    //It is getting replaced by the same character every thing
    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        //in this hashmap we will map the character of string s to character of string t
        HashMap<Character,Character> map1 = new HashMap<>();
        //make check of character of string t
        HashMap<Character,Boolean> map2 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character ch1 = s.charAt(i);
            Character ch2 = t.charAt(i);
            if(map1.containsKey(ch1)){
                if(map1.get(ch1)!=ch2){
                    return false;
                }
            }else{
                if(map2.containsKey(ch2)){
                    return false;
                }else{
                    map1.put(ch1, ch2);
                    map2.put(ch2,true);
                }
            }
        }
        return true;
    }
}
