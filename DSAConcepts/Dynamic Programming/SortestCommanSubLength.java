public class SortestCommanSubLength {
    public String shortestCommonSupersequence(String str1, String str2) {
         helper_function(str1.length(), str2.length(), str1, str2);
    }
    public int helper_function(int m, int n, String str1, String str2){
        if(m == 0){
            return n; //we have to return the remaining
        }
        if(n == 0){
            return m;
        }

        if(str1.charAt(m-1) == str2.charAt(n-1)){
            return 1 + helper_function(m-1, n-1, str1, str2);
        }
        else{
            return 1 + Math.min(helper_function(m-1, n, str1, str2),
            helper_function(m, n-1, str1, str2));
        }
    }
}
