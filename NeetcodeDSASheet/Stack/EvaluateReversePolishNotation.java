package NeetcodeDSASheet.Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> integer_value = new Stack<>();
        // '+', '-', '*', and '/'
        for(String token: tokens){
            if(token.equals("*")||token.equals("+")
            ||token.equals("/")||token.equals("-")){
                if(integer_value.size() < 2){
                    continue;
                }
                int b = Integer.valueOf(integer_value.pop());
                int a = Integer.valueOf(integer_value.pop());
                //now i will do a + b
                if(token.equals("*")){
                    integer_value.add(String.valueOf((a*b)));
                }else if(token.equals("+")){
                    integer_value.add(String.valueOf((a+b)));
                }else if(token.equals("-")){
                    integer_value.add(String.valueOf((a-b)));
                }else{
                    if(b==0){
                        integer_value.add("0");
                    }else{
                        integer_value.add(String.valueOf(a/b));
                    }
                }
            }else{
                integer_value.add(token);
            }
        }

        return Integer.valueOf(integer_value.pop());
    }
}
