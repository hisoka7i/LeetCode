class a83{
    public static void main(String[] args){

    }
    public static boolean search(int[] nums, int target){
        int low=0, high=nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target)return true;
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low++;
                high--;
                continue;
            }
            if(nums[low]<=nums[mid]){//checking if this half is sorted
                if(target<=nums[mid] && target>=nums[low]){
                    //means the target is in left sorted half
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(target<=nums[high] && target>=nums[mid]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}