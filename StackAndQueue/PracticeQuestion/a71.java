package StackAndQueue.PracticeQuestion;

import java.util.Stack;

public class a71 {
    //Simplify Path
    public static void main(String[] args) {
        String path = "/.../a//../b/c/../d/./";
        simplifyPath(path);
    }
    public static String simplifyPath(String path) {
        //if // or more found then replace with / 
        //if ... or more then do nothing
        //if .. then remove previous directory
        //if . then do nothing
        String[] array_string = path.split("/");

        Stack<String> current_stack = new Stack<>();
        for(int i=0;i<array_string.length;i++){
            if(array_string[i].equals("..")){
                if(!current_stack.isEmpty())
                  current_stack.pop();
            }else if(array_string[i].equals(".")){
                continue;
            }else if(array_string[i].equals("")){
                continue;
            }else{
                current_stack.push(array_string[i]);
            }
            System.out.println(array_string[i]);
        }
        StringBuilder sb = new StringBuilder("/");
        Stack<String> inverted_Stack = new Stack<>();
        while (!current_stack.isEmpty()) {
            inverted_Stack.push(current_stack.pop());
        }
        while (!inverted_Stack.isEmpty()) {
            sb.append(inverted_Stack.pop());
            sb.append("/");
        }
        if(sb.length()==1){
            return sb.toString();
        }
        return sb.toString().substring(sb.length()-1);
    }
}
