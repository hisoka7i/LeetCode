package BinarySearch.PracticeChallenge;

public class a2540 {
    public static void main(String[] args) {
        
    }
    //we will use two pointers here
    public static int getCommon(int[] nums1, int[] nums2) {
        //first we will check if
        if(nums1[0]>nums2[nums2.length-1] || nums2[0]>nums1[nums1.length-1])
            return -1;
        if(nums1[0]==nums2[nums2.length-1] || nums2[0]==nums1[nums1.length-1])
            return (nums1[0]==nums2[nums2.length-1]?nums1[0]:nums2[0]);
        
        int i=0,j=0;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i]>nums2[j]){
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else{
                return nums1[i];
            }
        }
        return -1;
    }
    //This is binary search approach
    public static int getCommon2(int[] nums1, int[] nums2) {
        if (nums1.length<nums2.length)
            return getCommon2(nums2, nums1);
        //we will iterate through 1st array
        for(int i=0;i<nums2.length;i++){
            //we will binary search the second array;
            int l=0;
            int r=nums1.length-1;
            while (l<=r) {
                int mid = l + (r-l)/2;
                if(nums1[mid]==nums2[i])
                    return nums1[mid];
                else if(nums1[mid]>nums2[i]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
