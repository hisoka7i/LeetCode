package MediumProblems;

public class a1248 {
    public static void main(String[] args) {
        
    }
    //Count Number of Nice Subarrays
    public static int numberOfSubarrays(int[] nums, int k) {
        return helperFunction(nums, k) - helperFunction(nums, k-1);
    }
    public static int helperFunction(int[] nums,int k){
        int count = 0, l = 0, r = 0, sum = 0;
        if(k<0) return 0;
        while(r<nums.length){
            sum += nums[r]%2;
            while(sum > k ){
                //we are decrementing the sum
                //frm left
                sum -= nums[l]%2;
                l++;
            }
            //we need to determine the number of subarrays int the array
            count += (r-l+1);
            r++;
        }
        //now we will return the count of subarrays 
        return count;
    }
}
