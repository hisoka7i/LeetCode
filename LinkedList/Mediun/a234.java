package LinkedList.Mediun;

import LinkedList.SinglyLinkedList.ListNode;

public class a234 {
    public static void main(String[] args) {
        
    }

    //1. find middle of the linked list
    //2. reverse the second half
    //3. compare
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //here we are finding the middle
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newHead = reverse(slow.next);
        ListNode firstHalf = head;
        ListNode secondHalf = newHead;
        //since last pointer of firstHalf will be connected to newHead
        //we will iterate secondHalf b/s its last will be null
        while(secondHalf!=null){
            //here we are comparing
            if(firstHalf.val != secondHalf.val){
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
    //here we are reversing the second half
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode temp = head;
        while(temp != null){
            ListNode front = temp.next;
            front.next = prev;
            prev = temp;
            temp = front;
        }
        head = prev;
        return head;
    }
}
