package LeetcodeStreak.Easy;
import java.util.Stack;

public class a1598 {
    public static void main(String[] args) {
        
    }
    public static int minOperations(String[] logs) {
        Stack<String> operations_stack = new Stack<>();

        for(String current_operation: logs){
            if(current_operation.equals("./")){

            }else if(current_operation.equals("../")){
                if(!operations_stack.isEmpty())
                    operations_stack.pop();
            }else{
                operations_stack.push(current_operation);
            }
        }
        return operations_stack.size();
    }
    //trying another solution
    public static int minOperations2(String[] logs) {
        // Stack<String> operations_stack = new Stack<>();
        int folder_structure_dept = 0;
        for(String current_operation: logs){
            if(current_operation.equals("./")){

            }else if(current_operation.equals("../")){
                if(folder_structure_dept>0){
                    folder_structure_dept--;
                }
            }else{
                folder_structure_dept++;
            }
        }
        return folder_structure_dept;
    }
}
