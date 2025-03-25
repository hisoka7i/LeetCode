package Revision.BinarySearch.Medium;

public class a33 {
    public static void main(String[] args) {
        a33 a = new a33();
        a.search(new int[]{5,1,3}, 5);
    }
    public int search(int[] nums, int target) {
        int out = searchInd(nums, target, 0, nums.length - 1);
        return out;
    }

    // public int search
    public int searchInd(int[] nums, int target, int l, int r){
        if(l > r){
            return -1;
        }
        int mid = l + (r-l)/2;
        if(nums[mid] == target)return mid;
        if(nums[l] <= nums[mid]){
            //this means left is sorted
            if(nums[l] <= target && target <= nums[mid] ){
                //this means target lies in this
                return searchInd(nums, target, l, mid - 1);
            }else{
                //this means that target  
                return searchInd(nums, target, mid + 1, r);
            }
        }else{
            //means right is sorted
            if(nums[mid] <= target && target <= nums[r] ){
                //this means target lies in this
                return searchInd(nums, target, mid + 1, r);
            }else{
                return searchInd(nums, target, l, mid - 1);
            }
        }
    }
}
