package Contest.WeeklyContest;

import java.util.Arrays;

class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
public class DeleteNodes {
    public static ListNode modifiedList(int[] nums, ListNode head) {
        // We are sorting this for binary search
        Arrays.sort(nums);
        
        // Dummy node to handle edge cases such as removing the head node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode temp = head;
        //we are using 2 pointers here
        //always remember to use 2 pointers while doing remove operations
        while (temp != null) {
            int current_node_value = temp.val;
            if (binarySearch(nums, current_node_value)) {
                // Remove the current node
                prev.next = temp.next;
            } else {
                // Move prev only when we do not delete the node
                prev = temp;
            }
            temp = temp.next;
        }
        
        return dummy.next;
    }
    public static boolean binarySearch(int[] nums, int target){
        int low = 0, high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid]>target){
                //we need to seach in left half
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }
}
