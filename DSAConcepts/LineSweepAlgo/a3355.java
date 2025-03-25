package LineSweepAlgo;
public class a3355 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] sweep = new int[n + 1];
        
        for(int[] query: queries){
            int l = query[0];
            int r = query[1];

            sweep[l] += 1;
            sweep[r+1] -= 1;
        }

        //now making the sweep array
        for(int i=1;i<sweep.length;i++){
            sweep[i] += sweep[i-1];
        }
        
        for(int i=0;i<nums.length;i++){
            if(sweep[i] < nums[i])return false;
        }
        return true;  
    }

    //brute force approach according to me //wrong
    public boolean bForce(int[] nums, int[][] queries){
        int[] sample = new int[nums.length];
        for(int i = 0; i<queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            while(left<=right){
                sample[left] -= 1;
                left++;
            }
        }
        for(int i=0;i<nums.length;i++){
            nums[i] -= sample[i];
            if(nums[i] != 0){
                return false;
            }
        }
        return true;
    }
}

