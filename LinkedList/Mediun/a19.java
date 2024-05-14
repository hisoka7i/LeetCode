package LinkedList.Mediun;

import LinkedList.SinglyLinkedList.ListNode;

public class a19 {
    public static void main(String[] args) {
        
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //we will take 2 pointers fast and slow
        ListNode slow = head;
        ListNode fast = head;
        //moving faster pointer  steps
        for(int i=0;i<n;i++){
            fast = fast.next;
        }

        //this means ki n is last node
        if(fast==null)return head.next;

        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode deleteNode = slow.next;
        slow.next = slow.next.next;
        deleteNode.next=null; //freeing this pointer

        return head;
    }
}
