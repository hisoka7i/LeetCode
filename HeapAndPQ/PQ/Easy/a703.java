package HeapAndPQ.PQ.Easy;

import java.util.PriorityQueue;

class KthLargest {
    final int size;
    PriorityQueue<Integer> min_heap = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        size = k;
        for(int current: nums){
            add(current);
        }
    }
    
    //This is showing time limit exceeded issue.
    public int add(int val) {
        if(min_heap.size() < size){
            min_heap.offer(val);
        }else if(val > min_heap.peek()){
            min_heap.poll();
            min_heap.offer(val);
        }
        return min_heap.peek();
    }
}
