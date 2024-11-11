package GreedyAlgorithm.gfg;

// import java.lang.reflect.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Data{
    int start;
    int end;
    int meetingno;
}

public class NmeetingsInaRoom {
    public int nMeetings(int[] start, int[] end, int n){
        int output = 1; //one meeting will definetly happen
        Data[] meetings = new Data[n];
        //we will be follwing greey appraoch in which, we will find the meetings that are ending sooner
        for(int i=0;i<n;i++){
            //we will be populating meetings data here
            meetings[i].start = start[i];
            meetings[i].end = end[i];
            meetings[i].meetingno = i+1;
        }

        //now we will sort this on the basis of ending time
        Arrays.sort(meetings,(a,b)->Integer.compare(a.end, b.end));
        int freetime = meetings[0].end; //this is ending time of first meeting

        List<Integer> meetings_list = new ArrayList<>(); //here we will get meeting which are possible
        //This we are maintaining, just in case if the interviewer asks for the meeting order. 
        meetings_list.add(meetings[0].meetingno); //this is first meeting which is happening

        //now we will simply check, if the starting time of the next meeting is later then ending time of previous meeting or free time
        for(int i=1;i<n;i++){
            if(meetings[i].start >= freetime){
                freetime = meetings[i].end;
                output++;
                meetings_list.add(meetings[i].meetingno);
            }
        }
        return output;
    }
}
