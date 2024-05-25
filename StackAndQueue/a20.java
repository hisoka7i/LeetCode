package StackAndQueue;

import java.util.Stack;

public class a20 {
    public static void main(String[] args) {
        
    }
    public static boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for(char it: s.toCharArray()){
            if(it=='{'||it=='['||it=='(')
                brackets.push(it);
            else{
                if(brackets.isEmpty())return false;
            char last = brackets.pop();
            //that simply means we have a closing bracket in string
            //but no opening bracket is present in the stack
            
            if((it==']'&&last=='[')||(it=='}'&&last=='{')||(it==')'&&last=='('))continue;
            else return false;
            }
        }
        //checking at the end of the process if stack is not empty then that means 
        //it is not balanced
        return brackets.isEmpty();
    }
}
