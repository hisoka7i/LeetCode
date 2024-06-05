package StackAndQueue;

import java.util.Stack;

public class a907 {
    public static void main(String[] args) {
        
    }
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        //This will act as a stack
        int[] stk = new int[arr.length + 1];
        int idx = 0;

        //This array is used as a stack to keep track of the indices of elements in the array.
        int[] sum_of_minimum = new int[n];
        
        long res = sum_of_minimum[0];

        for(int i=0;i<n;i++){
            //here we are check if there is any element which is less than the current element
            while(idx>=0 && arr[stk[idx]]>=arr[i]){
                idx--;
            }
            //This is the formula that is required for this question
            sum_of_minimum[i] = idx<0?(arr[i]*(i+1)):sum_of_minimum[stk[idx]]+(arr[i]*(i-stk[idx]));
            res += sum_of_minimum[i];
            stk[++idx] = i; //pushing next element into the stack
        }
        return (int)(res%1_000_000_007);
    }
}
