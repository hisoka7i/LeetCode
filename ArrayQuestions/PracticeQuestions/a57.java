package ArrayQuestions.PracticeQuestions;

import java.util.ArrayList;
import java.util.List;

public class a57 {
    public static void main(String[] args) {
        
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> output = new ArrayList<>();
        int n = intervals.length;
        int i=0;

        //we will check if interval end is less than, new interval start
        while(i<n && intervals[i][1]<newInterval[0]){
            output.add(intervals[i]);
            ++i;
        }

        //once we find the place insert the new interval start
        //now we will find the end point

        //for this we will check of start is less than or equal to end of new interval
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        //adding the new interval into it
        output.add(newInterval);
        while(i<n){
            output.add(intervals[i]);
            ++i;
        }

        return output.toArray(new int[output.size()][]);
    }
}
