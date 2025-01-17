package NeetcodeDSASheet.Stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    int minimum;
    public MinStack() {
        stack = new Stack<>();
        minimum = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= minimum){
            //here are we are maintaining minimum and old minimum
            //on top of each other
            //if minimum is poped out then new minimum value will be old_minimum
            stack.push(minimum);
            minimum = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.pop() == minimum)minimum = stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minimum;
    }
}
