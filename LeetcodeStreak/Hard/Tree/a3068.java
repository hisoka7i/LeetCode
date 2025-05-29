package LeetcodeStreak.Hard.Tree;

public class a3068 {

    //this was a solution provided by youtuber I wasted half an hour on this, what a waste
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        long minDifference = Long.MAX_VALUE;
        long totalDifference = 0;
        int positiveCount = 0;
        for(int num: nums){
            long difference = (num^k) - num;
            if (difference > 0) {
                totalDifference += difference;
                positiveCount++;
            } 
            minDifference = Math.min(minDifference,  Math.abs(difference));
        }
        if(positiveCount%2 == 1){
            totalDifference -= minDifference;
        }
        return total + totalDifference;
    }
}
