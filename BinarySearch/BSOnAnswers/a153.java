package BinarySearch.BSOnAnswers;

public class a153 {
    public static void main(String[] args) {
        a153 a = new a153();
        int[] sample = {2,3,4,5,1};
        a.findMin(sample);
    }
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int n = nums.length - 1;
        int min = 0;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            // finding the infliction point
            if (mid + 1 < nums.length)
                if (nums[mid] > nums[mid + 1]) {
                    return nums[mid+1];
                }
            if(mid - 1 >= 0)
            if(nums[mid - 1] > nums[mid]){
                return nums[mid];
            }

            //now search in right if last element is less than mid
            if(nums[n]<nums[mid]){
                //go left
                s = mid+1;
            }
            else{
                e = mid -1;
            }
        }
        return nums[0];
    }
}
