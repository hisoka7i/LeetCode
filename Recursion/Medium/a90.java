package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> bucket = new ArrayList<>();
        helperFunction(nums, 0, result, bucket);
        return result;
    }
    public void helperFunction(int[] nums, int index, List<List<Integer>> result,List<Integer> bucket){
        if(index == nums.length){
            if(!result.contains(bucket))
                result.add(new ArrayList<>(bucket));
            return;
        }

        //picking part 
        bucket.add(nums[index]);
        helperFunction(nums, index+1, result, bucket);

        //not picking part
        bucket.remove(bucket.size()-1);
        helperFunction(nums, index+1, result, bucket);
    }
}
