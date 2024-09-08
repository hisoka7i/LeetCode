package Medium;

import java.util.ArrayList;
import java.util.List;

public class a39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> bucket = new ArrayList<>();
        int sum = 0;
        int index =0;
        pickingNotPicking(candidates, target, index, sum, result, bucket);
        return result;
    }

    
    public void pickingNotPicking(int[] candidates, int target,int index,int sum, List<List<Integer>> result,List<Integer> bucket){
        if(index == candidates.length){
            //base condition
            if(sum == target){
                result.add(new ArrayList<>(bucket)); 
            }
            return;
        }

        if(sum > target)return;

        //picking part
        bucket.add(candidates[index]);
        sum+=candidates[index];
        //here we are not moving the index to allow, duplication of elements
        pickingNotPicking(candidates, target, index, sum, result, bucket);

        //picking not part
        bucket.remove(bucket.size()-1);
        // sum-=candidates[index];
        pickingNotPicking(candidates, target, index+1, sum, result, bucket);
    }
}
