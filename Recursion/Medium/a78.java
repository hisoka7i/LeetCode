package Medium;

import java.util.ArrayList;
import java.util.List;

public class a78 {
    //we are going to use striever picking and not picking pattern
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> bucket = new ArrayList<>();
        pickingNotPicking(nums, 0, output, bucket);
        return output;
    }
    public void pickingNotPicking(int nums[],int index, List<List<Integer>> output, List<Integer> bucket){
        if(index == nums.length){
            //base condition
            output.add(new ArrayList<Integer>(bucket));
        }

        //here we are writing the picking part
        bucket.add(nums[index]);
        pickingNotPicking(nums, index+1, output, bucket);

        bucket.remove(bucket.size()-1);
        pickingNotPicking(nums, index+1, output, bucket);
    }
}
