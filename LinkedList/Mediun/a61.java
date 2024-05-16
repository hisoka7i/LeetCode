package LinkedList.Mediun;

import LinkedList.SinglyLinkedList.ListNode;

public class a61 {
    public static void main(String[] args) {
        
    }
    public static ListNode rotateRight(ListNode head, int k) {
        ListNode slow = null;
        ListNode fast = null;

        int count = 1;
        boolean flag = false;
        for(int i=0;i<k;i++){
            fast = fast.next;
            count++;
            if(fast==null){
                flag = true;
                break;
            }
        }

        if(flag){
            if(k%count==0)return head;
            k = k%count;
            fast = head;
            for(int i=0;i<k;i++){
                fast = fast.next;
            }
        }

        while (fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        head = slow.next;
        slow.next = null;
        fast.next=head;
        head = fast;
        return head;
    }
}
