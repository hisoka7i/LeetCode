package NeetcodeDSASheet.Stack;

import java.util.Stack;

public class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> bucket = new Stack<>();

        for(char currentChar: s.toCharArray()){
            if(currentChar == '{' || currentChar == '[' || currentChar == '('){
                bucket.add(currentChar);
            }else{
                if(bucket.isEmpty())return false;

                char closingChar = bucket.pop();

                if((currentChar == '{' && closingChar == '}')||(currentChar == '[' && closingChar == ']')||(currentChar == '(' && closingChar == ')'))continue;
                else return false;
            }
        }
        return bucket.isEmpty() == true ? true:false;
    }
}
