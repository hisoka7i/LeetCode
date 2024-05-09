package LinkedList.Mediun;

import LinkedList.SinglyLinkedList.ListNode;

public class a206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode current=head;
        ListNode next=null;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
        return head;
    }
    public ListNode reverseRecursion(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseRecursion(head.next);
        //because the head is still at the first node, 
        ListNode front = head.next;
        front.next = head; // we are reversing the head here

        //we are breaking off the connection, using this
        head.next = null;
        return newHead;
    }
}
