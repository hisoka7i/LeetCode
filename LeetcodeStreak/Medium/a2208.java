package LeetcodeStreak.Medium;

import java.util.PriorityQueue;

public class a2208 {
    public static void main(String[] args) {
        halveArray(new int[]{6,58,10,84,35,8,22,64,1,78,86,71,77});
    }
    public static int halveArray(int[] nums) {
        //we need a max heap
        PriorityQueue<Double> queue  = new PriorityQueue<>((a,b)->Double.compare(b, a));
        double sum = 0d;
        for(int num: nums){
            sum+=num;
            queue.offer((num*1.0));
        }
        long diff = 0l;
        int count = 0;
        while(diff <= sum/2){
            double max_value = queue.poll();
            diff += max_value/2;
            count++;
            queue.offer(max_value/2);
        }
        return count;
    }
}
