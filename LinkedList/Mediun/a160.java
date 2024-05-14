package LinkedList.Mediun;

import LinkedList.SinglyLinkedList.ListNode;

public class a160 {
    public static void main(String[] args) {
        
    }
    //dry run this code on pen and paper, you will understand
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while(temp1!=temp2){
            temp1 = temp1 == null?headB:temp1.next;
            temp2 = temp2 == null?headA:temp2.next;
        }
        return temp1;
    }
}
