package ArrayQuestions.PracticeQuestions;

import java.util.Arrays;

public class a3169 {
    //Count Days Without Meetings
    public static void main(String[] args) {
        
    }  
    //intution here is
    //we will sort on the basis for initial meeting days

    //we will go through the array and find all the no meeting days avaible
    public static int countDays(int days, int[][] meetings) {
        int n = meetings.length;
        Arrays.sort(meetings,(x,y)->(x[0]-y[0]));

        int count = 0;

        count += Math.abs(meetings[0][0]-1);
        for(int i=1;i<n;i++){
            //if there is overlap for meeting days
            //example [6,8],[5,10]
            if(meetings[i][0]<=meetings[i-1][1]){
                // in this case we will simply change the last day as of previous 
                //basically we will merge the 2 ranges
                if(meetings[i][1]<meetings[i-1][1]){
                    meetings[i][1]=meetings[i-1][1];
                }
            }else{
                int no_meeting_days = meetings[i][0]-meetings[i-1][1];
                count += no_meeting_days - 1;
            }
        }

        count += Math.abs(meetings[n-1][1]-days);
        return count;
    }  
}
