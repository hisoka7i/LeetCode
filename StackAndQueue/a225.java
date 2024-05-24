package StackAndQueue;

import java.util.*;

class MyStack {

    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
        //here we are starting with 1 because we do not want to, reverse till the 
        //second last element
        //other wise if we reverse the entire queue, then it will come to its intial stage
        for(int i=0;i<q.size();i++){
            //here we are reversing the queue
            q.add(q.remove());
        }
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}
