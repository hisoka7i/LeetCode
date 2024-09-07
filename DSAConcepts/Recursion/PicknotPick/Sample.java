package Recursion.PicknotPick;

import java.util.List;

public class Sample {
    static int summation = 2;
    public static void main(String[] args) {
        
    }
    public static void pickOrNotPick(int[] nums, int index, List<Integer> output, int sum){
        if(index == nums.length-1){
            if(sum == summation){
                System.out.println(output.toString());
                return;
            }
        }
        //This is the pick part
        output.add(nums[index]);
        sum += nums[index];
        pickOrNotPick(nums, index + 1, output, sum );

        //This the not pick part
        output.remove(nums[index]);
        sum -= nums[index];
        pickOrNotPick(nums, index+1, output, sum);
    }
}
