class Solution {
    public int search(int[] nums, int target) {
        return search1(nums,target,0,nums.length-1);
    }
    static int search1(int[] nums, int target, int s, int e){
        if(s>e){
            return -1;
        }
        int m = s + (e-s)/2;
        if (nums[m]==target){
            return m;
        }

        if(nums[s]<=nums[m]){ //checking if the first half is sorted or not
            if(target>=nums[s] && target<=nums[m]){
              //checking if target is in first half or not
                return search1(nums,target,s,m-1);
            }
            else{
              //in case target is in 2nd half.
                return search1(nums,target,m+1,e);
            }
        }
        //checking if target is in second half.
        if(target >= nums[m] && target<=nums[e]){
            return search1(nums,target,m+1,e);
        }
        //suppose we need to search 6 in 5,6,1,2,3,4. In this case.
        return search1(nums,target,s,m-1);
    }
}
