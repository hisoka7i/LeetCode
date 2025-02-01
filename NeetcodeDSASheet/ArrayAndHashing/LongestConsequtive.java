package NeetcodeDSASheet.ArrayAndHashing;

import java.util.PriorityQueue;

public class LongestConsequtive {
    public int longestConsecutive(int[] nums) {
        //this is min heap
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->(a-b));
        for(int current_number: nums){
            queue.offer(current_number); //time complexity for insertion is o(logn)
        }
        if (queue.size() == 1) {
            return 1;
        }
        
        // Pointer to traverse the heap
        int pointer1 = queue.poll();  // Get the first element
        int maxLength = 1;  // Longest sequence length starts with 1 (the first element itself)
        int currentLength = 1;  // Current sequence length
    
        // Traverse the queue starting from the second element
        while (!queue.isEmpty()) {
            int pointer2 = queue.poll();  // Get the next smallest element
            
            // If the current number is consecutive (i.e., pointer2 == pointer1 + 1)
            if (pointer2 == pointer1 + 1) {
                currentLength++;  // Increase the length of the current consecutive sequence
            } else if (pointer2 != pointer1) {
                // Reset the length for a new sequence (non-consecutive)
                maxLength = Math.max(maxLength, currentLength);  // Update maxLength
                currentLength = 1;  // Reset currentLength to 1
            }
    
            pointer1 = pointer2;  // Move pointer1 to pointer2 for the next comparison
        }
    
        // After the loop ends, make sure to check the last sequence length
        maxLength = Math.max(maxLength, currentLength);
    
        return maxLength;
    }
}
