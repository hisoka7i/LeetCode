package LinkedList.Mediun;

import LinkedList.SinglyLinkedList.ListNode;

public class Sorting012 {
    public static void main(String[] args) {
        
    }
    public static ListNode sort012(ListNode head){
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        ListNode temp1 = zeroHead;
        ListNode temp2 = oneHead;
        ListNode temp3 = twoHead;
        while (head!=null) {
            int data = head.val;
            switch (data) {
                case 0:
                    ListNode zero = new ListNode(data);
                    temp1.next = zero;
                    temp1 = zero;
                    break;
                case 1:
                    ListNode one = new ListNode(data);
                    temp2.next = one;
                    temp2 = one;
                    break;
                case 2:
                    ListNode two = new ListNode(data);
                    temp3.next = two;
                    temp3 = two;
                    break;
                default:
                    break;
            }
            head = head.next;
        }
        zeroHead.next = oneHead.next;
        oneHead.next = twoHead.next;

        return zeroHead.next;
    }
}
