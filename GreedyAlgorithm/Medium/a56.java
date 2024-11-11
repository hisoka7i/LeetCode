package GreedyAlgorithm.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a56 {

    //greedy approach
    public int[][] merge(int[][] intervals) {
        //first need to sort the given intervals on the basis of, first interval
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));

        //now that we havae sorted the array, we will need a collection to sort the final intervals
        List<int[]> outList = new ArrayList<>();
        //now we will iterate throughout the array and we will compare starting index of next element to ending index of first element
        for(int i=0; i<intervals.length-1; i++){
            if(intervals[i][1] >= intervals[i+1][0]){
                intervals[i+1][0] = Math.min(intervals[i][0], intervals[i+1][0]);
                intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]);
            }else{
                outList.add(new int[]{intervals[i][0],intervals[i][1]});
            }
        }

        //
        outList.add(new int[]{intervals[intervals.length-1][0],intervals[intervals.length -1][1]});
        return outList.toArray(new int[outList.size()][]);
    }
}
