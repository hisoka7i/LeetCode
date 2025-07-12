public class SearchInRotatedArray {
   public int search(int[] nums, int target) {
        int answer = helperFunction(nums, target, 0, nums.length-1);
        return answer;
    }
    public int helperFunction(int nums[], int target, int l, int r){
        if( l > r){
            return  -1;
        }

        int m = l + (r - l)/2;

        if (nums[m] == target){
            return m;
        }
        if(nums[l] <= nums[m]){
            //this means that the left half is sorted
            if(nums[l] <= target && target <= nums[m]){
                return helperFunction(nums, target, l, m-1);
            }
            return helperFunction(nums, target, m + 1, r);
        }else{
            if(nums[m] <= target && target <= nums[r]){
                return helperFunction(nums, target, m + 1, r);
            }
            return helperFunction(nums, target, l, m-1);
        }
    }
}
