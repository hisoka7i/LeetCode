import java.lang.reflect.Array;
import java.util.Arrays;

public class EditDistance {

    //using brute force approach
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m+1][n+1];
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }
        return helper_memo_function(word1, word2, m, n, memo);
    }
    public int helper_brute_force(String s, String r, int m , int n){
        if (m == 0) return n;
        if(n == 0)return m; //this means that the all the remaining needs to be added or changes. Difference

        if( s.charAt(m-1) == r.charAt(n-1))
            return helper_brute_force(s, r, m-1, n-1);

            return 1+Math.min( Math.min(helper_brute_force(s, r, m-1, n), helper_brute_force(s, r, m, n-1)), helper_brute_force(s, r, m-1, n-1));
    }

    //solving the same question using memoisation
    public int helper_memo_function(String s, String r, int m, int n, int[][] memo){
        if(m == 0)return n;
        if(n == 0)return m;
        if(memo[m][n] != -1)return memo[m][n];
        if(s.charAt(m-1) == r.charAt(n-1)){
            return memo[m][n] = helper_memo_function(s, r, m-1, n-1, memo);
        }

        return memo[m][n] = 1 + Math.min(
            Math.min(helper_memo_function(s, r, m-1, n, memo), helper_memo_function(s, r, m, n-1, memo)), helper_memo_function(s, r, m-1, n-1, memo));
    }
}
