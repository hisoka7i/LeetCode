package ArrayQuestions.PracticeQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class a506 {
    public static void main(String[] args) {
        
    }
    public static String[] findRelativeRank(int[] score){
        String[] answer = new String[score.length];
        int[] temp = Arrays.copyOf(score, score.length);

        Arrays.sort(temp);
        Map<Integer,String> map =  new HashMap<>();
        //here we are putting the values
        for(int i=0;i<temp.length;i++){
            if(i== temp.length -1) map.put(temp[i], "Gold Medal");
            else if(i == temp.length - 2) map.put(temp[i], "Silver Medal");
            else if(i == temp.length - 3) map.put(temp[i], "Bronze Medal");
            else{
                map.put(temp[i], Integer.toString(temp.length - i));
            }
        }
        for(int i=0; i<score.length; i++){
            answer[i] = map.get(score[i]);
        }
        return answer;
    }
}
