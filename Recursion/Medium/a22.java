package Medium;
import java.util.ArrayList;
import java.util.List;

public class a22 {
    public static void main(String[] args) {
        generateParenthesis(3);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        helper(output,"",n,n);
        return output;
    }

    private static void helper(List<String> output, String string, int left, int right) {
        // TODO Auto-generated method stub
        if(left == 0 && right == 0){
            output.add(string);
        }//idhar left, right remaining k counter
        if(left > 0)
            helper(output, string + "(", left-1, right);
        if(right>left) //closing tab hi add krna, jb right remaining, left se zada ho.
            helper(output, string + ")", left, right-1);
    }
}
