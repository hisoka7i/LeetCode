package LinkedList.Hard;

import LinkedList.SinglyLinkedList.ListNode;

public class a25 {
    public static void main(String[] args) {
        
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        //To save the, last element of groupped list, which will be used to make connection 
        //with the rest of the linked list
        ListNode prevNode = null;

        while(temp!=null){
            //This is part of the linked list
            ListNode kthNode = findKthNode(temp, k);
            if(kthNode == null){
                //if prev node is null:> this means that there is only 1 or none kth grouph
                if(prevNode!=null) prevNode.next = temp;
                break;
            }
            //Using the next node to remember the next node to the kth node
            ListNode nextNode = kthNode.next;
            //seprating the kthnode from the rest 
            kthNode.next = null;
            //reversing the listNode
            reverseList(temp);
            ///check if first group
            if(temp==head){
                //new head 
                head = kthNode;
            }else{
                // Link the last node of the previous
                // group to the reversed group
                prevNode.next = kthNode;
            }  
            //saving the last node
            prevNode = temp;
            //moving to the next kth node
            temp = nextNode;         
        }
        return head;
    }
    public static ListNode findKthNode(ListNode temp, int k){
        // Decrement K as we already
        // start from the 1st node
        k -= 1;
        
        // Decrement K until it reaches
        // the desired position
        while (temp != null && k > 0) {
            // Decrement k as temp progresses
            k--;
            
            // Move to the next node
            temp = temp.next;
        }
        
        // Return the Kth node
        return temp;
    }
    public static void reverseList(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        while (current!=null) {
            ListNode forward = current.next;
            current.next = prev;
            prev = current;
            current = forward;
        }
        return prev;
    }
}
