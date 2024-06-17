package HashTable.PracticeProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class a819 {
    public static void main(String []ag){
        String para = "Bob";
        mostCommonWord(para, new String[]{""});
    }
    public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String,Integer> wordCount = new HashMap<>();

        String currentWord = "";
        for(int i=0;i<paragraph.length();i++){
            if((paragraph.charAt(i)>='A' && paragraph.charAt(i)<='Z')||(paragraph.charAt(i)>='a' && paragraph.charAt(i)<='z')){
                currentWord += paragraph.charAt(i)+"";
            }else{
                if(currentWord.length()>0){
                    currentWord = currentWord.toLowerCase();
                    wordCount.put(currentWord, wordCount.getOrDefault(currentWord, 0)+1);
                }
                currentWord = "";
            }
        }
        if(currentWord.length()>0){
            currentWord = currentWord.toLowerCase();
            wordCount.put(currentWord, wordCount.getOrDefault(currentWord, 0)+1);
        }
        for(String banned_word: banned){
                wordCount.remove(banned_word);
        }
        int maxLength = 0;
        for(Entry<String,Integer> word: wordCount.entrySet()){
            if(word.getValue()>maxLength){
                maxLength = word.getValue();
                currentWord = word.getKey();
            }
        }
        System.out.println(wordCount.toString());
        return currentWord;
    }
}
