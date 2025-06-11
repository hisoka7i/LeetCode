package LeetcodeStreak.Easy;

import java.util.ArrayList;
import java.util.List;

public class a2492 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(words[i].indexOf(x) == -1){
                answer.add(i);
            }
        }
        return answer;
    }
}
