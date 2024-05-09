package LinkedList.Mediun;

import LinkedList.SinglyLinkedList.ListNode;

public class a141 {
    //round robin method,, 
    //take two pointers slow moving and fast moving
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            //if the two pointers meets then that means that there is 
            //circle
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
