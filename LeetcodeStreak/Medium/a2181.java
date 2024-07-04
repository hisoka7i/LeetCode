package LeetcodeStreak.Medium;
public class a2181 {
    //self solved
    public ListNode mergeNodes(ListNode head) {
        ListNode output = new ListNode(0);
        ListNode temp = output;
        int sum = 0;
        while(head!=null){
            if(head.val == 0){
                if(sum != 0){
                    ListNode new_node = new ListNode(sum);
                    temp.next = new_node;
                    temp = new_node;
                }
                sum = 0;
            }else{
                sum += head.val;
            }
            head = head.next;
        }
        return output.next;
    }
}
class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
