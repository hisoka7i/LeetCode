package LeetcodeStreak.Medium;

import java.util.PriorityQueue;

public class a2182 {

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] frequency = new int[26];

        for (char character : s.toCharArray()) {
            frequency[character - 'a']++; //here we are counting, frequency of every character
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]); // here are adding character in reverse order along with it's count

        //adding values into the queue
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0) {
                queue.offer(new int[]{i + 'a', frequency[i]});
            }
        }
        StringBuffer result = new StringBuffer();
        while (queue.isEmpty() == false) {
            int[] current = queue.poll();

            //now we have character and it's count
            int current_character = current[0];
            int current_character_count = current[1];

            //now we will get information if character occurance is less than repeat limit or not
            int used = Math.min(repeatLimit, current_character_count);

            for (int i = 0; i < used; i++) {
                result.append((char) current_character);
            }

            current_character_count -= used;

            //now if have few character left, 
            //in case we have some characters left after repeat count
            if (current_character_count > 0) {
                if (queue.isEmpty() == true) {
                    break; //if there are no new characters left
                }
                int[] next = queue.poll(); //getting the next immediate character 
                result.append((char) next[0]); //reduce the frequency

                next[1]--; //reducing the count of next character
                //if next character still exists
                if (next[1] > 0) {
                    queue.offer(next); //we are giving the next character, back to queue 
                }

                queue.offer(new int[]{current_character, current_character_count});
            }
        }

        return result.toString();
    }
}
