package TreeTraversal.WithoutRecursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import TreeTraversal.BinaryTree;

public class ZigzagTraveral {
    public List<List<Integer>> ZigZagOutout(BinaryTree root){
        //we will need a queue for level order traversal
        //we will require a stack, for right to left 
        //we will require a list for left to right

        //we will require a flag to know, if we are moving from left to right
        boolean left_to_right = true;
        Queue<BinaryTree> queue = new LinkedList<>();
        List<List<Integer>> final_result = new ArrayList<>();

        List<Integer> current_level_values = new ArrayList<>();
        
        //adding data  into the queue
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            BinaryTree current_node = queue.poll();
            if(current_node != null){
                if(current_node.left != null){
                    queue.add(current_node.left);
                }
                if(current_node.right != null){
                    queue.add(current_node.right);
                }
                current_level_values.add(current_node.data);
            }else{
                if(left_to_right){
                    final_result.add(new ArrayList<>(current_level_values));
                    current_level_values.clear();
                }else{
                    Stack<Integer> stack = new Stack<>();
                    stack.addAll(current_level_values);
                    current_level_values = new ArrayList<>();
                    while (!stack.isEmpty()) {
                        current_level_values.add(stack.pop());
                    }

                    final_result.add(new ArrayList<>(current_level_values));
                    current_level_values.clear();
                }

                if(queue.isEmpty()){
                    break;
                }else{
                    queue.add(null);
                    left_to_right = !left_to_right;
                }
            }
        }
        return final_result;
    }
}
