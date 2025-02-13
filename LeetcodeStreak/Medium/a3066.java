package LeetcodeStreak.Medium;

import java.util.PriorityQueue;

public class a3066 {
    public int minOperations(int[] nums, int k) {
        //min heap
        PriorityQueue<Double> queue = new PriorityQueue<>();

        for(int num: nums){
            queue.offer(num*1.0);
        }

        int count =0;
        while(queue.peek() < k){
            if(queue.size() < 2){
                break;
            }
            double first = queue.poll();
            double second = queue.poll();
            double value = Math.min(first,second)*2 + Math.max(first,second);
            queue.offer(value);
            count++;
        }
        return count;
    }
}
