package ArrayQuestions.PracticeQuestions;

import java.util.ArrayList;
import java.util.List;

public class a2089 {
    public static void main(String[] args) {
        
    }
    public static List<Integer> targetIndices(int[] nums, int target) {
        int low = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                count++;
            }else if(nums[i]<target){
                low++;
            }
        }
        List<Integer> output = new ArrayList<>();
        for(int i=0;i<count;i++){
            //since indexes should be added in order of sorted array
            output.add(low+i);
        }
        return output;
    }
}
