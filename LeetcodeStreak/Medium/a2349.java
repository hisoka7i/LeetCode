package LeetcodeStreak.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class NumberContainers {
    public static void main(String[] args) {
        NumberContainers obj = new NumberContainers();

        // Test Case 1: Basic insert and find
        obj.change(1, 10);
        obj.change(2, 10);
        obj.change(3, 20);
        System.out.println(obj.find(10)); // Expected: 1 (smallest index of number 10)

        // Test Case 2: Change existing index
        obj.change(1, 20);
        System.out.println(obj.find(10)); // Expected: 2 (since index 1 moved to 20)

        // Test Case 3: Find for a non-existing number
        System.out.println(obj.find(30)); // Expected: -1 (number 30 does not exist)

        // Test Case 4: Removing a number (implicitly by changing all occurrences)
        obj.change(2, 30);
        System.out.println(obj.find(10)); // Expected: -1 (no index contains 10 anymore)

        // Test Case 5: Check correct order in PriorityQueue
        obj.change(4, 20);
        obj.change(5, 20);
        System.out.println(obj.find(20)); // Expected: 1 (smallest index with number 20)

        // Test Case 6: Update index with the same number (no change should happen)
        obj.change(4, 20);
        System.out.println(obj.find(20)); // Expected: 1 (unchanged)

        System.out.println("All test cases executed.");
    }

    Map<Integer, PriorityQueue<Integer>> numberMapping; // this will contain index and number
    Map<Integer, Integer> indexMapping;

    public NumberContainers() {
        numberMapping = new HashMap<>();
        indexMapping = new HashMap<>();
    }

    public void change(int index, int number) {
        if (numberMapping.containsKey(number) && !indexMapping.containsKey(index)) {
            indexMapping.put(index, number);
            numberMapping.get(number).offer(index);
        } else if (!numberMapping.containsKey(number) && indexMapping.containsKey(index)) {
            int prevNumber = indexMapping.get(index);
            // we need to remove the previous number entry,
            PriorityQueue<Integer> queue = numberMapping.get(prevNumber);
            queue.remove(index);

            if (queue.size() == 0) {
                numberMapping.remove(prevNumber);
            }
            indexMapping.put(index, number);
            // because we do not have the number.
            numberMapping.put(number, new PriorityQueue<>());
            numberMapping.get(number).offer(index);
        } else if (!numberMapping.containsKey(number) && !indexMapping.containsKey(index)) {
            indexMapping.put(index, number);
            numberMapping.put(number, new PriorityQueue<>());
            numberMapping.get(number).offer(index);
        } else {

            // we need to remove index from previous number entry
            int prevNumber = indexMapping.get(index);
            PriorityQueue<Integer> queue = numberMapping.get(prevNumber);
            queue.remove(index);
            if (queue.size() == 0) {
                numberMapping.remove(prevNumber);
            }

            indexMapping.put(index, number);
            numberMapping.get(number).offer(index);
        }

    }

    public int find(int number) {
        if(!numberMapping.containsKey(number) || numberMapping.get(number).size() == 0)
            return -1;
        return numberMapping.get(number).peek();
    }
}
