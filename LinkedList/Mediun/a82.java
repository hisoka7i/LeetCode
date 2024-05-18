package LinkedList.Mediun;
import LinkedList.SinglyLinkedList.ListNode;

public class a82 {
    public static void main(String[] args) {
        
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (head!=null) {
            if(head.next!=null && head.val == head.next.val){
                while(head.next!=null && head.val == head.next.val){
                    head = head.next;
                }
                prev.next = head.next;
            }else{
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
