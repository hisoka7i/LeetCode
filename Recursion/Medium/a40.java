package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //we need to modify, pick not picking pattern such that, there is no duplicate
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> bucket = new ArrayList<>();
        int index =0;
        pickingNotPicking2(candidates, target, index, result, bucket);
        return result;
    }

    private void pickingNotPicking2(int[] candidates, int target, int index, List<List<Integer>> result,
            List<Integer> bucket) {
            if(target == 0){
                result.add(new ArrayList<>(bucket));
                return;
            }

            if(target < 0 || index > candidates.length)
                return;

            //using a loop, to skip all the duplicated
            for(int i=index;i<candidates.length;i++){
                if(i>index && candidates[i] == candidates[i-1]){
                    continue;
                }

                //picking part of the pattern
                bucket.add(candidates[i]);
                pickingNotPicking2(candidates, target-candidates[i], i+1,  result, bucket);

                //not picking part of the pattern
                bucket.remove(bucket.size()-1);

                //we are not writing the call again because for loop will take care of call, after removal
            }
    }

    //This code is getting failed for last 4, test cases(out of memory error)
    public void pickingNotPicking(int[] candidates, int target,int index,int sum, List<List<Integer>> result,List<Integer> bucket){
        if(index == candidates.length){
            //base condition
            if(sum == target){
                if(!result.contains(bucket))
                    result.add(new ArrayList<>(bucket)); 
            }
            return;
        }

        //picking part
        bucket.add(candidates[index]);
        sum+=candidates[index];
        //here we are not moving the index to allow, duplication of elements
        pickingNotPicking(candidates, target, index, sum, result, bucket);

        //picking not part
        bucket.remove(bucket.size()-1);
        sum-=candidates[index];
        pickingNotPicking(candidates, target, index+1, sum, result, bucket);
    }
}

