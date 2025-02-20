package Revision.Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PerfectSum {
    static int count = 0;
    static int tar = 0;
    public static void main(String[] args) {
        perfectSum(new int[]{5,2,3,10,6,8}, 10);
    }
    public static int perfectSum(int[] nums, int target) {
        tar = target;
        // code here
        List<Integer> bucket = new ArrayList<>();
        Set<List<Integer>> output = new HashSet<>();
        helper(output,nums, target, bucket, 0);
        // System.err.println(output.size());
        // helper2(0, bucket, 0, nums);
        System.err.println(count);
        return count;
    }
    //after revising notes
    public static void helper2(int index, List<Integer> bucket, int sum, int[] nums){
        if(index > nums.length-1){
            if(sum == tar){
                System.out.println(bucket.toString());
            }
            return;
        }
            
        bucket.add(nums[index]);
        sum += nums[index];
        helper2(index+1, bucket, sum, nums); 

        int val = bucket.remove(bucket.size() - 1);
        sum -= val;
        helper2(index+1, bucket, sum, nums);
    }

    //need to implement picking not picking technique
    public static void helper(Set<List<Integer>> output,int[] nums, int target,List<Integer> bucket, int index){
        //base condition
        int summation = bucket.stream().reduce(0, (a,b)->a+b);
        

        if(index == nums.length){
            if(summation == target){
                System.out.println(bucket);
                output.add(bucket);
            }
            return;
        }

        // if(summation < target){
            bucket.add(nums[index]);
            helper(output, nums, target, bucket, index+1);
        // }else{
            bucket.remove(bucket.size()-1); //removing the last element
            helper(output, nums, target, bucket, index+1);
        // }
    }
}
