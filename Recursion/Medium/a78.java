package Medium;

import java.util.ArrayList;
import java.util.List;

public class a78 {
    //we are going to use striever picking and not picking pattern
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        pickingNotPickingUsingBit(nums, 0, output);
        return output;
    }
    //using bit manipulation
    public List<List<Integer>>  pickingNotPickingUsingBit(int nums[],int index, List<List<Integer>> output){
        int n = nums.length;
        for(int num =0;num<(1<<n);num++){
            List<Integer> bucket = new ArrayList<>();
            for(int i=0;i<n;i++){
                //we need to find, if ith bit is set or not
                //if set then add the answer
                if((num & (1<<i)) != 0){
                    bucket.add(nums[i]);
                }
            }
            // if(bucket.size() > 0){
                output.add(bucket);
            // }go
        }
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
