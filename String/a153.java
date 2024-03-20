public class a153 {
    public static void main(String[] args) {
        
    }
    public static int minimum(int[] nums){
        int min = Integer.MAX_VALUE;
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[low]<=nums[mid]){
                //This condition executes means ki left half is sorted
                if(nums[low]<min)min=nums[low];
                //now we will trim the left half 
                low = mid + 1;
            }else{
                //this means ki right half is sorted
                if(nums[mid]<min)min=nums[mid];
                //now we will trim the right half 
                high = mid -1;
            }
        }
        return min;
    }
}
