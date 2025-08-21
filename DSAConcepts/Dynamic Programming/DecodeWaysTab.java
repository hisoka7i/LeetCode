package DSAConcepts.DynamicProgramming.Tabulation;

public class DecodeWaysTab {
    public static void main(String[] args) {
        DecodeWaysTab dt = new DecodeWaysTab();
        dt.numDecodings("226");
    }
    public int numDecodings(String s) {
        int n = s.length();
        if(n < 2)return n;

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(n) != '0' ? 1:0;

        for(int i = 2; i<=n;i++){
            char c1 = s.charAt(i - 1); 
            char c0 = s.charAt(i - 2);

            if(c1 != '0')dp[i] += dp[i-1];

            int two = (c0 - '0')*10 + (c1 - '0');
            if(two >= 10 && two <= 26)dp[i] += dp[i-2];
        }
        return dp[n];
    }
}
