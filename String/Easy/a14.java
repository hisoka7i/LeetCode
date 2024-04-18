import java.util.Arrays;

public class a14 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight","flee"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i=0;i<strs.length;i++){
            //if word is present then next statement will not work
            while(strs[i].indexOf(prefix)!=0){
                //if we donot find the prefix word in it
                //then we will cut short the word by one index
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }
}
