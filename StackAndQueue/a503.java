package StackAndQueue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class a503 {
    public static void main(String[] args) {
        
    }
    public static int[] nextGreaterElements(int[] nums) {
        //creating a result array
        int n = nums.length;
        int[] result = new int[n];
        //initial the array with -1 value
        Arrays.fill(result, -1);

        //we will save all the indexes into it
        Stack<Integer> indexStack = new Stack<>();

        //when ever you encounter a circular array, always take double length
        for(int i=0;i<2*n;i++){
            //we will compare the previous index with the current index
            //and if we find that the previous index value was less then the current Index value
            //then in that case we will compare other indexes present in the indexStack with the current index value
            while(!indexStack.isEmpty() && nums[indexStack.peek()]<nums[i%n]){
                //we will save the next greater in the result array
                result[indexStack.pop()] = nums[i%n];
            }
            //insert the index into it
            indexStack.push(i%n);
        }
        return result;
    }
}
