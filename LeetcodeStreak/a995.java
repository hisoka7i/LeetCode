package LeetcodeStreak;

public class a995 {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int result = 0, flipped = 0;
        //This is to keep track of the switches
        int[] isFlipped = new int[n];

        for(int i=0;i<n;i++){
            if(i >= k){
            //This is like saying, "If I'm far enough 
            //along the row of switches, I need to check if I need to adjust my flipping."

            flipped ^= isFlipped[i - k];
            //This is to check k steps back, and to adjust my flipping
            }
            if(flipped == nums[i]){
                //that means the state is matching
                //0 == 0
                if(i + k > n){
                    return -1;
                }
                isFlipped[i] = 1;
                flipped ^= 1;
                result ++;
            }
        }
        return result;
    }
}
