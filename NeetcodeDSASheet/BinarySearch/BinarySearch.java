package NeetcodeDSASheet.BinarySearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[mid] > target){
                //this means that we are on the right side 
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
