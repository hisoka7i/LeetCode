package HeapAndPQ.PQ.Medium;

import java.util.PriorityQueue;

public class a215 {
    public int findKthLargest(int[] nums, int k) {
        //by default priority queue inplements, min - heap
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for(int current_number: nums){
            queue.offer(current_number);
            //that means we got over the limit. 
            if(queue.size() > k)queue.poll();
        }
        return queue.peek();
    }

    public int findKthSmallest(int[] nums, int k){
        //we need to implement max heap in this case
        PriorityQueue<Integer> max_heap = new PriorityQueue<>((a,b)->(b-a));

        for(int current_number: nums){
            max_heap.offer(current_number);
            if(max_heap.size()>k)max_heap.poll();
        }
        return max_heap.peek();
    }
}
