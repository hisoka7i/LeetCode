package StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class PrevSmaller {
    public static void main(String[] args) {
        
    }
    public static int[] prevSmaller(int[] A) {
        int n = A.length;

        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> previous_value_stack = new Stack<>();
        for(int i=0;i<n;i++){
            while (!previous_value_stack.isEmpty()) {
                if(previous_value_stack.peek()<A[i]){
                    //we will not remove the previous value from the stack,
                    result[i] = previous_value_stack.peek();
                    break;
                }else{
                    //we will search the stack if we find any smaller value present
                    previous_value_stack.pop();
                }
            }
            previous_value_stack.push(A[i]);
        }
        return result;
    }

}
