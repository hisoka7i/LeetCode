package GreedyAlgorithm.Medium;
public class a45 {
    public int jump(int[] nums) {
        int jump = 0;
        int farthest = 0;
        int left = 0, right = 0;

        while(right < nums.length-1){
            for(;left<right;left++)
            //since we check checking from the left, where is the maximum distance that we can do
                farthest = Math.max(left + nums[left], right);
            left = right + 1;
            right = farthest;
            jump++;
        }
        return jump;
    }
}
