package LeetcodeStreak.Medium;

import java.util.Stack;

public class a1190 {
    public static void main(String[] args) {
        
    }
    public String reverseParentheses(String s) {
        //in this we will keep staring indexes
        Stack<Integer> index_stack = new Stack<>();
        //changing the string into character array 
        char[] char_array = s.toCharArray();
        for(int i=0;i<char_array.length;i++){
            if(char_array[i]=='('){
                //keeping track of starting index
                index_stack.push(i);
            }else if(char_array[i]==')'){
                reverseArray(char_array, index_stack.pop(), i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<char_array.length;i++){
            if(Character.isAlphabetic(char_array[i])){
                sb.append(char_array[i]);
            }
        }
        return sb.toString();
    }
    public void reverseArray(char[] s, int l, int r){
        while(l<r){
            char temp = s[l];
            s[l++] = s[r];
            s[r--] = temp;
        }
    }
}
