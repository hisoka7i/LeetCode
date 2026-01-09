import java.util.Arrays;

public class CountPalindromicSubStrings {
    public static void main(String[] args) {
        CountPalindromicSubStrings cp = new CountPalindromicSubStrings();
        System.out.println(cp.countSubstrings("aaa"));
    }
    public int countSubstrings(String s) {
        return helper_function(s, 0, 0);
    }

    public int helper_function(String s, int i, int j){
        // if(i > j)return 0;
        if( i  == s.length() || j == s.length())return 0;
        int count = isPalidrome(s, i, j) ? 1 : 0 + helper_function(s, i +1, j);
        count += helper_function(s, i, j+1);
        return count;
    }

    public boolean isPalidrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }

    public int helper_function_leetcode(String s){
        int count = 0;
        for(int i = 0; i<s.length();i++){
            count += palindrome_count(s, i, i) + palindrome_count(s, i, i+1);
        }
        return count;
    }

    public int palindrome_count(String s, int i, int j){
        int count = 0;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            count++;
            i--;
            j++;
        }
        return count;
    }

    public int helper_function_interval(String s){
        int[] dp = new int[s.length()+1];
        for(int i = 0; i< s.length(); i++){
            int l = i;
            int r = i;
            while(l >= 0 && r < s.length()){
                if(s.charAt(l) == s.charAt(r)){dp[i]++;
                l--;
                r++;}
                break;
            }
        }

        return Arrays.stream(dp).sum();
    }

}
