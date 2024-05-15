package LinkedList.Mediun;

import java.util.List;

import LinkedList.SinglyLinkedList.ListNode;

public class a2 {
    public static void main(String[] args) {
        addTwoNumbers(null, null);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode output = new ListNode(-1);
        ListNode temp3 = output;
        int carry = 0;
        while(temp1!=null || temp2!=null){
            int sum = 0;
            if(temp1!=null){
                sum+=temp1.val;
                temp1=temp1.next;
            }
            if(temp2!=null){
                sum+=temp2.val;
                temp2=temp2.next;
            }
            sum = sum+carry;
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;


            temp3.next = newNode;
            temp3 = newNode;
        }
        if(carry ==1 ){
            ListNode newNode = new ListNode(1);
            temp3.next = newNode;
            temp3 = newNode;
        }
        return output.next;
    }
}
