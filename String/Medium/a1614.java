package String.Medium;

import java.util.Stack;

public class a1614 {
    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }
    //1ms solution
    public static int maxDepth(String s) {
        int max = -1;
        Stack<Character> paraStack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                paraStack.add(0, '(');
            }
            if(paraStack.size()>max){
                max = paraStack.size();
            }
            if(s.charAt(i)==')'){
                paraStack.pop();
            }
        }
        if(max==-1)
            return 0;
        return max;
    }
}
