public class a2529{
    //need to find first number whichh is greater than or equals 0
    // if middle s positive then move left
    public static int maximumCount(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(nums[m] >= 0){
                //this means we can look in left to see if there is positive on the left
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        int negatives = r == -1?0:r+1;
        int cZeros = 0;
        while(l>=0 && l<nums.length){
            if(nums[l] == 0){
                cZeros++;
            }else
                break;
            l++;
        }
        int positives = (nums.length - cZeros - negatives);
        return Math.max(negatives, positives);
    }
    public static void main(String[] args){
        // int[] sampple = {-3,-2,-1,0,0,1,2};
        int[] sampple = {0,0};
        System.out.println(maximumCount(sampple));
        ;
    }
}