package HeapAndPQ.PQ.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Map.Entry;

public class a347 {
    //here we need to find k most frequent integers
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> integer_mapping = new HashMap<>();
        for(int current_number: nums){
            integer_mapping.put(current_number, integer_mapping.getOrDefault(current_number, 0)+1);
        }

        //on the basis of frequency we are creating a max heap
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((a,b)->(
            b.getValue() - a.getValue()
        ));

        //need to insert data into max heap
        for(Entry<Integer,Integer> current: integer_mapping.entrySet()){
            maxHeap.offer(current);
        }

        int[] output = new int[k];

        for(int i=0;i<k;i++){
            output[i] = Objects.requireNonNull(maxHeap.poll().getKey());
        }

        return output;
    }
}
