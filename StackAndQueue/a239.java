package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class a239 {
    public static void main(String[] args) {
        
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //we will be using the comcept of next greatest element
        //we need a deque -- > This is a doubly linked list(allows operations at both sides)
        //we will add indexes into it

        //if we find a greater element while iterating, then in that case we will pop element from the back 
        //and then insert new element from the back
        // --> (back)]_____________[ <--(front) of dequeue
        //if we find a smaller value then we will insert it from the front


        //for k elements we will store the values in the dequeue, we will check the boundary 
        //if anything is out of boundary then we will not store it in the dequeue
        int n = nums.length;
        int[] result = new int[n-k+1];

        int right_index = 0;

        // store index
        Deque<Integer> q = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            
            //removes numbers out of range k
            if(!q.isEmpty() && q.peek()==i-k){
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                result[right_index++] = nums[q.peek()];
            }
        }
        return result;
    }
}
