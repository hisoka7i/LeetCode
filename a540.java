public class a540 {
    public static void main(String[] args) {
        
    }   
    public static int singleNonDuplicate(int[] nums) {
        //first checking the edge case 
        if(nums.length==1)return nums[0];
        int n = nums.length;
        //moving a left pointer forward by single step and moving the right pointer 
        //backward with single step. since 1st 2 duplicates and last 2 duplicates
        //{1,1,2,2,3,4,4} 
        //but also check if first or last are not the duplicate index
        if(nums[0]!=nums[1])return nums[0];
        if(nums[n-1]!=nums[n-2])return nums[n-1];
        int low = 1, high = n-2;
        //logic in the question is that left of the single element will have, (even,odd) index as same value
        //and right of the single element will always have (odd,even) as the same value
        //on this check basis we will, eliminate left or right half
        while(low<=high){
            int mid = low + (high-low)/2;

            //check if the mid is not the single element 
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])return nums[mid];
            //now writing the elimination part
            //checking if we are on the left half
            //2 ways to check if we are standing on even index and we match the next odd
            //we standing on odd index and we match the prev even index 
            if(((mid%2)==1 && (nums[mid]==nums[mid-1]))|| ((mid%2==0)&& (nums[mid]==nums[mid+1]))){
                //If this check pass this means that we are on the left half 
                //and we need to remove this left half 
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    } 
}
