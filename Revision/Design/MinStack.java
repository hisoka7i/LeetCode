package Revision.Design;

import java.util.PriorityQueue;
import java.util.Stack;

class MinStack {
    //I need a stack for normal operations
    //I need a min heap for getMin() operations
    Stack<Integer> normal;
    PriorityQueue<Integer> minHeap;
    public MinStack() {
        normal = new Stack<>();
        minHeap = new PriorityQueue<>(Integer::compare); //this is min heap //this a - b is causing integer overflow at the edges so. instead of this we are gonna use integer.compare
    }
    
    public void push(int val) {
        normal.push(val);
        minHeap.offer(val);
    }
    
    public void pop() {
        Integer value = normal.pop();
        minHeap.remove(value);
    }
    
    public int top() {
        return normal.peek();
    }
    
    public int getMin() {
        return minHeap.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
