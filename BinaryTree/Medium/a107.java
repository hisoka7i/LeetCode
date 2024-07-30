package BinaryTree.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import BinaryTree.TreeNode;

public class a107 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //we are going to use queue and stack
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        queue.add(root);
        queue.add(null); //this is to define different levels
        while(!queue.isEmpty()){
            TreeNode current_node = queue.remove();
            if(current_node != null){
                if(current_node.left != null)queue.offer(current_node.left);
                if(current_node.right != null)queue.offer(current_node.right);
                list.add(current_node.val);
            }else{
                if(!queue.isEmpty()){
                    queue.add(null);
                    result.add(list);
                    list = new ArrayList<>();
                }else{
                    break;
                }
            }
        }
        Collections.reverse(result);
        return result;
    }
}
