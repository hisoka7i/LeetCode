import java.util.Arrays;

class Solution{
    public int longestPalindromeSubseq(String s) {
        String t = "";
        for(int i = s.length()-1 ; i>=0;i--){
            t += s.charAt(i);
        }
        int[][] memo = new int[s.length()+1][s.length()+1];
        for(int[] row: memo)Arrays.fill(row, -1);
        return helper_function_memo(s, t, s.length()-1, s.length()-1, memo);
    }

    public int helper_function(String s, String t, int i, int j){
        if( i < 0 || j < 0)return 0;
        if(s.charAt(i) == t.charAt(j)){
            return 1 + helper_function(s, t, i - 1, j - 1);
        }else{
            return Math.max(
                helper_function(s, t, i - 1, j),
                helper_function(s, t, i, j - 1)
            );
        }
    }

    public int helper_function_memo(String s, String t, int i, int j, int[][] memo){
        if(i < 0  || j <0)return 0;
        if(memo[i][j] != -1)return memo[i][j];

        if(s.charAt(i) == t.charAt(j)){
            memo[i][j] = 1 + helper_function_memo(s, t, i - 1, j - 1,memo);
        }else{
            memo[i][j] = Math.max(
                helper_function_memo(s, t, i - 1, j, memo),
                helper_function_memo(s, t, i, j -1, memo)
            );
        }
        return memo[i][j];
    }
}