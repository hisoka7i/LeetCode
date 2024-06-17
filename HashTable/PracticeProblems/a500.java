package HashTable.PracticeProblems;

import java.util.ArrayList;
import java.util.List;

public class a500 {
    public static String[] findWords(String[] words) {
        List<String> output = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            int length1=0, length2=0, length3=0;
            String current_word = words[i];
            for(int j=0;j<current_word.length();j++){
                char current_char = Character.toLowerCase(current_word.charAt(j));
                if("qwertyuiop".contains(current_char+""))length1++;
                if("asdfghjkl".contains(current_char+""))length2++;
                if("zxcvbnm".contains(current_char+""))length3++;
            }
            if(length1==current_word.length() || length2==current_word.length() || length3==current_word.length()){
                output.add(current_word);
            }
        }

        String[] output_array = new String[output.size()];
        output_array = output.toArray(output_array);

        return output_array;
    }
}
