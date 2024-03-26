public class SplitArray_a410{
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
         System.out.println(splitArray(nums, 2));
    }
    //This question is similar to painter's partition
    /*Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

    Return the minimized largest sum of the split. */
    //Question is of type min(max)
    //similar to allocate books problem
    //sub array means contagious
    public static int splitArray(int[] nums, int k) {
        int n = nums.length;
        if(k>n)
            return -1;
        
        int low = Integer.MIN_VALUE;
        int high = 0;

        for(int i:nums){
            high += i;
            if(i>low)low=i;
        }

        while(low<=high){
            int mid = low + (high-low)/2;
            int splits = CountSplits(nums, mid);
            if(splits>k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
    public static int CountSplits(int[] nums,int min){
        int n = nums.length;
        int splits = 1;
        long currentSplits = 0;
        for(int i=0;i<n;i++){
            if(currentSplits + nums[i]<=min){
                currentSplits += nums[i];
            }else{
                splits++;
                currentSplits = nums[i];
            }
        }
        return splits;
    }
}