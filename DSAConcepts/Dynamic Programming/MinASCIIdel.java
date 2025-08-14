import java.util.Arrays;

public class MinASCIIdel {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        for(int[] row: memo)Arrays.fill(row, -1);
        return helper_function_memo(s1, s2, 0, 0, memo);
    }
    public int helper_function(String s1, String s2, int m, int n){
        if(m >= s1.length() && n >= s2.length())return 0;
        if(m >= s1.length()){
            int sum = 0;
            for (int i = n; i < s2.length(); i++) sum += s2.charAt(i);
            return sum;
        }

        if(n >= s2.length()){
            int sum = 0;
            for (int i = m; i < s1.length(); i++) sum += s1.charAt(i);

            return sum;
        }

        if(s1.charAt(m) == s2.charAt(n)){
            return helper_function(s1, s2, m + 1, n + 1); 
        }

        return Math.min((s1.charAt(m) + helper_function(s1, s2, m+1, n)),
        s2.charAt(n) + helper_function(s1, s2, m, n+1)
        );
    }

    public int helper_function_memo(String s1, String s2, int m, int n, int[][] memo){
        if(m >= s1.length() && n >= s2.length())return 0;
        if(memo[m][n] != -1)return memo[m][n];
        if(m >= s1.length()){
            int sum = 0;
            for (int i = n; i < s2.length(); i++) sum += s2.charAt(i);
            memo[m][n] = sum;
            return sum;
        }

        if(n >= s2.length()){
            int sum = 0;
            for (int i = m; i < s1.length(); i++) sum += s1.charAt(i);
            memo[m][n] = sum;
            return sum;
        }

        if(s1.charAt(m) == s2.charAt(n)){
            memo[m][n] = helper_function_memo(s1, s2, m + 1, n + 1, memo); 
            return memo[m][n];
        }

        memo[m][n] = Math.min(s1.charAt(m) +helper_function_memo(s1, s2, m+1, n, memo)
        , s2.charAt(n) +helper_function_memo(s1, s2, m, n+1, memo));

        return memo[m][n];

    }
}
