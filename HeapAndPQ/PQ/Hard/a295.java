package HeapAndPQ.PQ.Hard;

import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> max_heap_half;
    PriorityQueue<Integer> min_heap_half;

    /*
     * We will maintain 2 heaps, one where we will keep the upper half
     * One where we will maintain lower half
    */
    public MedianFinder() {
        max_heap_half = new PriorityQueue<>((a,b)->b-a);
        min_heap_half = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(max_heap_half.isEmpty() || max_heap_half.peek() <= num){
            //here we are checking for upper half,
            max_heap_half.offer(num);
        }else{
            min_heap_half.offer(num);
        }

        //now we need to balance both the halves
        if(max_heap_half.size() > min_heap_half.size()+1){
            min_heap_half.offer(max_heap_half.poll());
        }else if(min_heap_half.size() > max_heap_half.size()){
            max_heap_half.offer(min_heap_half.poll());
        }
    }
    
    public double findMedian() {
        if(max_heap_half.size() == min_heap_half.size()){
            return (max_heap_half.peek()/2.0 + min_heap_half.peek()/2.0);
        }
        return max_heap_half.peek();
    }
}
