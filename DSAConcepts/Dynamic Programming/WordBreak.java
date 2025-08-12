import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length() + 1];
        return helper_function_memo(s, wordDict,memo);   
    }

    public static void main(String[] args) {
        // s = "catsandog", wordDict = ["cats","dog","sand","and","cat"] // make a test case with these values
        WordBreak wb = new WordBreak(); 
        String s = "ddadddbdddadd";
        List<String> wordDict = List.of("dd","ad","da","b");
        boolean result = wb.wordBreak(s, wordDict);
        System.out.println(result);
    }

    //instead of randomly removing only remove the starting postion
    public boolean helper_function(String s, List<String> words){
        if(s.length() == 0){
            return true;
        }
        boolean value = false;
        for(String c_word: words){
            if(s.startsWith(c_word))
                value = value || helper_function(s.substring(c_word.length()), words);
            
        }
        
        return value;
    }

    public boolean helper_function_memo(String s, List<String> words, Boolean[] memo){
        if(s.length() == 0){
            return true;
        }
        if(memo[s.length()] != null)return memo[s.length()];
        boolean value = false;
        for(String c_word: words){
            if(s.startsWith(c_word))
                value = value || helper_function_memo(s.substring(c_word.length()), words,memo);
            
        }
        memo[s.length()] = value;
        return memo[s.length()];
    }
    
}
