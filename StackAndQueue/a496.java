package StackAndQueue;

import java.util.HashMap;
import java.util.Stack;

public class a496 {
    //dry run this code to understand
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i=0;i<nums2.length;i++){ 
            if(s.isEmpty())
                s.push(nums2[i]);
            while(!s.isEmpty() && s.peek()<nums2[i]){
                h.put(s.pop(), nums2[i]);
            }
            s.push(nums2[i]);
        }
        while (!s.isEmpty()) {
            h.put(s.pop(),-1);
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i] = h.get(nums1[i]);
        }
        return nums1;
    }
}
