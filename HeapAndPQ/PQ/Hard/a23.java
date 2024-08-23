package HeapAndPQ.PQ.Hard;

import java.util.List;
import java.util.PriorityQueue;

import LinkedList.SinglyLinkedList.ListNode;

public class a23 {
    //This is brute force, do this question, with divide and conquer as well
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> min_heap = new PriorityQueue<>((a,b)->a.val - b.val);
        //we have added all the list node in the max heap
        for(ListNode current_list_node: lists){
            while(current_list_node.next != null){
                min_heap.offer(current_list_node);
                //need to move this node to next
                current_list_node = current_list_node.next;
            }
        }

        //making a new List_node 
        ListNode result = min_heap.poll();
        //making a temp pointer, which will move forward
        ListNode temp = result;
        while(!min_heap.isEmpty()){
            temp.next = min_heap.poll();
            temp = temp.next;
        }
        if(temp != null){
            temp.next = null;
        }
        return result;
    }
}
