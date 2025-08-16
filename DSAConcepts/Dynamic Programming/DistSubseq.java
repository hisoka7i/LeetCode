
import java.util.Arrays;

public class DistSubseq {
    public int numDistinct(String s, String t) {
        // return helper_function(s, t, s.length()-1, t.length()-1);
        int[][] memo = new int[s.length()+1][t.length()+1];
        for(int[] row: memo)Arrays.fill(row, -1);
        return helper_function_memo(s, t, s.length()-1, t.length()-1, memo);
    }
    public int helper_function(String s, String t, int i, int j){
        if(j < 0)return  1;
        if(i < 0)return 0;
        

        int count = 0;
        if(s.charAt(i) == t.charAt(j)){
            count += helper_function(s, t, i-1, j-1);
        }

        count += helper_function(s, t, i-1, j);
        return count;
    }

    public int helper_function_memo(String s,String t, int i,int j, int[][] memo){
        if(j < 0)return 1;
        if(i < 0)return 0;

        if(memo[i][j] != -1)return memo[i][j];

        int count = 0;
        if(s.charAt(i) == t.charAt(j)){
            count += helper_function_memo(s, t, i-1, j-1, memo);
        }

        count += helper_function_memo(s, t, i-1, j, memo);
        memo[i][j] = count;
        return  count;
    }
}
