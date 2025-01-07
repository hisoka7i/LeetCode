package NeetcodeDSASheet.ArrayAndHashing;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class TopKFreqElement {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int current: nums){
            map.put(current, map.getOrDefault(current, 0)+1);
        }

        //now we are making a priority queue, max heap
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));

        for(java.util.Map.Entry<Integer, Integer> mapEntry: map.entrySet()){
            maxHeap.offer(mapEntry);
        }

        int[] output = new int[k];
        for(int i=0;i<k;i++){
            output[i] = Objects.requireNonNull(maxHeap.poll()).getKey();
        }
        return output;
    }
}
