package GreedyAlgorithm.Medium;

import java.util.Arrays;

public class a435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        //we will follow the same logic of, n meetings in a room

        //first sort according to end time of a meeting
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1], b[1]));

        //we are going greedy approach
        //we need to get, meeting who are getting completed sooner
        int endtime = intervals[0][1];
        int overlapping = 0; //these are number of overlapping meetings
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] >= endtime){
                endtime = intervals[i][1];
                // non_overlaping++;
            }else{
                overlapping++;
            }
        }
        return overlapping;
    }
}
