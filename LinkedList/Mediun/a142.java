package LinkedList.Mediun;

import LinkedList.SinglyLinkedList.ListNode;

public class a142 {
    public static void main(String[] args) {
        
    }
    public static ListNode detectCycle(ListNode head) {
         ListNode slow = head;
         ListNode fast = head;
         while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(slow != head){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
         }
         return null;
    }
    //This might be wrong
    public static boolean checkIfExist(ListNode head){
        if(head==null)return false;
        ListNode temp = head;
        do{
            temp = temp.next;
            if(temp==head){
                return true;
            }
        }while(temp!=null){
            if(temp==head){
                return true;
            }
            temp = temp.next;
        }
        return checkIfExist(head.next);
    }
}
