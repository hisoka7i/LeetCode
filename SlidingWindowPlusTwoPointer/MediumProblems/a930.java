package MediumProblems;

public class a930 {
    public static void main(String[] args) {
        
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        //we will find all the sums which are less or equal to goal
        //we will find all the sums which are less or equal to goal - 1
        //and we will simple subtract them
        //which in  turn give us, sum which are equal to goal
        return (helper(nums, goal)-helper(nums, goal-1));
    }
    //here we will try to find all the elements or sub arrays 
    //who's sum is less than the goal
    public static int helper(int[] nums, int goal) {
        int l =0, r =0, sum =0, count =0;
        if(goal<0) return 0;
        while(r<nums.length){
            sum += nums[r];
            while(sum>goal){
                //we will shrink the sum if this happens
                sum = sum - nums[l];
                //we will increase the left 
                l++;
            }
            //this count is the number of sub arrays which are less than 
            //or equal to goal
            count += (r-l+1);
            r++;
        }
        return count;
    }
}
