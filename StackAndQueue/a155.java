package StackAndQueue;

import java.util.Stack;

class MinStack {
    public static void main(String[] args) {
        int[] integer_array = {-2,0,4,-3,9,-10};
        for(int i: integer_array){
            push(i);
        }
        System.out.println(st.toString());
        pop();
        System.out.println(min);
        System.out.println(st.toString());
    }
    static Stack<Integer> st = new Stack<>();
    static int min = Integer.MAX_VALUE;
    
    public static void push(int val) {
        if(val <= min){
            //pushing the old minimum value
            st.push(min);
            min = val;
        }
        st.push(val);
    }
    
    public static void pop() {
        //reverting to previous minimum
        if(st.pop() == min)min = st.pop();
    }
    
    public static int top() {
        return st.peek();
    }
    
    public static int getMin() {
        return min;
    }
}
