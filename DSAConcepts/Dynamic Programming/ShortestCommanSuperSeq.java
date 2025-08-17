public class ShortestCommanSuperSeq {
    public String shortestCommonSupersequence2(String str1, String str2) {
        int length = helper_function(str1, str2, 0, 0);
        //now using the window we can find the i and j
        int i = 0;
        int j = length;

        int max = Math.max(str1.length(), str2.length());
        while(j < max){
            if(str1.charAt(i) == str2.charAt(i) && str1.charAt(j) == str2.charAt(j)){
                int mid = (j + i)/2;
                if(str1.charAt(mid) == str2.charAt(mid))break;
            }
            i++;
            j++;
        }
        //now simply remove the duplicate
    }

    //find the longest command subseq.
    public int helper_function(String s1,String s2, int i, int j){
        if(i == s1.length() || j == s2.length())return 0;

        if(s1.charAt(i) == s2.charAt(j)){
            return 1 + helper_function(s1, s2, i + 1, j + 1);
        }else{
            return Math.max(helper_function(s1, s2, i + 1, j), helper_function(s1, s2, i, j + 1));
        }
    }

     public String shortestCommonSupersequence(String str1, String str2) {
        int length = Math.max(str1.length(), str2.length());
        String[][] memo = new String[length+1][length+1];
        return buildSCSmemo(str1, str2, 0, 0,memo);
    }

   

    // Recursively create the SCS string
    private String buildSCSmemo(String s1, String s2, int i, int j,String[][] memo){
        if(i == s1.length() && j == s2.length()) return "";
        if(i == s1.length()) return s2.substring(j);
        if(j == s2.length()) return s1.substring(i);

        if(memo[i][j] != null)return memo[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            // If chars match, include it only once
            memo[i][j] =  s1.charAt(i) + buildSCSmemo(s1, s2, i + 1, j + 1, memo);
            return memo[i][j];
        }else{
            // Try both options and pick the shorter
            String option1 = s1.charAt(i) + buildSCSmemo(s1, s2, i + 1, j, memo);
            String option2 = s2.charAt(j) + buildSCSmemo(s1, s2, i, j + 1, memo);
            memo[i][j] = option1.length() < option2.length() ? option1 : option2;
            return memo[i][j];
        }
    }
}
