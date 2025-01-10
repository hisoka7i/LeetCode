package NeetcodeDSASheet.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        //we are not going to the last element since there are 3 pointers
        for(int i=0;i<n-2;i++){
            //This is duplicate checking
            if(i!=0 && nums[i-1] == nums[i])
                continue;
            
            int j = i + 1; //this will be our second pointer
            int k = n - 1; //this will be out third pointer

            while(j < k){
                int value = nums[i]  + nums[j] + nums[k];

                if(value > 0){
                    k--;
                }
                else if(value < 0){
                    j++;
                }else{
                    //that means we have met the condition
                    output.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;

                    //removing the duplicates
                    while(j<k && nums[j-1] == nums[j])j++;
                    while(j<k && nums[k] == nums[k+1])k--;
                }
            }
        }
        return output;
    }
}
