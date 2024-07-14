package LeetcodeStreak.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class a726 {
    public static String countOfAtoms(String formula) {
        Stack<Map<String,Integer>> stack = new Stack<>();

        //this empty hasmap is to symbolise level
        stack.push(new HashMap<>());
        
        int len = formula.length();
        for(int i=0;i<len;){
            if(formula.charAt(i)=='('){
                stack.push(new HashMap<>());
                i++;
            }else if(formula.charAt(i)==')'){
                Map<String,Integer> top = stack.pop();
                i++;
                int start_index = i;
                while(i<len && Character.isDigit(formula.charAt(i)))i++;
                int mutliplier = start_index<i?Integer.parseInt(formula.substring(start_index, i)):1;

                //getting the last map and addding this value into it
                for(String key : top.keySet()){
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0)+top.get(key)*mutliplier);
                }
            }else{
                int start = i;
                i++;
                while(i<len && Character.isLowerCase(formula.charAt(i)))i++;
                String element = formula.substring(start, i);

                start = i;
                while(i<len && Character.isDigit(formula.charAt(i)))i++;
                int count = start<i?Integer.parseInt(formula.substring(start, i)):1;
                stack.peek().put(element, stack.peek().getOrDefault(element, 0) + count);
            }
        }

        Map<String, Integer> result = stack.pop();
        List<String> elements = new ArrayList<>(result.keySet());
        Collections.sort(elements);
        StringBuilder sb = new StringBuilder();
        for (String element : elements) {
            sb.append(element);
            int count = result.get(element);
            if (count > 1) sb.append(count);
        }
        return sb.toString();
    }
}
