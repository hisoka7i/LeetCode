public class a3355 {
    //did it all by myself
    public boolean isZeroArray(int[] nums, int[][] queries) {
        //prefix sum of queries
        int[] diff_array = new int[nums.length + 1];
        for(int[] query: queries){
            diff_array[query[0]] += 1;
            diff_array[query[1] + 1] -= 1;
        } // creating a difference array
        int prefix_sum = 0;
        for(int i=0;i<nums.length;i++){
            prefix_sum += diff_array[i];
            if(nums[i] > prefix_sum){
                return false;
            }
        }
        return true;
    }
}
