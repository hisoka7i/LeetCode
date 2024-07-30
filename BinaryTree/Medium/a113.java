package BinaryTree.Medium;

import java.util.ArrayList;
import java.util.List;

import BinaryTree.TreeNode;

public class a113 {
    List<List<Integer>> result_list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper_function(root, targetSum, new ArrayList<>());
        return result_list;
    }

    //This code is got from chat gpt
    public void helper_function(TreeNode root, int targetSum, List<Integer> current_path) {
        if (root == null) {
            return;
        }

        current_path.add(root.val);

        // Check if it is a leaf node and path sum equals targetSum
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                result_list.add(new ArrayList<>(current_path));
            }
        } else {
            // Recursively check left and right subtrees
            helper_function(root.left, targetSum - root.val, current_path);
            helper_function(root.right, targetSum - root.val, current_path);
        }

        // Backtrack: Remove the current node's value from current_path
        // We will simply go the last node, and continue from here
        current_path.remove(current_path.size() - 1);
    }

    //this code is not working 
    public boolean helper_function_old(TreeNode root, int targetSum, List<Integer> current_path){
        if(root == null){
            current_path.clear();
            return false;
        }
        current_path.add(root.val);
        if(root.left == null && root.right == null){
            //this means that we have a leaf node
            if(root.val == targetSum){
                // List<Integer> saving_result = new ArrayList<>(current_path);
                result_list.add(new ArrayList<>(current_path));
                current_path.clear();
                return false;
            }else{
                current_path.clear();
                return true;
            }
        }

        return (helper_function(root.left, targetSum-root.val, current_path)||helper_function(root.right, targetSum-root.val, current_path));
    }
}
