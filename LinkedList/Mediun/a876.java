package LinkedList.Mediun;

import LinkedList.SinglyLinkedList.ListNode;

public class a876 {
    //this method implements tortoise hare method
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null && slow!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //by the time fast will cover d distance slow will only reach half
        //since speed of fast is double, so it will cover larger distance
        return slow;
    }
}
