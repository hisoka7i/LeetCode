import java.util.*;
public class a3201 {
    public int maximumLength(int[] nums) {
        int[][] patterns = {{0,0},{0,1},{1,0},{1,1}};

        int result = 0;
        for(int[] pattern: patterns){
            int count = 0;
            for(int n: nums){
                if(n%2 == pattern[count%2]){
                    count++;
                }
                result = Math.max(count, result);
            }
        }
        return result;
    }

    public void brute_force_pick_not_pick(int[] nums,int index, List<Integer> output, int size){
        if(index == nums.length){
            return;
        }

        //picking part
        output.add(nums[index]);

    }

    public void isTheLargest(List<Integer> output, int size){
        if(output.size() < 3)return;
        
       
    }
}
