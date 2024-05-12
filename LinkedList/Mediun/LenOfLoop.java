package LinkedList.Mediun;

import LinkedList.SinglyLinkedList.ListNode;

public class LenOfLoop {
    public static void main(String[] args) {
        
    }   
    public static void loopExist(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                System.out.println("length:"+tellLength(fast, slow));
            }
        }
    } 
    public static int tellLength(ListNode fast, ListNode slow){
        int count = 1;
        fast = fast.next;
        while(slow!=fast){
            fast = fast.next;
            count++;
        }
        return count;
    }
}
