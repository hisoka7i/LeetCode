package ArrayQuestions.PracticeQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class a436 {
    public static void main(String[] args) {
        
    }
    public static int[] findRightInterval(int[][] intervals) {
        int[][] endInterval = Arrays.copyOf(intervals, intervals.length);
        Map<int[],Integer> resultKeeper = new HashMap<>();

        for(int i=0;i<intervals.length;i++){
            resultKeeper.put(intervals[i],i);
        }

        //sorting on the basis for last index
        Arrays.sort(endInterval,(a,b)->a[1]-b[1]);
        //sorting on the basis of first index
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int j =0;
        int[] result = new int[intervals.length];

        for(int i=0;i<endInterval.length;i++){
            while(j<intervals.length && intervals[j][0]<endInterval[i][1]){
                j++;
                //here we are interatiing through the interval array
            }
            result[resultKeeper.get(endInterval[i])]= j == intervals.length?-1:resultKeeper.get(intervals[j]);
        }

        return result;
    }
}
