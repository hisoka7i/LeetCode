package BinarySearch.PracticeChallenge;

public class a300 {
    //Longest Increasing Subsequence
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
    }
    public static int lengthOfLIS(int[] nums) {
        int[] longestSub = new int[nums.length];
        int size = 0;
        for(int currentNumber: nums){
            int left = 0;
            int right = size;
            //finding the lower bound

            //This method is good at overwrite lower bound adding greater number 
            //into the longestSub
            while(left!=right){
                int mid = left + (right-left)/2;
                if(longestSub[mid]<currentNumber){
                    left = mid + 1;
                }else{
                    //dry run this code to under stand this 
                    right = mid ;
                }
            }
            longestSub[right] = currentNumber;
            if(right == size) size++;
        }
        return size;
    }
}
