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
    
    public int add(int val) {
        if(min_heap.size() < size){
            min_heap.offer(val);
        }else if(val > min_heap.peek()){
            min_heap.poll();
            min_heap.offer(val);
        }
        return min_heap.peek(); 
    }
    //My solution, but this is showing out of memory issue. 
    // I should have start from the very beginning.
    /*
     * public KthLargest(int k, int[] nums) { 
        size = k;
        for(int current: nums){
            max_heap.offer(current);
        }
    }
    
    public int add(int val) {
        max_heap.offer(val);
        if(max_heap.size() >= size){
            int[] deleted_value = new int[size];
            for(int i=0;i<size;i++){
                deleted_value[i] = max_heap.poll();
            }
            for(int current_value: deleted_value){
                max_heap.offer(current_value);
            }
            return deleted_value[deleted_value.length - 1];
        }
        return 0;
    }
    */
}
