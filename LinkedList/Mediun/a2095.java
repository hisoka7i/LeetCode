package LinkedList.Mediun;

import LinkedList.SinglyLinkedList.ListNode;

public class a2095 {
    public static void main(String[] args) {
        
    }
    public static ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null)return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next; 
            fast = fast.next.next;
        }
        //slow is the middle node
        fast = head;
        while(true){
            if(fast.next == slow ){
                //we are skipping the middle node here
                fast.next = fast.next.next;
                break;
            }
            //moving the fast node forward
            fast = fast.next;
        }
        return head;
    }
}
