package PracticeQuestion;

import java.util.HashSet;
import java.util.Set;

public class a804 {
    public static void main(String[] args) {
        
    }
    public static int uniqueMorseRepresentations(String[] words) {
        String[] mors = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> output = new HashSet<>();
        for(String currentWord: words){
            StringBuilder sb = new StringBuilder();
            for(char currentCharacter: currentWord.toCharArray()){
                sb.append(mors[currentCharacter-'a']);
            }
            output.add(sb.toString());
        }
        return output.size();
    }
}
