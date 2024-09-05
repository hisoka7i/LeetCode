package HeapAndPQ.PQ.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class a347 {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        //so my is to put all the elements into the heap and use 2 pointer after that to
        //calculate the result.
        List<Integer> output = new ArrayList<>();

        for(int current_number: nums){
            min_heap.offer(current_number);
        }
        int counter = 0;
        int pointer1 = min_heap.poll();
        while(!min_heap.isEmpty()){
            int pointer2 = min_heap.poll();
            if(pointer1 == pointer2){
                if(++counter == k){
                    output.add(pointer1);
                }
            }else{
                counter = 0;
                pointer1 = pointer2;
                pointer2 = min_heap.poll();
            }
        }

        return output.stream().mapToInt(i->i).toArray();
    }
}
