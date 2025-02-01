package NeetcodeDSASheet.Stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, "", n, n);
        return result;
    }
    public void helper(List<String> result, String string, int left, int right){
        if(left == 0 && right == 0){
            result.add(string);
        }
        if(left > 0)
            helper(result, string+"(", left-1, right);
        if(right > 0)
            helper(result, string+")", left, right-1);
    }
}
