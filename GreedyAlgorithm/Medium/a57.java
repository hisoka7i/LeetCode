package GreedyAlgorithm.Medium;  
import java.util.ArrayList;
import java.util.List;

public class a57 {
    //This is some old method that I used to solve this problem.
    public int[][] insertOld(int[][] intervals, int[] newInterval) {
        //we will maintain a collection which will have, final answer
        List<int[]> output = new ArrayList<>();

        //we will find position where we need to insert new element
        int i = 0, n = intervals.length;
        while(i<n && intervals[i][1] < newInterval[0]) //ending interval should be less than starting of new interval
        {
            //we will add all the intervals into the collection
            output.add(intervals[i]);
            i++;
        }

        //now we have the starting position with us,
        //we need to find the ending position
        while(i<n && intervals[i][0] <= newInterval[1]){
            //ending of new interval should be less than or equal starting of exsiting intervals

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            output.add(newInterval);
            i++;
        }

        //now we need to add all the remaining intervals into the colleciton
        while(i<n){
            output.add(intervals[i]);
            i++;
        }
        return output.toArray(new int[output.size()][]);
    }
}
