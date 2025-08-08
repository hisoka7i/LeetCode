import java.util.Arrays;

public class SolvingBrainPower {
     public long mostPoints(int[][] questions) {
        long[] memo = new long[questions.length+1];
        Arrays.fill(memo, -1);
        return helper_function_memoised(0, questions, memo);
    }

    //solved all by myself
    public long helper_function(int i, int[][] questions){
        if(i >= questions.length)return 0;

        long current_count = questions[i][0] + helper_function(i + questions[i][1] + 1, questions);

        long next_count = helper_function(i+1, questions);
        
        return Math.max(next_count, current_count);
    }

    public long helper_function_memoised(int i, int[][] questions, long[] memo){
        if(i >= questions.length)return 0;
        if(memo[i] != -1)return memo[i];

        long current_count = questions[i][0] + helper_function_memoised(i + questions[i][1] + 1, questions, memo);

        long next_count = helper_function_memoised(i+1, questions, memo);
        
        memo[i] = Math.max(next_count, current_count);
        return memo[i];
    }
}
