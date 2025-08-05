import java.util.Arrays;

public class LongestPalindrome {
    public String brute_force(String sample){
        int n = sample.length();
        char[] sample_array = sample.toCharArray();
        int min_i = 0;
        int max_j = 0;
        int[][] memo = new int[n+1][n+1];
        for(int[] m: memo)Arrays.fill(m, -1);
        for(int i = 0 ; i < n - 1; i++){
            int j = n - 1;
            while(i < j){
                if(memo[i][j] != -1)continue;
                if(isPalindrome(sample_array, i, j)){
                    if(j - i + 1 > max_j - min_i + 1){
                        min_i = i;
                        max_j = j;
                        memo[i][j] = 0;
                    }
                }
                j--;
            }
        }

        return sample.substring(min_i, max_j+1);
    }
    public boolean isPalindrome(char[] sample, int i, int j){
        while(i < j ){
            if(sample[i++] != sample[j--])return false;
        }
        return true;
    }
}
