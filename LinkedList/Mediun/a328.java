package LinkedList.Mediun;

import LinkedList.SinglyLinkedList.ListNode;

public class a328 {
    public static void main(String[] args) {
        
    }
    public static ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            
            even = even.next;
            odd = odd.next;
        }
        odd.next = evenHead;
        return head;
    }
}
