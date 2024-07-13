package LeetcodeStreak.Medium;

import java.util.Stack;

public class a1717 {
    public static void main(String[] args) {
        
    }
    public static int maximumGain(String s, int x, int y) {
        if(x>y){
            return maximumGain(s, y, x);
        }
        Stack<Character> character_stack = new Stack<>();
        StringBuilder string_builder = new StringBuilder();
        int result = 0;
        for(char current_char: s.toCharArray()){
            if(!character_stack.isEmpty() && (character_stack.peek() == 'b' && current_char=='a')){
                //that means we found the 'ba' we need to increment the result
                character_stack.pop();
                result += y;
            }else{
                character_stack.push(current_char);
            }
        }

        //getting the remaining string 
        while(!character_stack.isEmpty()){
            string_builder.append(character_stack.pop());
        }
        string_builder.reverse();

        //finding 'ab' in the remaining string
        for(char current_char: string_builder.toString().toCharArray()){
            if(!character_stack.isEmpty() && (character_stack.peek()=='a' && current_char=='b')){
                character_stack.pop();
                result += x;
            }else{
                character_stack.push(current_char);
            }
        }
        return result;
    }

}
