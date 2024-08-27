package ArrayQuestions.2Pointers.SimilarQuestions;

public class RemoveKDuplicate {
    //similar to leetcode question 80 
    //Given a sorted array, remove duplicates such that each element can appear at most k times.
    public void KDuplicatesRemoved(int[] nums, int k){
        //taking the starting index as k
        int index = k;
        if(nums.length <= k)return;
        
        for(int i=k;i<nums.length;i++){
            if(nums[index - k] != nums[i]){
                //we will simply push them forward 
                nums[index++] = nums[i];
            }
        }
    }
}
