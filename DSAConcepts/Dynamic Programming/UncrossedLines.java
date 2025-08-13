import java.util.Arrays;

public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length > nums2.length ? nums1.length : nums2.length;
        int[][] memo = new int[n+1][n+1];
        for(int[] row: memo)Arrays.fill(row, -1);
        return helper_function_memo(nums1, nums2, 0, 0, memo);
    }
    public int helper_function(int[] num1, int[] num2, int i, int j,boolean check){
        if( i>= num1.length)return 0;
        if( j >= num2.length)return 0;

        if(num1[i] == num2[j])return (1+helper_function(num1, num2, i+1, j+1, check));

        return Math.max(helper_function(num1, num2, i+1, j, true), 
        helper_function(num1, num2, i, j+1, false));
    }
    public int helper_function_memo(int[] n1, int[] n2, int i, int j, int[][] memo){
        if( i>= n1.length)return 0;
        if( j >= n2.length)return 0;

        if(memo[i][j] != -1)return memo[i][j];

        if(n1[i] == n2[j])return (1+helper_function_memo(n1, n2, i+1, j+1, memo));

        memo[i][j] =  Math.max(helper_function_memo(n1, n2, i+1, j, memo), 
        helper_function_memo(n1, n2, i, j+1, memo));
        return memo[i][j];
    }
}
