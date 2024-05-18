package LinkedList.Mediun;

import LinkedList.SinglyLinkedList.ListNode;

public class a143 {
    public static void reorderList(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        ListNode forward = head;

        int count = 0;

        //reversing the list
        ListNode backword=null;
        ListNode current=head;
        ListNode next=null;
        while(current!=null){
            next=current.next;
            current.next=backword;
            backword=current;
            current=next;
            count++;
        }
        if(count%2==0){
            
        }
    }
}
