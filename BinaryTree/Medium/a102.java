package BinaryTree.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BinaryTree.TreeNode;

public class a102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        //this will contain all the list
        List<List<Integer>> result = new ArrayList<>();

        if(root==null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //the null represent, the level change
        queue.add(null);

        List<Integer> current = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode current_tree = queue.remove();
            if(current_tree!=null){
                //adding data into the current
                current.add(current_tree.val);
                if(current_tree.left != null){
                    queue.add(current_tree.left);
                }
                if(current_tree.right != null){
                    queue.add(current_tree.right);
                }
            }else{
                result.add(current);
                if(!queue.isEmpty()){
                    queue.offer(null);
                    current = new ArrayList<>();
                }else{
                    break;
                }
            }
        }
        return result;
    }
}
