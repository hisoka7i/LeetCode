import java.util.HashSet;
import java.util.Set;

public class a3355 {

    public boolean isZeroArray_BruteForce_Working(int[] nums, int[][] queries) {
        //a data structure to keep all the zeros
        Set<Integer> zeroIndexs = new HashSet<>();
        for(int[] query: queries){
            int left = query[0];
            int right = query[1];
            while(left<=right){
                if(zeroIndexs.contains(left)){
                    left++;
                    continue;
                }
                if(nums[left] == 0){
                    zeroIndexs.add(left);
                }
                nums[left] -= 1;
                if(nums[left] == 0)
                    zeroIndexs.add(left);
                left++;
            }
        }
        return zeroIndexs.size() == nums.length;   
    }

    //using line sweep algorithm
    public boolean isZeroArray(int[] nums, int[][] queries){
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
}
