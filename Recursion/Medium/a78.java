package Medium;

import java.util.ArrayList;
import java.util.List;

public class a78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        helperFunction(result, subset, 0, nums);
        return result;
    }

    public void helperFunction(List<List<Integer>> result, List<Integer> subset, int index,int[] nums){
        if(index == nums.length){
            result.add(subset);
            return;
        }

        subset.add(nums[index]);
        helperFunction(result, subset, index+1, nums);

        subset.remove(nums[index-1]);
        helperFunction(result, subset, index+1, nums);
    }
}
