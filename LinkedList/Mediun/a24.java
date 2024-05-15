package LinkedList.Mediun;

import LinkedList.SinglyLinkedList.ListNode;

public class a24 {
    public static void main(String[] args) {
        
    }
    public static ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        else{
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = head;
            head = temp;
        }
        head.next.next = swapPairs(head.next.next);
        return head;
    }
}
