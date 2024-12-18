package LeetcodeStreak.Easy;

import java.util.Stack;

public class a1475 {

    public int[] finalPrices(int[] prices) {
        int[] discount = new int[prices.length];

        //now we will use a stack to track the index, from the last position
        Stack<Integer> stack = new Stack<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            while (stack.isEmpty() == false && prices[stack.peek()] > prices[i]) {
                //this means that next amount is greater then this current amount and we need to remove this amount
                stack.pop();
            }

            //now after removal from the stack we will have next immideate amount, which will be less than current amount
            discount[i] = stack.isEmpty() ? 0 : prices[stack.peek()]; //here we will not pop the amount since there is a chance that we will be 
            //reusing the amount 
            stack.push(i); //pushing the current index into the stack
        }

        //now that we have all the discounts that we require, we will simply get the final price
        for (int i = 0; i < prices.length; i++) {
            prices[i] -= discount[i];
        }
        return prices;
    }
}
