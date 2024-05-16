package LinkedList.Mediun;

import LinkedList.SinglyLinkedList.ListNode;

public class a92 {
    public static void main(String[] args) {
        
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = new ListNode(-1);

        //we are making dummy for just in case if left position is 1
        temp.next = head;

        //we will take two pointer one is left and other is previous to left
        ListNode prev = null;
        ListNode leftNode = temp;

        for(int i=0;i<left;i++){
            prev = leftNode;
            leftNode = leftNode.next;
        }

        //we will take two pointer, prevRight and rightNode
        ListNode prevRight = prev;
        ListNode rightNode = leftNode;

        //reversing the loop 
        for(int i=left;i<=right;i++){
            //rightNode is current Node
            ListNode forward = rightNode.next;
            rightNode.next = prevRight;
            prevRight = rightNode;
            rightNode = forward;
        }

        //making connection
        prev.next = prevRight;
        leftNode.next = rightNode;
        return temp.next;
    }
}
