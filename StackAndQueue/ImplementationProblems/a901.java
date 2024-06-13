package StackAndQueue.ImplementationProblems;

import java.util.Stack;

class StockSpanner {
    public static void main(String[] args) {
        
    }
    //Online Stock Span
    //here intution is that, we will use already present values in the result array
    //if the next value is smaller than current value 
    //then we can use that value, 

    //we will be making stock of ADT,
    //of stack and span combined
    static class Pair{
        int stock;
        int span;
        Pair(int stock,int span){
            this.stock = stock;
            this.span = span;
        }
    }
    private static Stack<Pair> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public static int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek().stock <= price){
            Pair p = stack.pop();
            span += p.span;
        }

        stack.push(new Pair(price, span));
        return span;
    }
}
