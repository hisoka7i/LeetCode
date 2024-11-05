package GreedyAlgorithm.Medium;

public class a55 {
    public boolean canJump(int[] nums) {
        //ye h ki maximum jump hum log kitne le skte hain.
        int maxReach = 0;
        for(int i=0;i<nums.length;i++){
            if(maxReach < i){
                //iska meaning hai ki uss index tk ki jump nhi ho skti
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}
