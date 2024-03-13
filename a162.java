public class a162 {
    public static void main(String[] args) {
        
    }
    public static int findPeakElement(int[] nums) {
        if(nums.length==1)return 0;
        //logic in the question
        //first we will check if the first element is greater then 2nd element 
        //This means it is a peak, sinnce element at -1 is - infinity 
        if(nums[0]>nums[1])return 0;

        int n = nums.length;

        //For the last element,
        //we will do the same thing, we will check if the last element is greater than the second last

        if(nums[n-1]>nums[n-2])return n-1;

        //performing the binary search for the remaining part
        //we are not checking for the first or the last
        //because we have already checked those 2
        int low=1, high = n-2;
        //we can do low = 0 and high = n-1, but then it will go array out of bound at (mid-1) check,
        while(low<=high){
            int mid = low + (high-low)/2;
            //we will check if mid is peak
            if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1])return mid;

            //otherwise we will check wheather mid is present on the increasing half
            //if true then remove that increasing half
            //since the peak will lie on the other half
            if(nums[mid]>nums[mid-1]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}
