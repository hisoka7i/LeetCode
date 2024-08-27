import java.util.PriorityQueue;

public class a846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //first we will check if all the cards can be clubbed into groups or not
        if(hand.length % groupSize != 0)
            return false;
        
        //then we will see if group size if 1
        if(groupSize == 1)
            return true;

        //now we will make a min heap
        PriorityQueue<Integer> max_heap = new PriorityQueue<>();

        //we will add the values into the priority queue
        for(int card: hand){
            max_heap.add(card);
        }

        //now we will check, if all the consecutive cards are present the group or not
        while(!max_heap.isEmpty()){
            int first_card = max_heap.poll();
            //getting the smallest card out
            for(int i=1;i<groupSize;i++){
                //we will check in group if all the consecutive cards are present or not
                if(!max_heap.remove(first_card + i)){
                    return false;
                }
            }
        } 

        return true;
    }
}
