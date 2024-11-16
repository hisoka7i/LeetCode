package BinaryTree.Medium;

import BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class a103 {
    //in this we will use, lvl order traversal, and when travel even level we will use a stack to reverse the values
    //or we can also do collection.reverse
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) { 
        //a queue is required to save the values
        List<List<Integer>> output = new ArrayList<>();
        if(root == null)
            return  output;
        Queue<TreeNode> queue = new PriorityQueue<>();
        boolean leftToRight = false;

        queue.offer(root);
        queue.offer(null);

        List<Integer> level_values = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current != null){
                    if(current.right != null){
                        queue.offer(current.right);
                    }
                    if(current.left != null){
                        queue.offer(current.left);
                    }
                level_values.add(current.val);
            }else{
                if (!leftToRight) {
                Collections.reverse(level_values);
            }
                output.add(level_values);
                if(!queue.isEmpty()){
                    queue.offer(null);
                    level_values = new ArrayList<>();
                    leftToRight = !leftToRight;
                }
            }
        }
        return  output;
    }
}
