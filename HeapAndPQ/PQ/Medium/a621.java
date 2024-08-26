package HeapAndPQ.PQ.Medium;

import java.util.Arrays;

public class a621 {
    public int leastInterval(char[] tasks, int n) {
        //This array will contain all the tasks frequencies
        int[] alphabet_array = new int[26];

        for(char task: tasks){
            alphabet_array[task - 'A']++;
        }

        Arrays.sort(alphabet_array);

        //suppose there is 3 'A' tasks, then there will be, A (1block) A (1block) A
        //max frequency - 1
        int number_of_blocks = alphabet_array[25] - 1;

        int max_number_of_ideal_blocks = number_of_blocks*n;

        //now we need to decrease the number of ideal spots or we need to fill ideal sopts
        //we will start from second last element since we already counted it
        for(int i=24; i>=0;i--){
            max_number_of_ideal_blocks -= Math.min(alphabet_array[i],number_of_blocks);
        }

        return max_number_of_ideal_blocks < 0? tasks.length: tasks.length + max_number_of_ideal_blocks;
    }
}
